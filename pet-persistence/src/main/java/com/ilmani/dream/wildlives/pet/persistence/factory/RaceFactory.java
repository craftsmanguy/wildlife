package com.ilmani.dream.wildlives.pet.persistence.factory;

import java.util.Set;

import javax.inject.Inject;

import com.ilmani.dream.wildlives.framework.constants.ConstantsCrud;
import com.ilmani.dream.wildlives.framework.dto.pet.RaceDto;
import com.ilmani.dream.wildlives.pet.persistence.dao.RaceDao;
import com.ilmani.dream.wildlives.pet.persistence.entity.RaceEntity;
import com.ilmani.dream.wildlives.pet.persistence.mapper.RaceMapper;

public class RaceFactory {

	@Inject
	RaceDao raceDao;

	public RaceDto getRaceDto(RaceDto raceDto, String action) {
		RaceEntity raceEn = RaceMapper.transformRaceDtoToRaceEntity(raceDto);
		RaceEntity result = new RaceEntity();

		switch (action) {

		case ConstantsCrud.SAVE:
			result = raceDao.insert(raceEn);
		case ConstantsCrud.UPDATE:
			result = raceDao.update(raceEn);
		case ConstantsCrud.FIND:
			result = raceDao.findByUniqueAttributConstraint(raceEn);
		}
		return RaceMapper.transformRaceEntityToRaceDto(result);
	}

	public Set<RaceDto> getRacesDto(RaceDto raceDto) {
		RaceEntity raceEn = RaceMapper.transformRaceDtoToRaceEntity(raceDto);
		Set<RaceEntity> result = raceDao.getByAttributes(raceEn);
		return RaceMapper.transformListRaceEntityToListRaceDto(result);
	}

	public void delete(RaceDto raceDto) {
		RaceEntity raceEn = RaceMapper.transformRaceDtoToRaceEntity(raceDto);
		raceDao.delete(raceEn);
	}

}
