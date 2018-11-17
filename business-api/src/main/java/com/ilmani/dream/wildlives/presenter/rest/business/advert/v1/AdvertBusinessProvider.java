package com.ilmani.dream.wildlives.presenter.rest.business.advert.v1;

import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.ws.rs.ext.Provider;

import com.ilmani.dream.wildlives.advert.business.api.AdvertBusinessLocal;
import com.ilmani.dream.wildlives.framework.dto.advert.AbstractAdvertDto;
import com.ilmani.dream.wildlives.framework.dto.advert.AbstractFormatDto;
import com.ilmani.dream.wildlives.framework.exceptions.EntityNotFoundException;
import com.ilmani.dream.wildlives.framework.exceptions.RequiredFieldException;
import com.ilmani.dream.wildlives.framework.exceptions.RestClientException;
import com.ilmani.dream.wildlives.framework.exceptions.UnauthorizedException;

@Provider
public class AdvertBusinessProvider {

	@EJB(name = "AdvertBusinessManager")
	AdvertBusinessLocal advertLocal;

	public AbstractAdvertDto saveAdvert(AbstractAdvertDto advert)
			throws RestClientException, RequiredFieldException, EntityNotFoundException {
		return advertLocal.saveAdvert(advert);
	}

	public void deleteAdvert(String id) throws EntityNotFoundException, RestClientException, UnauthorizedException {
		advertLocal.deleteAdvert(id);
	}

	public AbstractAdvertDto findAdvert(String id) throws EntityNotFoundException, RestClientException {
		return advertLocal.findAdvert(id);
	}

	public List<AbstractAdvertDto> getAdvertByAttributes(AbstractAdvertDto advert) throws EntityNotFoundException {
		return advertLocal.getAdvertByAttributes(advert);
	}

	public Set<AbstractFormatDto> searchFormats(AbstractFormatDto format) throws EntityNotFoundException {
		return advertLocal.searchFormats(format);
	}

}
