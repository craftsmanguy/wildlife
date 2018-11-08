package com.ilmani.dream.wildlives.user.acceptance;

import javax.transaction.UserTransaction;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.ilmani.dream.wildlives.framework.dto.user.AbstractUserDto;
import com.ilmani.dream.wildlives.framework.dto.user.UserInscriptionDto;
import com.ilmani.dream.wildlives.framework.exceptions.MalformedFieldException;
import com.ilmani.dream.wildlives.framework.exceptions.RequiredFieldException;
import com.ilmani.dream.wildlives.user.business.api.impl.UserBusinessManager;
import com.ilmani.dream.wildlives.user.business.facade.UserBusinessFacade;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ UserBusinessManager.class })
public class CrudBusinessUserTest {

	@InjectMocks
	private UserBusinessManager userMngr;

	@Mock
	private UserBusinessFacade userFacade;

	@Mock
	private UserTransaction utx;

	@Test
	public void insertionOfNewUserIsPossible() throws Exception {
		AbstractUserDto userToSave = new UserInscriptionDto("pseudonym", "email@email.fr", "Passw$ord1", "Passw$ord1", "France",
				"78210", "Paris");
		userMngr.saveUser(userToSave);
	}

	@Test(expected = RequiredFieldException.class)
	public void testGenerateExceptionBecauseAttributePetIsNull() throws Exception {
		userMngr.saveUser(new UserInscriptionDto());
	}

	@Test(expected = RequiredFieldException.class)
	public void testGenerateExceptionBecausePaswordAndConfirmationNotSame() throws Exception {
		AbstractUserDto userToSave = new UserInscriptionDto("pseudonym", "email@email", "Passwor$d1", "Pas*sword2", "France",
				"78210", "Paris");
		userMngr.saveUser(userToSave);
	}

	@Test(expected = MalformedFieldException.class)
	public void testGenerateExceptionBecausePasswordIsMalformed() throws Exception {
		AbstractUserDto userToSave = new UserInscriptionDto("pseudonym", "email@email", "password1", "password", "France",
				"78210", "Paris");
		userMngr.saveUser(userToSave);
	}

	@Test(expected = MalformedFieldException.class)
	public void testGenerateExceptionBecauseEmailIsMalformed() throws Exception {
		AbstractUserDto userToSave = new UserInscriptionDto("pseudonym", "email@email.f.", "Pass!word1", "Pass!word1", "France",
				"78210", "Paris");
		userMngr.saveUser(userToSave);
	}
	

}
