package com.ilmani.dream.wildlives.advert.persistence.mapper;

import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtils;

import com.ilmani.dream.wildlives.advert.persistence.entity.FormatEntity;
import com.ilmani.dream.wildlives.framework.dto.advert.FormatDto;

public class FormatMapper {

	public static FormatDto transformFormatEntityToFormatDto(FormatEntity formatEn) {
		FormatDto formatDto = new FormatDto();
		if (formatEn == null) {
			return formatDto;
		}
		try {
			BeanUtils.copyProperties(formatDto, formatEn);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO log
			formatDto = new FormatDto(formatEn.getName(), formatEn.getFeature(), formatEn.isActive());
		}
		return formatDto;
	}

	public static Set<FormatDto> transformListFormatEntityToListFormatDto(Set<FormatEntity> formatsEntity) {
		Set<FormatDto> formatsDto = new HashSet<FormatDto>();
		if (formatsEntity.isEmpty()) {
			return formatsDto;
		}
		for (FormatEntity formatEnTemp : formatsEntity) {
			FormatDto formatDtoTemp = transformFormatEntityToFormatDto(formatEnTemp);
			formatsDto.add(formatDtoTemp);
		}
		return formatsDto;
	}

	public static FormatEntity transformFormatDtoToFormatEntity(FormatDto formatDto) {
		FormatEntity formatEn = new FormatEntity();
		if (formatDto == null) {
			return formatEn;
		}
		try {
			BeanUtils.copyProperties(formatEn, formatDto);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO log
		}
		return formatEn;
	}
	
	public static Set<FormatEntity> transformListFormatDtoToListFormatEntity(Set<FormatDto> formatsDto) {
		Set<FormatEntity> formatsEn = new HashSet<FormatEntity>();
		if (formatsDto.isEmpty()) {
			return formatsEn;
		}
		for (FormatDto formatDtoTemp : formatsDto) {
			FormatEntity formatEnTemp = transformFormatDtoToFormatEntity(formatDtoTemp);
			formatsEn.add(formatEnTemp);
		}
		return formatsEn;
	}

}
