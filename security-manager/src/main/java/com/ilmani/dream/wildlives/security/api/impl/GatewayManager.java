package com.ilmani.dream.wildlives.security.api.impl;

import static javax.ws.rs.core.Response.Status.BAD_REQUEST;
import static javax.ws.rs.core.Response.Status.FORBIDDEN;

import java.security.NoSuchAlgorithmException;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;

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

		if (fields == null || fields.getUsername().isEmpty() || fields.getPassword().isEmpty()) {
			throw new AuthenticationException(BAD_REQUEST, ErrorEntity.ErrorKey.FIELD_IS_MISSING.getValue());
		}

		try {
			String idProfil = connectorFactory.findProfil(fields, profil);
			AuthentifyPersonDto person = new AuthentifyPersonDto(idProfil, fields.getUsername(), issuer);

			return connectorFactory.getToken(person, profil);
		} catch (EntityNotFoundException e) {
			throw new AuthenticationException(FORBIDDEN, ErrorEntity.ErrorKey.INVALID_USER_PASSWORD.getValue());
		} catch (NoSuchAlgorithmException e) {
			throw new RestClientException();
		}
	}

}
