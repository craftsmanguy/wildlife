package com.ilmani.dream.wildlives.advert.administration.api;

import java.util.Set;

import javax.ejb.Local;

import com.ilmani.dream.wildlives.framework.dto.advert.FormatDto;
import com.ilmani.dream.wildlives.framework.exceptions.AuthenticationException;
import com.ilmani.dream.wildlives.framework.exceptions.EntityAlreadyExistException;
import com.ilmani.dream.wildlives.framework.exceptions.EntityNotFoundException;
import com.ilmani.dream.wildlives.framework.exceptions.RequiredFieldException;
import com.ilmani.dream.wildlives.framework.exceptions.RestClientException;

@Local
public interface AdvertAdministrationLocal {
	
	public FormatDto saveFormat(FormatDto format)
			throws RequiredFieldException, EntityAlreadyExistException, RestClientException;
	
	public FormatDto updateFormat(FormatDto format, String codeToUpdate)
			throws RequiredFieldException, EntityNotFoundException, RestClientException, AuthenticationException;

	public FormatDto findFormatByCode(String code) throws EntityNotFoundException;
	
	public Set<FormatDto> searchFormats(FormatDto format) throws EntityNotFoundException;
	
	public void deleteFormat(String code) throws EntityNotFoundException, RestClientException;

}
