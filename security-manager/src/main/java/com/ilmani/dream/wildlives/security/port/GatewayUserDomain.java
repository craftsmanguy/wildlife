package com.ilmani.dream.wildlives.security.port;

import com.ilmani.dream.wildlives.framework.dto.auth.ConnectionFieldsDto;

public interface GatewayUserDomain {

	public boolean isProfilExists(ConnectionFieldsDto fields);
	
	public String findPseudonymByEmail(ConnectionFieldsDto fields);

}
