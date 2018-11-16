package com.ilmani.dream.wildlives.presenter.rest.business.advert.v1;

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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.ilmani.dream.wildlives.framework.dto.advert.AdvertBusinessDto;
import com.ilmani.dream.wildlives.framework.rest.service.AbstractService;
import com.ilmani.dream.wildlives.framework.security.AuthenticationGateway;

@Singleton
@Path("/v1")
public class AdvertBusinessResource extends AbstractService {

	@Inject
	AdvertBusinessProvider advertProvider;

	@POST
	@Path("adverts")
	@AuthenticationGateway
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response saveAdvert(AdvertBusinessDto advert) throws Exception {
		return responseHeader.responseBuilder(HttpMethod.POST, Response.Status.CREATED)
				.entity(advertProvider.saveAdvert(advert)).build();
	}

	@DELETE
	@Path("adverts/{id}")
	@AuthenticationGateway
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response deleteAdvert(@PathParam("id") String id) throws Exception {
		advertProvider.deleteAdvert(id);
		return responseHeader.responseBuilder(HttpMethod.DELETE, Response.Status.RESET_CONTENT).build();
	}

	@GET
	@Path("adverts/{id}")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response findAdvert(@PathParam("id") String id) throws Exception {
		return responseHeader.responseBuilder(HttpMethod.GET, Response.Status.OK).entity(advertProvider.findAdvert(id))
				.build();
	}

	@GET
	@Path("adverts")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response searchAdvert(@QueryParam("code") String code) throws Exception {
		AdvertBusinessDto advert = new AdvertBusinessDto(code);
		return responseHeader.responseBuilder(HttpMethod.GET, Response.Status.OK)
				.entity(advertProvider.getAdvertByAttributes(advert)).build();
	}

}
