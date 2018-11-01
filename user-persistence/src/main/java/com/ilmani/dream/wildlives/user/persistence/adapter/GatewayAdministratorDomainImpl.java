package com.ilmani.dream.wildlives.user.persistence.adapter;

import com.ilmani.dream.wildlives.framework.dto.auth.ConnectionFieldsDto;
import com.ilmani.dream.wildlives.framework.exceptions.EntityNotFoundException;
import com.ilmani.dream.wildlives.security.port.GatewayAdministratorDomain;

public class GatewayAdministratorDomainImpl implements GatewayAdministratorDomain {

	@Override
	public String findProfilByLoginAndPassword(ConnectionFieldsDto fields) throws EntityNotFoundException {
		// TODO Auto-generated method stub
		return "admin";
	}

}
