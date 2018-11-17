package com.ilmani.dream.wildlives.advert.persistence.acceptance.mapper;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.ilmani.dream.wildlives.advert.persistence.entity.FormatEntity;
import com.ilmani.dream.wildlives.advert.persistence.mapper.FormatMapper;
import com.ilmani.dream.wildlives.framework.dto.advert.AbstractFormatDto;
import com.ilmani.dream.wildlives.framework.dto.advert.FormatAdministratorDto;

public class FormatMapperTest {

	static FormatAdministratorDto formatDto;

	static FormatEntity formatEn;

	@Before
	public void setUp() throws Exception {
		formatDto = new FormatAdministratorDto("REQUEST", "REQ_PET_CAR", "PET_CARE", true);

		formatEn = new FormatEntity("OFFER", "OFF_PET_CAR", "PET_CARE", true);
	}

	@Test
	public void transformFormatEntityToFormatDtoTest() {
		FormatEntity formatEnTest = new FormatEntity("REQUEST", "REQ_PET_CAR", "PET_CARE", true);
		AbstractFormatDto resultDto = FormatMapper.transformFormatEntityToFormatAdministrationDto(formatEnTest);
		assertEquals(formatDto, resultDto);
	}

	@Test
	public void transformFormatEntityNullToFormatDtoTest() {
		AbstractFormatDto resultDto = FormatMapper.transformFormatEntityToFormatAdministrationDto(null);
		assertEquals(new FormatAdministratorDto(), resultDto);
	}

	@Test
	public void transformFormatDtoToFormatEntityTest() {
		FormatAdministratorDto formatDtoTest = new FormatAdministratorDto("OFFER", "OFF_PET_CAR", "PET_CARE", false);
		FormatEntity resultEn = FormatMapper.transformFormatDtoToFormatEntity(formatDtoTest);
		assertEquals(formatEn.getName(), resultEn.getName());
	}

}
