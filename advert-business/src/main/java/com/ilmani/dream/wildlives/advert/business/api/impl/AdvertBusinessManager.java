package com.ilmani.dream.wildlives.advert.business.api.impl;

import static com.ilmani.dream.wildlives.framework.security.SecurityInformationFacade.getInstance;
import static javax.ws.rs.core.Response.Status.BAD_REQUEST;
import static javax.ws.rs.core.Response.Status.NOT_FOUND;
import static javax.ws.rs.core.Response.Status.NO_CONTENT;
import static javax.ws.rs.core.Response.Status.UNAUTHORIZED;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.transaction.NotSupportedException;
import javax.transaction.Status;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import org.apache.commons.lang3.StringUtils;

import com.ilmani.dream.wildlives.advert.business.api.AdvertBusinessLocal;
import com.ilmani.dream.wildlives.advert.business.facade.AdvertBusinessFacade;
import com.ilmani.dream.wildlives.framework.dto.advert.AbstractAdvertDto;
import com.ilmani.dream.wildlives.framework.dto.advert.AbstractFormatDto;
import com.ilmani.dream.wildlives.framework.dto.advert.AdvertBusinessDto;
import com.ilmani.dream.wildlives.framework.error.ErrorEntity;
import com.ilmani.dream.wildlives.framework.exceptions.EntityNotFoundException;
import com.ilmani.dream.wildlives.framework.exceptions.RequiredFieldException;
import com.ilmani.dream.wildlives.framework.exceptions.RestClientException;
import com.ilmani.dream.wildlives.framework.exceptions.UnauthorizedException;
import com.ilmani.dream.wildlives.framework.helper.SlugHelper;
import com.ilmani.dream.wildlives.framework.helper.TransformationHelper;

@Stateless(name = "AdvertBusinessManager")
@TransactionManagement(TransactionManagementType.BEAN)
public class AdvertBusinessManager implements AdvertBusinessLocal {

	@Inject
	@Resource
	private UserTransaction utx;

	@Inject
	private AdvertBusinessFacade advertFacade;

	@Override
	public AbstractAdvertDto saveAdvert(AbstractAdvertDto advert)
			throws RestClientException, RequiredFieldException, EntityNotFoundException {
		AbstractAdvertDto result = null;

		throwsExceptionWhenAllFieldsAreNotFill(advert);
		generateFunctionalId(advert);

		try {
			utx.begin();
			((AdvertBusinessDto) advert).setUser(getInstance().getAuthenticationLogin());
			result = advertFacade.saveAdvert(advert);
		} catch (NotSupportedException | SystemException e) {
			throw new RestClientException();
		} catch (NoResultException e) {
			throw new EntityNotFoundException(BAD_REQUEST, ErrorEntity.ErrorKey.UNAUTHORIZED_ACTION.getValue());
		} finally {
			closeTransaction(utx);
		}

		return result;
	}

	@Override
	public void deleteAdvert(String id) throws EntityNotFoundException, RestClientException, UnauthorizedException {
		String login = getInstance().getAuthenticationLogin();

		AbstractAdvertDto result = findAdvert(id);
		if (!login.equals(((AdvertBusinessDto) result).getUser())) {
			throw new UnauthorizedException(UNAUTHORIZED, ErrorEntity.ErrorKey.UNAUTHORIZED_ACTION.getValue());
		}

		try {
			utx.begin();
			advertFacade.deleteAdvert(id);
		} catch (NotSupportedException | SystemException e) {
			throw new RestClientException();
		} finally {
			closeTransaction(utx);
		}
	}

	@Override
	public AbstractAdvertDto findAdvert(String id) throws EntityNotFoundException, RestClientException {
		try {
			return advertFacade.findAdvertById(id);
		} catch (NoResultException e) {
			throw new EntityNotFoundException(NOT_FOUND, ErrorEntity.ErrorKey.RESOURCE_NOT_FOUND.getValue());
		}
	}

	@Override
	public List<AbstractAdvertDto> getAdvertByAttributes(AbstractAdvertDto advert) throws EntityNotFoundException {
		List<AbstractAdvertDto> results = advertFacade.getAdvertByAttributes(advert);
		if (results.isEmpty()) {
			throw new EntityNotFoundException(NO_CONTENT, ErrorEntity.ErrorKey.RESOURCE_NOT_FOUND.getValue());
		}
		return results;
	}

	@Override
	public Set<AbstractFormatDto> searchFormats(AbstractFormatDto format) throws EntityNotFoundException {
		Set<AbstractFormatDto> results = advertFacade.searchFormatByAttributs(format);
		if (results.isEmpty()) {
			throw new EntityNotFoundException(NO_CONTENT, ErrorEntity.ErrorKey.RESOURCE_NOT_FOUND.getValue());
		}
		return results;
	}

	private void closeTransaction(UserTransaction utx) throws RestClientException {
		try {
			if (utx.getStatus() == Status.STATUS_ACTIVE) {
				utx.commit();
			} else {
				utx.rollback();
				throw new RestClientException();
			}
		} catch (Exception e) {
			throw new RestClientException();
		}
	}

	private static void throwsExceptionWhenAllFieldsAreNotFill(AbstractAdvertDto advert) throws RequiredFieldException {
		if (advert == null || StringUtils.isEmpty(advert.getTitle())
				|| ((AdvertBusinessDto) advert).getStartDate() == null
				|| ((AdvertBusinessDto) advert).getEndDate() == null
				|| ((AdvertBusinessDto) advert).getFormats().size() == 0) {
			throw new RequiredFieldException(BAD_REQUEST, ErrorEntity.ErrorKey.FIELD_IS_MISSING.getValue());
		}
	}

	private static void generateFunctionalId(AbstractAdvertDto advert) {
		AbstractFormatDto formatToSlugify = ((AdvertBusinessDto) advert).getFormats().stream().findFirst().get();
		advert.setFunctionalIdentifier(SlugHelper.makeSlug(advert.getTitle() + "-" + formatToSlugify.getCode() + "-"
				+ ((AdvertBusinessDto) advert).getStartDate() + "-" + ((AdvertBusinessDto) advert).getDescription()
				+ "-" + TransformationHelper.getRandomString(50)));

	}

}
