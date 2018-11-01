package com.ilmani.dream.wildlives.presenter.rest.business.advert.v1;

import javax.ejb.EJB;
import javax.ws.rs.ext.Provider;

import com.ilmani.dream.wildlives.advert.business.api.AdvertBusinessLocal;
import com.ilmani.dream.wildlives.framework.version.Number;
import com.ilmani.dream.wildlives.framework.version.Version;

@Provider
@Version(Number.V1)
public class AdvertBusinessProvider {

	@EJB(name = "AdvertBusinessManager")
	AdvertBusinessLocal advertLocal;

}
