package com.ilmani.dream.wildlives.framework.dto.advert;

import java.io.Serializable;

public class FormatAdministratorDto extends AbstractFormatDto implements Serializable {

	private static final long serialVersionUID = 1608491616188675082L;

	protected String name;

	protected boolean isActive;

	public FormatAdministratorDto() {
		super();
	}

	public FormatAdministratorDto(String code, String feature, boolean isActive) {
		super();
		this.code = code;
		this.feature = feature;
		this.isActive = isActive;
	}

	public FormatAdministratorDto(String name, String code, String feature, boolean isActive) {
		super();
		this.name = name;
		this.code = code;
		this.feature = feature;
		this.isActive = isActive;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (isActive ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		if (!(obj instanceof FormatAdministratorDto)) {
			return false;
		}
		FormatAdministratorDto other = (FormatAdministratorDto) obj;
		if (isActive != other.isActive) {
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
