package com.ilmani.dream.wildlives.presenter.rest.business.user.v1;

import javax.ejb.EJB;
import javax.ws.rs.ext.Provider;

import com.ilmani.dream.wildlives.framework.version.Number;
import com.ilmani.dream.wildlives.framework.version.Version;
import com.ilmani.dream.wildlives.user.business.api.UserBusinessLocal;

@Provider
@Version(Number.V1)
public class UserBusinessProvider {
	
	@EJB(name = "UserBusinessManager")
	UserBusinessLocal userLocal;

}
