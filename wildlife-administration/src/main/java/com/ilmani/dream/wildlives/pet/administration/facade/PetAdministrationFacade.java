package com.ilmani.dream.wildlives.pet.administration.facade;

import java.util.Set;

import javax.inject.Inject;

import com.ilmani.dream.wildlives.framework.dto.pet.AbstractRaceDto;
import com.ilmani.dream.wildlives.pet.administration.port.RaceAdministrationDomain;

public class PetAdministrationFacade {

	@Inject
	RaceAdministrationDomain raceDomain;

	public boolean isRaceExists(String code) {
		return raceDomain.isExists(code);
	}

	public AbstractRaceDto findRaceByCode(String code) {
		return raceDomain.findByCode(code);
	}

	public Set<AbstractRaceDto> searchRaces(AbstractRaceDto race) {
		return raceDomain.search(race);
	}

	public AbstractRaceDto saveRace(AbstractRaceDto race) {
		return raceDomain.save(race);
	}

	public void deleteRace(String code) {
		raceDomain.delete(code);
	}

	public AbstractRaceDto updateRace(AbstractRaceDto race, String codeToUpdate) {
		return raceDomain.update(race, codeToUpdate);
	}

}
