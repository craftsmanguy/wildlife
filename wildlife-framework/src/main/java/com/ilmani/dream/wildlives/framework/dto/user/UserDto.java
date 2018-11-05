package com.ilmani.dream.wildlives.framework.dto.user;

public class UserDto extends AbstractUserDto {

	private static final long serialVersionUID = -8951795870529852049L;

	public UserDto(String pseudonym, String email, String country, String postalCode, String city) {
		super();
		this.pseudonym = pseudonym;
		this.email = email;
		this.country = country;
		this.postalCode = postalCode;
		this.city = city;
	}

}
