package com.ilmani.dream.wildlives.pet.administration.api;

import java.util.Set;

import javax.ejb.Local;

import com.ilmani.dream.wildlives.framework.dto.pet.AbstractRaceDto;
import com.ilmani.dream.wildlives.framework.exceptions.AuthenticationException;
import com.ilmani.dream.wildlives.framework.exceptions.EntityAlreadyExistException;
import com.ilmani.dream.wildlives.framework.exceptions.EntityNotFoundException;
import com.ilmani.dream.wildlives.framework.exceptions.RequiredFieldException;
import com.ilmani.dream.wildlives.framework.exceptions.RestClientException;

@Local
public interface PetAdministrationLocal {

	public AbstractRaceDto saveRace(AbstractRaceDto race)
			throws RequiredFieldException, EntityAlreadyExistException, RestClientException;
	
	public AbstractRaceDto updateRace(AbstractRaceDto race, String codeToUpdate)
			throws RequiredFieldException, EntityNotFoundException, RestClientException, AuthenticationException;

	public AbstractRaceDto findRaceByCode(String code) throws EntityNotFoundException;
	
	public Set<AbstractRaceDto> searchRaces(AbstractRaceDto race) throws EntityNotFoundException;
	
	public void deleteRace(String code) throws EntityNotFoundException, RestClientException;
	

}
