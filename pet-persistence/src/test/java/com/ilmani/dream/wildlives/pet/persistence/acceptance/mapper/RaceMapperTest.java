package com.ilmani.dream.wildlives.pet.persistence.acceptance.mapper;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.ilmani.dream.wildlives.framework.dto.pet.RaceBusinessDto;
import com.ilmani.dream.wildlives.pet.persistence.entity.RaceEntity;
import com.ilmani.dream.wildlives.pet.persistence.mapper.RaceMapper;

public class RaceMapperTest {

	static RaceBusinessDto raceDto;

	static RaceEntity raceEntity;

	@Before
	public void setUp() throws Exception {
		raceDto = new RaceBusinessDto("AFFENPINSCHER", null, "AFFEN", "DOG", "MAMMALIA", true);

		raceEntity = new RaceEntity("AFFENPINSCHER", "AFFEN", "DOG", "MAMMALIA", false);
	}

	@Test
	public void transformRaceEntityToRaceDtoTest() {
		RaceEntity raceEnTest = new RaceEntity("AFFENPINSCHER", "AFFEN", "DOG", "MAMMALIA", true);
		RaceBusinessDto resultDto = RaceMapper.transformRaceEntityToRaceDto(raceEnTest);
		assertEquals(raceDto, resultDto);
	}

	@Test
	public void transformRaceEntityNullToRaceDtoTest() {
		RaceBusinessDto resultDto = RaceMapper.transformRaceEntityToRaceDto(null);
		assertEquals(new RaceBusinessDto(), resultDto);
	}

	@Test
	public void transformRaceDtoToRaceEntityTest() {
		RaceBusinessDto raceDtoTest = new RaceBusinessDto("AFFENPINSCHER", "", "AFFEN", "CHIEN", "MAMMIFERE", false);
		RaceEntity resultEn = RaceMapper.transformRaceDtoToRaceEntity(raceDtoTest);
		assertEquals(raceEntity.getName(), resultEn.getName());
	}

}
