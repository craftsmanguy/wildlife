package com.ilmani.dream.wildlives.user.persistence.adapter;

import com.ilmani.dream.wildlives.framework.dto.auth.ConnectionFieldsDto;
import com.ilmani.dream.wildlives.security.port.GatewayAdministratorDomain;

public class GatewayAdministratorDomainImpl implements GatewayAdministratorDomain {

	@Override
	public String findProfilByEmail(ConnectionFieldsDto fields) {
		return "admin";
	}

}
