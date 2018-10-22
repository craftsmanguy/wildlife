package com.ilmani.dream.wildlives.framework.dto.pet;

public class RaceDto {

	public String name;

	public String scientistName;

	public String code;

	public String specie;

	public String specieScientistName;

	public String specieCode;

	public String type;

	public String typeScientistName;

	public String typeCode;

	public RaceDto() {

	}

	public RaceDto(String name, String specie, String type) {
		this.name = name;
		this.specie = specie;
		this.type = type;
	}

	public RaceDto(String name, String scientistName, String code, String specie, String specieScientistName,
			String specieCode, String type, String typeScientistName, String typeCode) {
		this.name = name;
		this.scientistName = scientistName;
		this.code = code;
		this.specie = specie;
		this.specieScientistName = specieScientistName;
		this.specieCode = specieCode;
		this.type = type;
		this.typeScientistName = typeScientistName;
		this.typeCode = typeCode;
	}

}
