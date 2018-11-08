package com.ilmani.dream.wildlives.advert.persistence.acceptance.mapper;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;

import com.ilmani.dream.wildlives.advert.persistence.entity.AdvertEntity;
import com.ilmani.dream.wildlives.advert.persistence.entity.FormatEntity;
import com.ilmani.dream.wildlives.advert.persistence.mapper.AdvertMapper;
import com.ilmani.dream.wildlives.framework.dto.advert.AdvertBusinessDto;
import com.ilmani.dream.wildlives.framework.dto.advert.FormatAdministratorDto;

public class AdvertMapperTest {

	static AdvertBusinessDto advertDto;

	static FormatAdministratorDto formatDto;

	static AdvertEntity advertEn;

	static FormatEntity formatEn;

	@Test
	public void transformAdvertEntityToAdvertDtoTest() {
		formatEn = new FormatEntity("REQUEST", "REQ_TRA", "TRAINING", true);
		AdvertEntity advertEnTest = new AdvertEntity("tex1-descrip1-2013-affenpinsher-1995-0001", new Date(),
				new Date(), "titre 1", "description 1", "STEP_1");
		advertEnTest.getFormatsEn().add(formatEn);
		AdvertBusinessDto resultDto = AdvertMapper.transformAdvertEntityToAdvertDto(advertEnTest);
		assertEquals(advertEnTest.getFunctionalIdentifier(), resultDto.getFunctionalIdentifier());
		assertEquals(advertEnTest.getFormatsEn().iterator().next().getCode(), resultDto.getFormats().iterator().next().getCode());
	}

	@Test
	public void transformAdvertEntityNullToAdvertDtoTest() {
		AdvertBusinessDto resultDto = AdvertMapper.transformAdvertEntityToAdvertDto(null);
		assertEquals(new AdvertBusinessDto(), resultDto);
	}

	@Test
	public void transformAdvertDtoToFormatEntityTest() {
		formatDto = new FormatAdministratorDto("OFFER", "OFF_TRA", "TRAINING", false);
		AdvertBusinessDto advertDtoTest = new AdvertBusinessDto("tex6-descrip6-2013-azawakh-2007-007", new Date(),
				new Date(), "titre 6", "description 6");
		AdvertEntity resultEn = AdvertMapper.transformAdvertDtoToAdvertEntity(advertDtoTest);
		assertEquals(advertDtoTest.getFunctionalIdentifier(), resultEn.getFunctionalIdentifier());
	}

}
