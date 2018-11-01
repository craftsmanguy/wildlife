package com.ilmani.dream.wildlives.framework.error;

import java.io.Serializable;

public class ErrorEntity implements Serializable {

	private static final long serialVersionUID = 989445070052732905L;

	public enum ErrorKey {

		TECHNICAL_ERROR("TECHNICAL_ERROR"), 
		TOKEN_EXPIRED("TOKEN_EXPIRED"),
		TOKEN_NOT_FOUND("TOKEN_NOT_FOUND"), 
		TOKEN_IS_WRONG("TOKEN_IS_WRONG"), 
		USER_INACTIF("USER_INACTIF"), 
		LOGIN_NOT_FOUND("LOGIN_NOT_FOUND"), 
		INVALID_USER_PASSWORD("INVALID_USER_PASSWORD"), 
		ELEMENT_NOT_FOUND("ELEMENT_NOT_FOUND"), 
		UNAUTHORIZED_ACTION("UNAUTHORIZED_ACTION"), 
		RESOURCE_NOT_FOUND("RESOURCE_NOT_FOUND"), 
		FIELD_IS_MISSING("FIELD_IS_MISSING"),
		RESOURCE_ALREADY_EXIST("RESOURCE_ALREADY_EXIST"), 
		ACCESS_LOCKED("ACCESS_LOCKED"); 
		
		
		private String value;

		public String getValue() {
			return value;
		}

		ErrorKey(String value) {
			this.value = value;
		}
	}

}
