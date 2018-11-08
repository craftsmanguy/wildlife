package com.ilmani.dream.wildlives.advert.persistence.adapter;

import java.util.Set;

import javax.inject.Inject;
import javax.persistence.NoResultException;

import com.ilmani.dream.wildlives.advert.administration.port.FormatAdministrationDomain;
import com.ilmani.dream.wildlives.advert.persistence.dao.FormatDao;
import com.ilmani.dream.wildlives.advert.persistence.entity.FormatEntity;
import com.ilmani.dream.wildlives.advert.persistence.mapper.FormatMapper;
import com.ilmani.dream.wildlives.framework.dto.advert.AbstractFormatDto;

public class FormatAdministrationDomainImpl implements FormatAdministrationDomain {

	@Inject
	FormatDao formatDao;

	@Override
	public boolean isFormatExists(String code) {
		return formatDao.isExists(code);
	}

	@Override
	public AbstractFormatDto findFormatByCode(String code) throws NoResultException {
		FormatEntity formatFromDb = formatDao.findByCode(code);
		return FormatMapper.transformFormatEntityToFormatAdministratorDto(formatFromDb);
	}

	@Override
	public AbstractFormatDto save(AbstractFormatDto format) {
		FormatEntity formatEn = FormatMapper.transformFormatDtoToFormatEntity(format);
		FormatEntity result = formatDao.update(formatEn);
		return FormatMapper.transformFormatEntityToFormatAdministratorDto(result);
	}

	@Override
	public void delete(String code) {
		FormatEntity formatToDelete = formatDao.findByCode(code);
		formatDao.delete(formatToDelete);

	}

	@Override
	public AbstractFormatDto update(AbstractFormatDto format, String code) {
		FormatEntity raceEn = FormatMapper.transformFormatDtoToFormatEntity(format);
		FormatEntity raceToUpdate = formatDao.findByCode(code);
		FormatMapper.copyNewFormatEntityToOldFormatEntity(raceToUpdate, raceEn);
		FormatEntity result = formatDao.update(raceToUpdate);
		return FormatMapper.transformFormatEntityToFormatAdministratorDto(result);
	}

	@Override
	public Set<AbstractFormatDto> searchFormats(AbstractFormatDto format) {
		FormatEntity formatEn = FormatMapper.transformFormatDtoToFormatEntity(format);
		Set<FormatEntity> result = formatDao.getByAttributes(formatEn);
		return FormatMapper.transformListFormatEntityToListFormatDto(result);
	}

}
