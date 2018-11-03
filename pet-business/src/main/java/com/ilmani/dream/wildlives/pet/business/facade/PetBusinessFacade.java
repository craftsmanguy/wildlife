package com.ilmani.dream.wildlives.pet.business.facade;

import javax.inject.Inject;

import com.ilmani.dream.wildlives.framework.dto.pet.PetDto;
import com.ilmani.dream.wildlives.pet.business.port.PetBusinessDomain;

public class PetBusinessFacade {


	@Inject
	PetBusinessDomain petDomain;


	public PetDto savePet(PetDto pet) {
		return petDomain.save(pet);
	}
	
	public boolean isPetExists(String functionalId) {
		return petDomain.isExists(functionalId);
	}
	
	public void deletePet(String functionalId) {
		petDomain.delete(functionalId);
	}


}
