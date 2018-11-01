package com.ilmani.dream.wildlives.framework.exceptions;

import javax.ws.rs.core.Response.Status;

public class EntityAlreadyExist extends ExceptionAbstract {

	private static final long serialVersionUID = 3124156647818883945L;

	public EntityAlreadyExist(Status status, String error) {
		super(status, error);
	}

}
