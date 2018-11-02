package com.ilmani.dream.wildlives.advert.administration.facade;

import javax.inject.Inject;

import com.ilmani.dream.wildlives.advert.administration.port.FormatAdministrationDomain;
import com.ilmani.dream.wildlives.framework.dto.advert.FormatDto;
import com.ilmani.dream.wildlives.framework.exceptions.EntityAlreadyExistException;
import com.ilmani.dream.wildlives.framework.exceptions.RequiredFieldException;
import com.ilmani.dream.wildlives.framework.exceptions.RestClientException;

public class AdvertAdministrationFacade {
	
	@Inject
	private FormatAdministrationDomain formatDomain;
	
	public FormatDto saveFormat(FormatDto format)
			throws RequiredFieldException, EntityAlreadyExistException, RestClientException{
		return formatDomain.save(format);
	}
	
	public boolean isFormatExists(String code) {
		return formatDomain.isFormatExists(code);
	}

}
