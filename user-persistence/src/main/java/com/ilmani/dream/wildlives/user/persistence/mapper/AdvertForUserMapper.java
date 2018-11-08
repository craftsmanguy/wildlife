package com.ilmani.dream.wildlives.user.persistence.mapper;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.ilmani.dream.wildlives.framework.dto.advert.AbstractAdvertDto;
import com.ilmani.dream.wildlives.framework.dto.advert.AdvertMinimalDto;
import com.ilmani.dream.wildlives.user.persistence.entity.AdvertForUserEntity;

public class AdvertForUserMapper {

	public static AbstractAdvertDto transformAdvertEntityToAdvertDto(AdvertForUserEntity advertEn) {
		AbstractAdvertDto advertDto = new AdvertMinimalDto();
		if (advertEn == null) {
			return advertDto;
		}
		try {
			BeanUtils.copyProperties(advertDto, advertEn);

		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO log
		}
		return advertDto;
	}

	public static List<AbstractAdvertDto> transformListAdvertsEntityToListAdvertDto(
			List<AdvertForUserEntity> advertsEntity) {
		List<AbstractAdvertDto> formatsDto = new ArrayList<AbstractAdvertDto>();
		if (advertsEntity.isEmpty()) {
			return formatsDto;
		}
		for (AdvertForUserEntity formatEnTemp : advertsEntity) {
			AbstractAdvertDto advertDtoTemp = transformAdvertEntityToAdvertDto(formatEnTemp);
			formatsDto.add(advertDtoTemp);
		}
		return formatsDto;
	}

}
