package com.ilmani.dream.wildlives.user.business.port;

import com.ilmani.dream.wildlives.framework.dto.user.UserDto;

public interface UserBusinessDomain {

	public void saveUser(UserDto user);

	public boolean isEmailExists(String email);

	public boolean isPseudonymExists(String pseudonym);

}
