package com.ilmani.dream.wildlives.advert.administration.api;

import java.util.Set;

import javax.ejb.Local;

import com.ilmani.dream.wildlives.framework.dto.advert.FormatDto;

@Local
public interface AdvertAdministrationLocal {
	
	public Set<FormatDto> searchFormatsByIdenfier(FormatDto format);

}
