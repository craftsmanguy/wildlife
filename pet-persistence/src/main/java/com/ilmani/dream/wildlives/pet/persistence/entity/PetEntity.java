package com.ilmani.dream.wildlives.pet.persistence.entity;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

public class PetEntity {
	
	
	public UUID technicalIdentifier;
	
	public String name;

	public Date birthday;

	public String description;

	public boolean isLof;

	public String sexe;

	public Integer age;

	public Set<RaceEntity> species;

}
