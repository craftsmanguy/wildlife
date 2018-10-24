package com.ilmani.dream.wildlives.pet.persistence.acceptance.mapper;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.ilmani.dream.wildlives.framework.dto.pet.RaceDto;
import com.ilmani.dream.wildlives.pet.persistence.entity.RaceEntity;
import com.ilmani.dream.wildlives.pet.persistence.mapper.RaceMapper;

@RunWith(PowerMockRunner.class)
@PrepareForTest(RaceMapper.class)
public class RaceMapperTest {

	static RaceDto raceDto;

	static RaceEntity raceEntity;

	@Before
	public void setUp() throws Exception {
		raceDto = new RaceDto("AFFENPINSCHER", "", "AFFEN", "DOG", "MAMMALIA", true);

		raceEntity = new RaceEntity("AFFENPINSCHER", "", "AFFEN", "DOG", "MAMMALIA", false);
	}

	@Test
	public void transformRaceEntityToRaceDtoTest() {
		RaceEntity raceEnTest = new RaceEntity("AFFENPINSCHER", "", "AFFEN", "DOG", "MAMMALIA", true);
		RaceDto resultDto = RaceMapper.transformRaceEntityToRaceDto(raceEnTest);
		assertEquals(raceDto, resultDto);
	}

	@Test
	public void transformRaceEntityNullToRaceDtoTest() {
		RaceDto resultDto = RaceMapper.transformRaceEntityToRaceDto(null);
		assertEquals(new RaceDto(), resultDto);
	}

	@Test
	public void transformRaceDtoToRaceEntityTest() {
		RaceDto raceDtoTest = new RaceDto("AFFENPINSCHER", "", "AFFEN", "CHIEN", "MAMMIFERE", false);
		RaceEntity resultEn = RaceMapper.transformRaceDtoToRaceEntity(raceDtoTest);
		assertEquals(raceEntity.getName(), resultEn.getName());
	}

}
