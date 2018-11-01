package com.ilmani.dream.wildlives.pet.persistence.factory;

import java.util.List;

import javax.inject.Inject;

import com.ilmani.dream.wildlives.framework.constants.ConstantsCrud;
import com.ilmani.dream.wildlives.framework.dto.pet.PetDto;
import com.ilmani.dream.wildlives.pet.persistence.dao.PetDao;
import com.ilmani.dream.wildlives.pet.persistence.dao.RaceDao;
import com.ilmani.dream.wildlives.pet.persistence.entity.PetEntity;
import com.ilmani.dream.wildlives.pet.persistence.mapper.PetMapper;

public class PetFactory {
	
	@Inject
	PetDao petDao;
	
	@Inject
	RaceDao raceDao;
	
	public PetDto getPetDto(PetDto petDto, String action) {
		PetEntity petEn = PetMapper.transformPetDtoToPetEntity(petDto);
		PetEntity result = new PetEntity();
		
		petEn.setRaceEn(raceDao.findByUniqueAttributConstraint(petEn.getRaceEn()));

		switch (action) {
		case ConstantsCrud.SAVE:
			result = petDao.insert(petEn);
			break;
		case ConstantsCrud.UPDATE:
			result = petDao.update(petEn);
			break;
		case ConstantsCrud.FIND:
			result = petDao.findByIdentifier(petEn);
			break;
		}
		
		return PetMapper.transformPetEntityToPetDto(result);
	}

	public List<PetDto> getPetsDto(PetDto petDto) {
		PetEntity petEn = PetMapper.transformPetDtoToPetEntity(petDto);
		List<PetEntity> results = petDao.getByAttributes(petEn);
		return PetMapper.transformListPetEntityToListPetDto(results);
	}

	public void delete(PetDto petDto) {
		PetEntity petEn = PetMapper.transformPetDtoToPetEntity(petDto);
		petDao.delete(petEn);
	}

}
