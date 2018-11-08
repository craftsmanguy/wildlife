package com.ilmani.dream.wildlives.presenter.rest.business.advert.v1;

import javax.ejb.EJB;
import javax.ws.rs.ext.Provider;

import com.ilmani.dream.wildlives.advert.business.api.AdvertBusinessLocal;
import com.ilmani.dream.wildlives.framework.dto.advert.AbstractAdvertDto;
import com.ilmani.dream.wildlives.framework.exceptions.EntityNotFoundException;
import com.ilmani.dream.wildlives.framework.exceptions.RequiredFieldException;
import com.ilmani.dream.wildlives.framework.exceptions.RestClientException;

@Provider
public class AdvertBusinessProvider {

	@EJB(name = "AdvertBusinessManager")
	AdvertBusinessLocal advertLocal;

	public AbstractAdvertDto saveAdvert(AbstractAdvertDto advert)
			throws RestClientException, RequiredFieldException, EntityNotFoundException {
		return advertLocal.saveAdvert(advert);
	}

}
