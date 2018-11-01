package com.ilmani.dream.wildlives.advert.persistence.factory;

import java.util.Set;

import javax.inject.Inject;

import com.ilmani.dream.wildlives.advert.persistence.dao.FormatDao;
import com.ilmani.dream.wildlives.advert.persistence.entity.FormatEntity;
import com.ilmani.dream.wildlives.advert.persistence.mapper.FormatMapper;
import com.ilmani.dream.wildlives.framework.constants.ConstantsCrud;
import com.ilmani.dream.wildlives.framework.dto.advert.FormatDto;


public class FormatFactory {
	
	@Inject
	FormatDao formatDao;

	public FormatDto getFormatDto(FormatDto FormatDto, String action) {
		FormatEntity formatEn = FormatMapper.transformFormatDtoToFormatEntity(FormatDto);
		FormatEntity result = new FormatEntity();

		switch (action) {

		case ConstantsCrud.SAVE:
			result = formatDao.insert(formatEn);
			break;
		case ConstantsCrud.UPDATE:
			result = formatDao.update(formatEn);
			break;
		case ConstantsCrud.FIND:
			result = formatDao.findByUniqueAttributConstraint(formatEn);
			break;
		}
		return FormatMapper.transformFormatEntityToFormatDto(result);
	}

	public Set<FormatDto> getRacesDto(FormatDto FormatDto) {
		FormatEntity formatEn = FormatMapper.transformFormatDtoToFormatEntity(FormatDto);
		Set<FormatEntity> result = formatDao.getByAttributes(formatEn);
		return FormatMapper.transformListFormatEntityToListFormatDto(result);
	}

	public void delete(FormatDto FormatDto) {
		FormatEntity formatEn = FormatMapper.transformFormatDtoToFormatEntity(FormatDto);
		formatDao.delete(formatEn);
	}

}
