package com.ilmani.dream.wildlives.presenter.rest.administration.pet.v1;

import java.util.Set;

import javax.ejb.EJB;
import javax.ws.rs.ext.Provider;

import com.ilmani.dream.wildlives.framework.dto.pet.RaceDto;
import com.ilmani.dream.wildlives.framework.exceptions.AuthenticationException;
import com.ilmani.dream.wildlives.framework.exceptions.EntityAlreadyExistException;
import com.ilmani.dream.wildlives.framework.exceptions.EntityNotFoundException;
import com.ilmani.dream.wildlives.framework.exceptions.RequiredFieldException;
import com.ilmani.dream.wildlives.framework.exceptions.RestClientException;
import com.ilmani.dream.wildlives.pet.administration.api.PetAdministrationLocal;

@Provider
public class PetAdministrationProvider {

	@EJB(name = "PetAdministrationManager")
	PetAdministrationLocal petLocal;

	public RaceDto saveRace(RaceDto race)
			throws RequiredFieldException, EntityAlreadyExistException, RestClientException {
		return petLocal.saveRace(race);
	}
	
	public RaceDto updateRace(RaceDto race, String codeToUpdate)
			throws RequiredFieldException, EntityNotFoundException, RestClientException, AuthenticationException{
		return petLocal.updateRace(race, codeToUpdate);
	}

	public RaceDto findRaceByCode(String code) throws EntityNotFoundException {
		return petLocal.findRaceByCode(code);
	}

	public Set<RaceDto> searchRaces(RaceDto race) throws EntityNotFoundException {
		return petLocal.searchRaces(race);
	}
	
	public void deleteRace(String code) throws EntityNotFoundException, RestClientException{
		petLocal.deleteRace(code);
	}

}
