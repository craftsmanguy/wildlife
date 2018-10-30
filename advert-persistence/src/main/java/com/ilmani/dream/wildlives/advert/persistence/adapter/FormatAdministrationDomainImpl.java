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
	public FormatDto getByIdenfier(FormatDto format) {
		return formatFact.getFormatDto(format, Crud.valueOf("FIND").getAction());
	}

	@Override
	public FormatDto save(FormatDto format) {
		return formatFact.getFormatDto(format, Crud.valueOf("SAVE").getAction());
	}

	@Override
	public void delete(FormatDto format) {
		formatFact.delete(format);

	}

	@Override
	public FormatDto update(FormatDto format) {
		return formatFact.getFormatDto(format, Crud.valueOf("UPDATE").getAction());
	}

}
