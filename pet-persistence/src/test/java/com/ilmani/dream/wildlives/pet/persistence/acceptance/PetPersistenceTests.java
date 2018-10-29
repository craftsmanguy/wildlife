package com.ilmani.dream.wildlives.pet.persistence.acceptance;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.ParallelComputer;
import org.junit.runner.JUnitCore;

import com.ilmani.dream.wildlives.pet.persistence.acceptance.mapper.PetMapperTest;
import com.ilmani.dream.wildlives.pet.persistence.acceptance.mapper.RaceMapperTest;
import com.ilmani.dream.wildlives.pet.persistence.acceptance.query.PetDaoTest;
import com.ilmani.dream.wildlives.pet.persistence.acceptance.query.RaceDaoTest;

//@RunWith(Suite.class)
//@SuiteClasses({ RaceDaoTest.class, PetDaoTest.class, RaceMapperTest.class, PetMapperTest.class })
public class PetPersistenceTests {

	@Ignore
	 @Test
	 public void test() {
	 Class[] cls = { RaceDaoTest.class, PetDaoTest.class,
	 RaceMapperTest.class, PetMapperTest.class };
	
	 // Parallel among classes
	 JUnitCore.runClasses(ParallelComputer.classes(), cls);
	//
	// System.out.println("----------------------------");
	//
	// // Parallel among methods in a class
	// JUnitCore.runClasses(ParallelComputer.methods(), cls);
	//
	// System.out.println("----------------------------");
	//
	// // Parallel all methods in all classes
	// JUnitCore.runClasses(new ParallelComputer(true, true), cls);
	 }

}
