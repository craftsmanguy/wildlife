package com.ilmani.dream.wildlives.pet.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "race", uniqueConstraints = @UniqueConstraint(columnNames = { "name", "specie", "clan" }))
public class RaceEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "race_generator")
	@SequenceGenerator(name = "race_generator", sequenceName = "SEQ_ID", allocationSize = 1)
	@Column(name = "id", updatable = false, nullable = false)
	private Integer technicalIdentifier;

	@NotNull
	@Column(name = "name")
	private String name;

	@Column(name = "scientist_name")
	private String scientistName;

	@Column(name = "code")
	private String code;

	@NotNull
	@Column(name = "specie")
	private String specie;

	@NotNull
	@Column(name = "clan")
	private String clan;

	@Column(name = "is_active")
	private boolean isActive;

	public RaceEntity() {

	}

	public RaceEntity(String name, String scientistName, String code, String specie, String clan, boolean isActive) {
		this.name = name;
		this.scientistName = scientistName;
		this.code = code;
		this.specie = specie;
		this.clan = clan;
		this.isActive = isActive;
	}

	public RaceEntity(Integer technicalIdentifier, String name, String scientistName, String code, String specie,
			String clan, boolean isActive) {
		this.technicalIdentifier = technicalIdentifier;
		this.name = name;
		this.scientistName = scientistName;
		this.code = code;
		this.specie = specie;
		this.clan = clan;
		this.isActive = isActive;
	}

	public Integer getTechnicalIdentifier() {
		return technicalIdentifier;
	}

	public void setTechnicalIdentifier(Integer technicalIdentifier) {
		this.technicalIdentifier = technicalIdentifier;
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

	public String getClan() {
		return clan;
	}

	public void setClan(String clan) {
		this.clan = clan;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

}
