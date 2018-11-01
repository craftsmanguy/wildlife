package com.ilmani.dream.wildlives.advert.persistence.mapper;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtils;

import com.ilmani.dream.wildlives.advert.persistence.entity.AdvertEntity;
import com.ilmani.dream.wildlives.framework.dto.advert.AdvertDto;

public class AdvertMapper {
	
	public static AdvertDto transformAdvertEntityToAdvertDto(AdvertEntity advertEn) {
		AdvertDto advertDto = new AdvertDto();
		if (advertEn == null) {
			return advertDto;
		}
		try {
			BeanUtils.copyProperties(advertDto, advertEn);
			advertDto.setInsertionDate(advertEn.getInsertionDate());
			if (!advertEn.getFormatsEn().isEmpty()) {
				advertDto.setFormats(FormatMapper.transformListFormatEntityToListFormatDto(advertEn.getFormatsEn()));
			}
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO log
		}
		return advertDto;
	}

	public static List<AdvertDto> transformListAdvertEntityToListAdvertDto(Set<AdvertEntity> advertsEntity) {
		List<AdvertDto> formatsDto = new ArrayList<AdvertDto>();
		if (advertsEntity.isEmpty()) {
			return formatsDto;
		}
		for (AdvertEntity formatEnTemp : advertsEntity) {
			AdvertDto advertDtoTemp = transformAdvertEntityToAdvertDto(formatEnTemp);
			formatsDto.add(advertDtoTemp);
		}
		return formatsDto;
	}

	public static AdvertEntity transformAdvertDtoToAdvertEntity(AdvertDto advertDto) {
		AdvertEntity advertEn = new AdvertEntity();
		if (advertDto == null) {
			return advertEn;
		}
		try {
			BeanUtils.copyProperties(advertEn, advertDto);
			if (!advertDto.getFormats().isEmpty()) {
				advertEn.setFormatsEn(FormatMapper.transformListFormatDtoToListFormatEntity(advertDto.getFormats()));
			}
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO log
		}
		return advertEn;
	}

}
