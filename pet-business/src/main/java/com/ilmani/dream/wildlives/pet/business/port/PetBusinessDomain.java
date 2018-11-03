package com.ilmani.dream.wildlives.pet.business.port;

import com.ilmani.dream.wildlives.framework.dto.pet.PetDto;

public interface PetBusinessDomain {

	public PetDto save(PetDto pet);
	
	public boolean isExists(String functionalId);
	
	public void delete(String functionalId);

}
