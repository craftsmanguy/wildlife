package com.ilmani.dream.wildlives.advert.administration.api.impl;

import java.util.Set;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import com.ilmani.dream.wildlives.advert.administration.api.AdvertAdministrationLocal;
import com.ilmani.dream.wildlives.framework.dto.advert.FormatDto;

@Stateless(name = "AdvertAdministrationBean")
@TransactionManagement(TransactionManagementType.BEAN)
public class AdvertAdministrationBean implements AdvertAdministrationLocal{

	@Override
	public Set<FormatDto> searchFormatsByIdenfier(FormatDto format) {
		// TODO Auto-generated method stub
		return null;
	}

}
