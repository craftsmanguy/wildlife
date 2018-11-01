
package com.ilmani.dream.wildlives.framework.rest.responseheader;

import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

public interface ResponseHeaderBuilder {

	public ResponseBuilder responseBuilder(String method);

	public ResponseBuilder responseBuilder(String method, Status status);

	public ResponseBuilder responseBuilder(Status status);

}
