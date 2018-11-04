package com.ilmani.dream.wildlives.presenter.rest.business.security.v1;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.HttpMethod;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.ilmani.dream.wildlives.framework.dto.auth.ConnectionFieldsDto;
import com.ilmani.dream.wildlives.framework.rest.service.AbstractService;

@Singleton
@Path("/v1")
public class AuthenticationUserService extends AbstractService {

	@Inject
	AuthenticationUserProvider authProvider;

	@Context
	UriInfo uriInfo;

	@POST
	@Path("authentication/login")
	public Response authenticate(ConnectionFieldsDto fields) throws Exception {
		String token = authProvider.authenticate(fields, uriInfo.getAbsolutePath().toString());
		return responseHeader.responseBuilder(HttpMethod.GET, Response.Status.OK)
				.header(HttpHeaders.AUTHORIZATION, "Bearer " + token).build();
	}

}
