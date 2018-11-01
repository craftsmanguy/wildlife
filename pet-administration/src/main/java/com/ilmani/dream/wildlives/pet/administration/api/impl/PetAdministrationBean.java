package com.ilmani.dream.wildlives.pet.administration.api.impl;

import java.util.Set;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;

import com.ilmani.dream.wildlives.framework.dto.pet.RaceDto;
import com.ilmani.dream.wildlives.pet.administration.api.PetAdministrationLocal;

@Stateless(name = "PetAdministrationBean")
@TransactionManagement(TransactionManagementType.BEAN)
public class PetAdministrationBean implements PetAdministrationLocal {

	@Inject
	PetAdministrationManager petManager;


	@Override
	public Set<RaceDto> searchRacesByIdenfier(RaceDto race) {
		return petManager.searchRacesByIdenfier(race);
	}

}
