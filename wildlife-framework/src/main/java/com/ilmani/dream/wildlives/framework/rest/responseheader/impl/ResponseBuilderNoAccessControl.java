package com.ilmani.dream.wildlives.framework.rest.responseheader.impl;

import javax.enterprise.inject.Alternative;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

import com.ilmani.dream.wildlives.framework.rest.responseheader.ResponseHeaderBuilder;

@Alternative
public class ResponseBuilderNoAccessControl implements ResponseHeaderBuilder {

	@Override
	public ResponseBuilder responseBuilder(String method) {
		return responseBuilder(method, Response.Status.OK);
	}

	@Override
	public ResponseBuilder responseBuilder(String method, Status status) {
		ResponseBuilder res = Response.status(status);
		res.header("Access-Control-Allow-Origin", "*");
		res.header("Access-Control-Allow-Methods", method);
		res.header("Access-Control-Max-Age", "3600");
		res.header("Access-Control-Expose-Headers", "X-ACCOUNT-UNLOCKED");
		res.header("Access-Control-Allow-Headers", "Content-Type, Access-Control-Allow-Headers, Authorization,"
				+ " X-Requested-With, X-UserId, X-DeviceId");
		res.header("Access-Control-Allow-Credentials", true);
		return res;
	}

	@Override
	public ResponseBuilder responseBuilder(Status status) {
		ResponseBuilder res = responseBuilder("GET, POST, PUT, DELETE, OPTIONS, HEAD", status);
		return res;
	}

}
