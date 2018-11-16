package com.ilmani.dream.wildlives.pet.persistence.adapter;

import javax.inject.Inject;

import com.ilmani.dream.wildlives.framework.dto.pet.AbstractPetDto;
import com.ilmani.dream.wildlives.framework.dto.pet.PetBusinessDto;
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
	public AbstractPetDto save(AbstractPetDto pet) {
		PetEntity petEn = PetMapper.transformPetBusinessDtoToPetEntity(pet);
		petEn.setRaceEn(raceDao.findByCode(petEn.getRaceEn().getCode()));
		petEn.setUserEn(userDao.findUserByPseudonym(((PetBusinessDto) pet).getUserForPet()));
		PetEntity result = petDao.insert(petEn);
		return PetMapper.transformPetEntityToPetBusinessDto(result);
	}

	@Override
	public boolean isExists(String functionalId) {
		return petDao.isExists(functionalId);
	}

	@Override
	public void delete(String functionalId) {
		PetEntity petToDelete = petDao.findByFunctionalId(functionalId);
		petDao.delete(petToDelete);

	}

	@Override
	public AbstractPetDto find(String id) {
		PetEntity result = petDao.findByFunctionalId(id);
		return PetMapper.transformPetEntityToPetBusinessDto(result);
	}

}
