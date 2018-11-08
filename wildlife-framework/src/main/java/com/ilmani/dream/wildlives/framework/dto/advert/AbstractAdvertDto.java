package com.ilmani.dream.wildlives.framework.dto.advert;

public abstract class AbstractAdvertDto {

	protected String functionalIdentifier;
	
	protected String title;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((functionalIdentifier == null) ? 0 : functionalIdentifier.hashCode());
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
		if (!(obj instanceof AbstractAdvertDto)) {
			return false;
		}
		AbstractAdvertDto other = (AbstractAdvertDto) obj;
		if (functionalIdentifier == null) {
			if (other.functionalIdentifier != null) {
				return false;
			}
		} else if (!functionalIdentifier.equals(other.functionalIdentifier)) {
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
