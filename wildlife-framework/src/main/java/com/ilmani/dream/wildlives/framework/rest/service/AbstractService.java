/**
 * 
 */
package com.ilmani.dream.wildlives.framework.rest.service;

import javax.inject.Inject;
import javax.ws.rs.HttpMethod;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.ilmani.dream.wildlives.framework.rest.responseheader.ResponseHeaderBuilder;

public abstract class AbstractService {

	@Inject
	protected ResponseHeaderBuilder responseHeader;

	@OPTIONS
	@Path("{var:.*}")
	public Response options() {
		return responseHeader.responseBuilder(HttpMethod.OPTIONS).build();
	}
}
