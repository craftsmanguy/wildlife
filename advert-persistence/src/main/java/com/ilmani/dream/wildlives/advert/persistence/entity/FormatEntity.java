package com.ilmani.dream.wildlives.advert.persistence.entity;

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
@Table(name = "format", uniqueConstraints = @UniqueConstraint(columnNames = { "name", "feature" }))
public class FormatEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "format_generator")
	@SequenceGenerator(name = "format_generator", sequenceName = "FORMAT_SEQ_ID", allocationSize = 1)
	@Column(name = "id", updatable = false, nullable = false)
	protected int technicalIdentifier;

	@NotNull
	@Column(name = "name")
	protected String name;

	@NotNull
	@Column(name = "code")
	protected String code;

	@NotNull
	@Column(name = "feature")
	protected String feature;

	@Column(name = "is_active")
	protected boolean isActive;
	
	public FormatEntity() {
		super();
	}
	
	public FormatEntity(String code, boolean isActive) {
		super();
		this.code = code;
		this.isActive = isActive;
	}
	
	public FormatEntity(String name, String feature, boolean isActive) {
		super();
		this.name = name;
		this.feature = feature;
		this.isActive = isActive;
	}
	
	public FormatEntity(String name, String code, String feature, boolean isActive) {
		super();
		this.name = name;
		this.code = code;
		this.feature = feature;
		this.isActive = isActive;
	}

	public FormatEntity(int technicalIdentifier, String name, String code, String feature, boolean isActive) {
		super();
		this.technicalIdentifier = technicalIdentifier;
		this.name = name;
		this.code = code;
		this.feature = feature;
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getFeature() {
		return feature;
	}

	public void setFeature(String feature) {
		this.feature = feature;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	
	
}
