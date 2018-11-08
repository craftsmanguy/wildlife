package com.ilmani.dream.wildlives.advert.business.api.impl;

import static com.ilmani.dream.wildlives.framework.security.SecurityInformationFacade.getInstance;
import static javax.ws.rs.core.Response.Status.BAD_REQUEST;

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
import com.ilmani.dream.wildlives.framework.helper.SlugHelper;
import com.ilmani.dream.wildlives.framework.helper.TransformationHelper;

@Stateless(name = "AdvertBusinessManager")
@TransactionManagement(TransactionManagementType.BEAN)
public class AdvertBusinessManager implements AdvertBusinessLocal {

	@Inject
	@Resource
	private UserTransaction utx;

	@Inject
	private AdvertBusinessFacade avdertFacade;

	@Override
	public AbstractAdvertDto saveAdvert(AbstractAdvertDto advert)
			throws RestClientException, RequiredFieldException, EntityNotFoundException {
		AbstractAdvertDto result = null;

		throwsExceptionWhenAllFieldsAreNotFill(advert);
		generateFunctionalId(advert);

		try {
			utx.begin();
			((AdvertBusinessDto) advert).setUser(getInstance().getAuthenticationLogin());
			result = avdertFacade.saveAdvert(advert);
		} catch (NotSupportedException | SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoResultException e) {
			throw new EntityNotFoundException(BAD_REQUEST, ErrorEntity.ErrorKey.UNAUTHORIZED_ACTION.getValue());
		} finally {
			closeTransaction(utx);
		}

		return result;
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
		if (advert == null || StringUtils.isEmpty(advert.getTitle()) || ((AdvertBusinessDto) advert).getStartDate() == null
				|| ((AdvertBusinessDto) advert).getEndDate() == null || ((AdvertBusinessDto) advert).getFormats().size() == 0) {
			throw new RequiredFieldException(BAD_REQUEST, ErrorEntity.ErrorKey.FIELD_IS_MISSING.getValue());
		}
	}

	private static void generateFunctionalId(AbstractAdvertDto advert) {
		AbstractFormatDto formatToSlugify = ((AdvertBusinessDto) advert).getFormats().stream().findFirst().get();
		advert.setFunctionalIdentifier(
				SlugHelper.makeSlug(advert.getTitle() + "-" + formatToSlugify.getCode() + "-" + ((AdvertBusinessDto) advert).getStartDate()
						+ "-" + ((AdvertBusinessDto) advert).getDescription() + "-" + TransformationHelper.getRandomString(50)));

	}

}
