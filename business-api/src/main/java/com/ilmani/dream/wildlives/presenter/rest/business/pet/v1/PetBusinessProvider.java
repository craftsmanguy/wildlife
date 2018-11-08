package com.ilmani.dream.wildlives.presenter.rest.business.pet.v1;

import javax.ejb.EJB;
import javax.ws.rs.ext.Provider;

import com.ilmani.dream.wildlives.framework.dto.pet.AbstractPetDto;
import com.ilmani.dream.wildlives.framework.exceptions.EntityNotFoundException;
import com.ilmani.dream.wildlives.framework.exceptions.RequiredFieldException;
import com.ilmani.dream.wildlives.framework.exceptions.RestClientException;
import com.ilmani.dream.wildlives.pet.business.api.PetBusinessLocal;

@Provider
public class PetBusinessProvider {

	@EJB(name = "PetBusinessManager")
	PetBusinessLocal petLocal;

	public AbstractPetDto savePet(AbstractPetDto pet)
			throws RestClientException, RequiredFieldException, EntityNotFoundException {
		return petLocal.savePet(pet);
	}

	public void deletePet(String id) throws EntityNotFoundException, RestClientException {
		petLocal.deletePet(id);
	}

}
