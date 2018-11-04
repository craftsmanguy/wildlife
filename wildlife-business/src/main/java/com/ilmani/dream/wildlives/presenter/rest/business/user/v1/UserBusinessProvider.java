package com.ilmani.dream.wildlives.presenter.rest.business.user.v1;

import java.nio.channels.AlreadyBoundException;

import javax.ejb.EJB;
import javax.ws.rs.ext.Provider;

import com.ilmani.dream.wildlives.framework.dto.user.UserDto;
import com.ilmani.dream.wildlives.framework.exceptions.EntityAlreadyExistException;
import com.ilmani.dream.wildlives.framework.exceptions.MalformedFieldException;
import com.ilmani.dream.wildlives.framework.exceptions.RequiredFieldException;
import com.ilmani.dream.wildlives.framework.exceptions.RestClientException;
import com.ilmani.dream.wildlives.user.business.api.UserBusinessLocal;

@Provider
public class UserBusinessProvider {

	@EJB(name = "UserBusinessManager")
	UserBusinessLocal userLocal;

	public void saveUser(UserDto user) throws RestClientException, RequiredFieldException, AlreadyBoundException,
			MalformedFieldException, EntityAlreadyExistException {
		userLocal.saveUser(user);
	}

}
