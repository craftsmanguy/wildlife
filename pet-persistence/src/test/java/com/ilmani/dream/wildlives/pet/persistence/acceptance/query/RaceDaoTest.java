package com.ilmani.dream.wildlives.pet.persistence.acceptance.query;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.sql.Connection;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.internal.SessionImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.ilmani.dream.wildlives.database.acceptance.DBChangelogFileTest;
import com.ilmani.dream.wildlives.pet.persistence.dao.RaceDao;
import com.ilmani.dream.wildlives.pet.persistence.entity.RaceEntity;

import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.resource.ClassLoaderResourceAccessor;

@RunWith(MockitoJUnitRunner.class)
public class RaceDaoTest {

	private static final String UNIT_NAME = "petPuTest";

	private static Liquibase liquibase;

	@InjectMocks
	private RaceDao raceDao;

	@Mock
	private EntityManager em = Persistence.createEntityManagerFactory(UNIT_NAME).createEntityManager();

	@Before
	public void redefineUp() throws Exception {
		EntityManager entityManager = Persistence.createEntityManagerFactory(UNIT_NAME).createEntityManager();

		Session session = entityManager.unwrap(Session.class);
		SessionImpl sessionImpl = (SessionImpl) session;
		Connection connection = sessionImpl.connection();

		Database database = DatabaseFactory.getInstance()
				.findCorrectDatabaseImplementation(new JdbcConnection(connection));

		liquibase = new Liquibase("com/ilmani/dream/wildlives/database/wildlife.xml", new ClassLoaderResourceAccessor(),
				database);
		liquibase.update("wildlife-test");
	}

	@Test
	public void findByAttribut() {
		RaceEntity raceEntity = new RaceEntity("AFFENPINSCHER", "", "", "DOG", "MAMMALIA", false);
		RaceEntity result = raceDao.findByAttribut(raceEntity);
		assertEquals(raceEntity.getName(), result.getName());
	}

	@Test
	public void testGetByAttribut() {
		fail("Not yet implemented");
	}

	@Test
	public void testSave() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@After
	public void closeDataBase() throws Exception {
		liquibase.dropAll();
	}
}
