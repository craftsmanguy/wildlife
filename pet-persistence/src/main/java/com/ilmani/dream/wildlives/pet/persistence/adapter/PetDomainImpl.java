package com.ilmani.dream.wildlives.pet.persistence.adapter;

import javax.inject.Inject;

import com.ilmani.dream.wildlives.pet.business.port.PetDomain;
import com.ilmani.dream.wildlives.pet.persistence.dao.PetDao;

public class PetDomainImpl implements PetDomain {

	PetDao petDao;

	@Inject
	public PetDomainImpl(PetDao petDao) {
		this.petDao = petDao;

	}

	@Override
	public void getByIdenfier() {
		petDao.getByIdenfier();

	}

	@Override
	public void save() {
		petDao.save();
	}

	@Override
	public void delete() {
		petDao.delete();
	}

	@Override
	public void update() {
		petDao.update();
	}

}
