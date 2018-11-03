package com.ilmani.dream.wildlives.presenter.rest.administration.pet.v1;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HttpMethod;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.ilmani.dream.wildlives.framework.dto.pet.RaceDto;
import com.ilmani.dream.wildlives.framework.rest.service.AbstractService;

@Singleton
@Path("/v1")
public class PetAdministrationResource extends AbstractService {

	@Inject
	PetAdministrationProvider petProvider;

	@POST
	@Path("races")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response saveRace(RaceDto race) throws Exception {
		return responseHeader.responseBuilder(HttpMethod.POST, Response.Status.CREATED)
				.entity(petProvider.saveRace(race)).build();
	}

	@PUT
	@Path("races/{code}")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response updateRace(@PathParam("code") String code, RaceDto race) throws Exception {
		return responseHeader.responseBuilder(HttpMethod.PUT, Response.Status.OK)
				.entity(petProvider.updateRace(race, code)).build();
	}

	@GET
	@Path("races/{code}")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response findRaceByIdentifier(@PathParam("code") String code) throws Exception {
		return responseHeader.responseBuilder(HttpMethod.GET, Response.Status.OK)
				.entity(petProvider.findRaceByCode(code)).build();
	}

	@DELETE
	@Path("races/{code}")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response deleteRace(@PathParam("code") String code) throws Exception {
		petProvider.deleteRace(code);
		return responseHeader.responseBuilder(HttpMethod.GET, Response.Status.RESET_CONTENT).build();
	}

	@GET
	@Path("races")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response searchRacesByIdentifier(@QueryParam("name") String name, @QueryParam("specie") String specie,
			@QueryParam("clan") String clan) throws Exception {
		RaceDto race = new RaceDto(name, specie, clan);
		return responseHeader.responseBuilder(HttpMethod.GET, Response.Status.OK).entity(petProvider.searchRaces(race))
				.build();
	}

}
