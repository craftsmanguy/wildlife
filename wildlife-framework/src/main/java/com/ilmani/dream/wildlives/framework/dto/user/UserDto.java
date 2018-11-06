package com.ilmani.dream.wildlives.framework.dto.user;

import java.util.ArrayList;
import java.util.List;

import com.ilmani.dream.wildlives.framework.dto.pet.PetDto;

public class UserDto extends AbstractUserDto {

	private static final long serialVersionUID = -8951795870529852049L;

	private List<PetDto> pets = new ArrayList<PetDto>();

	public UserDto() {
		super();
	}

	public UserDto(String pseudonym, String email, String country, String postalCode, String city) {
		super();
		this.pseudonym = pseudonym;
		this.email = email;
		this.country = country;
		this.postalCode = postalCode;
		this.city = city;
	}

	public List<PetDto> getPets() {
		return pets;
	}

	public void setPets(List<PetDto> pets) {
		this.pets = pets;
	}

}
