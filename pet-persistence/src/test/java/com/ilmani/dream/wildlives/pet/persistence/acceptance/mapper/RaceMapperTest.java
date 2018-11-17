package com.ilmani.dream.wildlives.pet.persistence.acceptance.mapper;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.ilmani.dream.wildlives.framework.dto.pet.AbstractRaceDto;
import com.ilmani.dream.wildlives.framework.dto.pet.RaceAdministrationDto;
import com.ilmani.dream.wildlives.framework.dto.pet.RaceBusinessDto;
import com.ilmani.dream.wildlives.pet.persistence.entity.RaceEntity;
import com.ilmani.dream.wildlives.pet.persistence.mapper.RaceMapper;

public class RaceMapperTest {

	static RaceBusinessDto raceDto;

	static RaceEntity raceEntity;

	@Before
	public void setUp() throws Exception {
		raceDto = new RaceAdministrationDto("AFFENPINSCHER", null, "AFFEN", "DOG", "MAMMALIA", true);

		raceEntity = new RaceEntity("AFFENPINSCHER", "AFFEN", "DOG", "MAMMALIA", false);
	}

	@Test
	public void transformRaceEntityToRaceDtoTest() {
		RaceEntity raceEnTest = new RaceEntity("AFFENPINSCHER", "AFFEN", "DOG", "MAMMALIA", true);
		AbstractRaceDto resultDto = RaceMapper.transformRaceEntityToRaceAdministrationDto(raceEnTest);
		assertEquals(raceDto, resultDto);
	}

	@Test
	public void transformRaceEntityNullToRaceDtoTest() {
		AbstractRaceDto resultDto = RaceMapper.transformRaceEntityToRaceAdministrationDto(null);
		assertEquals(new RaceBusinessDto(), resultDto);
	}

	@Test
	public void transformRaceDtoToRaceEntityTest() {
		RaceAdministrationDto raceDtoTest = new RaceAdministrationDto("AFFENPINSCHER", "", "AFFEN", "CHIEN", "MAMMIFERE", false);
		RaceEntity resultEn = RaceMapper.transformRaceDtoToRaceEntity(raceDtoTest);
		assertEquals(raceEntity.getName(), resultEn.getName());
	}

}
