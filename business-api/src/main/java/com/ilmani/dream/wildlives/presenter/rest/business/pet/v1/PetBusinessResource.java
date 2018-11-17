package com.ilmani.dream.wildlives.presenter.rest.business.pet.v1;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HttpMethod;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.ilmani.dream.wildlives.framework.dto.pet.PetBusinessDto;
import com.ilmani.dream.wildlives.framework.rest.service.AbstractService;
import com.ilmani.dream.wildlives.framework.security.AuthenticationGateway;

@Singleton
@Path("/v1")
public class PetBusinessResource extends AbstractService {

	@Inject
	PetBusinessProvider petProvider;

	@POST
	@Path("pets")
	@AuthenticationGateway
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response savePet(PetBusinessDto pet) throws Exception {
		return responseHeader.responseBuilder(HttpMethod.POST, Response.Status.CREATED).entity(petProvider.savePet(pet))
				.build();
	}

	@DELETE
	@Path("pets/{id}")
	@AuthenticationGateway
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response deletePet(@PathParam("id") String id) throws Exception {
		petProvider.deletePet(id);
		return responseHeader.responseBuilder(HttpMethod.DELETE, Response.Status.RESET_CONTENT).build();
	}

	@GET
	@Path("pets/{id}")
	@AuthenticationGateway
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response findPet(@PathParam("id") String id) throws Exception {
		return responseHeader.responseBuilder(HttpMethod.GET, Response.Status.OK).entity(petProvider.findPet(id))
				.build();
	}
}
