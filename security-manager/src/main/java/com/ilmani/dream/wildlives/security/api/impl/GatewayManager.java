package com.ilmani.dream.wildlives.security.api.impl;

import static com.ilmani.dream.wildlives.framework.security.SecurityInformationFacade.getInstance;
import static javax.ws.rs.core.Response.Status.BAD_REQUEST;
import static javax.ws.rs.core.Response.Status.UNAUTHORIZED;

import java.security.NoSuchAlgorithmException;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import com.ilmani.dream.wildlives.framework.dto.auth.AuthentifyPersonDto;
import com.ilmani.dream.wildlives.framework.dto.auth.ConnectionFieldsDto;
import com.ilmani.dream.wildlives.framework.error.ErrorEntity;
import com.ilmani.dream.wildlives.framework.exceptions.AuthenticationException;
import com.ilmani.dream.wildlives.framework.exceptions.EntityNotFoundException;
import com.ilmani.dream.wildlives.framework.exceptions.RestClientException;
import com.ilmani.dream.wildlives.security.api.GatewayLocal;
import com.ilmani.dream.wildlives.security.connector.factory.ConnectorFactory;

@Stateless(name = "GatewayManager")
@TransactionManagement(TransactionManagementType.BEAN)
public class GatewayManager implements GatewayLocal {

	@Inject
	ConnectorFactory connectorFactory;

	public String authenticate(ConnectionFieldsDto fields, String profil, String issuer)
			throws AuthenticationException, RestClientException {

		throwsExceptionWhenAllFieldsAreNotFill(fields);

		try {
			
			String identifiant = connectorFactory.findIdentifiantByProfil(fields, profil);
			AuthentifyPersonDto person = new AuthentifyPersonDto(null, identifiant, issuer);

			return connectorFactory.getToken(person, profil);
		} catch (EntityNotFoundException e) {
			throw new AuthenticationException(UNAUTHORIZED, ErrorEntity.ErrorKey.INVALID_USER_PASSWORD.getValue());
		} catch (NoSuchAlgorithmException e) {
			throw new RestClientException();
		}
	}

	@Override
	public void checkToken(String token, String profil) throws AuthenticationException {
		if (StringUtils.isEmpty(token)) {
			throw new AuthenticationException(UNAUTHORIZED, ErrorEntity.ErrorKey.TOKEN_NOT_FOUND.getValue());
		}
		String identifiant = connectorFactory.getToken(token, profil);
		getInstance().setAuthenticationToken(token);
		getInstance().setAuthenticationLogin(identifiant);
	}

	private static void throwsExceptionWhenAllFieldsAreNotFill(ConnectionFieldsDto fields)
			throws AuthenticationException {
		if (fields == null || StringUtils.isEmpty(fields.getUsername()) || StringUtils.isEmpty(fields.getPassword())) {
			throw new AuthenticationException(BAD_REQUEST, ErrorEntity.ErrorKey.FIELD_IS_MISSING.getValue());
		}
	}

}
