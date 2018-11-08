package com.ilmani.dream.wildlives.presenter.rest.administration.advert.v1;

import java.util.Set;

import javax.ejb.EJB;
import javax.ws.rs.ext.Provider;

import com.ilmani.dream.wildlives.advert.administration.api.AdvertAdministrationLocal;
import com.ilmani.dream.wildlives.framework.dto.advert.AbstractFormatDto;
import com.ilmani.dream.wildlives.framework.exceptions.AuthenticationException;
import com.ilmani.dream.wildlives.framework.exceptions.EntityAlreadyExistException;
import com.ilmani.dream.wildlives.framework.exceptions.EntityNotFoundException;
import com.ilmani.dream.wildlives.framework.exceptions.RequiredFieldException;
import com.ilmani.dream.wildlives.framework.exceptions.RestClientException;

@Provider
public class AdvertAdministrationProvider {

	@EJB(name = "AdvertAdministrationManager")
	AdvertAdministrationLocal advertLocal;

	public AbstractFormatDto saveFormat(AbstractFormatDto format)
			throws RequiredFieldException, EntityAlreadyExistException, RestClientException {
		return advertLocal.saveFormat(format);
	}

	public AbstractFormatDto updateFormat(AbstractFormatDto format, String codeToUpdate)
			throws RequiredFieldException, EntityNotFoundException, RestClientException, AuthenticationException {
		return advertLocal.updateFormat(format, codeToUpdate);
	}

	public AbstractFormatDto findFormatByCode(String code) throws EntityNotFoundException {
		return advertLocal.findFormatByCode(code);
	}

	public Set<AbstractFormatDto> searchFormats(AbstractFormatDto format) throws EntityNotFoundException {
		return advertLocal.searchFormats(format);
	}

	public void deleteFormat(String code) throws EntityNotFoundException, RestClientException {
		advertLocal.deleteFormat(code);
	}

}
