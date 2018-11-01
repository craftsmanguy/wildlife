package com.ilmani.dream.wildlives.pet.administration.facade;

import java.util.Set;

import javax.inject.Inject;

import com.ilmani.dream.wildlives.framework.dto.pet.RaceDto;
import com.ilmani.dream.wildlives.pet.administration.port.RaceAdministrationDomain;

public class PetAministrationFacade {

	@Inject
	RaceAdministrationDomain specieDomain;
	
	@Inject
	RaceAdministrationDomain raceDomain;


	public RaceDto findByIdenfier(RaceDto race) {
		return specieDomain.findByIdenfier(race);
	}

	public Set<RaceDto> searchRaces(RaceDto race) {
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
