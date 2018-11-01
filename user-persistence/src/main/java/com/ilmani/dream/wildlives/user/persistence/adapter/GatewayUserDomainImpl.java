package com.ilmani.dream.wildlives.user.persistence.adapter;

import com.ilmani.dream.wildlives.framework.dto.auth.ConnectionFieldsDto;
import com.ilmani.dream.wildlives.framework.exceptions.EntityNotFoundException;
import com.ilmani.dream.wildlives.security.port.GatewayUserDomain;

public class GatewayUserDomainImpl implements GatewayUserDomain {

	@Override
	public String findProfilByLoginAndPassword(ConnectionFieldsDto fields) throws EntityNotFoundException {
		// TODO Auto-generated method stub
		return "user";
	}

}
