package com.ilmani.dream.wildlives.presenter.rest.business;

import javax.inject.Inject;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.ilmani.dream.wildlives.framework.exceptions.AuthenticationException;
import com.ilmani.dream.wildlives.framework.exceptions.EntityAlreadyExistException;
import com.ilmani.dream.wildlives.framework.exceptions.EntityNotFoundException;
import com.ilmani.dream.wildlives.framework.exceptions.RequiredFieldException;
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
			return responseHeader.responseBuilder(exception.getStatus()).header("Reason", exception.getError()).build();

		} else if (throwable instanceof EntityAlreadyExistException) {
			EntityAlreadyExistException exception = (EntityAlreadyExistException) throwable;
			return responseHeader.responseBuilder(exception.getStatus()).header("Reason", exception.getError()).build();

		} else if (throwable instanceof EntityNotFoundException) {
			EntityNotFoundException exception = (EntityNotFoundException) throwable;
			return responseHeader.responseBuilder(exception.getStatus()).header("Reason", exception.getError()).build();

		} else if (throwable instanceof RequiredFieldException) {
			RequiredFieldException exception = (RequiredFieldException) throwable;
			return responseHeader.responseBuilder(exception.getStatus()).header("Reason", exception.getError()).build();

		} else if (throwable instanceof JsonMappingException) {
			return responseHeader.responseBuilder(Status.BAD_REQUEST).build();
			
		} else if (throwable instanceof WebApplicationException) {
			WebApplicationException exception = (WebApplicationException) throwable;
			return exception.getResponse();

		} else {
			RestClientException exception = new RestClientException();
			return responseHeader.responseBuilder(exception.getStatus()).entity(exception.getMessage()).build();
		}
		
	}

}
