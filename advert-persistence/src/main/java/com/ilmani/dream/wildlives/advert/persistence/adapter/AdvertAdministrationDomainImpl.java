package com.ilmani.dream.wildlives.advert.persistence.adapter;

import javax.inject.Inject;

import com.ilmani.dream.wildlives.advert.administration.port.AdvertAdministrationDomain;
import com.ilmani.dream.wildlives.advert.persistence.factory.AdvertFactory;
import com.ilmani.dream.wildlives.framework.dto.advert.AdvertDto;
import com.ilmani.dream.wildlives.framework.version.Crud;

public class AdvertAdministrationDomainImpl implements AdvertAdministrationDomain {

	
	@Inject
	AdvertFactory advertFact;
	
	@Override
	public AdvertDto getByIdenfier(AdvertDto advert) {
		return advertFact.getAdvertDto(advert, Crud.valueOf("FIND").getAction());
	}

	@Override
	public AdvertDto save(AdvertDto advert) {
		return advertFact.getAdvertDto(advert, Crud.valueOf("SAVE").getAction());
	}

	@Override
	public void delete(AdvertDto advert) {
		advertFact.delete(advert);

	}

	@Override
	public AdvertDto update(AdvertDto advert) {
		return advertFact.getAdvertDto(advert, Crud.valueOf("UPDATE").getAction());
	}

}
