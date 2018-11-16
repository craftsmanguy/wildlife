package com.ilmani.dream.wildlives.pet.business.api.impl;

import static com.ilmani.dream.wildlives.framework.security.SecurityInformationFacade.getInstance;
import static javax.ws.rs.core.Response.Status.BAD_REQUEST;
import static javax.ws.rs.core.Response.Status.NOT_FOUND;
import static javax.ws.rs.core.Response.Status.NO_CONTENT;

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

import com.ilmani.dream.wildlives.framework.dto.pet.AbstractPetDto;
import com.ilmani.dream.wildlives.framework.dto.pet.AbstractRaceDto;
import com.ilmani.dream.wildlives.framework.dto.pet.PetBusinessDto;
import com.ilmani.dream.wildlives.framework.error.ErrorEntity;
import com.ilmani.dream.wildlives.framework.exceptions.EntityNotFoundException;
import com.ilmani.dream.wildlives.framework.exceptions.RequiredFieldException;
import com.ilmani.dream.wildlives.framework.exceptions.RestClientException;
import com.ilmani.dream.wildlives.framework.helper.SlugHelper;
import com.ilmani.dream.wildlives.framework.helper.TransformationHelper;
import com.ilmani.dream.wildlives.pet.business.api.PetBusinessLocal;
import com.ilmani.dream.wildlives.pet.business.facade.PetBusinessFacade;

@Stateless(name = "PetBusinessManager")
@TransactionManagement(TransactionManagementType.BEAN)
public class PetBusinessManager implements PetBusinessLocal {

	@Inject
	@Resource
	private UserTransaction utx;

	@Inject
	private PetBusinessFacade petFacade;

	@Override
	public AbstractPetDto savePet(AbstractPetDto pet)
			throws RestClientException, RequiredFieldException, EntityNotFoundException {
		PetBusinessDto result = null;

		if (pet == null || ((PetBusinessDto) pet).getRace() == null || StringUtils.isEmpty(pet.getName())
				|| StringUtils.isEmpty(((PetBusinessDto) pet).getGender())
				|| ((PetBusinessDto) pet).getBirth().intValue() < 0 || StringUtils.isEmpty(pet.getName())
				|| StringUtils.isEmpty(((PetBusinessDto) pet).getRace().getCode())) {
			throw new RequiredFieldException(BAD_REQUEST, ErrorEntity.ErrorKey.FIELD_IS_MISSING.getValue());
		}

		generateFunctionalId(pet);
		pet.setName(pet.getName().substring(0, 1).toUpperCase() + pet.getName().substring(1));
		((PetBusinessDto) pet).setGender(
				TransformationHelper.cleanAllSpecialsCharacters(((PetBusinessDto) pet).getGender().toUpperCase()));

		boolean isGenderBelongEnum = TransformationHelper.isGenderEnumContainsValue(((PetBusinessDto) pet).getGender());
		if (!isGenderBelongEnum) {
			throw new RequiredFieldException(BAD_REQUEST, ErrorEntity.ErrorKey.UNAUTHORIZED_ACTION.getValue());
		}

		try {
			utx.begin();
			((PetBusinessDto) pet).setUserForPet(getInstance().getAuthenticationLogin());
			result = (PetBusinessDto) petFacade.savePet(pet);
		} catch (NotSupportedException | SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoResultException e) {
			throw new EntityNotFoundException(BAD_REQUEST, ErrorEntity.ErrorKey.UNAUTHORIZED_ACTION.getValue());
		} finally {
			closeTransaction(utx);
		}

		return result;
	}

	@Override
	public void deletePet(String functionalId) throws EntityNotFoundException, RestClientException {
		boolean ifPetExists = petFacade.isPetExists(functionalId);
		if (!ifPetExists) {
			throw new EntityNotFoundException(NOT_FOUND, ErrorEntity.ErrorKey.RESOURCE_NOT_FOUND.getValue());
		}
		try {
			utx.begin();
			petFacade.deletePet(functionalId);
		} catch (NotSupportedException | SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeTransaction(utx);
		}
	}

	@Override
	public AbstractPetDto findPet(String id) throws EntityNotFoundException, RestClientException {
		try {
			return petFacade.findPet(id);
		} catch (NoResultException e) {
			throw new EntityNotFoundException(NOT_FOUND, ErrorEntity.ErrorKey.RESOURCE_NOT_FOUND.getValue());
		}

	}
	
	@Override
	public Set<AbstractRaceDto> searchRace(AbstractRaceDto race) throws EntityNotFoundException {
		Set<AbstractRaceDto> results = petFacade.searchRace(race);
		if (results.isEmpty()) {
			throw new EntityNotFoundException(NO_CONTENT, ErrorEntity.ErrorKey.RESOURCE_NOT_FOUND.getValue());
		}
		return results;
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

	private static void generateFunctionalId(AbstractPetDto pet) {
		pet.setFunctionalIdentifier(SlugHelper
				.makeSlug(((PetBusinessDto) pet).getRace().getCode() + "-" + ((PetBusinessDto) pet).getRace().getName()
						+ "-" + pet.getName() + "-" + ((PetBusinessDto) pet).getBirth().toString() + "-"
						+ ((PetBusinessDto) pet).getDescription() + "-" + TransformationHelper.getRandomString(50)));

	}

}
