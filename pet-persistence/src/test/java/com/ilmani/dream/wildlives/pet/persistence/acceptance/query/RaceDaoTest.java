package com.ilmani.dream.wildlives.pet.persistence.acceptance.query;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Set;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.jdbc.Work;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import com.ilmani.dream.wildlives.pet.persistence.dao.RaceDao;
import com.ilmani.dream.wildlives.pet.persistence.entity.RaceEntity;

import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.LiquibaseException;
import liquibase.resource.ClassLoaderResourceAccessor;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ RaceDao.class })
public class RaceDaoTest extends DataBaseCreationTest {

	private RaceDao raceDao = new RaceDao();

	@Before
	public void initializeENtityManager() {
		Session session = entityManager.unwrap(Session.class);
		session.doWork(new Work() {
			@Override
			public void execute(Connection connection) throws SQLException {
				try {
					Database database = DatabaseFactory.getInstance()
							.findCorrectDatabaseImplementation(new JdbcConnection(connection));

					liquibase = new Liquibase("com/ilmani/dream/wildlives/database/wildlife.xml",
							new ClassLoaderResourceAccessor(), database);
					liquibase.update("wildlife-test");
				} catch (LiquibaseException e) {
					throw new RuntimeException("could not initialize with liquibase");
				}
			}
		});
		Whitebox.setInternalState(raceDao, "em", entityManager);
	}

	@Test
	public void findByAttributTest() {
		RaceEntity raceEntity = new RaceEntity("AFFENPINSCHER", "", "", "DOG", "MAMMALIA", false);
		RaceEntity result = raceDao.findByUniqueAttributConstraint(raceEntity);
		assertEquals(raceEntity.getName(), result.getName());
	}

	@Test(expected = NoResultException.class)
	public void notFindByAttributTest() {
		raceDao.findByUniqueAttributConstraint(new RaceEntity("WRONG_RACE", "", "", "WRONG_SPECIE", "WRONG_CLAN", false));
	}

	@Test
	public void getByAttributTest() {
		Set<RaceEntity> results = raceDao.getByAttributes(new RaceEntity());
		assertEquals(8, results.size());
	}

	@Test
	public void testUpdate() {
		RaceEntity raceToUpdate = new RaceEntity("AFFENPINSCHER", "", "AFFEN_DOG", "DOG", "MAMMALIA", false);
		RaceEntity updateRaceValue = new RaceEntity("BENGAL", "", "BENG_CAT", "CAT", "MAMMALIA", false);

		RaceEntity result = raceDao.update(raceToUpdate);

		RaceEntity resultFromDb = raceDao.findByUniqueAttributConstraint(raceToUpdate);
		assertEquals(raceToUpdate.getName(), resultFromDb.getName());
	}

	@Test
	public void testSave() {
		RaceEntity result = raceDao.save(new RaceEntity("AFFENPINSCHER", "", "AFFEN_DOG", "DOG", "MAMMALIA", true));
		assertEquals(new Integer(9), result.getTechnicalIdentifier());
	}

	@Ignore
	@Test
	public void testDelete() {
		RaceEntity resultFrom = raceDao
				.findByUniqueAttributConstraint(new RaceEntity(7, "AZAWAKH", "", "AZAWA_DOG", "DOG", "MAMMALIA", true));
		raceDao.delete(resultFrom);
		Set<RaceEntity> results = raceDao.getByAttributes(new RaceEntity());
		assertEquals(8, results.size());
	}

}
