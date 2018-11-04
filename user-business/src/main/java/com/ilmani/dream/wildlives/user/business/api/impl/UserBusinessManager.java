package com.ilmani.dream.wildlives.user.business.api.impl;

import static javax.ws.rs.core.Response.Status.BAD_REQUEST;
import static javax.ws.rs.core.Response.Status.CONFLICT;

import java.nio.channels.AlreadyBoundException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
import org.apache.commons.validator.routines.EmailValidator;

import com.ilmani.dream.wildlives.framework.dto.user.UserDto;
import com.ilmani.dream.wildlives.framework.dto.user.UserInscriptionDto;
import com.ilmani.dream.wildlives.framework.error.ErrorEntity;
import com.ilmani.dream.wildlives.framework.exceptions.EntityAlreadyExistException;
import com.ilmani.dream.wildlives.framework.exceptions.MalformedFieldException;
import com.ilmani.dream.wildlives.framework.exceptions.RequiredFieldException;
import com.ilmani.dream.wildlives.framework.exceptions.RestClientException;
import com.ilmani.dream.wildlives.user.business.api.UserBusinessLocal;
import com.ilmani.dream.wildlives.user.business.facade.UserBusinessFacade;

@Stateless(name = "UserBusinessManager")
@TransactionManagement(TransactionManagementType.BEAN)
public class UserBusinessManager implements UserBusinessLocal {

	@Inject
	UserBusinessFacade userFacade;
	
	@Inject
	@Resource
	private UserTransaction utx;

	private static Pattern pattern;
	private static Matcher matcher;

	private static final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[$&+,:;=?@#|'<>.^*()%!-]).{6,20})";

	@Override
	public void saveUser(UserDto user) throws RestClientException, RequiredFieldException, AlreadyBoundException,
			MalformedFieldException, EntityAlreadyExistException {

		throwsExceptionWhenAllFieldsAreNotFill(user);
		checkPasswordRecommandation(user);
		checkEmailRecommandation(user.getEmail());
		throwsExceptionWhenUserAlreadyExists(user.getEmail(), user.getPseudonym());
		
		try {
			utx.begin();
			userFacade.saveUser(user);
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

	private static void throwsExceptionWhenAllFieldsAreNotFill(UserDto user) throws RequiredFieldException {
		if (user == null || StringUtils.isEmpty(user.getPseudonym()) || StringUtils.isEmpty(user.getEmail())
				|| StringUtils.isEmpty(user.getCountry()) || StringUtils.isEmpty(user.getPostalCode())
				|| StringUtils.isEmpty(user.getCity()) || StringUtils.isEmpty(((UserInscriptionDto) user).getPassword())
				|| StringUtils.isEmpty(((UserInscriptionDto) user).getConfirmPassword())) {
			throw new RequiredFieldException(BAD_REQUEST, ErrorEntity.ErrorKey.FIELD_IS_MISSING.getValue());
		}
	}

	private static void checkPasswordRecommandation(UserDto user) throws RequiredFieldException, MalformedFieldException {
		pattern = Pattern.compile(PASSWORD_PATTERN);
		matcher = pattern.matcher(((UserInscriptionDto) user).getPassword());
		boolean isMatch = matcher.matches();
		if (!isMatch) {
			throw new MalformedFieldException(BAD_REQUEST, ErrorEntity.ErrorKey.INVALID_PASSWORD.getValue());
		}

		if (!((UserInscriptionDto) user).getPassword().equals(((UserInscriptionDto) user).getConfirmPassword())) {
			throw new RequiredFieldException(BAD_REQUEST, ErrorEntity.ErrorKey.PASSWORD_NO_MATCH.getValue());
		}
	}

	private static void checkEmailRecommandation(String email) throws MalformedFieldException {
		boolean allowLocal = true;
		boolean isMailValid = EmailValidator.getInstance(allowLocal).isValid(email);
		if (!isMailValid) {
			throw new MalformedFieldException(BAD_REQUEST, ErrorEntity.ErrorKey.INVALID_PASSWORD.getValue());
		}
	}

	private void throwsExceptionWhenUserAlreadyExists(String email, String pseudonym) throws EntityAlreadyExistException {
		boolean isEmailExists = userFacade.isEmailExists(email);
		if (isEmailExists) {
			throw new EntityAlreadyExistException(CONFLICT, ErrorEntity.ErrorKey.EMAIL_ALREADY_EXIST.getValue());
		}
		
		boolean isPseudonymExists = userFacade.isPseudonymExists(pseudonym);
		if (isPseudonymExists) {
			throw new EntityAlreadyExistException(CONFLICT, ErrorEntity.ErrorKey.PSEUDO_ALREADY_EXIST.getValue());
		}		
	}

}
