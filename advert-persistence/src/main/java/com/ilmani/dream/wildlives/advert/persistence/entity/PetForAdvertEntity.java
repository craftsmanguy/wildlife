package com.ilmani.dream.wildlives.advert.persistence.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;;

@Entity
@Table(name = "pet")
public class PetForAdvertEntity {

	@Id
	@Column(columnDefinition = "uuid", name = "id", updatable = false, nullable = false)
	private UUID id;

	@Column(name = "functional_id", updatable = false, nullable = false)
	private String functionalIdentifier;

	@Column(name = "name")
	private String name;

	public PetForAdvertEntity() {
		super();
	}

	public PetForAdvertEntity(String functionalIdentifier, String name) {
		super();
		this.functionalIdentifier = functionalIdentifier;
		this.name = name;
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
		this.functionalIdentifier = functionalIdentifier;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
