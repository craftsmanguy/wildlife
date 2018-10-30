package com.ilmani.dream.wildlives.advert.persistence.acceptance.mapper;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.ilmani.dream.wildlives.advert.persistence.entity.FormatEntity;
import com.ilmani.dream.wildlives.advert.persistence.mapper.FormatMapper;
import com.ilmani.dream.wildlives.framework.dto.advert.FormatDto;

public class FormatMapperTest {

	static FormatDto formatDto;

	static FormatEntity formatEn;

	@Before
	public void setUp() throws Exception {
		formatDto = new FormatDto("REQUEST", "REQ_PET_CAR", "PET_CARE", true);

		formatEn = new FormatEntity("OFFER", "OFF_PET_CAR", "PET_CARE", true);
	}

	@Test
	public void transformFormatEntityToFormatDtoTest() {
		FormatEntity formatEnTest = new FormatEntity("REQUEST", "REQ_PET_CAR", "PET_CARE", true);
		FormatDto resultDto = FormatMapper.transformFormatEntityToFormatDto(formatEnTest);
		assertEquals(formatDto, resultDto);
	}

	@Test
	public void transformFormatEntityNullToFormatDtoTest() {
		FormatDto resultDto = FormatMapper.transformFormatEntityToFormatDto(null);
		assertEquals(new FormatDto(), resultDto);
	}

	@Test
	public void transformFormatDtoToFormatEntityTest() {
		FormatDto formatDtoTest = new FormatDto("OFFER", "OFF_PET_CAR", "PET_CARE", false);
		FormatEntity resultEn = FormatMapper.transformFormatDtoToFormatEntity(formatDtoTest);
		assertEquals(formatEn.getName(), resultEn.getName());
	}

}
