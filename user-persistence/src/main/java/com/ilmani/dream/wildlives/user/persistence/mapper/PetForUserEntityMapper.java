package com.ilmani.dream.wildlives.user.persistence.mapper;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.ilmani.dream.wildlives.framework.dto.pet.PetDto;
import com.ilmani.dream.wildlives.user.persistence.entity.PetForUserEntity;

public class PetForUserEntityMapper {
	
	public static PetDto transformPetForUserEntityToPetDto(PetForUserEntity petEntity) {
		PetDto petDto = new PetDto();
		if (petEntity == null) {
			return petDto;
		}
		try {
			BeanUtils.copyProperties(petDto, petEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO log
		}
		return petDto;
	}

	public static List<PetDto> transformListForUserEntityToListPetDto(List<PetForUserEntity> petsEntity) {
		List<PetDto> petsDto = new ArrayList<PetDto>();
		if (petsEntity.isEmpty()) {
			return petsDto;
		}
		for (PetForUserEntity petEnTemp : petsEntity) {
			PetDto petDtoTemp = transformPetForUserEntityToPetDto(petEnTemp);
			petsDto.add(petDtoTemp);
		}
		return petsDto;
	}

}
