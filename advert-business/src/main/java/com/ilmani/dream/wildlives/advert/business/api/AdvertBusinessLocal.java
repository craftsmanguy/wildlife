package com.ilmani.dream.wildlives.advert.business.api;

import javax.ejb.Local;

import com.ilmani.dream.wildlives.framework.dto.advert.AbstractAdvertDto;
import com.ilmani.dream.wildlives.framework.exceptions.EntityNotFoundException;
import com.ilmani.dream.wildlives.framework.exceptions.RequiredFieldException;
import com.ilmani.dream.wildlives.framework.exceptions.RestClientException;

@Local
public interface AdvertBusinessLocal {
	
	public AbstractAdvertDto saveAdvert(AbstractAdvertDto advert) throws RestClientException, RequiredFieldException, EntityNotFoundException;

}
