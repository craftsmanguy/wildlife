package com.ilmani.dream.wildlives.advert.persistence.factory;

import javax.inject.Inject;

import com.ilmani.dream.wildlives.advert.persistence.dao.AdvertDao;
import com.ilmani.dream.wildlives.advert.persistence.dao.FormatDao;
import com.ilmani.dream.wildlives.advert.persistence.entity.AdvertEntity;
import com.ilmani.dream.wildlives.advert.persistence.entity.FormatEntity;
import com.ilmani.dream.wildlives.advert.persistence.mapper.AdvertMapper;
import com.ilmani.dream.wildlives.framework.constants.ConstantsCrud;
import com.ilmani.dream.wildlives.framework.dto.advert.AbstractAdvertDto;
import com.ilmani.dream.wildlives.framework.dto.advert.AdvertBusinessDto;

public class AdvertFactory {
	
	@Inject
	AdvertDao advertDao;
	
	@Inject
	FormatDao formatDao;
	
	public AbstractAdvertDto getAdvertDto(AdvertBusinessDto advertDto, String action) {
		AdvertEntity advertEn = AdvertMapper.transformAdvertDtoToAdvertEntity(advertDto);
		AdvertEntity result = new AdvertEntity();
		
		for (FormatEntity formatEnTemp : advertEn.getFormatsEn()){
			advertEn.getFormatsEn().add(formatDao.findByCode(formatEnTemp.getCode()));
		}
		
		switch (action) {
		case ConstantsCrud.UPDATE:
			result = advertDao.update(advertEn);
			break;
		}
		return AdvertMapper.transformAdvertEntityToAdvertDto(result);
	}

	

}
