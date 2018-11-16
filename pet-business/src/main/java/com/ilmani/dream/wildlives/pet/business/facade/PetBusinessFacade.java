package com.ilmani.dream.wildlives.pet.business.facade;

import java.util.Set;

import javax.inject.Inject;

import com.ilmani.dream.wildlives.framework.dto.pet.AbstractPetDto;
import com.ilmani.dream.wildlives.framework.dto.pet.AbstractRaceDto;
import com.ilmani.dream.wildlives.pet.business.port.PetBusinessDomain;
import com.ilmani.dream.wildlives.pet.business.port.RaceBusinessDomain;

public class PetBusinessFacade {

	@Inject
	PetBusinessDomain petDomain;
	
	@Inject
	RaceBusinessDomain raceDomain;

	public AbstractPetDto savePet(AbstractPetDto pet) {
		return petDomain.save(pet);
	}

	public boolean isPetExists(String functionalId) {
		return petDomain.isExists(functionalId);
	}

	public void deletePet(String functionalId) {
		petDomain.delete(functionalId);
	}
	
	public AbstractPetDto findPet(String functionalId) {
		return petDomain.find(functionalId);
	}
	
	public Set<AbstractRaceDto> searchRace(AbstractRaceDto race){
		return raceDomain.search(race);
	}

}
