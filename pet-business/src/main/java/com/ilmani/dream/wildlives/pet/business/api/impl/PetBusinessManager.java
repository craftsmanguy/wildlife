package com.ilmani.dream.wildlives.pet.business.api.impl;

import static com.ilmani.dream.wildlives.framework.security.SecurityInformationFacade.getInstance;
import static javax.ws.rs.core.Response.Status.BAD_REQUEST;
import static javax.ws.rs.core.Response.Status.NOT_FOUND;

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

import com.ilmani.dream.wildlives.framework.dto.pet.PetDto;
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
	public PetDto savePet(PetDto pet) throws RestClientException, RequiredFieldException, EntityNotFoundException {
		PetDto result = null;

		if (pet == null || pet.getRace() == null || StringUtils.isEmpty(pet.getName())
				|| StringUtils.isEmpty(pet.getGender()) || pet.getBirth().intValue() < 0
				|| StringUtils.isEmpty(pet.getName()) || StringUtils.isEmpty(pet.getRace().getCode())) {
			throw new RequiredFieldException(BAD_REQUEST, ErrorEntity.ErrorKey.FIELD_IS_MISSING.getValue());
		}

		generateFunctionalId(pet);
		pet.setName(pet.getName().substring(0, 1).toUpperCase() + pet.getName().substring(1));
		pet.setGender(TransformationHelper.cleanAllSpecialsCharacters(pet.getGender().toUpperCase()));

		boolean isGenderBelongEnum = TransformationHelper.isGenderEnumContainsValue(pet.getGender());
		if (!isGenderBelongEnum) {
			throw new RequiredFieldException(BAD_REQUEST, ErrorEntity.ErrorKey.UNAUTHORIZED_ACTION.getValue());
		}

		try {
			utx.begin();
			pet.setUserForPet(getInstance().getAuthenticationLogin());
			result = petFacade.savePet(pet);
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

	private static void generateFunctionalId(PetDto pet) {
		pet.setFunctionalIdentifier(SlugHelper.makeSlug(pet.getRace().getCode() + "-" + pet.getRace().getName() + "-"
				+ pet.getName() + "-" + pet.getBirth().toString() + "-" + pet.getDescription() + "-"
				+ TransformationHelper.getRandomString(50)));

	}

}
