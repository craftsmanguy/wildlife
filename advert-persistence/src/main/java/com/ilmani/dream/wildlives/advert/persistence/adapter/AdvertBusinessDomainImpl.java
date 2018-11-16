package com.ilmani.dream.wildlives.advert.persistence.adapter;

import java.util.List;

import javax.inject.Inject;

import com.ilmani.dream.wildlives.advert.business.port.AdvertBusinessDomain;
import com.ilmani.dream.wildlives.advert.persistence.dao.AdvertDao;
import com.ilmani.dream.wildlives.advert.persistence.dao.FormatDao;
import com.ilmani.dream.wildlives.advert.persistence.dao.PetForAdvertDao;
import com.ilmani.dream.wildlives.advert.persistence.dao.UserForAdvertDao;
import com.ilmani.dream.wildlives.advert.persistence.entity.AdvertEntity;
import com.ilmani.dream.wildlives.advert.persistence.factory.AdvertFactory;
import com.ilmani.dream.wildlives.advert.persistence.mapper.AdvertMapper;
import com.ilmani.dream.wildlives.framework.dto.advert.AbstractAdvertDto;
import com.ilmani.dream.wildlives.framework.dto.advert.AbstractFormatDto;
import com.ilmani.dream.wildlives.framework.dto.advert.AdvertBusinessDto;
import com.ilmani.dream.wildlives.framework.dto.pet.AbstractPetDto;

public class AdvertBusinessDomainImpl implements AdvertBusinessDomain {

	@Inject
	AdvertFactory advertFact;

	@Inject
	AdvertDao advertDao;

	@Inject
	FormatDao formatDao;

	@Inject
	PetForAdvertDao petDao;

	@Inject
	UserForAdvertDao userDao;

	@Override
	public AbstractAdvertDto saveAdvert(AbstractAdvertDto advert) {
		AdvertEntity advertEn = AdvertMapper.transformAdvertDtoToAdvertEntity(advert);
		AdvertEntity result = new AdvertEntity();
		for (AbstractFormatDto formatTemp : ((AdvertBusinessDto) advert).getFormats()) {
			advertEn.getFormatsEn().add(formatDao.findByCode(formatTemp.getCode()));
		}

		for (AbstractPetDto petTemp : ((AdvertBusinessDto) advert).getPets()) {
			advertEn.getPetsEn().add(petDao.findByFunctionalIdentifier(petTemp.getFunctionalIdentifier()));
		}
		advertEn.setUserEn(userDao.findUserByPseudonym(((AdvertBusinessDto) advert).getUser()));
		result = advertDao.insert(advertEn);
		return AdvertMapper.transformAdvertEntityToAdvertDto(result);
	}

	@Override
	public boolean isExists(String id) {
		return advertDao.isExists(id);
	}
	
	

	@Override
	public void delete(String id) {
		AdvertEntity advertToDelete = advertDao.findByFunctionalId(id);
		advertDao.delete(advertToDelete);

	}

	@Override
	public AbstractAdvertDto findById (String id) {
		AdvertEntity result = advertDao.findByFunctionalId(id);
		return AdvertMapper.transformAdvertEntityToAdvertDto(result);
	}
	
	@Override
	public List<AbstractAdvertDto> getAdvertByAttributes(AbstractAdvertDto advertDto) {
		AdvertEntity advertEn = AdvertMapper.transformAdvertDtoToAdvertEntity(advertDto);
		List<AdvertEntity> results = advertDao.getByAttributes(advertEn);
		return AdvertMapper.transformListAdvertEntityToListAdvertDto(results);
	}
}
