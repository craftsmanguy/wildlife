package com.ilmani.dream.wildlives.pet.persistence.adapter;

import javax.inject.Inject;

import com.ilmani.dream.wildlives.framework.dto.pet.PetDto;
import com.ilmani.dream.wildlives.pet.business.port.PetBusinessDomain;
import com.ilmani.dream.wildlives.pet.persistence.dao.PetDao;
import com.ilmani.dream.wildlives.pet.persistence.dao.RaceDao;
import com.ilmani.dream.wildlives.pet.persistence.dao.UserForPetDao;
import com.ilmani.dream.wildlives.pet.persistence.entity.PetEntity;
import com.ilmani.dream.wildlives.pet.persistence.mapper.PetMapper;

public class PetBusinessDomainImpl implements PetBusinessDomain {

	@Inject
	private RaceDao raceDao;

	@Inject
	private PetDao petDao;

	@Inject
	UserForPetDao userDao;

	@Override
	public PetDto save(PetDto pet) {
		PetEntity petEn = PetMapper.transformPetDtoToPetEntity(pet);
		petEn.setRaceEn(raceDao.findByCode(petEn.getRaceEn().getCode()));
		petEn.setUserEn(userDao.findUserByPseudonym(pet.getUserForPet()));
		PetEntity result = petDao.insert(petEn);
		return PetMapper.transformPetEntityToPetDto(result);
	}

	@Override
	public boolean isExists(String functionalId) {
		return petDao.isExists(functionalId);
	}

	@Override
	public void delete(String functionalId) {
		PetEntity petToDelete = petDao.findByFunctionalIdentifier(functionalId);
		petDao.delete(petToDelete);

	}

}
