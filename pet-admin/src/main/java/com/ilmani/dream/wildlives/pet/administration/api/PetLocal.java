package com.ilmani.dream.wildlives.pet.administration.api;

import java.util.List;

import javax.ejb.Local;

import com.ilmani.dream.wildlives.framework.dto.pet.RaceDto;

@Local
public interface PetLocal {

	public List<RaceDto> searchRacesByIdenfier(RaceDto race);

}
