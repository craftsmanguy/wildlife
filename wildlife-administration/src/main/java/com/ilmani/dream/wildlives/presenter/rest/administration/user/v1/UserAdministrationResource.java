package com.ilmani.dream.wildlives.presenter.rest.administration.user.v1;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.Path;

import com.ilmani.dream.wildlives.framework.rest.service.AbstractService;

@Singleton
@Path("/v1")
public class UserAdministrationResource extends AbstractService {

	@Inject
	UserAdministrationProvider userProvider;

}
