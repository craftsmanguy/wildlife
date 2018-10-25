package com.ilmani.dream.wildlives.pet.persistence.factory;

import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import com.ilmani.dream.wildlives.framework.dto.pet.RaceDto;
import com.ilmani.dream.wildlives.pet.persistence.dao.RaceDao;
import com.ilmani.dream.wildlives.pet.persistence.entity.RaceEntity;
import com.ilmani.dream.wildlives.pet.persistence.mapper.RaceMapper;

public class RaceFactory {

	RaceDao raceDao;
	private final static String SAVE_RACE = "SAVE";
	private final static String UPDATE_RACE = "UPDATE";
	private final static String FIND_RACE = "FIND";

	@Inject
	public RaceFactory(RaceDao raceDao) {
		this.raceDao = raceDao;
	}

	public RaceDto getRaceDto(RaceDto raceDto, String action) {
		RaceEntity raceEn = RaceMapper.transformRaceDtoToRaceEntity(raceDto);
		RaceEntity result = new RaceEntity();

		switch (action) {

		case SAVE_RACE:
			result = raceDao.save(raceEn);
		case UPDATE_RACE:
			result = raceDao.update(raceEn);
		case FIND_RACE:
			result = raceDao.findByAttribut(raceEn);
		}
		return RaceMapper.transformRaceEntityToRaceDto(result);
	}

	public List<RaceDto> getRacesDto(RaceDto raceDto) {
		RaceEntity raceEn = RaceMapper.transformRaceDtoToRaceEntity(raceDto);
		Set<RaceEntity> result = raceDao.getByAttribut(raceEn);
		return RaceMapper.transformListRaceEntityToListRaceDto(result);
	}

	public void delete(RaceDto raceDto) {
		RaceEntity raceEn = RaceMapper.transformRaceDtoToRaceEntity(raceDto);
		raceDao.delete(raceEn);
	}

}
