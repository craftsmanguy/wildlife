package com.ilmani.dream.wildlives.pet.administration.port;

import java.util.Set;

import javax.persistence.NoResultException;

import com.ilmani.dream.wildlives.framework.dto.pet.RaceDto;

public interface RaceAdministrationDomain {
	
	public boolean isRaceExists(String code);
	
	public RaceDto saveRace(RaceDto race);

	public RaceDto findRaceByCode(String code) throws NoResultException;

	public Set<RaceDto> searchRaces(RaceDto race);

	public void deleteRace(String code);

	public RaceDto update(RaceDto race, String codeToUpdate);

}
