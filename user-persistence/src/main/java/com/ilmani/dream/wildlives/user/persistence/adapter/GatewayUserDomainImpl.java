package com.ilmani.dream.wildlives.user.persistence.adapter;

import javax.inject.Inject;

import com.ilmani.dream.wildlives.framework.dto.auth.ConnectionFieldsDto;
import com.ilmani.dream.wildlives.security.port.GatewayUserDomain;
import com.ilmani.dream.wildlives.user.persistence.dao.UserDao;

public class GatewayUserDomainImpl implements GatewayUserDomain {

	@Inject
	UserDao userDao;

	@Override
	public boolean isProfilExists(ConnectionFieldsDto fields) {
		return userDao.isProfilExists(fields.getUsername(), fields.getPassword());
	}

	@Override
	public String findPseudonymByEmail(ConnectionFieldsDto fields) {
		return userDao.findPseudonymByEmail(fields.getUsername());
	}

}
