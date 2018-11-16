package com.ilmani.dream.wildlives.pet.business.port;

import java.util.Set;

import com.ilmani.dream.wildlives.framework.dto.pet.AbstractRaceDto;

public interface RaceBusinessDomain {

	public Set<AbstractRaceDto> search(AbstractRaceDto race);

}
