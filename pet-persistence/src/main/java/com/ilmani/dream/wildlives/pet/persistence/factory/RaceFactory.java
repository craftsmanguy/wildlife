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

	@Inject
	public RaceFactory(RaceDao raceDao) {
		this.raceDao = raceDao;
	}

	public RaceDto getRaceDto(RaceDto raceDto, String action) {
		RaceEntity raceEn = RaceMapper.transformRaceDtoToRaceEntity(raceDto);
		RaceEntity result = new RaceEntity();
		switch (action) {

		case "SAVE":
			result = raceDao.save(raceEn);
		case "UPDATE":
			result = raceDao.update(raceEn);
		case "FIND":
			result = raceDao.findByIdenfier(raceEn);
		}
		return RaceMapper.transformRaceEntityToRaceDto(result);
	}

	public List<RaceDto> getRacesDto(RaceDto raceDto, String profil) {
		Set<RaceEntity> result;
		switch (profil) {

		case "GET":
			RaceEntity raceEn = RaceMapper.transformRaceDtoToRaceEntity(raceDto);
			result = raceDao.getByIdenfier(raceEn);
		default:
			result = raceDao.getAll();
		}
		return RaceMapper.transformListRaceEntityToListRaceDto(result);
	}

	public void delete(RaceDto raceDto) {
		RaceEntity raceEn = RaceMapper.transformRaceDtoToRaceEntity(raceDto);
		raceDao.delete(raceEn);
	}

}
