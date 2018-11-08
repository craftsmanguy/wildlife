package com.ilmani.dream.wildlives.framework.exceptions;

import javax.ws.rs.core.Response.Status;

public abstract class AbstractException extends Exception {

	private static final long serialVersionUID = -2723453987900183977L;

	protected String error;
	
	protected final Status status;

	public AbstractException(Status status, String error) {
		this.status = status;
		this.error = error;
	}
	
	public AbstractException(Status status) {
		this.status = status;
	}
	
	
	public Status getStatus() {
        return status;
    }

	public String getError() {
		return error;
	}

}
