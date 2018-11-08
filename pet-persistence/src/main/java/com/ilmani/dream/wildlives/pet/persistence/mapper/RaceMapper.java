package com.ilmani.dream.wildlives.pet.persistence.mapper;

import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtils;

import com.ilmani.dream.wildlives.framework.dto.pet.AbstractRaceDto;
import com.ilmani.dream.wildlives.framework.dto.pet.RaceBusinessDto;
import com.ilmani.dream.wildlives.framework.dto.pet.RaceMinimalDto;
import com.ilmani.dream.wildlives.pet.persistence.entity.RaceEntity;

public class RaceMapper {

	public static RaceBusinessDto transformRaceEntityToRaceDto(RaceEntity raceEntity) {
		RaceBusinessDto raceDto = new RaceBusinessDto();
		if (raceEntity == null) {
			return raceDto;
		}
		try {
			BeanUtils.copyProperties(raceDto, raceEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO log
			raceDto = new RaceBusinessDto(raceEntity.getName(), raceEntity.getSpecie(), raceEntity.getClan());
		}
		return raceDto;
	}

	public static Set<AbstractRaceDto> transformListRaceEntityToListRaceDto(Set<RaceEntity> racesEntity) {
		Set<AbstractRaceDto> racesDto = new HashSet<AbstractRaceDto>();
		if (racesEntity.isEmpty()) {
			return racesDto;
		}
		for (RaceEntity raceEnTemp : racesEntity) {
			RaceBusinessDto raceDtoTemp = transformRaceEntityToRaceDto(raceEnTemp);
			racesDto.add(raceDtoTemp);
		}
		return racesDto;
	}

	public static RaceEntity transformRaceDtoToRaceEntity(AbstractRaceDto raceDto) {
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

	public static void copyNewRaceEntityToOldRaceEntity(RaceEntity raceToUpdate, RaceEntity newRace) {
		raceToUpdate.setName(newRace.getName());
		raceToUpdate.setCode(newRace.getCode());
		raceToUpdate.setSpecie(newRace.getSpecie());
		raceToUpdate.setClan(newRace.getClan());
		raceToUpdate.setScientistName(newRace.getScientistName());
		raceToUpdate.setActive(newRace.isActive());
	}

	public static RaceEntity transformRaceMinimalDtoToRaceEntity(RaceMinimalDto raceDto) {
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

	public static RaceMinimalDto transformRaceEntityToRaceMinimalDto(RaceEntity raceEntity) {
		AbstractRaceDto raceDto = new RaceMinimalDto();
		if (raceEntity == null) {
			return (RaceMinimalDto) raceDto;
		}
		try {
			BeanUtils.copyProperties(raceDto, raceEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO log
			raceDto = new RaceBusinessDto(raceEntity.getName(), raceEntity.getSpecie(), raceEntity.getClan());
		}
		return (RaceMinimalDto) raceDto;
	}
}
