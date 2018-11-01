package com.ilmani.dream.wildlives.security.connector.factory;

import java.security.NoSuchAlgorithmException;

import javax.inject.Inject;

import com.ilmani.dream.wildlives.framework.dto.auth.AuthentifyPersonDto;
import com.ilmani.dream.wildlives.framework.dto.auth.ConnectionFieldsDto;
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

	public String findProfil(ConnectionFieldsDto fields, String profil) throws EntityNotFoundException {
		String idProfil = null;

		switch (profil) {
		case "ADMIN":
			idProfil = loginAdministrator.findProfilByLoginAndPassword(fields);
			break;
		case "USER":
			idProfil = loginUser.findProfilByLoginAndPassword(fields);
			break;
		}
		return idProfil;
	}

}
