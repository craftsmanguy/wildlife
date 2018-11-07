package com.ilmani.dream.wildlives.framework.dto.advert;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.ilmani.dream.wildlives.framework.dto.pet.AbstractPetDto;

public class AdvertDto {

	private String functionalIdentifier;

	private Date insertionDate;

	private Date startDate;

	private Date endDate;

	private String title;

	private String description;

	private String state;

	private Set<FormatDto> formats = new HashSet<FormatDto>();

	private String userForAdvert;

	private List<AbstractPetDto> pets = new ArrayList<AbstractPetDto>();

	public AdvertDto() {
		super();
	}

	public AdvertDto(String functionalIdentifier, Date insertionDate, Date startDate, Date endDate, String title,
			String description, String state) {
		super();
		this.functionalIdentifier = functionalIdentifier;
		this.insertionDate = insertionDate;
		this.startDate = startDate;
		this.endDate = endDate;
		this.title = title;
		this.description = description;
		this.state = state;
	}

	public Date getInsertionDate() {
		return insertionDate;
	}

	public String getFunctionalIdentifier() {
		return functionalIdentifier;
	}

	public void setFunctionalIdentifier(String functionalIdentifier) {
		this.functionalIdentifier = functionalIdentifier;
	}

	public void setInsertionDate(Date insertionDate) {
		this.insertionDate = insertionDate;
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

	public Set<FormatDto> getFormats() {
		return formats;
	}

	public void setFormats(Set<FormatDto> formats) {
		this.formats = formats;
	}

	public String getUserForAdvert() {
		return userForAdvert;
	}

	public void setUserForAdvert(String userForAdvert) {
		this.userForAdvert = userForAdvert;
	}

	public List<AbstractPetDto> getPets() {
		return pets;
	}

	public void setPets(List<AbstractPetDto> petsDto) {
		this.pets = petsDto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + ((formats == null) ? 0 : formats.hashCode());
		result = prime * result + ((functionalIdentifier == null) ? 0 : functionalIdentifier.hashCode());
		result = prime * result + ((insertionDate == null) ? 0 : insertionDate.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof AdvertDto)) {
			return false;
		}
		AdvertDto other = (AdvertDto) obj;
		if (description == null) {
			if (other.description != null) {
				return false;
			}
		} else if (!description.equals(other.description)) {
			return false;
		}
		if (endDate == null) {
			if (other.endDate != null) {
				return false;
			}
		} else if (!endDate.equals(other.endDate)) {
			return false;
		}
		if (formats == null) {
			if (other.formats != null) {
				return false;
			}
		} else if (!formats.equals(other.formats)) {
			return false;
		}
		if (functionalIdentifier == null) {
			if (other.functionalIdentifier != null) {
				return false;
			}
		} else if (!functionalIdentifier.equals(other.functionalIdentifier)) {
			return false;
		}
		if (insertionDate == null) {
			if (other.insertionDate != null) {
				return false;
			}
		} else if (!insertionDate.equals(other.insertionDate)) {
			return false;
		}
		if (startDate == null) {
			if (other.startDate != null) {
				return false;
			}
		} else if (!startDate.equals(other.startDate)) {
			return false;
		}
		if (state == null) {
			if (other.state != null) {
				return false;
			}
		} else if (!state.equals(other.state)) {
			return false;
		}
		if (title == null) {
			if (other.title != null) {
				return false;
			}
		} else if (!title.equals(other.title)) {
			return false;
		}
		return true;
	}

}
