package com.ilmani.dream.wildlives.administration.presentation.rest.provider.v1;

import java.util.Set;

import javax.ejb.EJB;
import javax.ws.rs.ext.Provider;

import com.ilmani.dream.wildlives.framework.dto.pet.RaceDto;
import com.ilmani.dream.wildlives.framework.version.Number;
import com.ilmani.dream.wildlives.framework.version.Version;
import com.ilmani.dream.wildlives.pet.administration.api.PetAdministrationLocal;

@Provider
@Version(Number.V1)
public class PetAdministrationProvider {

	@EJB(name = "PetAdministrationManager")
	PetAdministrationLocal petLocal;

	public Set<RaceDto> searchRacesByIdenfier(RaceDto race) {
		return petLocal.searchRacesByIdenfier(race);
	}

}
