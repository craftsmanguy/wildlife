package com.ilmani.dream.wildlives.framework.dto.advert;

import java.io.Serializable;

public class FormatBusinessDto extends AbstractFormatDto implements Serializable {

	private static final long serialVersionUID = 1608491616188675082L;

	public FormatBusinessDto() {
		super();
	}
	
	public FormatBusinessDto(String code, String feature) {
		super();
		this.code = code;
		this.feature = feature;
	}
}
