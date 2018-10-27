package com.ilmani.dream.wildlives.pet.persistence.acceptance.query;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import liquibase.Liquibase;
import liquibase.exception.LiquibaseException;

public class DataBaseCreationTest {

	private static final String UNIT_NAME = "petPuTest";

	protected static EntityManager entityManager;

	protected static Liquibase liquibase;

	@BeforeClass
	public static void initializeDatabase() throws Exception {
		entityManager = Persistence.createEntityManagerFactory(UNIT_NAME).createEntityManager();
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
