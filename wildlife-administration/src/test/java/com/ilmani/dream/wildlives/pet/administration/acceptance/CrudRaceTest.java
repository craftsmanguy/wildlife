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

import com.ilmani.dream.wildlives.framework.dto.pet.AbstractRaceDto;
import com.ilmani.dream.wildlives.framework.dto.pet.RaceBusinessDto;
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
	public void insertionOfAnimalNewRaceIsPossible() throws Exception {
		RaceBusinessDto expectedResult = new RaceBusinessDto("AIREDALE_LE_TERRIER", "", "airedale_le_terrier-dog",
				"DOG", "MAMMAL", false);
		AbstractRaceDto raceToInsert = new RaceBusinessDto("$airedale le'terrier*2", "", "", "dog/^", "mammal", true);

		when(petFacade.saveRace(raceToInsert)).thenReturn(raceToInsert);
		AbstractRaceDto result = managePet.saveRace(raceToInsert);

		assertEquals(expectedResult, result);
	}

	@Test(expected = RequiredFieldException.class)
	public void testGenerateExceptionBecauseAttributeRaceIsNull() throws Exception {
		managePet.saveRace(new RaceBusinessDto());
	}

	@Test(expected = EntityNotFoundException.class)
	public void testGenerateExceptionBecauseNoRacesBySearchMultipleCriterias() throws Exception {
		RaceBusinessDto raceSearch = new RaceBusinessDto("AIREDALE_LE_TERRIER", "DOG", "MAMMAL");
		Set<AbstractRaceDto> results = new HashSet<>();
		when(petFacade.searchRaces(raceSearch)).thenReturn(results);
		managePet.searchRaces(new RaceBusinessDto());
	}

	@Test
	public void updateRaceUsingWithCodeWhichExists() throws Exception {
		RaceBusinessDto expectedRace = new RaceBusinessDto("APPENFISCHER", "", "appenfischer-dog", "DOG", "MAMMAL", true);
		RaceBusinessDto race = new RaceBusinessDto("$appenfischer", "", "", "dog/^", "mammal", true);
		String oldCode = "airedale_le_terrier-dog";
		
		Boolean isExists = true;
		when(petFacade.isRaceExists(oldCode)).thenReturn(isExists);
		when(petFacade.updateRace(race, oldCode)).thenReturn(race);
		AbstractRaceDto raceUpdated = managePet.updateRace(race, oldCode);
		assertEquals(expectedRace, raceUpdated);
	}
	
	@Test(expected = EntityNotFoundException.class)
	public void attemptToRemoveResourceWichNotExist() throws Exception {
		managePet.deleteRace(new String ("some_code"));
	}

}
