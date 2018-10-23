package com.ilmani.dream.wildlives.pet.persistence.adapter;

import java.util.List;

import javax.inject.Inject;

import com.ilmani.dream.wildlives.framework.dto.pet.RaceDto;
import com.ilmani.dream.wildlives.framework.version.Crud;
import com.ilmani.dream.wildlives.pet.administration.port.RaceAdministratorDomain;
import com.ilmani.dream.wildlives.pet.persistence.factory.RaceFactory;

public class RaceAdministratorDomainImpl implements RaceAdministratorDomain {

	RaceFactory raceFactory;

	@Inject
	public RaceAdministratorDomainImpl(RaceFactory raceFactory) {
		this.raceFactory = raceFactory;

	}

	@Override
	public RaceDto findByIdenfier(RaceDto race) {
		return raceFactory.getRaceDto(race, Crud.valueOf("FIND").getAction());
	}

	@Override
	public List<RaceDto> searchRaces(RaceDto race) {
		return raceFactory.getRacesDto(race);
	}

	@Override
	public RaceDto save(RaceDto race) {
		return raceFactory.getRaceDto(race, Crud.valueOf("SAVE").getAction());
	}

	@Override
	public void delete(RaceDto race) {
		raceFactory.delete(race);

	}

	@Override
	public RaceDto update(RaceDto race) {
		return raceFactory.getRaceDto(race, Crud.valueOf("UPDATE").getAction());
	}

}
