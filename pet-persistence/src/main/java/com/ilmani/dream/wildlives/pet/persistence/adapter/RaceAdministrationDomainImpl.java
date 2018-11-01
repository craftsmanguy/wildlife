package com.ilmani.dream.wildlives.pet.persistence.adapter;

import java.util.Set;

import javax.inject.Inject;

import com.ilmani.dream.wildlives.framework.dto.pet.RaceDto;
import com.ilmani.dream.wildlives.framework.version.Crud;
import com.ilmani.dream.wildlives.pet.administration.port.RaceAdministrationDomain;
import com.ilmani.dream.wildlives.pet.persistence.factory.RaceFactory;

public class RaceAdministrationDomainImpl implements RaceAdministrationDomain {

	@Inject
	RaceFactory raceFact;


	@Override
	public RaceDto findByIdenfier(RaceDto race) {
		return raceFact.getRaceDto(race, Crud.valueOf("FIND").getAction());
	}

	@Override
	public Set<RaceDto> searchRaces(RaceDto race) {
		return raceFact.getRacesDto(race);
	}

	@Override
	public RaceDto save(RaceDto race) {
		return raceFact.getRaceDto(race, Crud.valueOf("SAVE").getAction());
	}

	@Override
	public void delete(RaceDto race) {
		raceFact.delete(race);

	}

	@Override
	public RaceDto update(RaceDto race) {
		return raceFact.getRaceDto(race, Crud.valueOf("UPDATE").getAction());
	}

}
