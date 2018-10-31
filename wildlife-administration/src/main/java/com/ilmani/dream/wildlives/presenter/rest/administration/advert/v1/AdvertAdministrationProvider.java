package com.ilmani.dream.wildlives.presenter.rest.administration.advert.v1;

import javax.ejb.EJB;
import javax.ws.rs.ext.Provider;

import com.ilmani.dream.wildlives.advert.administration.api.AdvertAdministrationLocal;
import com.ilmani.dream.wildlives.framework.version.Number;
import com.ilmani.dream.wildlives.framework.version.Version;

@Provider
@Version(Number.V1)
public class AdvertAdministrationProvider {

	@EJB(name = "AdvertAdministrationManager")
	AdvertAdministrationLocal advertLocal;

}
