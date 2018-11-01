package com.ilmani.dream.wildlives.pet.persistence.acceptance.query;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
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

import com.ilmani.dream.wildlives.pet.persistence.dao.PetDao;
import com.ilmani.dream.wildlives.pet.persistence.dao.RaceDao;
import com.ilmani.dream.wildlives.pet.persistence.entity.PetEntity;
import com.ilmani.dream.wildlives.pet.persistence.entity.RaceEntity;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ PetDao.class })
public class PetDaoTest extends DataBaseCreationTest {

	@InjectMocks
	private PetDao petDao = new PetDao();

	@InjectMocks
	private RaceDao raceDao = new RaceDao();

	@Before
	public void initializeEnvironmentTest() {
		initializeDataBase();
		Whitebox.setInternalState(petDao, "em", entityManager);
	}

	@Test
	public void findByExactAttribute() {
		PetEntity petEntity = new PetEntity("rex-pet-dog-affenpinsher-1995-0001", "Rex", "aucune", false, "MALE", 1995);
		PetEntity result = petDao.findByIdentifier(petEntity);
		assertEquals(petEntity.getFunctionalIdentifier(), result.getFunctionalIdentifier());
	}

	@Test(expected = NoResultException.class)
	public void notBecauseAttributeIsWrong() {
		petDao.findByIdentifier(new PetEntity("wrong_functional_id", "wrong_name", "aucune", false, "MALE", 1995));
	}

	@Test
	public void searchByOptionalAttribute() {
		List<PetEntity> results = petDao.getByAttributes(new PetEntity());
		assertEquals(8, results.size());
	}

	@Test
	public void updateRaceByChangingAttribute() {
		PetEntity petToUpdate = new PetEntity("et_si-pet-dog-azawakh-2007-007", "et si", "", false, "MALE", 2007);
		PetEntity updatablePet = new PetEntity("et_si-pet-dog-azawakh-2007-007", "coome", "nouveau commentaire", true,
				"MALE", 2011);

		PetEntity resultToUpdateFromDb = petDao.findByIdentifier(petToUpdate);
		resultToUpdateFromDb.setGender(updatablePet.getGender());
		resultToUpdateFromDb.setDescription(updatablePet.getDescription());
		resultToUpdateFromDb.setLof(updatablePet.isLof());
		resultToUpdateFromDb.setBirth(updatablePet.getBirth());

		petDao.update(resultToUpdateFromDb);
		PetEntity resultUpdatingFromDb = petDao.findByIdentifier(petToUpdate);
		assertEquals(updatablePet.getDescription(), resultUpdatingFromDb.getDescription());
		assertTrue(resultUpdatingFromDb.isLof());
	}

	@Test
	public void insertionOfNewPet() {
		PetEntity pet = new PetEntity("slug-url-1", "Rex", "", true, "M", new Integer(2015));
		Whitebox.setInternalState(raceDao, "em", entityManager);
		RaceEntity resultRace = raceDao
				.findByUniqueAttributConstraint(new RaceEntity("AFFENPINSCHER", "", "DOG", "MAMMALIA", true));
		pet.setRaceEn(resultRace);
		PetEntity petToSave = petDao.insert(pet);
		assertNotNull(petToSave.getId().toString());
	}

}
