package com.ilmani.dream.wildlives.advert.business.port;

import java.util.List;

import com.ilmani.dream.wildlives.framework.dto.advert.AbstractAdvertDto;

public interface AdvertBusinessDomain {

	public AbstractAdvertDto saveAdvert(AbstractAdvertDto advert);
	
	public boolean isExists(String id);

	public void delete(String id);
	
	public AbstractAdvertDto findById(String id);
	
	public List<AbstractAdvertDto> getAdvertByAttributes (AbstractAdvertDto advert);

}
