package com.ilmani.dream.wildlives.pet.persistence.factory;

import java.util.List;
import java.util.Set;

import javax.inject.Inject;

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
	
	private final static String SAVE_PET = "SAVE";
	private final static String UPDATE_PET = "UPDATE";
	private final static String FIND_PET = "FIND";

	public PetDto getPetDto(PetDto petDto, String action) {
		PetEntity petEn = PetMapper.transformPetDtoToPetEntity(petDto);
		PetEntity result = new PetEntity();
		
		petEn.setRaceEn(raceDao.findByUniqueAttributConstraint(petEn.getRaceEn()));

		switch (action) {
		case SAVE_PET:
			result = petDao.insert(petEn);
		case UPDATE_PET:
			result = petDao.update(petEn);
		case FIND_PET:
			result = petDao.findByIdentifier(petEn);
		}
		
		return PetMapper.transformPetEntityToPetDto(result);
	}

	public List<PetDto> getPetsDto(PetDto petDto) {
		PetEntity petEn = PetMapper.transformPetDtoToPetEntity(petDto);
		Set<PetEntity> result = petDao.getByAttributes(petEn);
		return PetMapper.transformListPetEntityToListPetDto(result);
	}

	public void delete(PetDto petDto) {
		PetEntity petEn = PetMapper.transformPetDtoToPetEntity(petDto);
		petDao.delete(petEn);
	}

}
