package com.ilmani.dream.wildlives.pet.administration.port;

import java.util.Set;

import javax.persistence.NoResultException;

import com.ilmani.dream.wildlives.framework.dto.pet.AbstractRaceDto;

public interface RaceAdministrationDomain {

	public boolean isExists(String code);

	public AbstractRaceDto save(AbstractRaceDto race);

	public AbstractRaceDto findByCode(String code) throws NoResultException;

	public Set<AbstractRaceDto> search(AbstractRaceDto race);

	public void delete(String code);

	public AbstractRaceDto update(AbstractRaceDto race, String codeToUpdate);

}
