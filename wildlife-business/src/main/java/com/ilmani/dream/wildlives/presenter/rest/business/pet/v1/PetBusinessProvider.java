package com.ilmani.dream.wildlives.presenter.rest.business.pet.v1;

import javax.ejb.EJB;
import javax.ws.rs.ext.Provider;

import com.ilmani.dream.wildlives.framework.version.Number;
import com.ilmani.dream.wildlives.framework.version.Version;
import com.ilmani.dream.wildlives.pet.business.api.PetBusinessLocal;

@Provider
@Version(Number.V1)
public class PetBusinessProvider {

	@EJB(name = "PetBusinessManager")
	PetBusinessLocal petLocal;


}
