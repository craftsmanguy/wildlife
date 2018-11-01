package com.ilmani.dream.wildlives.presenter.rest.administration;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.ilmani.dream.wildlives.framework.exceptions.AuthenticationException;
import com.ilmani.dream.wildlives.framework.exceptions.EntityAlreadyExist;
import com.ilmani.dream.wildlives.framework.exceptions.EntityNotFoundException;
import com.ilmani.dream.wildlives.framework.exceptions.RestClientException;
import com.ilmani.dream.wildlives.framework.rest.responseheader.ResponseHeaderBuilder;

@Provider
public class ExceptionHandler implements ExceptionMapper<Exception> {

	@Inject
	protected ResponseHeaderBuilder responseHeader;

	@Override
	public Response toResponse(Exception throwable) {
		if (throwable instanceof AuthenticationException) {
			AuthenticationException exception = (AuthenticationException) throwable;
			return responseHeader.responseBuilder(exception.getStatus()).entity(exception.getError()).build();

		} else if (throwable instanceof EntityAlreadyExist) {
			EntityAlreadyExist exception = (EntityAlreadyExist) throwable;
			return responseHeader.responseBuilder(exception.getStatus()).entity(exception.getError()).build();

		} else if (throwable instanceof EntityNotFoundException) {
			EntityNotFoundException exception = (EntityNotFoundException) throwable;
			return responseHeader.responseBuilder(exception.getStatus()).entity(exception.getError()).build();

		} else {
			RestClientException exception = new RestClientException();
			return responseHeader.responseBuilder(exception.getStatus()).entity(exception.getMessage()).build();

		}
	}

}
