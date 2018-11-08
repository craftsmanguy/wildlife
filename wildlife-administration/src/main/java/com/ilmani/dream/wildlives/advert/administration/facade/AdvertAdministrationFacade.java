package com.ilmani.dream.wildlives.advert.administration.facade;

import java.util.Set;

import javax.inject.Inject;
import javax.persistence.NoResultException;

import com.ilmani.dream.wildlives.advert.administration.port.FormatAdministrationDomain;
import com.ilmani.dream.wildlives.framework.dto.advert.AbstractFormatDto;
import com.ilmani.dream.wildlives.framework.exceptions.EntityAlreadyExistException;
import com.ilmani.dream.wildlives.framework.exceptions.RequiredFieldException;
import com.ilmani.dream.wildlives.framework.exceptions.RestClientException;

public class AdvertAdministrationFacade {

	@Inject
	private FormatAdministrationDomain formatDomain;

	public AbstractFormatDto saveFormat(AbstractFormatDto format)
			throws RequiredFieldException, EntityAlreadyExistException, RestClientException {
		return formatDomain.save(format);
	}
	
	public AbstractFormatDto findFormatByCode(String code) throws NoResultException {
		return formatDomain.findFormatByCode(code);
	}

	public boolean isFormatExists(String code) {
		return formatDomain.isFormatExists(code);
	}

	public Set<AbstractFormatDto> searchFormats(AbstractFormatDto format) {
		return formatDomain.searchFormats(format);
	}

	public void deleteFormat(String code) {
		formatDomain.delete(code);
	}

	public AbstractFormatDto updateFormat(AbstractFormatDto format, String code) {
		return formatDomain.update(format, code);
	}

}
