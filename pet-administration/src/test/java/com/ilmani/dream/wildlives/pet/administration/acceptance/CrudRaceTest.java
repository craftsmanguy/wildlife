package com.ilmani.dream.wildlives.pet.administration.acceptance;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.UserTransaction;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.ilmani.dream.wildlives.framework.dto.pet.RaceDto;
import com.ilmani.dream.wildlives.framework.exceptions.EntityNotFoundException;
import com.ilmani.dream.wildlives.framework.exceptions.RequiredFieldException;
import com.ilmani.dream.wildlives.pet.administration.api.impl.PetAdministrationManager;
import com.ilmani.dream.wildlives.pet.administration.facade.PetAdministrationFacade;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ PetAdministrationManager.class })
public class CrudRaceTest {

	@InjectMocks
	private PetAdministrationManager managePet;

	@Mock
	private PetAdministrationFacade petFacade;

	@Mock
	private UserTransaction utx;


	@Test
	public void isInsertionOfTheRaceIsPossible() throws Exception {
		RaceDto expectedResult = new RaceDto("AIREDALE_LE_TERRIER", "", "044df3c874ec3186081a473944d2af7e9646d3a2",
				"DOG", "MAMMAL", false);
		RaceDto raceToInsert = new RaceDto("$airedale le'terrier*2", "", "", "dog/^", "mammal", true);

		when(petFacade.saveRace(raceToInsert)).thenReturn(raceToInsert);
		RaceDto result = managePet.saveRace(raceToInsert);

		assertEquals(expectedResult, result);
	}

	@Test(expected = RequiredFieldException.class)
	public void notBecauseAttributeRaceIsNull() throws Exception {
		managePet.saveRace(new RaceDto());
	}

	@Test(expected = EntityNotFoundException.class)
	public void iHaveNoRacesBySearchMultipleCriterias() throws Exception {
		RaceDto raceSearch = new RaceDto("AIREDALE_LE_TERRIER", "DOG", "MAMMAL");
		Set<RaceDto> results = new HashSet<>();
		when(petFacade.searchRaces(raceSearch)).thenReturn(results);
		managePet.searchRaces(new RaceDto());
	}

	@Test
	public void updateRaceUsingCode() throws Exception {
		RaceDto expectedRace = new RaceDto("APPENFISCHER", "", "1dba55ef5a384123195d625cf1cb003b588b9744", "DOG", "MAMMAL", true);
		RaceDto race = new RaceDto("$appenfischer", "", "", "dog/^", "mammal", true);
		String oldCode = "20c4274a8b0cb741fecfceee8782f2c8922eb215";
		
		Boolean isExists = true;
		when(petFacade.isRaceExists(oldCode)).thenReturn(isExists);
		when(petFacade.updateRace(race, oldCode)).thenReturn(race);
		RaceDto raceUpdated = managePet.updateRace(race, oldCode);
		assertEquals(expectedRace, raceUpdated);
	}
	
	@Test(expected = EntityNotFoundException.class)
	public void attemptToRemoveResourceWichNotExist() throws Exception {
		managePet.deleteRace(new String ("some_code"));
	}

}
