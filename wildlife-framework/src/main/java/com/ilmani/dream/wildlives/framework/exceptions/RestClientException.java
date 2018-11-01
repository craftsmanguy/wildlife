package com.ilmani.dream.wildlives.framework.exceptions;

import javax.ws.rs.core.Response.Status;

public class RestClientException extends Exception {

	private static final long serialVersionUID = -4045983827917057914L;

	private final String message = "The server encountered an internal error or misconfiguration and was unable to complete your request";

	protected final Status status = Status.INTERNAL_SERVER_ERROR;

	public String getMessage() {
		return this.message;
	}

	public Status getStatus() {
		return this.status;
	}

}
