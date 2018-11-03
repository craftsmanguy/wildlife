package com.ilmani.dream.wildlives.pet.administration.api.impl;

import static javax.ws.rs.core.Response.Status.BAD_REQUEST;
import static javax.ws.rs.core.Response.Status.CONFLICT;
import static javax.ws.rs.core.Response.Status.NOT_FOUND;
import static javax.ws.rs.core.Response.Status.NO_CONTENT;
import static javax.ws.rs.core.Response.Status.FORBIDDEN;

import java.security.NoSuchAlgorithmException;
import java.util.Set;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.transaction.NotSupportedException;
import javax.transaction.Status;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import org.apache.commons.lang3.StringUtils;

import com.ilmani.dream.wildlives.framework.dto.pet.RaceDto;
import com.ilmani.dream.wildlives.framework.error.ErrorEntity;
import com.ilmani.dream.wildlives.framework.exceptions.AuthenticationException;
import com.ilmani.dream.wildlives.framework.exceptions.EntityAlreadyExistException;
import com.ilmani.dream.wildlives.framework.exceptions.EntityNotFoundException;
import com.ilmani.dream.wildlives.framework.exceptions.RequiredFieldException;
import com.ilmani.dream.wildlives.framework.exceptions.RestClientException;
import com.ilmani.dream.wildlives.framework.helper.TransformationHelper;
import com.ilmani.dream.wildlives.pet.administration.api.PetAdministrationLocal;
import com.ilmani.dream.wildlives.pet.administration.facade.PetAdministrationFacade;

@Stateless(name = "PetAdministrationManager")
@TransactionManagement(TransactionManagementType.BEAN)
public class PetAdministrationManager implements PetAdministrationLocal {

	@Inject
	private PetAdministrationFacade petFacade;

	@Inject
	@Resource
	private UserTransaction utx;

	public RaceDto findRaceByCode(String code) throws EntityNotFoundException {
		try {
			return petFacade.findRaceByCode(code);
		} catch (NoResultException e) {
			throw new EntityNotFoundException(NOT_FOUND, ErrorEntity.ErrorKey.RESOURCE_NOT_FOUND.getValue());
		}
	}

	public RaceDto saveRace(RaceDto race)
			throws RequiredFieldException, RestClientException, EntityAlreadyExistException {

		RaceDto result = null;

		if (race == null || StringUtils.isEmpty(race.getName()) || StringUtils.isEmpty(race.getSpecie())
				|| StringUtils.isEmpty(race.getClan())) {
			throw new RequiredFieldException(BAD_REQUEST, ErrorEntity.ErrorKey.FIELD_IS_MISSING.getValue());
		}
		sanitizeFieldsOfRace(race);

		boolean isValuable = isVertebrateEnumContainsValue(race.getClan());
		if (!isValuable) {
			throw new RequiredFieldException(BAD_REQUEST, ErrorEntity.ErrorKey.UNAUTHORIZED_ACTION.getValue());
		}

		getSha1FromCodeField(race);
		race.setActive(false);

		boolean ifRaceExists = petFacade.isRaceExists(race.getCode());
		if (ifRaceExists) {
			throw new EntityAlreadyExistException(CONFLICT, ErrorEntity.ErrorKey.RESOURCE_ALREADY_EXIST.getValue());
		}

		try {
			utx.begin();
			result = petFacade.saveRace(race);
		} catch (NotSupportedException | SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeTransaction(utx);
		}

		return result;
	}

	@Override
	public Set<RaceDto> searchRaces(RaceDto race) throws EntityNotFoundException {
		Set<RaceDto> results = petFacade.searchRaces(race);
		if (results.isEmpty()) {
			throw new EntityNotFoundException(NO_CONTENT, ErrorEntity.ErrorKey.RESOURCE_NOT_FOUND.getValue());
		}
		return results;
	}

	@Override
	public RaceDto updateRace(RaceDto race, String code)
			throws RequiredFieldException, EntityNotFoundException, RestClientException, AuthenticationException {
		RaceDto result = null;

		if (race == null || StringUtils.isEmpty(race.getName()) || StringUtils.isEmpty(race.getSpecie())
				|| StringUtils.isEmpty(race.getClan())) {
			throw new RequiredFieldException(BAD_REQUEST, ErrorEntity.ErrorKey.FIELD_IS_MISSING.getValue());
		}
		boolean ifRaceExists = petFacade.isRaceExists(code);
		if (!ifRaceExists) {
			throw new EntityNotFoundException(NOT_FOUND, ErrorEntity.ErrorKey.RESOURCE_NOT_FOUND.getValue());
		}
		sanitizeFieldsOfRace(race);
		getSha1FromCodeField(race);

		boolean ifRaceToUpdateExists = petFacade.isRaceExists(race.getCode());
		if (ifRaceToUpdateExists && !code.equals(race.getCode())) {
			throw new AuthenticationException(FORBIDDEN, ErrorEntity.ErrorKey.RESOURCE_NOT_FOUND.getValue());
		}

		try {
			utx.begin();
			result = petFacade.updateRace(race, code);
		} catch (NotSupportedException | SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeTransaction(utx);
		}

		return result;
	}

	@Override
	public void deleteRace(String code) throws EntityNotFoundException, RestClientException {

		boolean ifRaceExists = petFacade.isRaceExists(code);
		if (!ifRaceExists) {
			throw new EntityNotFoundException(NOT_FOUND, ErrorEntity.ErrorKey.RESOURCE_NOT_FOUND.getValue());
		}
		try {
			utx.begin();
			petFacade.deleteRace(code);
		} catch (NotSupportedException | SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeTransaction(utx);
		}
	}

	private void closeTransaction(UserTransaction utx) throws RestClientException {
		try {
			if (utx.getStatus() == Status.STATUS_ACTIVE) {
				utx.commit();
			} else {
				utx.rollback();
				throw new RestClientException();
			}
		} catch (Exception e) {
			throw new RestClientException();
		}
	}

	private void sanitizeFieldsOfRace(RaceDto race) {
		race.setName(TransformationHelper.cleanAllSpecialsCharacters(race.getName().toUpperCase()));
		race.setSpecie(TransformationHelper.cleanAllSpecialsCharacters(race.getSpecie().toUpperCase()));
		race.setClan(TransformationHelper.cleanAllSpecialsCharacters(race.getClan().toUpperCase()));
	}

	private void getSha1FromCodeField(RaceDto race) throws RestClientException {
		String textToEncrypt = race.getName() + "_" + race.getSpecie() + "_" + race.getClan();
		try {
			race.setCode(TransformationHelper.checksumStringWithSHA1(textToEncrypt));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			throw new RestClientException();
		}
	}

	private static boolean isVertebrateEnumContainsValue(String value) {
		for (VertebrateEnum vertebrateType : VertebrateEnum.values()) {
			if (vertebrateType.name().equals(value)) {
				return true;
			}
		}
		return false;
	}

}
