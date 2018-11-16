package com.ilmani.dream.wildlives.pet.persistence.mapper;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.ilmani.dream.wildlives.framework.dto.pet.AbstractPetDto;
import com.ilmani.dream.wildlives.framework.dto.pet.PetBusinessDto;
import com.ilmani.dream.wildlives.pet.persistence.entity.PetEntity;

public class PetMapper {

	
	public static List<AbstractPetDto> transformListPetEntityToListPetDto(List<PetEntity> petsEntity) {
		List<AbstractPetDto> petsDto = new ArrayList<AbstractPetDto>();
		if (petsEntity.isEmpty()) {
			return petsDto;
		}
		for (PetEntity petEnTemp : petsEntity) {
			AbstractPetDto petDtoTemp = transformPetEntityToPetBusinessDto(petEnTemp);
			petsDto.add(petDtoTemp);
		}
		return petsDto;
	}

	public static PetEntity transformPetDtoToPetEntity(AbstractPetDto petDto) {
		PetEntity petEntity = new PetEntity();
		if (petDto == null) {
			return petEntity;
		}
		try {
			BeanUtils.copyProperties(petEntity, petDto);
			if (((PetBusinessDto) petDto).getRace() != null) {
				petEntity.setRaceEn(RaceMapper.transformRaceDtoToRaceEntity(((PetBusinessDto) petDto).getRace()));
			}
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO log
		}
		return petEntity;
	}
	
	public static PetEntity transformPetBusinessDtoToPetEntity(AbstractPetDto petDto) {
		PetEntity petEntity = new PetEntity();
		if (petDto == null) {
			return petEntity;
		}
		try {
			BeanUtils.copyProperties(petEntity, petDto);
			if (((PetBusinessDto) petDto).getRace() != null) {
				petEntity.setRaceEn(RaceMapper.transformRaceDtoToRaceEntity(((PetBusinessDto) petDto).getRace()));
			}
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO log
		}
		return petEntity;
	}
	
	public static AbstractPetDto transformPetEntityToPetBusinessDto(PetEntity petEntity) {
		AbstractPetDto petDto = new PetBusinessDto();
		if (petEntity == null) {
			return petDto;
		}
		try {
			BeanUtils.copyProperties(petDto, petEntity);
			if (petEntity.getRaceEn() != null) {
				((PetBusinessDto) petDto).setRace(RaceMapper.transformRaceEntityToRaceMinimalDto(petEntity.getRaceEn()));
			}
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO log
		}
		return petDto;
	}


}
