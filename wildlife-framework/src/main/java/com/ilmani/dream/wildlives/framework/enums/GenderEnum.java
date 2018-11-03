package com.ilmani.dream.wildlives.framework.enums;

public enum GenderEnum {
	MALE("MALE"), FEMALE("FEMALE"), OHTER("OTHER");

	private String name;

	GenderEnum(String name) {
		this.name = name;
	}

	public String toString() {
		return name;
	}
}
