package com.ilmani.dream.wildlives.security.port;

import com.ilmani.dream.wildlives.framework.dto.auth.ConnectionFieldsDto;

public interface GatewayAdministratorDomain {

	public String findProfilByEmail(ConnectionFieldsDto fields);

}
