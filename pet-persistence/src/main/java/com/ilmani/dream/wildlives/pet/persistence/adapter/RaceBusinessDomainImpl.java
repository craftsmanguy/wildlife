package com.ilmani.dream.wildlives.pet.persistence.adapter;

import java.util.Set;

import javax.inject.Inject;

import com.ilmani.dream.wildlives.framework.dto.pet.AbstractRaceDto;
import com.ilmani.dream.wildlives.pet.business.port.RaceBusinessDomain;
import com.ilmani.dream.wildlives.pet.persistence.dao.RaceDao;
import com.ilmani.dream.wildlives.pet.persistence.entity.RaceEntity;
import com.ilmani.dream.wildlives.pet.persistence.mapper.RaceMapper;

public class RaceBusinessDomainImpl implements RaceBusinessDomain {

	@Inject
	RaceDao raceDao;

	@Override
	public Set<AbstractRaceDto> search(AbstractRaceDto race) {
		RaceEntity raceEn = RaceMapper.transformRaceDtoToRaceEntity(race);
		raceEn.setActive(true);
		Set<RaceEntity> results = raceDao.getByAttributes(raceEn);
		return RaceMapper.transformListRaceEntityToListRaceMinimalDto(results);
	}

}
