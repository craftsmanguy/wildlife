package com.ilmani.dream.wildlives.advert.administration.port;

import java.util.Set;

import javax.persistence.NoResultException;

import com.ilmani.dream.wildlives.framework.dto.advert.AbstractFormatDto;

public interface FormatAdministrationDomain {

	public boolean isFormatExists(String code);

	public AbstractFormatDto findFormatByCode(String code) throws NoResultException;

	public Set<AbstractFormatDto> searchFormats(AbstractFormatDto format);

	public AbstractFormatDto save(AbstractFormatDto advert);

	public void delete(String code);

	public AbstractFormatDto update(AbstractFormatDto format, String code);

}
