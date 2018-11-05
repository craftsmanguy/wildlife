package com.ilmani.dream.wildlives.presenter.rest.business;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.ilmani.dream.wildlives.presenter.rest.business.advert.v1.AdvertBusinessResource;
import com.ilmani.dream.wildlives.presenter.rest.business.pet.v1.PetBusinessService;
import com.ilmani.dream.wildlives.presenter.rest.business.security.v1.AuthenticationRequestUserFilter;
import com.ilmani.dream.wildlives.presenter.rest.business.security.v1.AuthenticationUserService;
import com.ilmani.dream.wildlives.presenter.rest.business.user.v1.UserBusinessService;


@ApplicationPath("/")
public class ApplicationConfig  extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> resources = new HashSet<>();
		
		resources.add(ExceptionHandler.class);

		resources.add(AuthenticationRequestUserFilter.class);
		resources.add(AuthenticationUserService.class);
		resources.add(AdvertBusinessResource.class);
		resources.add(PetBusinessService.class);
		resources.add(UserBusinessService.class);

		return resources;
	}

	@Override
	public Set<Object> getSingletons() {
		Set<Object> singletons = new HashSet<>();
		return singletons;
	}

}
