package com.ilmani.dream.wildlives.advert.administration.acceptance;

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

import com.ilmani.dream.wildlives.advert.administration.api.impl.AdvertAdministrationManager;
import com.ilmani.dream.wildlives.advert.administration.facade.AdvertAdministrationFacade;
import com.ilmani.dream.wildlives.framework.dto.advert.FormatDto;
import com.ilmani.dream.wildlives.framework.exceptions.EntityNotFoundException;
import com.ilmani.dream.wildlives.framework.exceptions.RequiredFieldException;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ AdvertAdministrationManager.class })
public class CrudFormatTest {

	@InjectMocks
	private AdvertAdministrationManager advertMngr;

	@Mock
	private AdvertAdministrationFacade advertFacade;

	@Mock
	private UserTransaction utx;

	@Test
	public void isInsertionOfTheFormatIsPossible() throws Exception {
		FormatDto expectedResult = new FormatDto("REQUEST", "request-pet_care", "PET_CARE",
				false);
		FormatDto formatToInsert = new FormatDto("request*", "", "pet care", true);
		when(advertFacade.saveFormat(formatToInsert)).thenReturn(formatToInsert);
		FormatDto result = advertMngr.saveFormat(formatToInsert);
		assertEquals(expectedResult, result);
	}

	@Test(expected = RequiredFieldException.class)
	public void exceptionBecauseAttributeFormatIsNull() throws Exception {
		advertMngr.saveFormat(new FormatDto());
	}

	@Test(expected = RequiredFieldException.class)
	public void exceptionBecauseFormatTypeIsWrong() throws Exception {
		FormatDto formatToInsert = new FormatDto("wrong_type*", "", "pet care", true);
		advertMngr.saveFormat(formatToInsert);
	}
	
	@Test(expected = EntityNotFoundException.class)
	public void iHaveNoFormatBySearchMultipleCriterias() throws Exception {
		FormatDto formatSearch = new FormatDto("REQUEST", "", "pet care", true);
		Set<FormatDto> results = new HashSet<>();
		when(advertFacade.searchFormats(formatSearch)).thenReturn(results);
		advertMngr.searchFormats(new FormatDto());
	}
	
	@Test
	public void updateFormatUsingWithCodeWhichExists() throws Exception {
		FormatDto expectedFormat = new FormatDto("REQUEST", "request-walk","WALK", true);
		FormatDto format = new FormatDto("REQUEST", "", "PET_CARE", true);
		String oldCode = "request-pet_care";
		
		Boolean isExists = true;
		when(advertFacade.isFormatExists(oldCode)).thenReturn(isExists);
		when(advertFacade.updateFormat(format, oldCode)).thenReturn(format);
		format.setFeature("WALK");
		FormatDto raceUpdated = advertMngr.updateFormat(format, oldCode);
		assertEquals(expectedFormat, raceUpdated);
	}
	
	@Test(expected = EntityNotFoundException.class)
	public void attemptToRemoveResourceWichNotExist() throws Exception {
		advertMngr.deleteFormat(new String ("some_code"));
	}

}
