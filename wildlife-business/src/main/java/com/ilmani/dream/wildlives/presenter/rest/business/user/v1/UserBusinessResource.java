package com.ilmani.dream.wildlives.presenter.rest.business.user.v1;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.HttpMethod;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.ilmani.dream.wildlives.framework.dto.user.UserInscriptionDto;
import com.ilmani.dream.wildlives.framework.rest.service.AbstractService;

@Singleton
@Path("/v1")
public class UserBusinessResource extends AbstractService {

	@Inject
	UserBusinessProvider userProvider;

	@POST
	@Path("users")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response saveUser(UserInscriptionDto user) throws Exception {
		userProvider.saveUser(user);
		return responseHeader.responseBuilder(HttpMethod.POST, Response.Status.CREATED).build();
	}

}
