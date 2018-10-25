package com.ilmani.dream.wildlives.database.acceptance;

import java.sql.Connection;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.internal.SessionImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.LiquibaseException;
import liquibase.resource.ClassLoaderResourceAccessor;

public class DBChangelogFileTest {

	private static final String UNIT_NAME = "databasePu";
	
	protected static EntityManager entityManager;
	
	protected Liquibase liquibase;

	@BeforeClass
	public static void setUp() throws Exception {
		entityManager = Persistence.createEntityManagerFactory(UNIT_NAME).createEntityManager();
	}
	
	@Before
	public void craeteDatabaseTest() throws LiquibaseException{
		Session session = entityManager.unwrap(Session.class);
		SessionImpl sessionImpl = (SessionImpl) session;
		Connection connection = sessionImpl.connection();

		Database database = DatabaseFactory.getInstance()
				.findCorrectDatabaseImplementation(new JdbcConnection(connection));

		liquibase = new Liquibase("com/ilmani/dream/wildlives/database/wildlife.xml", new ClassLoaderResourceAccessor(), database);
		liquibase.update("wildlife-test");
		
	}
	
	@Test
	public void test(){
		
	}
	
	@After
	public void closeDatabase() throws LiquibaseException{
		liquibase.dropAll();
		entityManager.clear();
		entityManager.close();
	}

}
