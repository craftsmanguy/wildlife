package com.ilmani.dream.wildlives.advert.persistence.acceptance.query;

import java.sql.Connection;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.jdbc.Work;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.LiquibaseException;
import liquibase.resource.ClassLoaderResourceAccessor;

public abstract class DataBaseCreationTest {

	private static final String UNIT_NAME = "advertPuTest";

	protected static EntityManager entityManager;

	protected Session session;

	private static Liquibase liquibase;

	@BeforeClass
	public static void initializeEntityManager() throws Exception {
		entityManager = Persistence.createEntityManagerFactory(UNIT_NAME).createEntityManager();
	}

	protected void initializeDataBase() {
		session = entityManager.unwrap(Session.class);
		session.doWork(new Work() {
			@Override
			public void execute(Connection connection) throws SQLException {
				createDatabase(connection);
			}
		});
	}

	private void createDatabase(Connection connection) {
		try {
			Database database = DatabaseFactory.getInstance()
					.findCorrectDatabaseImplementation(new JdbcConnection(connection));

			liquibase = new Liquibase("database-test/db.wildlife-test.xml",
					new ClassLoaderResourceAccessor(), database);
			liquibase.update("wildlife-test");
		} catch (LiquibaseException e) {
			throw new RuntimeException("could not initialize with liquibase");
		}
	}

	@After
	public void closeDatabase() throws LiquibaseException {
		liquibase.dropAll();
	}

	@AfterClass
	public static void closeEntityManager() {
		entityManager.clear();
		entityManager.close();
	}
}
