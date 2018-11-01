package com.ilmani.dream.wildlives.presenter.rest.administration.security.v1;

import javax.ejb.EJB;
import javax.ws.rs.ext.Provider;

import com.ilmani.dream.wildlives.framework.dto.auth.ConnectionFieldsDto;
import com.ilmani.dream.wildlives.framework.exceptions.AuthenticationException;
import com.ilmani.dream.wildlives.framework.exceptions.RestClientException;
import com.ilmani.dream.wildlives.security.api.GatewayLocal;

@Provider
public class AuthenticationAdministratorProvider {

	@EJB(name = "GatewayManager")
	GatewayLocal gateway;

	public String authenticate(ConnectionFieldsDto fields, String issuer)
			throws AuthenticationException, RestClientException {
		return gateway.authenticate(fields, "ADMIN", issuer);
	}

}
