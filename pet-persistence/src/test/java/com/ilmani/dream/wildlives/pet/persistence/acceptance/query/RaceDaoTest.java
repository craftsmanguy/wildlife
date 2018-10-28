package com.ilmani.dream.wildlives.pet.persistence.acceptance.query;

import static org.junit.Assert.assertEquals;

import java.util.Set;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.transaction.UserTransaction;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import com.ilmani.dream.wildlives.pet.persistence.dao.RaceDao;
import com.ilmani.dream.wildlives.pet.persistence.entity.RaceEntity;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ RaceDao.class })
public class RaceDaoTest extends DataBaseCreationTest {

	@Inject
	@Resource
	private RaceDao raceDao = new RaceDao();

	@Mock
	UserTransaction utx;

	@Before
	public void initializeEnvironmentTest() {
		initializeDateBase();
		Whitebox.setInternalState(raceDao, "em", entityManager);
	}

	@Test
	public void findByAttributTest() {
		RaceEntity raceEntity = new RaceEntity("AFFENPINSCHER", "", "", "DOG", "MAMMALIA", true);
		RaceEntity result = raceDao.findByUniqueAttributConstraint(raceEntity);
		assertEquals(raceEntity.getName(), result.getName());
	}

	@Test(expected = NoResultException.class)
	public void notFindByAttributTest() {
		raceDao.findByUniqueAttributConstraint(
				new RaceEntity("WRONG_RACE", "", "", "WRONG_SPECIE", "WRONG_CLAN", true));
	}

	@Test
	public void getByAttributesTest() {
		Set<RaceEntity> results = raceDao.getByAttributes(new RaceEntity());
		assertEquals(8, results.size());
	}

	@Test
	public void testUpdate() {
		RaceEntity raceToUpdate = new RaceEntity("AIREDALE_TERRIER", "", "AI_TE_DOG", "DOG", "MAMMALIA", true);
		RaceEntity updatableRace = new RaceEntity(2, "BENGAL", "", "BENG_CAT", "CAT", "MAMMALIA", false);

		RaceEntity resultToUpdateFromDb = raceDao.findByUniqueAttributConstraint(raceToUpdate);
		resultToUpdateFromDb.setActive(updatableRace.isActive());
		resultToUpdateFromDb.setName(updatableRace.getName());
		resultToUpdateFromDb.setCode(updatableRace.getCode());
		resultToUpdateFromDb.setSpecie(updatableRace.getSpecie());

		raceDao.update(resultToUpdateFromDb);
		RaceEntity resultpdatingFromDb = raceDao.findByUniqueAttributConstraint(raceToUpdate);
		assertEquals(updatableRace.getName(), resultpdatingFromDb.getName());
	}

	@Test
	public void testSave() {
		RaceEntity result = raceDao.insert(new RaceEntity("AFFENPINSCHER", "", "AFFEN_DOG", "DOG", "MAMMALIA", true));
		assertEquals(9, result.getTechnicalIdentifier());
	}

}
