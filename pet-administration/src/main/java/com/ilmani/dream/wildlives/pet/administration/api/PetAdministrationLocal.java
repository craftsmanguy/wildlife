package com.ilmani.dream.wildlives.pet.administration.api;

import java.util.Set;

import javax.ejb.Local;

import com.ilmani.dream.wildlives.framework.dto.pet.RaceDto;
import com.ilmani.dream.wildlives.framework.exceptions.AuthenticationException;
import com.ilmani.dream.wildlives.framework.exceptions.EntityAlreadyExistException;
import com.ilmani.dream.wildlives.framework.exceptions.EntityNotFoundException;
import com.ilmani.dream.wildlives.framework.exceptions.RequiredFieldException;
import com.ilmani.dream.wildlives.framework.exceptions.RestClientException;

@Local
public interface PetAdministrationLocal {

	public RaceDto saveRace(RaceDto race)
			throws RequiredFieldException, EntityAlreadyExistException, RestClientException;
	
	public RaceDto updateRace(RaceDto race, String codeToUpdate)
			throws RequiredFieldException, EntityNotFoundException, RestClientException, AuthenticationException;

	public RaceDto findRaceByCode(String code) throws EntityNotFoundException;
	
	public Set<RaceDto> searchRaces(RaceDto race) throws EntityNotFoundException;
	
	public void deleteRace(String code) throws EntityNotFoundException, RestClientException;

}
