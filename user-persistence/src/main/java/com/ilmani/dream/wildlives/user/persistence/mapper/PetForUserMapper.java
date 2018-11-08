package com.ilmani.dream.wildlives.user.persistence.mapper;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.ilmani.dream.wildlives.framework.dto.pet.AbstractPetDto;
import com.ilmani.dream.wildlives.framework.dto.pet.PetMinimalDto;
import com.ilmani.dream.wildlives.user.persistence.entity.PetForUserEntity;

public class PetForUserMapper {
	
	public static AbstractPetDto transformPetForUserEntityToAbstractPetDto(PetForUserEntity petEntity) {
		PetMinimalDto petDto = new PetMinimalDto();
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
	
	public static List<AbstractPetDto> transformListPetsEntityToListPetsDto(List<PetForUserEntity> petsEntity) {
		List<AbstractPetDto> petsDto = new ArrayList<AbstractPetDto>();
		if (petsEntity.isEmpty()) {
			return petsDto;
		}
		for (PetForUserEntity petEnTemp : petsEntity) {
			PetMinimalDto petDtoTemp = (PetMinimalDto) transformPetForUserEntityToAbstractPetDto(petEnTemp);
			petsDto.add(petDtoTemp);
		}
		return petsDto;
	}

}
