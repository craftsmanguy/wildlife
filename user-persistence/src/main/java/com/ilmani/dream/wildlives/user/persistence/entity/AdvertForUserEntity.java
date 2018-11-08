package com.ilmani.dream.wildlives.user.persistence.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "advert")
public class AdvertForUserEntity {

	@Id
	@Column(columnDefinition = "uuid", name = "id", updatable = false, nullable = false)
	private UUID id;

	@Column(name = "functional_id", updatable = false, nullable = false)
	private String functionalIdentifier;

	@Column(name = "title")
	private String title;

	@ManyToOne
	@JoinColumn(name = "participant_id")
	private UserEntity userEn;

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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public UserEntity getUserEn() {
		return userEn;
	}

	public void setUserEn(UserEntity userEn) {
		this.userEn = userEn;
	}

}
