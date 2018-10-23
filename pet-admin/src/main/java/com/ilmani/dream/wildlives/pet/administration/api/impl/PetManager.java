package com.ilmani.dream.wildlives.pet.administration.api.impl;

import java.util.List;

import javax.inject.Inject;

import com.ilmani.dream.wildlives.framework.dto.pet.RaceDto;
import com.ilmani.dream.wildlives.pet.administration.facade.PetFacade;

public class PetManager {

	PetFacade petFacade;

	@Inject
	public PetManager(PetFacade petFacade) {
		this.petFacade = petFacade;
	}

	public List<RaceDto> searchRacesByIdenfier(RaceDto race) {
		return petFacade.searchRaces(race);
	}

}
