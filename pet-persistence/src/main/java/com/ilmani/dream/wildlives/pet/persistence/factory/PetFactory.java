package com.ilmani.dream.wildlives.pet.persistence.factory;

import java.util.List;

import javax.inject.Inject;

import com.ilmani.dream.wildlives.framework.constants.ConstantsCrud;
import com.ilmani.dream.wildlives.framework.dto.pet.AbstractPetDto;
import com.ilmani.dream.wildlives.framework.dto.pet.PetBusinessDto;
import com.ilmani.dream.wildlives.pet.persistence.dao.PetDao;
import com.ilmani.dream.wildlives.pet.persistence.dao.RaceDao;
import com.ilmani.dream.wildlives.pet.persistence.entity.PetEntity;
import com.ilmani.dream.wildlives.pet.persistence.mapper.PetMapper;

public class PetFactory {

	@Inject
	PetDao petDao;

	@Inject
	RaceDao raceDao;

	public PetBusinessDto getPetDto(PetBusinessDto petDto, String action) {
		PetEntity petEn = PetMapper.transformPetDtoToPetEntity(petDto);
		PetEntity result = new PetEntity();

		petEn.setRaceEn(raceDao.findByCode(petEn.getRaceEn().getCode()));

		switch (action) {
		case ConstantsCrud.UPDATE:
			result = petDao.update(petEn);
			break;
		}

		return (PetBusinessDto) PetMapper.transformPetEntityToPetBusinessDto(result);
	}

	public List<AbstractPetDto> getPetsDto(AbstractPetDto petDto) {
		PetEntity petEn = PetMapper.transformPetDtoToPetEntity((PetBusinessDto) petDto);
		List<PetEntity> results = petDao.getByAttributes(petEn);
		return PetMapper.transformListPetEntityToListPetDto(results);
	}


}
