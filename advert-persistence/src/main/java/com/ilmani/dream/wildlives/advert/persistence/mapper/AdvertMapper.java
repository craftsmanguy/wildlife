package com.ilmani.dream.wildlives.advert.persistence.mapper;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtils;

import com.ilmani.dream.wildlives.advert.persistence.entity.AdvertEntity;
import com.ilmani.dream.wildlives.framework.dto.advert.AbstractAdvertDto;
import com.ilmani.dream.wildlives.framework.dto.advert.AdvertBusinessDto;
import com.ilmani.dream.wildlives.framework.dto.pet.AbstractPetDto;

public class AdvertMapper {

	public static AdvertBusinessDto transformAdvertEntityToAdvertDto(AdvertEntity advertEn) {
		AdvertBusinessDto advertDto = new AdvertBusinessDto();
		if (advertEn == null) {
			return advertDto;
		}
		try {
			BeanUtils.copyProperties(advertDto, advertEn);
			if (!advertEn.getFormatsEn().isEmpty()) {
				advertDto.setFormats(
						FormatMapper.transformListFormatEntityToListFormatBusinessDto(advertEn.getFormatsEn()));
			}
			if (!advertEn.getPetsEn().isEmpty()) {
				List<AbstractPetDto> pets = PetForAdvertMapper
						.transformListForUserEntityToListAbstractPetDto(advertEn.getPetsEn());
				advertDto.setPets(pets);
			}
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO log
		}
		return advertDto;
	}

	public static List<AdvertBusinessDto> transformListAdvertEntityToListAdvertDto(Set<AdvertEntity> advertsEntity) {
		List<AdvertBusinessDto> formatsDto = new ArrayList<AdvertBusinessDto>();
		if (advertsEntity.isEmpty()) {
			return formatsDto;
		}
		for (AdvertEntity formatEnTemp : advertsEntity) {
			AdvertBusinessDto advertDtoTemp = transformAdvertEntityToAdvertDto(formatEnTemp);
			formatsDto.add(advertDtoTemp);
		}
		return formatsDto;
	}

	public static AdvertEntity transformAdvertDtoToAdvertEntity(AbstractAdvertDto advertDto) {
		AdvertEntity advertEn = new AdvertEntity();
		if (advertDto == null) {
			return advertEn;
		}
		try {
			BeanUtils.copyProperties(advertEn, advertDto);
			// if (!advertDto.getFormats().isEmpty()) {
			// advertEn.setFormatsEn(FormatMapper.transformListFormatDtoToListFormatEntity(advertDto.getFormats()));
			// }
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO log
		}
		return advertEn;
	}

}
