package com.ilmani.dream.wildlives.advert.persistence.factory;

import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import com.ilmani.dream.wildlives.advert.persistence.dao.AdvertDao;
import com.ilmani.dream.wildlives.advert.persistence.dao.FormatDao;
import com.ilmani.dream.wildlives.advert.persistence.entity.AdvertEntity;
import com.ilmani.dream.wildlives.advert.persistence.entity.FormatEntity;
import com.ilmani.dream.wildlives.advert.persistence.mapper.AdvertMapper;
import com.ilmani.dream.wildlives.framework.constants.ConstantsCrud;
import com.ilmani.dream.wildlives.framework.dto.advert.AdvertDto;

public class AdvertFactory {
	
	@Inject
	AdvertDao advertDao;
	
	@Inject
	FormatDao formatDao;
	
	public AdvertDto getAdvertDto(AdvertDto advertDto, String action) {
		AdvertEntity advertEn = AdvertMapper.transformAdvertDtoToAdvertEntity(advertDto);
		AdvertEntity result = new AdvertEntity();
		
		for (FormatEntity formatEnTemp : advertEn.getFormatsEn()){
			advertEn.getFormatsEn().add(formatDao.findByCode(formatEnTemp.getCode()));
		}
		
		switch (action) {
		case ConstantsCrud.SAVE:
			result = advertDao.insert(advertEn);
			break;
		case ConstantsCrud.UPDATE:
			result = advertDao.update(advertEn);
			break;
		case ConstantsCrud.FIND:
			result = advertDao.findByIdentifier(advertEn);
			break;
		}
		
		return AdvertMapper.transformAdvertEntityToAdvertDto(result);
	}

	public List<AdvertDto> getAdvertsDto(AdvertDto advertDto) {
		AdvertEntity advertEn = AdvertMapper.transformAdvertDtoToAdvertEntity(advertDto);
		Set<AdvertEntity> results = advertDao.getByAttributes(advertEn);
		return AdvertMapper.transformListAdvertEntityToListAdvertDto(results);
	}

	public void delete(AdvertDto advertDto) {
		AdvertEntity advertEn = AdvertMapper.transformAdvertDtoToAdvertEntity(advertDto);
		advertDao.delete(advertEn);
	}

}
