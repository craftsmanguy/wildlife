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
	@SequenceGenerator(name = "race_generator", sequenceName = "RACE_SEQ_ID", allocationSize = 1)
	@Column(name = "id", updatable = false, nullable = false)
	protected int technicalIdentifier;

	@NotNull
	@Column(name = "name")
	protected String name;

	@Column(name = "scientist_name")
	protected String scientistName;

	@Column(name = "code")
	protected String code;

	@NotNull
	@Column(name = "specie")
	protected String specie;

	@NotNull
	@Column(name = "clan")
	protected String clan;

	@Column(name = "is_active")
	protected boolean isActive;

	public RaceEntity() {

	}

	public RaceEntity(String code, boolean isActive) {
		this.code = code;
		this.isActive = isActive;
	}

	public RaceEntity(String name, String code, String specie, String clan, boolean isActive) {
		this.name = name;
		this.code = code;
		this.specie = specie;
		this.clan = clan;
		this.isActive = isActive;
	}

	public RaceEntity(int technicalIdentifier, String name, String scientistName, String code, String specie,
			String clan, boolean isActive) {
		this.technicalIdentifier = technicalIdentifier;
		this.name = name;
		this.scientistName = scientistName;
		this.code = code;
		this.specie = specie;
		this.clan = clan;
		this.isActive = isActive;
	}

	public int getTechnicalIdentifier() {
		return technicalIdentifier;
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
