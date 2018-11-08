package com.ilmani.dream.wildlives.advert.business.acceptance;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Date;

import javax.transaction.UserTransaction;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.ilmani.dream.wildlives.advert.business.api.impl.AdvertBusinessManager;
import com.ilmani.dream.wildlives.advert.business.facade.AdvertBusinessFacade;
import com.ilmani.dream.wildlives.framework.dto.advert.AbstractAdvertDto;
import com.ilmani.dream.wildlives.framework.dto.advert.AdvertBusinessDto;
import com.ilmani.dream.wildlives.framework.dto.advert.FormatBusinessDto;
import com.ilmani.dream.wildlives.framework.exceptions.RequiredFieldException;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ AdvertBusinessManager.class })
public class CrudBusinessAdvertTest {

	@InjectMocks
	private AdvertBusinessManager manageAdvert;

	@Mock
	private AdvertBusinessFacade advertFacade;

	@Mock
	private UserTransaction utx;

	@Test
	public void insertionOfNewAdvertIsPossible() throws Exception {
		AbstractAdvertDto expectedResult = new AdvertBusinessDto(
				"une-titre-pet_garde-wed-nov-07-221704-cet-2018-aucune-ou-pas-7z8k69mcs--", new Date(), new Date(),
				"une titre?", "aucune ou pas");
		((AdvertBusinessDto) expectedResult).getFormats().add(new FormatBusinessDto("pet_garde", ""));

		AdvertBusinessDto toInsert = new AdvertBusinessDto("", new Date(), new Date(), "une titre?",
				"aucune ou pas");
		((AdvertBusinessDto) toInsert).getFormats().add(new FormatBusinessDto("", ""));

		when(advertFacade.saveAdvert(toInsert)).thenReturn(toInsert);
		AdvertBusinessDto actual = (AdvertBusinessDto) manageAdvert.saveAdvert(toInsert);
		assertEquals(expectedResult.getFunctionalIdentifier().substring(0, 10),
				actual.getFunctionalIdentifier().substring(0, 10));
		assertEquals(expectedResult.getTitle(), actual.getTitle());
	}

	@Test(expected = RequiredFieldException.class)
	public void testGenerateExceptionBecauseAttributeAdvertIsNull() throws Exception {
		manageAdvert.saveAdvert(new AdvertBusinessDto());
	}

	@Test(expected = RequiredFieldException.class)
	public void insertionOfNewAdvertWithWrongFormatIsNotPossible() throws Exception {
		AdvertBusinessDto toInsert = new AdvertBusinessDto("", new Date(), new Date(), "une titre?",
				"aucune ou pas");
		manageAdvert.saveAdvert(toInsert);
	}

}
