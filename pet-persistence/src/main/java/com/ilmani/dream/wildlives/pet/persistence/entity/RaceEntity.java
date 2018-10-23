package com.ilmani.dream.wildlives.pet.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "race")
public class RaceEntity {

	@Id
	@Column(name="id", updatable=false, nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer technicalIdentifier;

	@NotNull
	@Column(name="name")
	private String name;

	@Column(name="scientist_name")
	private String scientistName;

	@Column(name="code")
	private String code;

	@NotNull
	@Column(name="specie")
	private String specie;

	@Column(name="specie_scientist_name")
	private String specieScientistName;

	@Column(name="specie_code")
	private String specieCode;

	@NotNull
	@Column(name="type")
	private String type;

	@Column(name="type_scientist_name")
	private String typeScientistName;

	@Column(name="type_code")
	private String typeCode;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getScientistName() {
		return scientistName;
	}

	public void setScientistName(String scientistName) {
		this.scientistName = scientistName;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getSpecie() {
		return specie;
	}

	public void setSpecie(String specie) {
		this.specie = specie;
	}

	public String getSpecieScientistName() {
		return specieScientistName;
	}

	public void setSpecieScientistName(String specieScientistName) {
		this.specieScientistName = specieScientistName;
	}

	public String getSpecieCode() {
		return specieCode;
	}

	public void setSpecieCode(String specieCode) {
		this.specieCode = specieCode;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTypeScientistName() {
		return typeScientistName;
	}

	public void setTypeScientistName(String typeScientistName) {
		this.typeScientistName = typeScientistName;
	}

	public String getTypeCode() {
		return typeCode;
	}	

}
