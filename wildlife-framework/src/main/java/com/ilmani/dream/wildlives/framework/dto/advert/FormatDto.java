package com.ilmani.dream.wildlives.framework.dto.advert;

import java.io.Serializable;

public class FormatDto implements Serializable{

	private static final long serialVersionUID = 1608491616188675082L;

	protected String name;

	protected String code;

	protected String feature;

	protected boolean isActive;

	public FormatDto() {
		super();
	}

	public FormatDto(String name, String feature, boolean isActive) {
		super();
		this.name = name;
		this.feature = feature;
		this.isActive = isActive;
	}

	public FormatDto(String name, String code, String feature, boolean isActive) {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((feature == null) ? 0 : feature.hashCode());
		result = prime * result + (isActive ? 1231 : 1237);
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
		if (!(obj instanceof FormatDto)) {
			return false;
		}
		FormatDto other = (FormatDto) obj;
		if (code == null) {
			if (other.code != null) {
				return false;
			}
		} else if (!code.equals(other.code)) {
			return false;
		}
		if (feature == null) {
			if (other.feature != null) {
				return false;
			}
		} else if (!feature.equals(other.feature)) {
			return false;
		}
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
