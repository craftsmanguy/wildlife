package com.ilmani.dream.wildlives.security.connector.impl;

import java.security.NoSuchAlgorithmException;

import javax.inject.Inject;

import com.ilmani.dream.wildlives.framework.dto.auth.AuthentifyPersonDto;
import com.ilmani.dream.wildlives.framework.dto.auth.ConnectionFieldsDto;
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
	public String findProfilByLoginAndPassword(ConnectionFieldsDto fields) throws EntityNotFoundException {
		return gatewayUserDomain.findProfilByLoginAndPassword(fields);
	}

	@Override
	public String createJwtToken(AuthentifyPersonDto person) throws NoSuchAlgorithmException {
		return TokenHelper.createJwtTokenWithAESAlogirthm(person, validityTime, privateKey);
	}

}
