package com.ilmani.dream.wildlives.pet.persistence.adapter;

import javax.inject.Inject;
import javax.persistence.NoResultException;

import com.ilmani.dream.wildlives.framework.dto.pet.PetDto;
import com.ilmani.dream.wildlives.framework.version.Crud;
import com.ilmani.dream.wildlives.pet.administration.port.PetAdministrationDomain;
import com.ilmani.dream.wildlives.pet.persistence.factory.PetFactory;

public class PetAdministrationDomainImpl implements PetAdministrationDomain {

	@Inject
	PetFactory petFactory;

	@Override
	public PetDto getByIdenfier(PetDto pet) throws NoResultException {
		return petFactory.getPetDto(pet, Crud.valueOf("FIND").getAction());
	}

	@Override
	public PetDto save(PetDto pet) {
		return petFactory.getPetDto(pet, Crud.valueOf("SAVE").getAction());
	}

	@Override
	public void delete(PetDto pet) {
		petFactory.delete(pet);
		
	}

	@Override
	public PetDto update(PetDto pet) {
		return petFactory.getPetDto(pet, Crud.valueOf("UPDATE").getAction());
	}

}
