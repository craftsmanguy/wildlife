package com.ilmani.dream.wildlives.framework.dto.advert;

import java.io.Serializable;

public class FormatAdministratorDto extends AbstractFormatDto implements Serializable {

	private static final long serialVersionUID = 1608491616188675082L;

	protected boolean isActive;

	public FormatAdministratorDto() {
		super();
	}

	public FormatAdministratorDto(String code, String feature) {
		super();
		this.code = code;
		this.feature = feature;
	}

	public FormatAdministratorDto(String name, String code, String feature, boolean isActive) {
		super();
		this.name = name;
		this.code = code;
		this.feature = feature;
		this.isActive = isActive;
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
		result = prime * result + (isActive ? 1231 : 1237);
		return result;
	}
}
