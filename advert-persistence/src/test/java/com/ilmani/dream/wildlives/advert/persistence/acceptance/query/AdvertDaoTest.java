package com.ilmani.dream.wildlives.advert.persistence.acceptance.query;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.List;

import javax.persistence.NoResultException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import com.ilmani.dream.wildlives.advert.persistence.dao.AdvertDao;
import com.ilmani.dream.wildlives.advert.persistence.dao.FormatDao;
import com.ilmani.dream.wildlives.advert.persistence.entity.AdvertEntity;
import com.ilmani.dream.wildlives.advert.persistence.entity.FormatEntity;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ AdvertDao.class })
public class AdvertDaoTest extends DataBaseCreationTest {

	@InjectMocks
	private AdvertDao advertDao = new AdvertDao();

	@InjectMocks
	private FormatDao formatDao = new FormatDao();

	@Before
	public void initializeEnvironmentTest() {
		initializeDataBase();
		Whitebox.setInternalState(advertDao, "em", entityManager);
	}

	@Test
	public void findByExactAttribute() {
		AdvertEntity advertEn = new AdvertEntity("tex1-descrip1-2013-affenpinsher-1995-0001", new Date(), new Date(),
				"titre 1", "description 1", "TEST");
		AdvertEntity result = advertDao.findByFunctionalId(advertEn.getFunctionalIdentifier());
		assertEquals(advertEn.getFunctionalIdentifier(), result.getFunctionalIdentifier());
	}

	@Test(expected = NoResultException.class)
	public void notBecauseAttributeIsWrong() {
		advertDao.findByFunctionalId("wrong_functional_id");
	}

	@Test
	public void searchByOptionalAttribute() {
		List<AdvertEntity> results = advertDao.getByAttributes(new AdvertEntity());
		assertEquals(7, results.size());
	}

	@Test
	public void updateRaceByChangingAttribute() {
		AdvertEntity advertToUpdate = new AdvertEntity("tex6-descrip6-2013-azawakh-2007-007", new Date(), new Date(),
				"titre 6", "description 6", "TEST");
		AdvertEntity updatableAdvert = new AdvertEntity("tex6-descrip6-2013-azawakh-2007-007", new Date(), new Date(),
				"nouveau titre", "nouveau description", "AVANCE");

		AdvertEntity resultToUpdateFromDb = advertDao
				.findByFunctionalId(advertToUpdate.getFunctionalIdentifier());
		resultToUpdateFromDb.setStartDate(updatableAdvert.getStartDate());
		resultToUpdateFromDb.setDescription(updatableAdvert.getDescription());
		resultToUpdateFromDb.setTitle(updatableAdvert.getTitle());
		resultToUpdateFromDb.setState(updatableAdvert.getState());

		advertDao.update(resultToUpdateFromDb);
		AdvertEntity resultUpdatingFromDb = advertDao
				.findByFunctionalId(advertToUpdate.getFunctionalIdentifier());
		assertEquals(updatableAdvert.getTitle(), resultUpdatingFromDb.getTitle());
		assertEquals(updatableAdvert.getDescription(), resultUpdatingFromDb.getDescription());
	}

	@Test
	public void insertionOfNewPet() {
		AdvertEntity advert = new AdvertEntity("tex8-descrip8-2018-azawakh-2007-008", new Date(), new Date(), "titre 8",
				"description 8", "TEST");
		Whitebox.setInternalState(formatDao, "em", entityManager);
		FormatEntity resultRace = formatDao.findByCode("REQ_PET_CAR");
		advert.getFormatsEn().add(resultRace);
		AdvertEntity advertToSave = advertDao.insert(advert);
		assertNotNull(advertToSave.getId().toString());
	}

}
