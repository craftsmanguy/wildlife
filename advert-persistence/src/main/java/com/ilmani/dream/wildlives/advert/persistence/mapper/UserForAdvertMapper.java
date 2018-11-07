package com.ilmani.dream.wildlives.advert.persistence.mapper;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.ilmani.dream.wildlives.advert.persistence.entity.PetForAdvertEntity;
import com.ilmani.dream.wildlives.framework.dto.pet.AbstractPetDto;
import com.ilmani.dream.wildlives.framework.dto.pet.PetMinimalDto;

public class UserForAdvertMapper {
	
	public static AbstractPetDto transformPetForUserEntityToAbstractPetDto(PetForAdvertEntity petEntity) {
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
	
	public static List<AbstractPetDto> transformListForUserEntityToListAbstractPetDto(List<PetForAdvertEntity> petsEntity) {
		List<AbstractPetDto> petsDto = new ArrayList<AbstractPetDto>();
		if (petsEntity.isEmpty()) {
			return petsDto;
		}
		for (PetForAdvertEntity petEnTemp : petsEntity) {
			PetMinimalDto petDtoTemp = (PetMinimalDto) transformPetForUserEntityToAbstractPetDto(petEnTemp);
			petsDto.add(petDtoTemp);
		}
		return petsDto;
	}

}
