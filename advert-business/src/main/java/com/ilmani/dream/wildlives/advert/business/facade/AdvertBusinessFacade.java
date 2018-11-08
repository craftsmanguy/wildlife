package com.ilmani.dream.wildlives.advert.business.facade;

import javax.inject.Inject;

import com.ilmani.dream.wildlives.advert.business.port.AdvertBusinessDomain;
import com.ilmani.dream.wildlives.framework.dto.advert.AbstractAdvertDto;

public class AdvertBusinessFacade {

	@Inject
	private AdvertBusinessDomain adverDomain;

	public AbstractAdvertDto saveAdvert(AbstractAdvertDto advert) {
		return adverDomain.saveAdvert(advert);

	}

}
