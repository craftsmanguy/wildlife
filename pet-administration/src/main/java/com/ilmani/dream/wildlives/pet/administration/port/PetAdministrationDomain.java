package com.ilmani.dream.wildlives.pet.administration.port;

import com.ilmani.dream.wildlives.framework.dto.pet.PetDto;

public interface PetAdministrationDomain {

	public PetDto getByIdenfier(PetDto pet);

	public PetDto save(PetDto pet);

	public void delete(PetDto pet);

	public PetDto update(PetDto pet);

}
