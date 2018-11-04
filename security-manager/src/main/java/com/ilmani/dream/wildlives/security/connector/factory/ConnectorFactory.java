package com.ilmani.dream.wildlives.security.connector.factory;

import java.security.NoSuchAlgorithmException;

import javax.inject.Inject;

import com.ilmani.dream.wildlives.framework.dto.auth.AuthentifyPersonDto;
import com.ilmani.dream.wildlives.framework.dto.auth.ConnectionFieldsDto;
import com.ilmani.dream.wildlives.framework.exceptions.AuthenticationException;
import com.ilmani.dream.wildlives.framework.exceptions.EntityNotFoundException;
import com.ilmani.dream.wildlives.security.connector.Connectivity;
import com.ilmani.dream.wildlives.security.connector.LoginAdministrator;
import com.ilmani.dream.wildlives.security.connector.LoginUser;

public class ConnectorFactory {

	@Inject
	@LoginUser
	private Connectivity loginUser;

	@Inject
	@LoginAdministrator
	private Connectivity loginAdministrator;

	public String getToken(AuthentifyPersonDto person, String profil) throws NoSuchAlgorithmException {
		String token = null;

		switch (profil) {
		case "ADMIN":
			token = loginAdministrator.createJwtToken(person);
			break;
		case "USER":
			token = loginUser.createJwtToken(person);
			break;
		}
		return token;
	}

	public String findIdentifiantByProfil(ConnectionFieldsDto fields, String profil) throws EntityNotFoundException {
		String result = null;
		switch (profil) {
		case "ADMIN":
			result = loginAdministrator.findIdentifiant(fields);
			break;
		case "USER":
			result = loginUser.findIdentifiant(fields);
			break;
		}
		return result;
	}

	public String getToken(String token, String profil) throws AuthenticationException {
		String result = null;
		switch (profil) {
		case "ADMIN":
			result = loginAdministrator.getJwtToken(token);
			break;
		case "USER":
			result = loginUser.getJwtToken(token);
			break;
		}
		return result;
	}

}
