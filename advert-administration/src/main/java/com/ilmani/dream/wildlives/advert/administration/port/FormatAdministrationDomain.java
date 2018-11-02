package com.ilmani.dream.wildlives.advert.administration.port;

import com.ilmani.dream.wildlives.framework.dto.advert.FormatDto;

public interface FormatAdministrationDomain {
	
	public boolean isFormatExists(String code);
	
	public FormatDto getByIdenfier(FormatDto advert);

	public FormatDto save(FormatDto advert);

	public void delete(FormatDto advert);

	public FormatDto update(FormatDto advert);

}
