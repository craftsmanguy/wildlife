package com.ilmani.dream.wildlives.pet.persistence.mapper;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.ilmani.dream.wildlives.framework.dto.pet.PetDto;
import com.ilmani.dream.wildlives.pet.persistence.entity.PetEntity;

public class PetMapper {

	public static PetDto transformPetEntityToPetDto(PetEntity petEntity) {
		PetDto petDto = new PetDto();
		if (petEntity == null) {
			return petDto;
		}
		try {
			BeanUtils.copyProperties(petDto, petEntity);
			if (petEntity.getRaceEn() != null) {
				petDto.setRace(RaceMapper.transformRaceEntityToRaceDto(petEntity.getRaceEn()));
			}
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO log
		}
		return petDto;
	}

	public static List<PetDto> transformListPetEntityToListPetDto(List<PetEntity> petsEntity) {
		List<PetDto> petsDto = new ArrayList<PetDto>();
		if (petsEntity.isEmpty()) {
			return petsDto;
		}
		for (PetEntity petEnTemp : petsEntity) {
			PetDto petDtoTemp = transformPetEntityToPetDto(petEnTemp);
			petsDto.add(petDtoTemp);
		}
		return petsDto;
	}

	public static PetEntity transformPetDtoToPetEntity(PetDto petDto) {
		PetEntity petEntity = new PetEntity();
		if (petDto == null) {
			return petEntity;
		}
		try {
			BeanUtils.copyProperties(petEntity, petDto);
			if (petDto.getRace() != null) {
				petEntity.setRaceEn(RaceMapper.transformRaceDtoToRaceEntity(petDto.getRace()));
			}
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO log
		}
		return petEntity;
	}

}
