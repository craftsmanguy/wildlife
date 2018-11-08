package com.ilmani.dream.wildlives.advert.administration.api.impl;

public enum FormatEnum {
	REQUEST("REQUEST"), OFFER("OFFER");

	private String name;

	FormatEnum(String name) {
		this.name = name;
	}

	public String toString() {
		return name;
	}
}
