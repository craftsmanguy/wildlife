package com.ilmani.dream.wildlives.pet.business.acceptance;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import javax.transaction.UserTransaction;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.ilmani.dream.wildlives.framework.dto.pet.PetDto;
import com.ilmani.dream.wildlives.framework.dto.pet.RaceDto;
import com.ilmani.dream.wildlives.framework.exceptions.EntityNotFoundException;
import com.ilmani.dream.wildlives.framework.exceptions.RequiredFieldException;
import com.ilmani.dream.wildlives.pet.business.api.impl.PetBusinessManager;
import com.ilmani.dream.wildlives.pet.business.facade.PetBusinessFacade;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ PetBusinessManager.class })
public class CrudBusinessPetTest {

	@InjectMocks
	private PetBusinessManager managePet;

	@Mock
	private PetBusinessFacade petFacade;

	@Mock
	private UserTransaction utx;

	@Test
	public void insertionOfNewPetIsPossible() throws Exception {
		PetDto expectedResult = new PetDto("af508a2e7a33055e308387eaad72e3fd3a6a9cbe-affenpinscher-rex-2018-anything", "Rex", "anything", true, "MALE",
				2018, new RaceDto("AFFENPINSCHER", "af508a2e7a33055e308387eaad72e3fd3a6a9cbe"));
		PetDto toInsert = new PetDto("", "rex", "anything", true, "male", 2018,
				new RaceDto("AFFENPINSCHER", "af508a2e7a33055e308387eaad72e3fd3a6a9cbe"));

		when(petFacade.savePet(toInsert)).thenReturn(toInsert);
		
		PetDto actual = managePet.savePet(toInsert);
		assertEquals(expectedResult.getFunctionalIdentifier(), actual.getFunctionalIdentifier().substring(0, 72));
		assertEquals(expectedResult.getName(), actual.getName());
		assertEquals(expectedResult.getGender(), actual.getGender());
	}
	
	@Test(expected = RequiredFieldException.class)
	public void testGenerateExceptionBecauseAttributePetIsNull() throws Exception {
		managePet.savePet(new PetDto());
	}
	
	@Test(expected = RequiredFieldException.class)
	public void insertionOfNewPetWithWrongGenderIsPossible() throws Exception {
		PetDto toInsert = new PetDto("", "rex", "anything", true, "malebi", 2018,
				new RaceDto("AFFENPINSCHER", "af508a2e7a33055e308387eaad72e3fd3a6a9cbe"));
		managePet.savePet(toInsert);
	}
	
	@Test(expected = EntityNotFoundException.class)
	public void attemptToRemoveResourceWichNotExist() throws Exception {
		managePet.deletePet(new String ("some_code"));
	}
	
	

}
