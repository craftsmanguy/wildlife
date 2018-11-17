package com.ilmani.dream.wildlives.advert.business.port;

import java.util.Set;

import com.ilmani.dream.wildlives.framework.dto.advert.AbstractFormatDto;

public interface FormatBusinessDomain {
	
	public Set<AbstractFormatDto> search(AbstractFormatDto format);

}
