package com.ilmani.dream.wildlives.user.persistence.adapter;

import javax.inject.Inject;

import com.ilmani.dream.wildlives.framework.dto.user.AbstractUserDto;
import com.ilmani.dream.wildlives.user.business.port.UserBusinessDomain;
import com.ilmani.dream.wildlives.user.persistence.dao.UserDao;
import com.ilmani.dream.wildlives.user.persistence.entity.UserEntity;
import com.ilmani.dream.wildlives.user.persistence.mapper.UserMapper;

public class UserBusinessDomainImpl implements UserBusinessDomain {
	
	@Inject
	UserDao userDao;

	@Override
	public void saveUser(AbstractUserDto user) {
		UserEntity userToInsert = UserMapper.transformUserDtoToUserEntity(user);
		userDao.saveUser(userToInsert);
	}

	@Override
	public boolean isEmailExists(String email) {
		return userDao.isEmailExists(email);
	}

	@Override
	public boolean isPseudonymExists(String pseudonym) {
		return userDao.isPseudonymExists(pseudonym);
	}

	@Override
	public AbstractUserDto findProfilByIdentifier(String pseudonym) {
		UserEntity userFromDb = userDao.findByPseudonym(pseudonym);
		return UserMapper.transformUserEntityToUserDto(userFromDb);
	}

}
