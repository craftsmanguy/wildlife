package com.ilmani.dream.wildlives.security.connector.impl;

import java.security.NoSuchAlgorithmException;

import javax.inject.Inject;

import com.ilmani.dream.wildlives.framework.dto.auth.AuthentifyPersonDto;
import com.ilmani.dream.wildlives.framework.dto.auth.ConnectionFieldsDto;
import com.ilmani.dream.wildlives.framework.exceptions.EntityNotFoundException;
import com.ilmani.dream.wildlives.framework.helper.TokenHelper;
import com.ilmani.dream.wildlives.security.connector.Connectivity;
import com.ilmani.dream.wildlives.security.connector.LoginAdministrator;
import com.ilmani.dream.wildlives.security.port.GatewayAdministratorDomain;

@LoginAdministrator
public class ConnectorAdministrator implements Connectivity {

	@Inject
	private GatewayAdministratorDomain gatewayAdministratorDomain;

	private static String privateKey = "admin";

	private static long validityTime = 6000000;

	@Override
	public String findProfilByLoginAndPassword(ConnectionFieldsDto fields) throws EntityNotFoundException {
		return gatewayAdministratorDomain.findProfilByLoginAndPassword(fields);
	}

	@Override
	public String createJwtToken(AuthentifyPersonDto person) throws NoSuchAlgorithmException {
		return TokenHelper.createJwtTokenWithAESAlogirthm(person, validityTime, privateKey);
	}

}
