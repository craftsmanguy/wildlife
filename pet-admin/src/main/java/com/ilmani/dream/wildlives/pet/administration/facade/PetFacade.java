package com.ilmani.dream.wildlives.pet.administration.facade;

import java.util.List;

import javax.inject.Inject;

import com.ilmani.dream.wildlives.framework.dto.pet.RaceDto;
import com.ilmani.dream.wildlives.pet.administration.port.RaceAdministratorDomain;

public class PetFacade {

	RaceAdministratorDomain specieDomain;

	@Inject
	public PetFacade(RaceAdministratorDomain specieDomain) {
		this.specieDomain = specieDomain;
	}

	public RaceDto findByIdenfier(RaceDto race) {
		return specieDomain.findByIdenfier(race);
	}

	public List<RaceDto> searchRaces(RaceDto race) {
		return specieDomain.searchRaces(race);
	}

	public RaceDto save(RaceDto specie) {
		return specieDomain.save(specie);
	}

	public void delete(RaceDto specie) {
		specieDomain.delete(specie);
	}

	public RaceDto update(RaceDto specie) {
		return specieDomain.update(specie);
	}

}
