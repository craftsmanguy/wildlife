package com.ilmani.dream.wildlives.presenter.rest.administration.advert.v1;

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

import com.ilmani.dream.wildlives.framework.dto.advert.FormatAdministratorDto;
import com.ilmani.dream.wildlives.framework.rest.service.AbstractService;

@Singleton
@Path("/v1")
public class AdvertAdministrationResource extends AbstractService {

	@Inject
	AdvertAdministrationProvider advertProvider;

	@POST
	@Path("formats")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response saveFormat(FormatAdministratorDto format) throws Exception {
		return responseHeader.responseBuilder(HttpMethod.POST, Response.Status.CREATED)
				.entity(advertProvider.saveFormat(format)).build();
	}

	@PUT
	@Path("formats/{code}")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response updateFormat(@PathParam("code") String code, FormatAdministratorDto format) throws Exception {
		return responseHeader.responseBuilder(HttpMethod.PUT, Response.Status.OK)
				.entity(advertProvider.updateFormat(format, code)).build();
	}

	@GET
	@Path("formats/{code}")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response findFormatByCode(@PathParam("code") String code) throws Exception {
		return responseHeader.responseBuilder(HttpMethod.GET, Response.Status.OK)
				.entity(advertProvider.findFormatByCode(code)).build();
	}

	@DELETE
	@Path("formats/{code}")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response deleteFormat(@PathParam("code") String code) throws Exception {
		advertProvider.deleteFormat(code);
		return responseHeader.responseBuilder(HttpMethod.GET, Response.Status.RESET_CONTENT).build();
	}

	@GET
	@Path("formats")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response searchFormatsByIdentifier(@QueryParam("name") String name, @QueryParam("feature") String feature)
			throws Exception {
		FormatAdministratorDto format = new FormatAdministratorDto(name, feature, true);
		return responseHeader.responseBuilder(HttpMethod.GET, Response.Status.OK)
				.entity(advertProvider.searchFormats(format)).build();
	}

}
