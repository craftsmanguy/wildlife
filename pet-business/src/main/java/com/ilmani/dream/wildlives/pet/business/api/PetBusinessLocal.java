package com.ilmani.dream.wildlives.pet.business.api;

import javax.ejb.Local;

import com.ilmani.dream.wildlives.framework.dto.pet.AbstractPetDto;
import com.ilmani.dream.wildlives.framework.exceptions.EntityNotFoundException;
import com.ilmani.dream.wildlives.framework.exceptions.RequiredFieldException;
import com.ilmani.dream.wildlives.framework.exceptions.RestClientException;

@Local
public interface PetBusinessLocal {
	
	public AbstractPetDto savePet(AbstractPetDto pet) throws RestClientException, RequiredFieldException, EntityNotFoundException;
	
	public void deletePet(String id) throws EntityNotFoundException, RestClientException;

}
