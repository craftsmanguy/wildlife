package com.ilmani.dream.wildlives.pet.business.port;

import com.ilmani.dream.wildlives.framework.dto.pet.AbstractPetDto;

public interface PetBusinessDomain {

	public AbstractPetDto save(AbstractPetDto pet);

	public boolean isExists(String functionalId);

	public void delete(String functionalId);

}
