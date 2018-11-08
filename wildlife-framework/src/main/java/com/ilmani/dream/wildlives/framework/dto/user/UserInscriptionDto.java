package com.ilmani.dream.wildlives.framework.dto.user;

public class UserInscriptionDto extends AbstractUserDto {

	private static final long serialVersionUID = -2462849373611428172L;

	private String password;

	private String confirmPassword;

	public UserInscriptionDto() {
		super();
	}

	public UserInscriptionDto(String pseudonym, String email, String password, String confirmPassword, String country,
			String postalCode, String city) {
		this.pseudonym = pseudonym;
		this.email = email;
		this.country = country;
		this.postalCode = postalCode;
		this.city = city;
		this.password = password;
		this.confirmPassword = confirmPassword;
	}

	public UserInscriptionDto(String password, String confirmPassword) {
		super();
		this.password = password;
		this.confirmPassword = confirmPassword;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

}
