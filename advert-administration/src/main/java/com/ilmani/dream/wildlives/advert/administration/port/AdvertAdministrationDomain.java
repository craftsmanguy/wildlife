package com.ilmani.dream.wildlives.advert.administration.port;

public interface AdvertAdministrationDomain {
	
	public AdvertDto getByIdenfier(AdvertDto advert);

	public AdvertDto save(AdvertDto advert);

	public void delete(AdvertDto advert);

	public AdvertDto update(AdvertDto advert);

}
