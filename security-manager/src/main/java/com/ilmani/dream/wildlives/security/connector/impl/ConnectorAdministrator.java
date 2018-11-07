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
	public String findIdentifiant(ConnectionFieldsDto fields) throws EntityNotFoundException {
		return gatewayAdministratorDomain.findProfilByEmail(fields);
	}

	@Override
	public String createToken(AuthentifyPersonDto person) throws NoSuchAlgorithmException {
		return TokenHelper.createJwtTokenWithAESAlogirthm(person, validityTime, privateKey);
	}

	@Override
	public String getUserFromToken(String token) {
		// TODO Auto-generated method stub
		return null;
	}



}
