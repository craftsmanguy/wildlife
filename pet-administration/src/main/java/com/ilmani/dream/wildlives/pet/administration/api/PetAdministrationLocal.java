package com.ilmani.dream.wildlives.pet.administration.api;

import java.util.Set;

import javax.ejb.Local;

import com.ilmani.dream.wildlives.framework.dto.pet.RaceDto;

@Local
public interface PetAdministrationLocal {

	public Set<RaceDto> searchRacesByIdenfier(RaceDto race);

}
