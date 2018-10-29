package com.ilmani.dream.wildlives.advert.persistence.factory;

import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import com.ilmani.dream.wildlives.advert.persistence.dao.FormatDao;
import com.ilmani.dream.wildlives.advert.persistence.entity.FormatEntity;
import com.ilmani.dream.wildlives.advert.persistence.mapper.FormatMapper;
import com.ilmani.dream.wildlives.framework.dto.advert.FormatDto;


public class FormatFactory {
	
	@Inject
	FormatDao formatDao;
	
	private final static String SAVE_RACE = "SAVE";
	private final static String UPDATE_RACE = "UPDATE";
	private final static String FIND_RACE = "FIND";

	public FormatDto getFormatDto(FormatDto FormatDto, String action) {
		FormatEntity formatEn = FormatMapper.transformFormatDtoToFormatEntity(FormatDto);
		FormatEntity result = new FormatEntity();

		switch (action) {

		case SAVE_RACE:
			result = formatDao.insert(formatEn);
		case UPDATE_RACE:
			result = formatDao.update(formatEn);
		case FIND_RACE:
			result = formatDao.findByUniqueAttributConstraint(formatEn);
		}
		return FormatMapper.transformFormatEntityToFormatDto(result);
	}

	public List<FormatDto> getRacesDto(FormatDto FormatDto) {
		FormatEntity formatEn = FormatMapper.transformFormatDtoToFormatEntity(FormatDto);
		Set<FormatEntity> result = formatDao.getByAttributes(formatEn);
		return FormatMapper.transformListFormatEntityToListFormatDto(result);
	}

	public void delete(FormatDto FormatDto) {
		FormatEntity formatEn = FormatMapper.transformFormatDtoToFormatEntity(FormatDto);
		formatDao.delete(formatEn);
	}

}
