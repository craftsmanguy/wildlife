package com.ilmani.dream.wildlives.presenter.rest.business.pet.v1;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.HttpMethod;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.ilmani.dream.wildlives.framework.dto.pet.PetDto;
import com.ilmani.dream.wildlives.framework.rest.service.AbstractService;

@Singleton
@Path("/v1")
public class PetBusinessResource extends AbstractService {

	@Inject
	PetBusinessProvider petProvider;


	@POST
	@Path("pets")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response savePet(PetDto pet) throws Exception {
		return responseHeader.responseBuilder(HttpMethod.POST, Response.Status.CREATED)
				.entity(petProvider.savePet(pet)).build();
	}
	
	@DELETE
	@Path("pets/{functionalId}")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response deletePet(@PathParam("functionalId") String functionalId) throws Exception {
		petProvider.deletePet(functionalId);
		return responseHeader.responseBuilder(HttpMethod.GET, Response.Status.RESET_CONTENT).build();
	}

}
