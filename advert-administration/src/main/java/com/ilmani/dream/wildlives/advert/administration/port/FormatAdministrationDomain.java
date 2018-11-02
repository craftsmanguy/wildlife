package com.ilmani.dream.wildlives.advert.administration.port;

import java.util.Set;

import javax.persistence.NoResultException;

import com.ilmani.dream.wildlives.framework.dto.advert.FormatDto;

public interface FormatAdministrationDomain {
	
	public boolean isFormatExists(String code);
	
	public FormatDto findFormatByCode(String code) throws NoResultException;
	
	public Set<FormatDto> searchFormats(FormatDto format);
	
	public FormatDto save(FormatDto advert);

	public void delete(String code);

	public FormatDto update(FormatDto format, String code);

}
