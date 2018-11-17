package com.ilmani.dream.wildlives.advert.persistence.adapter;

import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import com.ilmani.dream.wildlives.advert.business.port.FormatBusinessDomain;
import com.ilmani.dream.wildlives.advert.persistence.dao.FormatDao;
import com.ilmani.dream.wildlives.advert.persistence.entity.FormatEntity;
import com.ilmani.dream.wildlives.advert.persistence.mapper.FormatMapper;
import com.ilmani.dream.wildlives.framework.dto.advert.AbstractFormatDto;

public class FormatBusinessDomainImpl implements FormatBusinessDomain {

	@Inject
	FormatDao formatDao;

	@Override
	public Set<AbstractFormatDto> search(AbstractFormatDto format) {
		FormatEntity formatEn = FormatMapper.transformFormatDtoToFormatEntity(format);
		formatEn.setActive(true); // Get only active format for user. 
		List<FormatEntity> result = formatDao.getByAttributes(formatEn);
		return FormatMapper.transformListFormatEntityToListFormatBusinessDto(result);
	}

}
