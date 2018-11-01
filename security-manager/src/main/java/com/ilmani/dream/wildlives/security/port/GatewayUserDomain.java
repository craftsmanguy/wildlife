package com.ilmani.dream.wildlives.security.port;

import com.ilmani.dream.wildlives.framework.dto.auth.ConnectionFieldsDto;
import com.ilmani.dream.wildlives.framework.exceptions.EntityNotFoundException;

public interface GatewayUserDomain {

	public String findProfilByLoginAndPassword(ConnectionFieldsDto fields) throws EntityNotFoundException;

}
