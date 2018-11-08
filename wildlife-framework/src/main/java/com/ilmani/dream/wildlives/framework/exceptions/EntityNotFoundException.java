package com.ilmani.dream.wildlives.framework.exceptions;

import javax.ws.rs.core.Response.Status;

public class EntityNotFoundException extends AbstractException {

	private static final long serialVersionUID = -2505175314663703222L;

	public EntityNotFoundException(Status status, String error) {
		super(status, error);
	}

}
