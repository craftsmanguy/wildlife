package com.ilmani.dream.wildlives.user.persistence.entity;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnTransformer;

@Entity
@Table(name = "participant")
public class UserEntity {

	@Id
	@Column(columnDefinition = "uuid", name = "id", updatable = false, nullable = false)
	private UUID id;

	@Column(name = "pseudonym", nullable = false, updatable = false)
	private String pseudonym;

	@Column(name = "insertion_date", insertable = false, updatable = false)
	private Date insertionDate;

	@Column(name = "email", nullable = false, updatable = false)
	private String email;

	@Column(name = "country")
	private String country;

	@Column(name = "postal_code")
	private String postalCode;

	@Column(name = "city")
	private String city;

	@ColumnTransformer(write = "crypt( " + " ?, " + "gen_salt('bf', 12))")
	@Column(name = "pass")
	private String pass;

	@OneToMany(mappedBy = "userEn", fetch = FetchType.LAZY)
	private List<PetForUserEntity> petsEn;

	public UserEntity() {
		super();
	}

	public UserEntity(String pseudonym, String email, String country, String postalCode, String city) {
		super();
		this.pseudonym = pseudonym;
		this.email = email;
		this.country = country;
		this.postalCode = postalCode;
		this.city = city;
	}

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

	public Date getInsertionDate() {
		return insertionDate;
	}

	public void setInsertionDate(Date insertionDate) {
		this.insertionDate = insertionDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public List<PetForUserEntity> getPetsEn() {
		return petsEn;
	}

	public void setPetsEn(List<PetForUserEntity> petsEn) {
		this.petsEn = petsEn;
	}

	

}
