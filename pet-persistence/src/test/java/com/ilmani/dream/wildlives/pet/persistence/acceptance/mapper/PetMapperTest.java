package com.ilmani.dream.wildlives.pet.persistence.acceptance.mapper;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.ilmani.dream.wildlives.framework.dto.pet.AbstractRaceDto;
import com.ilmani.dream.wildlives.framework.dto.pet.PetBusinessDto;
import com.ilmani.dream.wildlives.framework.dto.pet.RaceMinimalDto;
import com.ilmani.dream.wildlives.pet.persistence.entity.PetEntity;
import com.ilmani.dream.wildlives.pet.persistence.entity.RaceEntity;
import com.ilmani.dream.wildlives.pet.persistence.mapper.PetMapper;

public class PetMapperTest {

	static PetBusinessDto petDto;

	static PetEntity petEntity;

	static RaceEntity raceEntity;

	@Test
	public void transformPetEntityToPetDtoTest() {
		raceEntity = new RaceEntity(1, "AFFENPINSCHER", "", "AFFEN", "DOG", "MAMMALIA", true);
		PetEntity petEnTest = new PetEntity("coby-pet-dog-akita_americain-1999-003", "Coby", "la question", false,
				"FEMALE", 1999);
		petEnTest.setRaceEn(raceEntity);
		PetBusinessDto resultDto = (PetBusinessDto) PetMapper.transformPetEntityToPetBusinessDto(petEnTest);
		assertEquals(petEnTest.getFunctionalIdentifier(), resultDto.getFunctionalIdentifier());
		assertEquals(petEnTest.getRaceEn().getCode(), resultDto.getRace().getCode());
	}

	@Test
	public void transformPetEntityNullToPetDtoTest() {
		PetBusinessDto resultDto = (PetBusinessDto) PetMapper.transformPetEntityToPetBusinessDto(null);
		assertEquals(new PetBusinessDto(), resultDto);
	}

	@Test
	public void transformPetDtoToRaceEntityTest() {
		AbstractRaceDto raceDto = new RaceMinimalDto("AFFENPINSCHER", "");
		PetBusinessDto petDtoTest = new PetBusinessDto("rex-pet-dog-affenpinsher-1995-0001", "Rex", "aucune", false, "MALE",
				1995, (RaceMinimalDto) raceDto);
		PetEntity resultEn = PetMapper.transformPetDtoToPetEntity(petDtoTest);
		assertEquals(petDtoTest.getFunctionalIdentifier(), resultEn.getFunctionalIdentifier());
	}

}
