package com.ilmani.dream.wildlives.framework.exceptions;

import javax.ws.rs.core.Response.Status;

public class AuthenticationException extends ExceptionAbstract {

	public AuthenticationException(Status status, String error) {
		super(status, error);
	}

	private static final long serialVersionUID = -3304927153089051656L;

}
