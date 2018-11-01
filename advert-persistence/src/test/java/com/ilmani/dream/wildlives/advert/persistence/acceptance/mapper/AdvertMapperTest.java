package com.ilmani.dream.wildlives.advert.persistence.acceptance.mapper;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;

import com.ilmani.dream.wildlives.advert.persistence.entity.AdvertEntity;
import com.ilmani.dream.wildlives.advert.persistence.entity.FormatEntity;
import com.ilmani.dream.wildlives.advert.persistence.mapper.AdvertMapper;
import com.ilmani.dream.wildlives.framework.dto.advert.AdvertDto;
import com.ilmani.dream.wildlives.framework.dto.advert.FormatDto;

public class AdvertMapperTest {

	static AdvertDto advertDto;

	static FormatDto formatDto;

	static AdvertEntity advertEn;

	static FormatEntity formatEn;

	@Test
	public void transformAdvertEntityToAdvertDtoTest() {
		formatEn = new FormatEntity("REQUEST", "REQ_TRA", "TRAINING", true);
		AdvertEntity advertEnTest = new AdvertEntity("tex1-descrip1-2013-affenpinsher-1995-0001", new Date(),
				new Date(), "titre 1", "description 1", "STEP_1");
		advertEnTest.getFormatsEn().add(formatEn);
		AdvertDto resultDto = AdvertMapper.transformAdvertEntityToAdvertDto(advertEnTest);
		assertEquals(advertEnTest.getFunctionalIdentifier(), resultDto.getFunctionalIdentifier());
		assertEquals(advertEnTest.getFormatsEn().iterator().next().getCode(), resultDto.getFormats().iterator().next().getCode());
	}

	@Test
	public void transformAdvertEntityNullToAdvertDtoTest() {
		AdvertDto resultDto = AdvertMapper.transformAdvertEntityToAdvertDto(null);
		assertEquals(new AdvertDto(), resultDto);
	}

	@Test
	public void transformAdvertDtoToFormatEntityTest() {
		formatDto = new FormatDto("OFFER", "OFF_TRA", "TRAINING", false);
		AdvertDto advertDtoTest = new AdvertDto("tex6-descrip6-2013-azawakh-2007-007", new Date(), new Date(),
				new Date(), "titre 6", "description 6", "STEP_6");
		AdvertEntity resultEn = AdvertMapper.transformAdvertDtoToAdvertEntity(advertDtoTest);
		assertEquals(advertDtoTest.getFunctionalIdentifier(), resultEn.getFunctionalIdentifier());
	}

}
