package com.ilmani.dream.wildlives.pet.administration.api.impl.v1;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;

import com.ilmani.dream.wildlives.framework.dto.pet.RaceDto;
import com.ilmani.dream.wildlives.pet.administration.api.PetLocal;

@Stateless(name = "PetBean")
@TransactionManagement(TransactionManagementType.BEAN)
public class PetBean implements PetLocal {

	PetManager petManager;

	@Inject
	public PetBean(PetManager petManager) {
		this.petManager = petManager;
	}

	@Override
	public List<RaceDto> searchRacesByIdenfier(RaceDto race) {
		return petManager.searchRacesByIdenfier(race);
	}

}
