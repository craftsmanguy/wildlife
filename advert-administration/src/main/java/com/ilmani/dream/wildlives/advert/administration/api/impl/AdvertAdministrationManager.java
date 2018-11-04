package com.ilmani.dream.wildlives.advert.administration.api.impl;

import static javax.ws.rs.core.Response.Status.BAD_REQUEST;
import static javax.ws.rs.core.Response.Status.CONFLICT;
import static javax.ws.rs.core.Response.Status.FORBIDDEN;
import static javax.ws.rs.core.Response.Status.NOT_FOUND;
import static javax.ws.rs.core.Response.Status.NO_CONTENT;
import static javax.ws.rs.core.Response.Status.UNAUTHORIZED;

import java.util.Set;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.transaction.NotSupportedException;
import javax.transaction.Status;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import org.apache.commons.lang3.StringUtils;

import com.ilmani.dream.wildlives.advert.administration.api.AdvertAdministrationLocal;
import com.ilmani.dream.wildlives.advert.administration.facade.AdvertAdministrationFacade;
import com.ilmani.dream.wildlives.framework.dto.advert.FormatDto;
import com.ilmani.dream.wildlives.framework.error.ErrorEntity;
import com.ilmani.dream.wildlives.framework.exceptions.AuthenticationException;
import com.ilmani.dream.wildlives.framework.exceptions.EntityAlreadyExistException;
import com.ilmani.dream.wildlives.framework.exceptions.EntityNotFoundException;
import com.ilmani.dream.wildlives.framework.exceptions.RequiredFieldException;
import com.ilmani.dream.wildlives.framework.exceptions.RestClientException;
import com.ilmani.dream.wildlives.framework.helper.SlugHelper;
import com.ilmani.dream.wildlives.framework.helper.TransformationHelper;

@Stateless(name = "AdvertAdministrationBean")
@TransactionManagement(TransactionManagementType.BEAN)
public class AdvertAdministrationManager implements AdvertAdministrationLocal {

	@Inject
	@Resource
	private UserTransaction utx;

	@Inject
	private AdvertAdministrationFacade advertFacade;

	@Override
	public FormatDto saveFormat(FormatDto format)
			throws RequiredFieldException, EntityAlreadyExistException, RestClientException {
		FormatDto result = null;

		throwsExceptionIfAllFieldsAreNotFill(format);
		sanitizeFieldsOfFormat(format);
		throwsExceptionIfFormatEnumNotContainValue(format.getName());
		format.setActive(false);
		getCodeFromFields(format);
		throwsExceptionWhenFormatAlreadyExists(format.getCode());

		try {
			utx.begin();
			result = advertFacade.saveFormat(format);
		} catch (NotSupportedException | SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeTransaction(utx);
		}

		return result;
	}

	@Override
	public FormatDto updateFormat(FormatDto format, String codeToUpdate)
			throws RequiredFieldException, EntityNotFoundException, RestClientException, AuthenticationException {
		FormatDto result = null;

		throwsExceptionIfAllFieldsAreNotFill(format);
		throwsExceptionWhenFormatDoesNotExists(codeToUpdate);
		sanitizeFieldsOfFormat(format);
		getCodeFromFields(format);
		throwsExceptionWhenNewFormatAlreadyExists(codeToUpdate, format.getCode());

		try {
			utx.begin();
			result = advertFacade.updateFormat(format, codeToUpdate);
		} catch (NotSupportedException | SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeTransaction(utx);
		}

		return result;
	}

	@Override
	public FormatDto findFormatByCode(String code) throws EntityNotFoundException {
		FormatDto formatFromDb = advertFacade.findFormatByCode(code);
		if (formatFromDb != null && formatFromDb.getName() != null) {
			throw new EntityNotFoundException(NOT_FOUND, ErrorEntity.ErrorKey.RESOURCE_NOT_FOUND.getValue());
		}
		return formatFromDb;
	}

	@Override
	public Set<FormatDto> searchFormats(FormatDto format) throws EntityNotFoundException {
		Set<FormatDto> results = advertFacade.searchFormats(format);
		if (results.isEmpty()) {
			throw new EntityNotFoundException(NO_CONTENT, ErrorEntity.ErrorKey.RESOURCE_NOT_FOUND.getValue());
		}
		return results;
	}

	@Override
	public void deleteFormat(String code) throws EntityNotFoundException, RestClientException {
		throwsExceptionWhenFormatDoesNotExists(code);

		try {
			utx.begin();
			advertFacade.deleteFormat(code);
		} catch (NotSupportedException | SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeTransaction(utx);
		}
	}

	private void sanitizeFieldsOfFormat(FormatDto format) {
		format.setName(TransformationHelper.cleanAllSpecialsCharacters(format.getName().toUpperCase()));
		format.setFeature(TransformationHelper.cleanAllSpecialsCharacters(format.getFeature().toUpperCase()));
	}

	private static void throwsExceptionIfFormatEnumNotContainValue(String value) throws RequiredFieldException {
		boolean isValuable = isFormatEnumContainsValue(value);
		if (!isValuable) {
			throw new RequiredFieldException(UNAUTHORIZED, ErrorEntity.ErrorKey.UNAUTHORIZED_ACTION.getValue());
		}
	}

	private static boolean isFormatEnumContainsValue(String value) {
		for (FormatEnum formatType : FormatEnum.values()) {
			if (formatType.name().equals(value)) {
				return true;
			}
		}
		return false;
	}

	private void throwsExceptionIfAllFieldsAreNotFill(FormatDto format) throws RequiredFieldException {
		if (format == null || StringUtils.isEmpty(format.getName()) || StringUtils.isEmpty(format.getFeature())) {
			throw new RequiredFieldException(BAD_REQUEST, ErrorEntity.ErrorKey.FIELD_IS_MISSING.getValue());
		}
	}

	private void getCodeFromFields(FormatDto format) throws RestClientException {
		String textToEncrypt = format.getName() + "-" + format.getFeature();
		format.setCode(SlugHelper.makeSlug(textToEncrypt));
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

	private void throwsExceptionWhenFormatDoesNotExists(String code) throws EntityNotFoundException {
		boolean ifFormatExists = advertFacade.isFormatExists(code);
		if (!ifFormatExists) {
			throw new EntityNotFoundException(NOT_FOUND, ErrorEntity.ErrorKey.RESOURCE_NOT_FOUND.getValue());
		}
	}

	private void throwsExceptionWhenNewFormatAlreadyExists(String codeToUpdate, String newCode)
			throws AuthenticationException {
		boolean ifFormatToUpdateExists = advertFacade.isFormatExists(newCode);
		if (ifFormatToUpdateExists && !codeToUpdate.equals(newCode)) {
			throw new AuthenticationException(FORBIDDEN, ErrorEntity.ErrorKey.RESOURCE_NOT_FOUND.getValue());
		}
	}

	private void throwsExceptionWhenFormatAlreadyExists(String code) throws EntityAlreadyExistException {
		boolean isExists = advertFacade.isFormatExists(code);
		if (isExists) {
			throw new EntityAlreadyExistException(CONFLICT, ErrorEntity.ErrorKey.RESOURCE_ALREADY_EXIST.getValue());
		}
	}

}
