package com.ilmani.dream.wildlives.pet.administration.port;

import java.util.Set;

import javax.persistence.NoResultException;

import com.ilmani.dream.wildlives.framework.dto.pet.RaceDto;

public interface RaceAdministrationDomain {
	
	public boolean isExists(String code);
	
	public RaceDto save(RaceDto race);

	public RaceDto findByCode(String code) throws NoResultException;

	public Set<RaceDto> search(RaceDto race);

	public void delete(String code);

	public RaceDto update(RaceDto race, String codeToUpdate);

}
