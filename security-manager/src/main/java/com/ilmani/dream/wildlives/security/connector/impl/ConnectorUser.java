package com.ilmani.dream.wildlives.security.connector.impl;

import static javax.ws.rs.core.Response.Status.FORBIDDEN;
import static javax.ws.rs.core.Response.Status.UNAUTHORIZED;

import java.security.NoSuchAlgorithmException;

import javax.inject.Inject;
import javax.persistence.NoResultException;

import com.ilmani.dream.wildlives.framework.dto.auth.AuthentifyPersonDto;
import com.ilmani.dream.wildlives.framework.dto.auth.ConnectionFieldsDto;
import com.ilmani.dream.wildlives.framework.error.ErrorEntity;
import com.ilmani.dream.wildlives.framework.exceptions.AuthenticationException;
import com.ilmani.dream.wildlives.framework.exceptions.EntityNotFoundException;
import com.ilmani.dream.wildlives.framework.helper.TokenHelper;
import com.ilmani.dream.wildlives.security.connector.Connectivity;
import com.ilmani.dream.wildlives.security.connector.LoginUser;
import com.ilmani.dream.wildlives.security.port.GatewayUserDomain;

@LoginUser
public class ConnectorUser implements Connectivity {

	@Inject
	private GatewayUserDomain gatewayUserDomain;
	
	private static String privateKey = "user";

	private static long validityTime = 600000;

	@Override
	public String findIdentifiant(ConnectionFieldsDto fields) throws EntityNotFoundException {
		try {
			boolean isProfilExists = gatewayUserDomain.isProfilExists(fields);
			if (!isProfilExists) {
				throw new EntityNotFoundException(FORBIDDEN, ErrorEntity.ErrorKey.INVALID_USER_PASSWORD.getValue());
			}
			return gatewayUserDomain.findPseudonymByEmail(fields);
		} catch (NoResultException e) {
			throw new EntityNotFoundException(FORBIDDEN, ErrorEntity.ErrorKey.INVALID_USER_PASSWORD.getValue());
		}
	}

	@Override
	public String createToken(AuthentifyPersonDto person) throws NoSuchAlgorithmException {
		return TokenHelper.createJwtTokenWithAESAlogirthm(person, validityTime, privateKey);
	}

	@Override
	public String getUserFromToken(String token) throws AuthenticationException  {
		try {
			return TokenHelper.parseJWT(token, privateKey);
		} catch (Exception e) {
			throw new AuthenticationException(UNAUTHORIZED, ErrorEntity.ErrorKey.TOKEN_IS_WRONG.getValue());
		}
		
		
	}

}
