package com.ilmani.dream.wildlives.advert.persistence.acceptance.query;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.persistence.NoResultException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import com.ilmani.dream.wildlives.advert.persistence.dao.FormatDao;
import com.ilmani.dream.wildlives.advert.persistence.entity.FormatEntity;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ FormatDao.class })
public class FormatDaoTest extends DataBaseCreationTest {

	@InjectMocks
	private FormatDao formatDao = new FormatDao();

	@Before
	public void initializeEnvironmentTest() {
		initializeDataBase();
		Whitebox.setInternalState(formatDao, "em", entityManager);
	}

	@Test
	public void formatDoesnotExist() throws NoResultException {
		boolean isExists = formatDao.isExists("WRONG_CODE");
		assertFalse(isExists);
	}

	@Test
	public void findByExactAttribute() {
		FormatEntity formatEntity = new FormatEntity("REQUEST", "REQ_PET_CAR", "PET_CARE", true);
		FormatEntity result = formatDao.findByCode(formatEntity.getCode());
		assertEquals(formatEntity.getName(), result.getName());
	}

	@Test(expected = NoResultException.class)
	public void notBecauseAttributeIsWrong() {
		formatDao.findByCode("WRONG_CODE");
	}

	@Test
	public void searchByOptionalAttribute() {
		List<FormatEntity> results = formatDao.getByAttributes(new FormatEntity());
		assertEquals(8, results.size());
	}

	@Test
	public void updateRaceByChangingAttribute() {
		FormatEntity formatToUpdate = new FormatEntity("OFFER", "OFF_WAL", "WALK", true);
		FormatEntity updatableRace = new FormatEntity(7, "REQUEST", "REQ_BOA_SCH", "BOARDING_SCHOOL", false);

		FormatEntity resultToUpdateFromDb = formatDao.findByCode(formatToUpdate.getCode());
		resultToUpdateFromDb.setActive(updatableRace.isActive());
		resultToUpdateFromDb.setName(updatableRace.getName());
		resultToUpdateFromDb.setCode(updatableRace.getCode());
		resultToUpdateFromDb.setFeature(updatableRace.getFeature());

		formatDao.update(resultToUpdateFromDb);
		FormatEntity resultUpdatingFromDb = formatDao.findByCode(formatToUpdate.getCode());
		assertEquals(updatableRace.getName(), resultUpdatingFromDb.getName());
		assertTrue(false == resultUpdatingFromDb.isActive());
	}

	@Test
	public void insertionOfNewRace() {
		FormatEntity result = formatDao.insert(new FormatEntity("OFFER", "REQ_SEL", "SELL", true));
		assertEquals(9, result.getTechnicalIdentifier());
	}

}
