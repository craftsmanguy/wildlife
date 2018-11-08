package com.ilmani.dream.wildlives.user.business.api;

import java.nio.channels.AlreadyBoundException;

import javax.ejb.Local;

import com.ilmani.dream.wildlives.framework.dto.user.AbstractUserDto;
import com.ilmani.dream.wildlives.framework.exceptions.EntityAlreadyExistException;
import com.ilmani.dream.wildlives.framework.exceptions.EntityNotFoundException;
import com.ilmani.dream.wildlives.framework.exceptions.MalformedFieldException;
import com.ilmani.dream.wildlives.framework.exceptions.RequiredFieldException;
import com.ilmani.dream.wildlives.framework.exceptions.RestClientException;

@Local
public interface UserBusinessLocal {

	public void saveUser(AbstractUserDto user) throws RestClientException, RequiredFieldException,
			AlreadyBoundException, MalformedFieldException, EntityAlreadyExistException;

	public AbstractUserDto findProfilByIdentifier(String pseudonym) throws EntityNotFoundException;

	public AbstractUserDto getPersonalProfil();

}
