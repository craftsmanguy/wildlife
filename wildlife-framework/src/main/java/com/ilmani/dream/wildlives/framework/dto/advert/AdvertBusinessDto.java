package com.ilmani.dream.wildlives.framework.dto.advert;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.ilmani.dream.wildlives.framework.dto.pet.AbstractPetDto;

public class AdvertBusinessDto extends AbstractAdvertDto {
	
	protected Date startDate;

	protected Date endDate;

	protected String description;

	protected List<AbstractPetDto> pets = new ArrayList<AbstractPetDto>();
	
	private String user;
	
	private String state = "TO_VALIDATE";
	
	protected Set<FormatBusinessDto> formats = new HashSet<FormatBusinessDto>();

	public AdvertBusinessDto() {
		super();
	}

	public AdvertBusinessDto(String functionalIdentifier, Date startDate, Date endDate, String title,
			String description) {
		super();
		this.functionalIdentifier = functionalIdentifier;
		this.startDate = startDate;
		this.endDate = endDate;
		this.title = title;
		this.description = description;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<AbstractPetDto> getPets() {
		return pets;
	}

	public void setPets(List<AbstractPetDto> pets) {
		this.pets = pets;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Set<FormatBusinessDto> getFormats() {
		return formats;
	}

	public void setFormats(Set<FormatBusinessDto> formats) {
		this.formats = formats;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + ((formats == null) ? 0 : formats.hashCode());
		result = prime * result + ((pets == null) ? 0 : pets.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof AdvertBusinessDto)) {
			return false;
		}
		AdvertBusinessDto other = (AdvertBusinessDto) obj;
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
		if (pets == null) {
			if (other.pets != null) {
				return false;
			}
		} else if (!pets.equals(other.pets)) {
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
		if (user == null) {
			if (other.user != null) {
				return false;
			}
		} else if (!user.equals(other.user)) {
			return false;
		}
		return true;
	}

	
}
