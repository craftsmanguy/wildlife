package com.ilmani.dream.wildlives.presenter.rest.business.user.v1.resources;

import java.nio.channels.AlreadyBoundException;

import javax.ejb.EJB;
import javax.ws.rs.ext.Provider;

import com.ilmani.dream.wildlives.framework.dto.user.AbstractUserDto;
import com.ilmani.dream.wildlives.framework.exceptions.EntityAlreadyExistException;
import com.ilmani.dream.wildlives.framework.exceptions.EntityNotFoundException;
import com.ilmani.dream.wildlives.framework.exceptions.MalformedFieldException;
import com.ilmani.dream.wildlives.framework.exceptions.RequiredFieldException;
import com.ilmani.dream.wildlives.framework.exceptions.RestClientException;
import com.ilmani.dream.wildlives.user.business.api.UserBusinessLocal;

@Provider
public class UserBusinessProvider {

	@EJB(name = "UserBusinessManager")
	UserBusinessLocal userLocal;

	public void saveUser(AbstractUserDto user) throws RestClientException, RequiredFieldException,
			AlreadyBoundException, MalformedFieldException, EntityAlreadyExistException {
		userLocal.saveUser(user);
	}

	public AbstractUserDto findProfilByIdentifier(String pseudonym) throws EntityNotFoundException {
		return userLocal.findProfilByIdentifier(pseudonym);
	}

	public AbstractUserDto getPersonalProfil() {
		return userLocal.getPersonalProfil();
	}

}
