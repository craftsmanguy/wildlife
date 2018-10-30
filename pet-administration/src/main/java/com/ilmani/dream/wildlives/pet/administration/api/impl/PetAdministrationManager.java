package com.ilmani.dream.wildlives.pet.administration.api.impl;

import java.util.Set;

import javax.inject.Inject;

import com.ilmani.dream.wildlives.framework.dto.pet.RaceDto;
import com.ilmani.dream.wildlives.pet.administration.facade.PetAministrationFacade;

public class PetAdministrationManager {

	@Inject
	PetAministrationFacade petFacade;

	public Set<RaceDto> searchRacesByIdenfier(RaceDto race) {
		return petFacade.searchRaces(race);
	}

}
