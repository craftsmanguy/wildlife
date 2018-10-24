package com.ilmani.dream.wildlives.pet.persistence.mapper;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtils;

import com.ilmani.dream.wildlives.framework.dto.pet.RaceDto;
import com.ilmani.dream.wildlives.pet.persistence.entity.RaceEntity;

public class RaceMapper {

	public static RaceDto transformRaceEntityToRaceDto(RaceEntity raceEntity) {
		RaceDto raceDto = new RaceDto();
		if (raceEntity == null) {
			return raceDto;
		}
		try {
			BeanUtils.copyProperties(raceDto, raceEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO log
			raceDto = new RaceDto(raceEntity.getName(), raceEntity.getSpecie(), raceEntity.getClan());
		}
		return raceDto;
	}

	public static List<RaceDto> transformListRaceEntityToListRaceDto(Set<RaceEntity> racesEntity) {
		List<RaceDto> racesDto;
		if (racesEntity.isEmpty()) {
			return Collections.emptyList();
		}
		racesDto = new ArrayList<RaceDto>();
		for (RaceEntity raceEnTemp : racesEntity) {
			RaceDto raceDtoTemp = transformRaceEntityToRaceDto(raceEnTemp);
			racesDto.add(raceDtoTemp);
		}
		return racesDto;
	}

	public static RaceEntity transformRaceDtoToRaceEntity(RaceDto raceDto) {
		RaceEntity raceEntity = new RaceEntity();
		if (raceDto == null) {
			return raceEntity;
		}
		try {
			BeanUtils.copyProperties(raceEntity, raceDto);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO log
		}
		return raceEntity;
	}

}
