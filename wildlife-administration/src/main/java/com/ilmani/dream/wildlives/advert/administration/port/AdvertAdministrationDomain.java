package com.ilmani.dream.wildlives.advert.administration.port;

import com.ilmani.dream.wildlives.framework.dto.advert.AdvertBusinessDto;

public interface AdvertAdministrationDomain {
	
	public AdvertBusinessDto getByIdenfier(AdvertBusinessDto advert);

	public AdvertBusinessDto save(AdvertBusinessDto advert);

	public void delete(AdvertBusinessDto advert);

	public AdvertBusinessDto update(AdvertBusinessDto advert);

}
