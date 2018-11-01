package com.ilmani.dream.wildlives.advert.persistence.acceptance.query;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Set;

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
	public void findByExactAttribute() {
		FormatEntity FormatEntity = new FormatEntity("REQUEST", "PET_CARE", true);
		FormatEntity result = formatDao.findByUniqueAttributConstraint(FormatEntity);
		assertEquals(FormatEntity.getName(), result.getName());
	}

	@Test(expected = NoResultException.class)
	public void notBecauseAttributeIsWrong() {
		formatDao.findByUniqueAttributConstraint(new FormatEntity("WRONG_FORMAT", "WRONG_PRESTATION", true));
	}

	@Test
	public void searchByOptionalAttribute() {
		Set<FormatEntity> results = formatDao.getByAttributes(new FormatEntity());
		assertEquals(7, results.size());
	}

	@Test
	public void updateRaceByChangingAttribute() {
		FormatEntity formatToUpdate = new FormatEntity("OFFER", "WALK", true);
		FormatEntity updatableRace = new FormatEntity(7, "REQUEST", "REQ_BOA_SCH", "BOARDING_SCHOOL", false);

		FormatEntity resultToUpdateFromDb = formatDao.findByUniqueAttributConstraint(formatToUpdate);
		resultToUpdateFromDb.setActive(updatableRace.isActive());
		resultToUpdateFromDb.setName(updatableRace.getName());
		resultToUpdateFromDb.setCode(updatableRace.getCode());
		resultToUpdateFromDb.setFeature(updatableRace.getFeature());

		formatDao.update(resultToUpdateFromDb);
		FormatEntity resultUpdatingFromDb = formatDao.findByUniqueAttributConstraint(formatToUpdate);
		assertEquals(updatableRace.getName(), resultUpdatingFromDb.getName());
		assertTrue(false == resultUpdatingFromDb.isActive());
	}

	@Test
	public void insertionOfNewRace() {
		FormatEntity result = formatDao.insert(new FormatEntity("OFFER", "REQ_SEL", "SELL", true));
		assertEquals(9, result.getTechnicalIdentifier());
	}

}
