package com.ilmani.dream.wildlives.pet.persistence.mapper;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.validation.constraints.NotNull;

import org.apache.commons.beanutils.BeanUtils;

import com.ilmani.dream.wildlives.framework.dto.pet.RaceDto;
import com.ilmani.dream.wildlives.pet.persistence.entity.RaceEntity;

public class RaceMapper {

	public static RaceDto transformRaceEntityToRaceDto(@NotNull RaceEntity raceEntity) {
		RaceDto raceDto;
		try {
			raceDto = new RaceDto();
			BeanUtils.copyProperties(raceDto, raceEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO log
			raceDto = new RaceDto(raceEntity.name, raceEntity.scientistName, raceEntity.code, raceEntity.specie,
					raceEntity.specieScientistName, raceEntity.specieCode, raceEntity.type,
					raceEntity.typeScientistName, raceEntity.typeCode);
		}
		return raceDto;
	}

	public static List<RaceDto> transformListRaceEntityToListRaceDto(Set<RaceEntity> racesEntity) {
		List<RaceDto> racesDto = new ArrayList<RaceDto>();
		try {
			racesDto = new ArrayList<RaceDto>();
			for (RaceEntity raceEnTemp : racesEntity) {
				RaceDto raceDtoTemp = transformRaceEntityToRaceDto(raceEnTemp);
				racesDto.add(raceDtoTemp);
			}
		} catch (Exception e) {
			racesDto = Collections.emptyList();
		}
		return racesDto;
	}

	public static RaceEntity transformRaceDtoToRaceEntity(RaceDto raceDto) {
		RaceEntity raceEntity;
		try {
			raceEntity = new RaceEntity();
			BeanUtils.copyProperties(raceEntity, raceDto);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO log
			raceEntity = new RaceEntity(raceDto.name, raceDto.scientistName, raceDto.code, raceDto.specie,
					raceDto.specieScientistName, raceDto.specieCode, raceDto.type, raceDto.typeScientistName,
					raceDto.typeCode);
		}
		return new RaceEntity();
	}

	public static List<RaceEntity> transformListRaceDtoToListRaceEntity(List<RaceDto> racesDto) {
		List<RaceEntity> racesEntity = new ArrayList<RaceEntity>();
		try {
			racesEntity = new ArrayList<RaceEntity>();
			for (RaceDto raceDtoTemp : racesDto) {
				RaceEntity raceEnTemp = transformRaceDtoToRaceEntity(raceDtoTemp);
				racesEntity.add(raceEnTemp);
			}
		} catch (Exception e) {
			racesDto = Collections.emptyList();
		}
		return racesEntity;
	}

}
