package com.ilmani.dream.wildlives.user.persistence.acceptance;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import com.ilmani.dream.wildlives.user.persistence.dao.UserDao;
import com.ilmani.dream.wildlives.user.persistence.entity.UserEntity;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ UserDaoTest.class })
public class UserDaoTest extends DataBaseCreationTest {

	@InjectMocks
	private UserDao userDao;

	@Mock
	private EntityManager em;
	
	
	@Before
	public void initializeEnvironmentTest() {
		initializeDataBase();
		Whitebox.setInternalState(userDao, "em", entityManager);
	}

	@Test
	public void getEffectiveProfilWhenImConnected() throws Exception {
		UserEntity expected = new UserEntity("Matthieu", "m@ya.fr", "France", "78210", "Paris");
		UserEntity result = userDao.findByPseudonym("Matthieu");
		assertEquals(expected.getEmail(), result.getEmail());

	}

}
