package com.ilmani.dream.wildlives.advert.persistence.mapper;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.ilmani.dream.wildlives.advert.persistence.entity.AdvertEntity;
import com.ilmani.dream.wildlives.framework.dto.advert.AbstractAdvertDto;
import com.ilmani.dream.wildlives.framework.dto.advert.AdvertBusinessDto;
import com.ilmani.dream.wildlives.framework.dto.pet.AbstractPetDto;

public class AdvertMapper {

	public static AbstractAdvertDto transformAdvertEntityToAdvertDto(AdvertEntity advertEn) {
		AbstractAdvertDto advertDto = new AdvertBusinessDto();
		if (advertEn == null) {
			return advertDto;
		}
		try {
			BeanUtils.copyProperties(advertDto, advertEn);
			if (!advertEn.getFormatsEn().isEmpty()) {
				((AdvertBusinessDto) advertDto).setFormats(FormatMapper
						.transformListFormatEntityToListFormatBusinessDto(new ArrayList<>(advertEn.getFormatsEn())));
			}
			if (!advertEn.getPetsEn().isEmpty()) {
				List<AbstractPetDto> pets = PetForAdvertMapper
						.transformListForUserEntityToListAbstractPetDto(advertEn.getPetsEn());
				((AdvertBusinessDto) advertDto).setPets(pets);
			}
			if (advertEn.getUserEn() != null) {
				((AdvertBusinessDto) advertDto).setUser(advertEn.getUserEn().getPseudonym());
			}
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO log
		}
		return advertDto;
	}

	public static List<AbstractAdvertDto> transformListAdvertEntityToListAdvertDto(List<AdvertEntity> advertsEntity) {
		List<AbstractAdvertDto> formatsDto = new ArrayList<AbstractAdvertDto>();
		if (advertsEntity.isEmpty()) {
			return formatsDto;
		}
		for (AdvertEntity formatEnTemp : advertsEntity) {
			AbstractAdvertDto advertDtoTemp = transformAdvertEntityToAdvertDto(formatEnTemp);
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
			if (!((AdvertBusinessDto) advertDto).getFormats().isEmpty()) {
				advertEn.setFormatsEn(FormatMapper.transformListFormatDtoToListFormatEntity(((AdvertBusinessDto) advertDto).getFormats()));
			}
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO log
		}
		return advertEn;
	}

}
