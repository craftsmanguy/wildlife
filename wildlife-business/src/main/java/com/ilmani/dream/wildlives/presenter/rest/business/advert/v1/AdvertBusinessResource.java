package com.ilmani.dream.wildlives.presenter.rest.business.advert.v1;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.Path;

import com.ilmani.dream.wildlives.framework.rest.service.AbstractService;
import com.ilmani.dream.wildlives.framework.version.Number;
import com.ilmani.dream.wildlives.framework.version.Version;

@Singleton
@Path("/v1")
public class AdvertBusinessResource extends AbstractService {

	@Inject
	@Version(Number.V1)
	AdvertBusinessProvider advertProvider;

}
