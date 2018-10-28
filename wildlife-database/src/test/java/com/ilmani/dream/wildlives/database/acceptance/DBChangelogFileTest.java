package com.ilmani.dream.wildlives.database.acceptance;

import java.sql.Connection;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.jdbc.Work;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.LiquibaseException;
import liquibase.resource.ClassLoaderResourceAccessor;

public class DBChangelogFileTest {

	private static final String UNIT_NAME = "databasePuTest";

	protected static EntityManager entityManager;

	protected Liquibase liquibase;

	@BeforeClass
	public static void initializeEntityManager() throws Exception {
		entityManager = Persistence.createEntityManagerFactory(UNIT_NAME).createEntityManager();
	}

	@Before
	public void initializeDatabase() throws LiquibaseException {
		Session session = entityManager.unwrap(Session.class);
		session.doWork(new Work() {
			@Override
			public void execute(Connection connection) throws SQLException {
				try {
					Database database = DatabaseFactory.getInstance()
							.findCorrectDatabaseImplementation(new JdbcConnection(connection));

					liquibase = new Liquibase("com/ilmani/dream/wildlives/database-test/db.wildlife-test.xml",
							new ClassLoaderResourceAccessor(), database);
					liquibase.update("wildlife-test");
				} catch (LiquibaseException e) {
					throw new RuntimeException("could not initialize with liquibase");
				}
			}
		});
	}

	@After
	public void closeDatabase() throws LiquibaseException {
		liquibase.dropAll();
	}

	@AfterClass
	public static void tearDown() {
		entityManager.clear();
		entityManager.close();
	}
}
