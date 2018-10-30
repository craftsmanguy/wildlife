package com.ilmani.dream.wildlives.administration.presentation.rest.ressource.pet.v1;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HttpMethod;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.ilmani.dream.wildlives.administration.presentation.rest.provider.v1.PetAdministrationProvider;
import com.ilmani.dream.wildlives.framework.dto.pet.RaceDto;
import com.ilmani.dream.wildlives.framework.rest.service.AbstractService;
import com.ilmani.dream.wildlives.framework.version.Number;
import com.ilmani.dream.wildlives.framework.version.Version;

@Singleton
@Path("/v1")
public class PetAdministrationResource extends AbstractService {

	@Inject
	@Version(Number.V1)
	PetAdministrationProvider petProvider;

	@GET
	@Path("races")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response searchRacesByIdenfier(@QueryParam("name") String name, @QueryParam("specie") String specie,
			@QueryParam("type") String type) throws Exception {
		RaceDto race = new RaceDto(name, specie, type);
		return responseHeader.responseBuilder(HttpMethod.GET, Response.Status.OK)
				.entity(petProvider.searchRacesByIdenfier(race)).build();
	}

}
