package com.ilmani.dream.wildlives.pet.administration.port;

import java.util.List;

import com.ilmani.dream.wildlives.framework.dto.pet.RaceDto;

public interface RaceAdministratorDomain {

	public RaceDto findByIdenfier(RaceDto race);

	public List<RaceDto> searchRaces(RaceDto race);

	public RaceDto save(RaceDto race);

	public void delete(RaceDto race);

	public RaceDto update(RaceDto race);

}
