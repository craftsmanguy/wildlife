package com.ilmani.dream.wildlives.pet.persistence.mapper;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

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
			petDto.setInsertionDate(petEntity.getInsertionDate());
			if (petEntity.getRaceEn() != null) {
				petDto.setRaceDto(RaceMapper.transformRaceEntityToRaceDto(petEntity.getRaceEn()));
			}
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO log
		}
		return petDto;
	}

	public static List<PetDto> transformListPetEntityToListPetDto(Set<PetEntity> petsEntity) {
		List<PetDto> petsDto;
		if (petsEntity.isEmpty()) {
			return Collections.emptyList();
		}
		petsDto = new ArrayList<PetDto>();
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
			if (petDto.getRaceDto() != null) {
				petEntity.setRaceEn(RaceMapper.transformRaceDtoToRaceEntity(petDto.getRaceDto()));
			}
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO log
		}
		return petEntity;
	}

}
