package com.ilmani.dream.wildlives.pet.persistence.acceptance.query;

import static org.junit.Assert.*;

import java.util.Set;

import javax.persistence.NoResultException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import com.ilmani.dream.wildlives.pet.persistence.dao.RaceDao;
import com.ilmani.dream.wildlives.pet.persistence.entity.RaceEntity;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ RaceDao.class })
public class RaceDaoTest extends DataBaseCreationTest {

	@InjectMocks
	private RaceDao raceDao;

	@Before
	public void initializeEnvironmentTest() {
		initializeDataBase();
		Whitebox.setInternalState(raceDao, "em", entityManager);
	}

	@Test
	public void raceDoesnotExist() throws NoResultException {
		boolean isExists = raceDao.isExists("WRONG_CODE");
		assertFalse(isExists);
	}

	@Test
	public void findByExactAttribute() {
		RaceEntity raceEntity = new RaceEntity("AFFENPINSCHER", "AFFEN_DOG", "DOG", "MAMMALIA", true);
		RaceEntity result = raceDao.findByCode(raceEntity.getCode());
		assertEquals(raceEntity.getName(), result.getName());
	}

	@Test(expected = NoResultException.class)
	public void notBecauseAttributeIsWrong() {
		raceDao.findByCode("WRONG_CODE");
	}

	@Test
	public void searchByOptionalAttribute() {
		Set<RaceEntity> results = raceDao.getByAttributes(new RaceEntity());
		assertEquals(7, results.size());
	}
	
	@Test
	public void returnNotResultWithOptionalAttribute() {
		Set<RaceEntity> results = raceDao.getByAttributes(new RaceEntity("AFFENPINSCHERI", "AFFEN_DOG", "DOG", "WHET", true));
		assertEquals(0, results.size());
	}

	@Test
	public void updateRaceByChangingAttribute() {
		RaceEntity raceToUpdate = new RaceEntity("AIREDALE_TERRIER", "AI_TE_DOG", "DOG", "MAMMALIA", true);
		RaceEntity updatableRace = new RaceEntity(2, "BENGAL", "", "BENG_CAT", "CAT", "MAMMALIA", false);

		RaceEntity resultToUpdateFromDb = raceDao.findByCode(raceToUpdate.getCode());
		resultToUpdateFromDb.setActive(updatableRace.isActive());
		resultToUpdateFromDb.setName(updatableRace.getName());
		resultToUpdateFromDb.setCode(updatableRace.getCode());
		resultToUpdateFromDb.setSpecie(updatableRace.getSpecie());

		raceDao.update(resultToUpdateFromDb);
		RaceEntity resultpdatingFromDb = raceDao.findByCode(raceToUpdate.getCode());
		assertEquals(updatableRace.getName(), resultpdatingFromDb.getName());
		assertTrue(false == resultpdatingFromDb.isActive());
	}

	@Test
	public void insertionOfNewRace() {
		RaceEntity result = raceDao.insert(new RaceEntity("AFFENPINSCHER", "AFFEN_DOG", "DOG", "MAMMALIA", true));
		assertEquals(9, result.getTechnicalIdentifier());
	}

}
