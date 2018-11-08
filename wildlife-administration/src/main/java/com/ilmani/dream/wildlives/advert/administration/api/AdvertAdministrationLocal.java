package com.ilmani.dream.wildlives.advert.administration.api;

import java.util.Set;

import javax.ejb.Local;

import com.ilmani.dream.wildlives.framework.dto.advert.AbstractFormatDto;
import com.ilmani.dream.wildlives.framework.exceptions.AuthenticationException;
import com.ilmani.dream.wildlives.framework.exceptions.EntityAlreadyExistException;
import com.ilmani.dream.wildlives.framework.exceptions.EntityNotFoundException;
import com.ilmani.dream.wildlives.framework.exceptions.RequiredFieldException;
import com.ilmani.dream.wildlives.framework.exceptions.RestClientException;

@Local
public interface AdvertAdministrationLocal {

	public AbstractFormatDto saveFormat(AbstractFormatDto format)
			throws RequiredFieldException, EntityAlreadyExistException, RestClientException;

	public AbstractFormatDto updateFormat(AbstractFormatDto format, String codeToUpdate)
			throws RequiredFieldException, EntityNotFoundException, RestClientException, AuthenticationException;

	public AbstractFormatDto findFormatByCode(String code) throws EntityNotFoundException;

	public Set<AbstractFormatDto> searchFormats(AbstractFormatDto format) throws EntityNotFoundException;

	public void deleteFormat(String code) throws EntityNotFoundException, RestClientException;

}
