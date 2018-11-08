package com.ilmani.dream.wildlives.framework.dto.pet;

import java.io.Serializable;

public class AbstractPetDto implements Serializable {

	private static final long serialVersionUID = 2811739234678308526L;

	protected String functionalIdentifier;

	protected String name;

	public AbstractPetDto() {
		super();
	}

	public AbstractPetDto(String functionalIdentifier, String name) {
		super();
		this.functionalIdentifier = functionalIdentifier;
		this.name = name;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((functionalIdentifier == null) ? 0 : functionalIdentifier.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		if (!(obj instanceof AbstractPetDto)) {
			return false;
		}
		AbstractPetDto other = (AbstractPetDto) obj;
		if (functionalIdentifier == null) {
			if (other.functionalIdentifier != null) {
				return false;
			}
		} else if (!functionalIdentifier.equals(other.functionalIdentifier)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		return true;
	}

}
