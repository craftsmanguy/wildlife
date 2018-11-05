package com.ilmani.dream.wildlives.presenter.rest.business.pet.v1.resources;

import javax.ejb.EJB;
import javax.ws.rs.ext.Provider;

import com.ilmani.dream.wildlives.framework.dto.pet.PetDto;
import com.ilmani.dream.wildlives.framework.exceptions.EntityNotFoundException;
import com.ilmani.dream.wildlives.framework.exceptions.RequiredFieldException;
import com.ilmani.dream.wildlives.framework.exceptions.RestClientException;
import com.ilmani.dream.wildlives.pet.business.api.PetBusinessLocal;

@Provider
public class PetBusinessProvider {

	@EJB(name = "PetBusinessManager")
	PetBusinessLocal petLocal;

	public PetResource savePet(PetResource pet)
			throws RestClientException, RequiredFieldException, EntityNotFoundException {
		PetDto petDto = PetResourceMapper.transformPetResourceToPetDto(pet);
		PetDto result = petLocal.savePet(petDto);
		return PetResourceMapper.transformPetDtoToPetResource(result);
	}

	public void deletePet(String id) throws EntityNotFoundException, RestClientException {
		petLocal.deletePet(id);
	}

}
