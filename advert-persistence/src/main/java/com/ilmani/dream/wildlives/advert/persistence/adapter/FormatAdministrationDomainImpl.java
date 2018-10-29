package com.ilmani.dream.wildlives.advert.persistence.adapter;

import javax.inject.Inject;

import com.ilmani.dream.wildlives.advert.administration.port.FormatAdministrationDomain;
import com.ilmani.dream.wildlives.advert.persistence.factory.FormatFactory;
import com.ilmani.dream.wildlives.framework.dto.advert.FormatDto;
import com.ilmani.dream.wildlives.framework.version.Crud;

public class FormatAdministrationDomainImpl implements FormatAdministrationDomain {
	
	@Inject
	FormatFactory formatFact;

	@Override
	public FormatDto getByIdenfier(FormatDto advert) {
		return formatFact.getFormatDto(advert, Crud.valueOf("FIND").getAction());
	}

	@Override
	public FormatDto save(FormatDto advert) {
		return formatFact.getFormatDto(advert, Crud.valueOf("SAVE").getAction());
	}

	@Override
	public void delete(FormatDto advert) {
		formatFact.delete(advert);

	}

	@Override
	public FormatDto update(FormatDto advert) {
		return formatFact.getFormatDto(advert, Crud.valueOf("UPDATE").getAction());
	}

}
