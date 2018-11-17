package com.ilmani.dream.wildlives.presenter.rest.business.security.v1;

import static javax.ws.rs.core.Response.Status.FORBIDDEN;

import java.io.IOException;

import javax.annotation.Priority;
import javax.ejb.EJB;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;

import com.ilmani.dream.wildlives.framework.error.ErrorEntity;
import com.ilmani.dream.wildlives.framework.helper.TokenHelper;
import com.ilmani.dream.wildlives.framework.rest.service.AbstractService;
import com.ilmani.dream.wildlives.framework.security.AuthenticationGateway;
import com.ilmani.dream.wildlives.security.api.GatewayLocal;

@Provider
@AuthenticationGateway
@Priority(Priorities.AUTHENTICATION)
public class AuthenticationRequestUserFilter extends AbstractService implements ContainerRequestFilter {

	@EJB(name = "GatewayManager")
	GatewayLocal gateway;

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		String token = TokenHelper.extractToken(requestContext);
		try {
			gateway.checkToken(token, "USER");
		} catch (Exception e) {
			requestContext.abortWith(responseHeader.responseBuilder(requestContext.getMethod(), FORBIDDEN)
					.header("Reason", ErrorEntity.ErrorKey.TOKEN_NOT_FOUND.getValue()).build());
		}
	}

}
