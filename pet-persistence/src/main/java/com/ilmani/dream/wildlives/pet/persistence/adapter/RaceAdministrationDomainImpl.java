package com.ilmani.dream.wildlives.pet.persistence.adapter;

import java.util.Set;

import javax.inject.Inject;
import javax.persistence.NoResultException;

import com.ilmani.dream.wildlives.framework.dto.pet.RaceDto;
import com.ilmani.dream.wildlives.pet.administration.port.RaceAdministrationDomain;
import com.ilmani.dream.wildlives.pet.persistence.dao.RaceDao;
import com.ilmani.dream.wildlives.pet.persistence.entity.RaceEntity;
import com.ilmani.dream.wildlives.pet.persistence.mapper.RaceMapper;

public class RaceAdministrationDomainImpl implements RaceAdministrationDomain {

	@Inject
	RaceDao raceDao;

	@Override
	public boolean isRaceExists(String code) {
		return raceDao.isRaceExists(code);
	}

	@Override
	public RaceDto findRaceByCode(String code) throws NoResultException {
		RaceEntity raceFromDb = raceDao.findRaceByCode(code);
		return RaceMapper.transformRaceEntityToRaceDto(raceFromDb);
	}

	@Override
	public Set<RaceDto> searchRaces(RaceDto race) {
		RaceEntity raceEn = RaceMapper.transformRaceDtoToRaceEntity(race);
		Set<RaceEntity> results = raceDao.getByAttributes(raceEn);
		return RaceMapper.transformListRaceEntityToListRaceDto(results);
	}

	@Override
	public RaceDto saveRace(RaceDto race) {
		RaceEntity raceEn = RaceMapper.transformRaceDtoToRaceEntity(race);
		RaceEntity result = raceDao.insert(raceEn);
		return RaceMapper.transformRaceEntityToRaceDto(result);
	}

	@Override
	public void delete(RaceDto race) throws NoResultException {
		RaceEntity raceEn = RaceMapper.transformRaceDtoToRaceEntity(race);
		raceDao.delete(raceEn);

	}

	@Override
	public RaceDto update(RaceDto race) throws NoResultException {
		RaceEntity raceEn = RaceMapper.transformRaceDtoToRaceEntity(race);
		RaceEntity result = raceDao.update(raceEn);
		return RaceMapper.transformRaceEntityToRaceDto(result);
	}

}
