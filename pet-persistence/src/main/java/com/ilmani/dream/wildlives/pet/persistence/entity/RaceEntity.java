package com.ilmani.dream.wildlives.pet.persistence.entity;

public class RaceEntity {

	private Integer technicalIdentifier;

	public String name;

	public String scientistName;

	public String code;

	public String specie;

	public String specieScientistName;

	public String specieCode;

	public String type;

	public String typeScientistName;

	public String typeCode;

	public Integer getTechnicalIdentifier() {
		return technicalIdentifier;
	}

	public RaceEntity() {

	}

	public RaceEntity(String name, String scientistName, String code, String specie, String specieScientistName,
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

	public RaceEntity(Integer technicalIdentifier, String name, String scientistName, String code, String specie,
			String specieScientistName, String specieCode, String type, String typeScientistName, String typeCode) {
		this.technicalIdentifier = technicalIdentifier;
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
