package com.ilmani.dream.wildlives.advert.business.api;

import java.util.List;
import java.util.Set;

import javax.ejb.Local;

import com.ilmani.dream.wildlives.framework.dto.advert.AbstractAdvertDto;
import com.ilmani.dream.wildlives.framework.dto.advert.AbstractFormatDto;
import com.ilmani.dream.wildlives.framework.exceptions.EntityNotFoundException;
import com.ilmani.dream.wildlives.framework.exceptions.RequiredFieldException;
import com.ilmani.dream.wildlives.framework.exceptions.RestClientException;
import com.ilmani.dream.wildlives.framework.exceptions.UnauthorizedException;

@Local
public interface AdvertBusinessLocal {

	public AbstractAdvertDto saveAdvert(AbstractAdvertDto advert)
			throws RestClientException, RequiredFieldException, EntityNotFoundException;
	
	public void deleteAdvert(String id) throws EntityNotFoundException, RestClientException, UnauthorizedException;
	
	public AbstractAdvertDto findAdvert(String id) throws EntityNotFoundException, RestClientException;
	
	public List<AbstractAdvertDto> getAdvertByAttributes(AbstractAdvertDto advert) throws EntityNotFoundException;
	
	public Set<AbstractFormatDto> searchFormats(AbstractFormatDto format) throws EntityNotFoundException;
}
