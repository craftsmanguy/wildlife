package com.ilmani.dream.wildlives.user.business.facade;

import javax.inject.Inject;

import com.ilmani.dream.wildlives.framework.dto.user.AbstractUserDto;
import com.ilmani.dream.wildlives.user.business.port.UserBusinessDomain;

public class UserBusinessFacade {

	@Inject
	private UserBusinessDomain userDomain;

	public void saveUser(AbstractUserDto user) {
		userDomain.saveUser(user);
	}

	public boolean isEmailExists(String email) {
		return userDomain.isEmailExists(email);
	}

	public boolean isPseudonymExists(String pseudonym) {
		return userDomain.isPseudonymExists(pseudonym);
	}

	public AbstractUserDto findProfilByIdentifier(String pseudonym){
		return userDomain.findProfilByIdentifier(pseudonym);
	}

}
