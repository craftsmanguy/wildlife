package com.ilmani.dream.wildlives.framework.dto.auth;

public class AuthentifyPersonDto {
	
	private String id;
	
	private String username;
	
	private String issuer;

	public AuthentifyPersonDto(String id, String username, String issuer) {
		super();
		this.id = id;
		this.username = username;
		this.issuer = issuer;
	}

	public String getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getIssuer() {
		return issuer;
	}

	
	
	

}
