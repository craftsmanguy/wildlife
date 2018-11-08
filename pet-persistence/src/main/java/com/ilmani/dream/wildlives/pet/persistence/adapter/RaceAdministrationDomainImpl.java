package com.ilmani.dream.wildlives.pet.persistence.adapter;

import java.util.Set;

import javax.inject.Inject;
import javax.persistence.NoResultException;

import com.ilmani.dream.wildlives.framework.dto.pet.AbstractRaceDto;
import com.ilmani.dream.wildlives.pet.administration.port.RaceAdministrationDomain;
import com.ilmani.dream.wildlives.pet.persistence.dao.RaceDao;
import com.ilmani.dream.wildlives.pet.persistence.entity.RaceEntity;
import com.ilmani.dream.wildlives.pet.persistence.mapper.RaceMapper;

public class RaceAdministrationDomainImpl implements RaceAdministrationDomain {

	@Inject
	RaceDao raceDao;

	@Override
	public boolean isExists(String code) {
		return raceDao.isExists(code);
	}

	@Override
	public AbstractRaceDto findByCode(String code) throws NoResultException {
		RaceEntity raceFromDb = raceDao.findByCode(code);
		return RaceMapper.transformRaceEntityToRaceDto(raceFromDb);
	}

	@Override
	public Set<AbstractRaceDto> search(AbstractRaceDto race) {
		RaceEntity raceEn = RaceMapper.transformRaceDtoToRaceEntity(race);
		Set<RaceEntity> results = raceDao.getByAttributes(raceEn);
		return RaceMapper.transformListRaceEntityToListRaceDto(results);
	}

	@Override
	public AbstractRaceDto save(AbstractRaceDto race) {
		RaceEntity raceEn = RaceMapper.transformRaceDtoToRaceEntity(race);
		RaceEntity result = raceDao.insert(raceEn);
		return RaceMapper.transformRaceEntityToRaceDto(result);
	}

	@Override
	public void delete(String code) {
		RaceEntity raceToDelete = raceDao.findByCode(code);
		raceDao.delete(raceToDelete);

	}

	@Override
	public AbstractRaceDto update(AbstractRaceDto race, String oldCode) throws NoResultException {
		RaceEntity raceEn = RaceMapper.transformRaceDtoToRaceEntity(race);
		RaceEntity raceToUpdate = raceDao.findByCode(oldCode);
		RaceMapper.copyNewRaceEntityToOldRaceEntity(raceToUpdate, raceEn);
		RaceEntity result = raceDao.update(raceToUpdate);
		return RaceMapper.transformRaceEntityToRaceDto(result);
	}

}
