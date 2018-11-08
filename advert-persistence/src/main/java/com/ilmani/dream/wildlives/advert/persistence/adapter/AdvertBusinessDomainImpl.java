package com.ilmani.dream.wildlives.advert.persistence.adapter;

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
}
