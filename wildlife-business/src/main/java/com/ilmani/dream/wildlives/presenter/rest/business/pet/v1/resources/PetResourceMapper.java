package com.ilmani.dream.wildlives.presenter.rest.business.pet.v1.resources;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import com.ilmani.dream.wildlives.framework.dto.pet.PetDto;

public class PetResourceMapper {

	public static PetDto transformPetResourceToPetDto(PetResource petResource) {
		PetDto petDto = new PetDto();
		if (petResource == null) {
			return petDto;
		}
		try {
			BeanUtils.copyProperties(petDto, petResource);
			petDto.setFunctionalIdentifier(petResource.getId());
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO log
		}
		return petDto;
	}


	public static PetResource transformPetDtoToPetResource(PetDto petDto) {
		PetResource petResource = new PetResource();
		if (petDto == null) {
			return petResource;
		}
		try {
			BeanUtils.copyProperties(petResource, petDto);
			petResource.setId(petDto.getFunctionalIdentifier());
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO log
		}
		return petResource;
	}

}
