package com.ilmani.dream.wildlives.presenter.rest.administration.advert.v1;

import java.util.Set;

import javax.ejb.EJB;
import javax.ws.rs.ext.Provider;

import com.ilmani.dream.wildlives.advert.administration.api.AdvertAdministrationLocal;
import com.ilmani.dream.wildlives.framework.dto.advert.FormatDto;
import com.ilmani.dream.wildlives.framework.exceptions.AuthenticationException;
import com.ilmani.dream.wildlives.framework.exceptions.EntityAlreadyExistException;
import com.ilmani.dream.wildlives.framework.exceptions.EntityNotFoundException;
import com.ilmani.dream.wildlives.framework.exceptions.RequiredFieldException;
import com.ilmani.dream.wildlives.framework.exceptions.RestClientException;

@Provider
public class AdvertAdministrationProvider {

	@EJB(name = "AdvertAdministrationManager")
	AdvertAdministrationLocal advertLocal;

	public FormatDto saveFormat(FormatDto format)
			throws RequiredFieldException, EntityAlreadyExistException, RestClientException {
		return advertLocal.saveFormat(format);
	}

	public FormatDto updateFormat(FormatDto format, String codeToUpdate)
			throws RequiredFieldException, EntityNotFoundException, RestClientException, AuthenticationException {
		return advertLocal.updateFormat(format, codeToUpdate);
	}

	public FormatDto findFormatByCode(String code) throws EntityNotFoundException {
		return advertLocal.findFormatByCode(code);
	}

	public Set<FormatDto> searchFormats(FormatDto format) throws EntityNotFoundException {
		return advertLocal.searchFormats(format);
	}

	public void deleteFormat(String code) throws EntityNotFoundException, RestClientException {
		advertLocal.deleteFormat(code);
	}

}
