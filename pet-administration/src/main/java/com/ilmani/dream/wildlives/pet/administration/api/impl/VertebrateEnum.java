package com.ilmani.dream.wildlives.pet.administration.api.impl;

public enum VertebrateEnum {
	MAMMAL("MAMMAL"), BIRD("BIRD"), FISH("FISH"), REPTILE("REPTILE"), AMPHIBIAN("AMPHIBIAN");

	private String name;

	VertebrateEnum(String name) {
		this.name = name;
	}

	public String toString() {
		return name;
	}
}
