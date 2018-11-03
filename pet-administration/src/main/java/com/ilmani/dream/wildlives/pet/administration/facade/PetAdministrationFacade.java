package com.ilmani.dream.wildlives.pet.administration.facade;

import java.util.Set;

import javax.inject.Inject;

import com.ilmani.dream.wildlives.framework.dto.pet.RaceDto;
import com.ilmani.dream.wildlives.pet.administration.port.RaceAdministrationDomain;

public class PetAdministrationFacade {

	@Inject
	RaceAdministrationDomain raceDomain;

	public boolean isRaceExists(String code) {
		return raceDomain.isExists(code);
	}

	public RaceDto findRaceByCode(String code) {
		return raceDomain.findByCode(code);
	}

	public Set<RaceDto> searchRaces(RaceDto race) {
		return raceDomain.search(race);
	}

	public RaceDto saveRace(RaceDto race) {
		return raceDomain.save(race);
	}

	public void deleteRace(String code) {
		raceDomain.delete(code);
	}

	public RaceDto updateRace(RaceDto race, String codeToUpdate) {
		return raceDomain.update(race, codeToUpdate);
	}

}
