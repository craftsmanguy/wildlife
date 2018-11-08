package com.ilmani.dream.wildlives.pet.persistence.entity;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;;

@Entity
@Table(name = "pet")
public class PetEntity {

	@Id
	@Column(columnDefinition = "uuid", name = "id", updatable = false, nullable = false)
	private UUID id;

	@Column(name = "functional_id", updatable = false, nullable = false)
	private String functionalIdentifier;

	@Column(name = "insertion_date", insertable = false, updatable = false)
	private Date insertionDate;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@Column(name = "is_lof")
	private boolean isLof;

	@Column(name = "gender")
	private String gender;

	@Column(name = "birth")
	private Integer birth;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "race_id")
	private RaceEntity raceEn;
	
	@ManyToOne
	@JoinColumn(name = "participant_id")
	private UserForPetEntity userEn;

	public PetEntity() {
		super();
	}

	public PetEntity(String functionalIdentifier, String name, String description, boolean isLof, String gender,
			Integer birth) {
		super();
		this.functionalIdentifier = functionalIdentifier;
		this.name = name;
		this.description = description;
		this.isLof = isLof;
		this.gender = gender;
		this.birth = birth;
	}

	public PetEntity(UUID id, String functionalIdentifier, String name, String description, boolean isLof,
			String gender, Integer birth) {
		super();
		this.id = id;
		this.functionalIdentifier = functionalIdentifier;
		this.name = name;
		this.description = description;
		this.isLof = isLof;
		this.gender = gender;
		this.birth = birth;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getFunctionalIdentifier() {
		return functionalIdentifier;
	}
	
	public void setFunctionalIdentifier(String functionalIdentifier) {
		this.functionalIdentifier =  functionalIdentifier;
	}

	public Date getInsertionDate() {
		return insertionDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isLof() {
		return isLof;
	}

	public void setLof(boolean isLof) {
		this.isLof = isLof;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getBirth() {
		return birth;
	}

	public void setBirth(Integer birth) {
		this.birth = birth;
	}

	public RaceEntity getRaceEn() {
		return this.raceEn;
	}

	public void setRaceEn(RaceEntity raceEn) {
		this.raceEn = raceEn;
	}
	
	public UserForPetEntity getUserEn() {
		return userEn;
	}

	public void setUserEn(UserForPetEntity userEn) {
		this.userEn = userEn;
	}
	

}
