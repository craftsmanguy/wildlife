package com.ilmani.dream.wildlives.advert.persistence.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "participant")
public class UserForAdvertEntity {

	@Id
	@Column(columnDefinition = "uuid", name = "id", updatable = false, nullable = false)
	private UUID id;

	@Column(name = "pseudonym", nullable = false, updatable = false)
	private String pseudonym;


	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getPseudonym() {
		return pseudonym;
	}

	public void setPseudonym(String pseudonym) {
		this.pseudonym = pseudonym;
	}


}
