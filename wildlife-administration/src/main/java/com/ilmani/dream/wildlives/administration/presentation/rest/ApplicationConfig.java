package com.ilmani.dream.wildlives.administration.presentation.rest;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.ilmani.dream.wildlives.administration.presentation.rest.ressource.pet.v1.PetAdministrationRessource;

@ApplicationPath("/")
public class ApplicationConfig extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> resources = new HashSet<>();

		resources.add(PetAdministrationRessource.class);

		return resources;
	}

	@Override
	public Set<Object> getSingletons() {
		Set<Object> singletons = new HashSet<>();
		return singletons;
	}

}
