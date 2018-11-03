package com.ilmani.dream.wildlives.pet.business.api;

import javax.ejb.Local;

import com.ilmani.dream.wildlives.framework.dto.pet.PetDto;
import com.ilmani.dream.wildlives.framework.exceptions.EntityNotFoundException;
import com.ilmani.dream.wildlives.framework.exceptions.RequiredFieldException;
import com.ilmani.dream.wildlives.framework.exceptions.RestClientException;

@Local
public interface PetBusinessLocal {
	
	public PetDto savePet(PetDto pet) throws RestClientException, RequiredFieldException, EntityNotFoundException;
	
	public void deletePet(String functionalId) throws EntityNotFoundException, RestClientException;

}
