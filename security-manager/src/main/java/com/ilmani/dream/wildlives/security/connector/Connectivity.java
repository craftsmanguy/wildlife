package com.ilmani.dream.wildlives.security.connector;

import java.security.NoSuchAlgorithmException;

import com.ilmani.dream.wildlives.framework.dto.auth.AuthentifyPersonDto;
import com.ilmani.dream.wildlives.framework.dto.auth.ConnectionFieldsDto;
import com.ilmani.dream.wildlives.framework.exceptions.AuthenticationException;
import com.ilmani.dream.wildlives.framework.exceptions.EntityNotFoundException;

public interface Connectivity {

	public String findIdentifiant(ConnectionFieldsDto fields) throws EntityNotFoundException;

	public String createJwtToken(AuthentifyPersonDto person) throws NoSuchAlgorithmException;
	
	public String getJwtToken(String token) throws AuthenticationException;

}
