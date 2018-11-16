package com.ilmani.dream.wildlives.presenter.rest.business.advert.v1;

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

import com.ilmani.dream.wildlives.framework.dto.advert.FormatBusinessDto;
import com.ilmani.dream.wildlives.framework.rest.service.AbstractService;

@Singleton
@Path("/v1")
public class FormatBusinessResource extends AbstractService {

	@Inject
	AdvertBusinessProvider advertProvider;

	@GET
	@Path("formats")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response searchActiveFormatByName(@QueryParam("name") String name) throws Exception {
		FormatBusinessDto format = new FormatBusinessDto(name);
		return responseHeader.responseBuilder(HttpMethod.GET, Response.Status.OK)
				.entity(advertProvider.searchFormats(format)).build();
	}

}
