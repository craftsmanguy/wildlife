package com.ilmani.dream.wildlives.framework.exceptions;

import javax.ws.rs.core.Response.Status;

public class EntityAlreadyExistException extends AbstractException {

	private static final long serialVersionUID = 3124156647818883945L;

	public EntityAlreadyExistException(Status status, String error) {
		super(status, error);
	}

}
