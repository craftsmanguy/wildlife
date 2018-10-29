package com.ilmani.dream.wildlives.advert.persistence.entity;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Id;

public class AdvertEntity {
	
	@Id
	@Column(columnDefinition = "uuid", name = "id", updatable = false, nullable = false)
	private UUID id;

	@Column(name = "functional_id", updatable = false, nullable = false)
	private String functionalIdentifier;

	@Column(name = "insertion_date", updatable = false)
	private Date insertionDate;
	
	@Column(name = "start_date")
	private Date startDate;
	
	@Column(name = "end_date")
	private Date endDate;

	@Column(name = "is_active")
	private boolean isActive;

	@Column(name = "title")
	private String title;
	
	@Column(name = "description")
	private String description;

	@Column(name = "state")
	private String state;
	
	public AdvertEntity(){
		super();
	}

	public AdvertEntity(UUID id, String functionalIdentifier, Date insertionDate, Date startDate, Date endDate,
			boolean isActive, String title, String description, String state) {
		super();
		this.id = id;
		this.functionalIdentifier = functionalIdentifier;
		this.insertionDate = insertionDate;
		this.startDate = startDate;
		this.endDate = endDate;
		this.isActive = isActive;
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

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
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
	
	

}
