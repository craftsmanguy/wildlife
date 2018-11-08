package com.ilmani.dream.wildlives.advert.persistence.mapper;

import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtils;

import com.ilmani.dream.wildlives.advert.persistence.entity.FormatEntity;
import com.ilmani.dream.wildlives.framework.dto.advert.AbstractFormatDto;
import com.ilmani.dream.wildlives.framework.dto.advert.FormatAdministratorDto;
import com.ilmani.dream.wildlives.framework.dto.advert.FormatBusinessDto;

public class FormatMapper {

	public static AbstractFormatDto transformFormatEntityToFormatAdministratorDto(FormatEntity formatEn) {
		AbstractFormatDto formatDto = new FormatAdministratorDto();
		if (formatEn == null) {
			return formatDto;
		}
		try {
			BeanUtils.copyProperties(formatDto, formatEn);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO log
			formatDto = new FormatAdministratorDto(formatEn.getName(), formatEn.getFeature(), formatEn.isActive());
		}
		return formatDto;
	}

	public static Set<AbstractFormatDto> transformListFormatEntityToListFormatDto(Set<FormatEntity> formatsEntity) {
		Set<AbstractFormatDto> formatsDto = new HashSet<AbstractFormatDto>();
		if (formatsEntity.isEmpty()) {
			return formatsDto;
		}
		for (FormatEntity formatEnTemp : formatsEntity) {
			AbstractFormatDto formatDtoTemp = transformFormatEntityToFormatAdministratorDto(formatEnTemp);
			formatsDto.add(formatDtoTemp);
		}
		return formatsDto;
	}

	// Mapper for type Business
	public static Set<FormatBusinessDto> transformListFormatEntityToListFormatBusinessDto(
			Set<FormatEntity> formatsEntity) {
		Set<FormatBusinessDto> formatsDto = new HashSet<FormatBusinessDto>();
		if (formatsEntity.isEmpty()) {
			return formatsDto;
		}
		for (FormatEntity formatEnTemp : formatsEntity) {
			FormatBusinessDto formatDtoTemp = transformFormatEntityToFormatBusinessDto(formatEnTemp);
			formatsDto.add(formatDtoTemp);
		}
		return formatsDto;
	}

	public static FormatBusinessDto transformFormatEntityToFormatBusinessDto(FormatEntity formatEn) {
		FormatBusinessDto formatDto = new FormatBusinessDto();
		if (formatEn == null) {
			return formatDto;
		}
		try {
			BeanUtils.copyProperties(formatDto, formatEn);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO log
			formatDto = new FormatBusinessDto(formatEn.getName(), formatEn.getFeature());
		}
		return formatDto;
	}

	public static FormatEntity transformFormatDtoToFormatEntity(AbstractFormatDto formatDto) {
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

	public static Set<FormatEntity> transformListFormatDtoToListFormatEntity(Set<FormatAdministratorDto> formatsDto) {
		Set<FormatEntity> formatsEn = new HashSet<FormatEntity>();
		if (formatsDto.isEmpty()) {
			return formatsEn;
		}
		for (FormatAdministratorDto formatDtoTemp : formatsDto) {
			FormatEntity formatEnTemp = transformFormatDtoToFormatEntity(formatDtoTemp);
			formatsEn.add(formatEnTemp);
		}
		return formatsEn;
	}

	public static void copyNewFormatEntityToOldFormatEntity(FormatEntity formatToUpdate, FormatEntity newFormat) {
		formatToUpdate.setName(newFormat.getName());
		formatToUpdate.setCode(newFormat.getCode());
		formatToUpdate.setFeature(newFormat.getFeature());
		formatToUpdate.setActive(newFormat.isActive());
	}

}
