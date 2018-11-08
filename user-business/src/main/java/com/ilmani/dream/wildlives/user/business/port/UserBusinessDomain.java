package com.ilmani.dream.wildlives.user.business.port;

import com.ilmani.dream.wildlives.framework.dto.user.AbstractUserDto;

public interface UserBusinessDomain {

	public void saveUser(AbstractUserDto user);

	public boolean isEmailExists(String email);

	public boolean isPseudonymExists(String pseudonym);

	public AbstractUserDto findProfilByIdentifier(String pseudonym);

}
