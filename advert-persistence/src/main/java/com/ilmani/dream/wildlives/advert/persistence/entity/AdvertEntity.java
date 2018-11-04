package com.ilmani.dream.wildlives.advert.persistence.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "advert")
public class AdvertEntity {

	@Id
	@Column(columnDefinition = "uuid", name = "id", updatable = false, nullable = false)
	private UUID id;

	@Column(name = "functional_id", updatable = false, nullable = false)
	private String functionalIdentifier;

	@Column(name = "insertion_date",  insertable = false, updatable = false)
	private Date insertionDate;

	@Column(name = "start_date")
	private Date startDate;

	@Column(name = "end_date")
	private Date endDate;

	@Column(name = "title")
	private String title;

	@Column(name = "description")
	private String description;

	@Column(name = "state")
	private String state;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "advert_join_format", joinColumns = { @JoinColumn(name = "advert_id") }, inverseJoinColumns = {
			@JoinColumn(name = "format_id") })
	private Set<FormatEntity> formatsEn = new HashSet<FormatEntity>();

	public AdvertEntity() {
		super();
	}
	
	public AdvertEntity(String functionalIdentifier, Date startDate, Date endDate,
			 String title, String description, String state) {
		super();
		this.functionalIdentifier = functionalIdentifier;
		this.startDate = startDate;
		this.endDate = endDate;
		this.title = title;
		this.description = description;
		this.state = state;
	}

	public AdvertEntity(UUID id, String functionalIdentifier, Date insertionDate, Date startDate, Date endDate,
			 String title, String description, String state) {
		super();
		this.id = id;
		this.functionalIdentifier = functionalIdentifier;
		this.insertionDate = insertionDate;
		this.startDate = startDate;
		this.endDate = endDate;
		this.title = title;
		this.description = description;
		this.state = state;
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

	public Date getInsertionDate() {
		return insertionDate;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Set<FormatEntity> getFormatsEn() {
		return formatsEn;
	}

	public void setFormatsEn(Set<FormatEntity> formats) {
		this.formatsEn = formats;
	}

}
