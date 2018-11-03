package com.ilmani.dream.wildlives.advert.administration.facade;

import java.util.Set;

import javax.inject.Inject;
import javax.persistence.NoResultException;

import com.ilmani.dream.wildlives.advert.administration.port.FormatAdministrationDomain;
import com.ilmani.dream.wildlives.framework.dto.advert.FormatDto;
import com.ilmani.dream.wildlives.framework.exceptions.EntityAlreadyExistException;
import com.ilmani.dream.wildlives.framework.exceptions.RequiredFieldException;
import com.ilmani.dream.wildlives.framework.exceptions.RestClientException;

public class AdvertAdministrationFacade {

	@Inject
	private FormatAdministrationDomain formatDomain;

	public FormatDto saveFormat(FormatDto format)
			throws RequiredFieldException, EntityAlreadyExistException, RestClientException {
		return formatDomain.save(format);
	}
	
	public FormatDto findFormatByCode(String code) throws NoResultException {
		return formatDomain.findFormatByCode(code);
	}

	public boolean isFormatExists(String code) {
		return formatDomain.isFormatExists(code);
	}

	public Set<FormatDto> searchFormats(FormatDto format) {
		return formatDomain.searchFormats(format);
	}

	public void deleteFormat(String code) {
		formatDomain.delete(code);
	}

	public FormatDto updateFormat(FormatDto format, String code) {
		return formatDomain.update(format, code);
	}

}
