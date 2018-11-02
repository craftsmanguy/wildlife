package com.ilmani.dream.wildlives.presenter.rest.administration.pet.v1;

import java.util.Set;

import javax.ejb.EJB;
import javax.ws.rs.ext.Provider;

import com.ilmani.dream.wildlives.framework.dto.pet.RaceDto;
import com.ilmani.dream.wildlives.framework.exceptions.EntityAlreadyExistException;
import com.ilmani.dream.wildlives.framework.exceptions.EntityNotFoundException;
import com.ilmani.dream.wildlives.framework.exceptions.RequiredFieldException;
import com.ilmani.dream.wildlives.framework.exceptions.RestClientException;
import com.ilmani.dream.wildlives.pet.administration.api.impl.PetAdministrationManager;

@Provider
public class PetAdministrationProvider {

	@EJB(name = "PetAdministrationManager")
	PetAdministrationManager petMngt;

	public RaceDto saveRace(RaceDto race)
			throws RequiredFieldException, EntityAlreadyExistException, RestClientException {
		return petMngt.saveRace(race);
	}

	public RaceDto findRaceByCode(String code) throws EntityNotFoundException {
		return petMngt.findRaceByCode(code);
	}

	public Set<RaceDto> searchRaces(RaceDto race) throws EntityNotFoundException {
		return petMngt.searchRaces(race);
	}

}
