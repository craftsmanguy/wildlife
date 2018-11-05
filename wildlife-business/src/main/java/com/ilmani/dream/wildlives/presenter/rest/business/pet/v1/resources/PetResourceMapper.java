package com.ilmani.dream.wildlives.presenter.rest.business.pet.v1.resources;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import com.ilmani.dream.wildlives.framework.dto.pet.PetDto;
import com.ilmani.dream.wildlives.framework.dto.pet.RaceDto;

public class PetResourceMapper {

	public static PetDto transformPetResourceToPetDto(PetResource petResource) {
		PetDto petDto = new PetDto();
		if (petResource == null) {
			return petDto;
		}
		try {
			BeanUtils.copyProperties(petDto, petResource);
			petDto.setFunctionalIdentifier(petResource.getId());

			if (petResource.getBreed() != null) {
				RaceDto raceDto = transformRaceResourceToRaceDto(petResource.getBreed());
				petDto.setRace(raceDto);
			}
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

			if (petDto.getRace() != null) {
				RaceResource raceResource = transformRaceDtoToRaceResource(petDto.getRace());
				petResource.setBreed(raceResource);
			}
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO log
		}
		return petResource;
	}

	public static RaceDto transformRaceResourceToRaceDto(RaceResource raceResource) {
		RaceDto raceDto = new RaceDto();
		if (raceResource == null) {
			return raceDto;
		}
		try {
			BeanUtils.copyProperties(raceDto, raceResource);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO log
		}
		return raceDto;
	}

	public static RaceResource transformRaceDtoToRaceResource(RaceDto raceDto) {
		RaceResource raceResource = new RaceResource();
		if (raceDto == null) {
			return raceResource;
		}
		try {
			BeanUtils.copyProperties(raceResource, raceDto);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO log
		}
		return raceResource;
	}

}
