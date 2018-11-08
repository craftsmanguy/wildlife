package com.ilmani.dream.wildlives.presenter.rest.business.advert.v1;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.HttpMethod;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.ilmani.dream.wildlives.framework.dto.advert.AdvertBusinessDto;
import com.ilmani.dream.wildlives.framework.rest.service.AbstractService;
import com.ilmani.dream.wildlives.framework.security.TokenAuthentication;

@Singleton
@Path("/v1")
public class AdvertBusinessResource extends AbstractService {

	@Inject
	AdvertBusinessProvider advertProvider;
	
	@POST
	@Path("adverts")
	@TokenAuthentication
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response saveAdvert(AdvertBusinessDto advert) throws Exception {
		return responseHeader.responseBuilder(HttpMethod.POST, Response.Status.CREATED)
				.entity(advertProvider.saveAdvert(advert)).build();
	}

}
