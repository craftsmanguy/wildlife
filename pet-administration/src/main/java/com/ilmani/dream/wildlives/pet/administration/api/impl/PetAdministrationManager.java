package com.ilmani.dream.wildlives.pet.administration.api.impl;

import static javax.ws.rs.core.Response.Status.BAD_REQUEST;
import static javax.ws.rs.core.Response.Status.CONFLICT;
import static javax.ws.rs.core.Response.Status.NO_CONTENT;

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

import com.ilmani.dream.wildlives.framework.dto.pet.RaceDto;
import com.ilmani.dream.wildlives.framework.error.ErrorEntity;
import com.ilmani.dream.wildlives.framework.exceptions.EntityAlreadyExistException;
import com.ilmani.dream.wildlives.framework.exceptions.EntityNotFoundException;
import com.ilmani.dream.wildlives.framework.exceptions.RequiredFieldException;
import com.ilmani.dream.wildlives.framework.exceptions.RestClientException;
import com.ilmani.dream.wildlives.framework.helper.TransformationHelper;
import com.ilmani.dream.wildlives.pet.administration.api.PetAdministrationLocal;
import com.ilmani.dream.wildlives.pet.administration.facade.PetAministrationFacade;

@Stateless(name = "PetAdministrationManager")
@TransactionManagement(TransactionManagementType.BEAN)
public class PetAdministrationManager implements PetAdministrationLocal {

	@Inject
	private PetAministrationFacade petFacade;

	@Inject
	@Resource
	private UserTransaction utx;

	public RaceDto findRaceByCode(String code) throws EntityNotFoundException {
		RaceDto raceFromDb = petFacade.findRaceByCode(code);
		if (raceFromDb != null && raceFromDb.getName() != null) {
			throw new EntityNotFoundException(NO_CONTENT, ErrorEntity.ErrorKey.RESOURCE_NOT_FOUND.getValue());
		}
		return raceFromDb;
	}

	public RaceDto saveRace(RaceDto race)
			throws RequiredFieldException, RestClientException, EntityAlreadyExistException {

		RaceDto result = null;

		if (race == null || race.getName() == null || race.getSpecie() == null || race.getClan() == null) {
			throw new RequiredFieldException(BAD_REQUEST, ErrorEntity.ErrorKey.FIELD_IS_MISSING.getValue());
		}
		sanitizeFieldsOfRace(race);
		getSha1FromCodeField(race);
		race.setActive(false);

		try {
			utx.begin();
			boolean ifRaceExists = petFacade.isRaceExists(race.getCode());
			if (ifRaceExists) {
				throw new EntityAlreadyExistException(CONFLICT, ErrorEntity.ErrorKey.RESOURCE_ALREADY_EXIST.getValue());
			}
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
		try {
			return petFacade.searchRaces(race);
		} catch (NoResultException e) {
			throw new EntityNotFoundException(NO_CONTENT, ErrorEntity.ErrorKey.RESOURCE_NOT_FOUND.getValue());
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

}
