package com.ilmani.dream.wildlives.presenter.rest.administration;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.ilmani.dream.wildlives.presenter.rest.administration.advert.v1.AdvertAdministrationResource;
import com.ilmani.dream.wildlives.presenter.rest.administration.pet.v1.PetAdministrationResource;
import com.ilmani.dream.wildlives.presenter.rest.administration.security.v1.AuthenticationAdministratorService;
import com.ilmani.dream.wildlives.presenter.rest.administration.user.v1.UserAdministrationResource;

@ApplicationPath("/")
public class ApplicationConfig extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> resources = new HashSet<>();
		
		resources.add(ExceptionHandler.class);

		resources.add(AuthenticationAdministratorService.class);
		
		resources.add(AdvertAdministrationResource.class);
		resources.add(PetAdministrationResource.class);
		resources.add(UserAdministrationResource.class);

		return resources;
	}

	@Override
	public Set<Object> getSingletons() {
		Set<Object> singletons = new HashSet<>();
		return singletons;
	}

}
