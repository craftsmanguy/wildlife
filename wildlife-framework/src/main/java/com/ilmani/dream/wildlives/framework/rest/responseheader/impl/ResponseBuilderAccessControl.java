
package com.ilmani.dream.wildlives.framework.rest.responseheader.impl;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;
import com.ilmani.dream.wildlives.framework.rest.responseheader.ResponseHeaderBuilder;

public class ResponseBuilderAccessControl implements ResponseHeaderBuilder {

	public ResponseBuilder responseBuilder(String method) {
		return responseBuilder(method, Response.Status.OK);
	}

	public ResponseBuilder responseBuilder(String method, Status status) {
		ResponseBuilder response = Response.status(status);
		return response;
	}

	public ResponseBuilder responseBuilder(Status status) {
		ResponseBuilder response = responseBuilder(null, status);
		return response;
	}

}
