package com.ilmani.dream.wildlives.pet.persistence.acceptance.mapper;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.ilmani.dream.wildlives.framework.dto.pet.PetDto;
import com.ilmani.dream.wildlives.framework.dto.pet.RaceDto;
import com.ilmani.dream.wildlives.pet.persistence.entity.PetEntity;
import com.ilmani.dream.wildlives.pet.persistence.entity.RaceEntity;
import com.ilmani.dream.wildlives.pet.persistence.mapper.PetMapper;

public class PetMapperTest {

	static PetDto petDto;

	static RaceDto raceDto;

	static PetEntity petEntity;

	static RaceEntity raceEntity;

	@Test
	public void transformPetEntityToPetDtoTest() {
		raceEntity = new RaceEntity(1, "AFFENPINSCHER", "", "AFFEN", "DOG", "MAMMALIA", true);
		PetEntity petEnTest = new PetEntity("coby-pet-dog-akita_americain-1999-003", "Coby", "la question", false,
				"FEMALE", 1999);
		petEnTest.setRaceEn(raceEntity);
		PetDto resultDto = PetMapper.transformPetEntityToPetDto(petEnTest);
		assertEquals(petEnTest.getFunctionalIdentifier(), resultDto.getFunctionalIdentifier());
		assertEquals(petEnTest.getRaceEn().getCode(), resultDto.getRace().getCode());
	}

	@Test
	public void transformPetEntityNullToPetDtoTest() {
		PetDto resultDto = PetMapper.transformPetEntityToPetDto(null);
		assertEquals(new PetDto(), resultDto);
	}

	@Test
	public void transformPetDtoToRaceEntityTest() {
		raceDto = new RaceDto("AFFENPINSCHER", "", "AFFEN", "DOG", "MAMMALIA", true);
		PetDto petDtoTest = new PetDto("rex-pet-dog-affenpinsher-1995-0001", null, "Rex", "aucune", false, "MALE",
				1995, raceDto);
		PetEntity resultEn = PetMapper.transformPetDtoToPetEntity(petDtoTest);
		assertEquals(petDtoTest.getFunctionalIdentifier(), resultEn.getFunctionalIdentifier());
	}

}
