package com.ilmani.dream.wildlives.pet.administration.acceptance;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.UserTransaction;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.ilmani.dream.wildlives.framework.dto.pet.RaceDto;
import com.ilmani.dream.wildlives.framework.exceptions.EntityAlreadyExistException;
import com.ilmani.dream.wildlives.framework.exceptions.EntityNotFoundException;
import com.ilmani.dream.wildlives.framework.exceptions.RequiredFieldException;
import com.ilmani.dream.wildlives.framework.exceptions.RestClientException;
import com.ilmani.dream.wildlives.pet.administration.api.impl.PetAdministrationManager;
import com.ilmani.dream.wildlives.pet.administration.facade.PetAministrationFacade;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ PetAdministrationManager.class })
public class CrudRaceTest {

	@InjectMocks
	private PetAdministrationManager managePet;

	@Mock
	private PetAministrationFacade petFacade;

	@Mock
	private UserTransaction utx;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void isInsertionOfTheRaceIsPossible() throws Exception {
		RaceDto expectedResult = new RaceDto("AIREDALE_LE_TERRIER", "", "20c4274a8b0cb741fecfceee8782f2c8922eb215",
				"DOG", "MAMMALIA", false);
		RaceDto raceToInsert = new RaceDto("$airedale le'terrier*2", "", "", "dog/^", "mammalia", true);

		when(petFacade.saveRace(raceToInsert)).thenReturn(raceToInsert);
		RaceDto result = managePet.saveRace(raceToInsert);

		assertEquals(expectedResult, result);
	}

	@Test(expected = RequiredFieldException.class)
	public void notBecauseAttributeRaceIsNull()
			throws RequiredFieldException, RestClientException, EntityAlreadyExistException {
		managePet.saveRace(new RaceDto());
	}

	@Test(expected = EntityNotFoundException.class)
	public void getRaceBySearchMultipleCriterias() throws EntityNotFoundException {
		RaceDto raceSearch = new RaceDto("AIREDALE_LE_TERRIER", "DOG", "MAMMALIA");
		Set<RaceDto> results = new HashSet<>();
		when(petFacade.searchRaces(raceSearch)).thenReturn(results);
		managePet.searchRaces(new RaceDto());
	}

}
