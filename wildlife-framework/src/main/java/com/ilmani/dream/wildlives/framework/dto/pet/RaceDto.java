package com.ilmani.dream.wildlives.framework.dto.pet;

public class RaceDto {

	private String name;

	private String scientistName;

	private String code;

	private String specie;

	private String specieScientistName;

	private String specieCode;

	private String type;

	private String typeScientistName;

	private String typeCode;

	public RaceDto() {

	}

	public RaceDto(String name, String specie, String type) {
		this.name = name;
		this.specie = specie;
		this.type = type;
	}

	public RaceDto(String name, String scientistName, String code, String specie, String specieScientistName,
			String specieCode, String type, String typeScientistName, String typeCode) {
		this.name = name;
		this.scientistName = scientistName;
		this.code = code;
		this.specie = specie;
		this.specieScientistName = specieScientistName;
		this.specieCode = specieCode;
		this.type = type;
		this.typeScientistName = typeScientistName;
		this.typeCode = typeCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getScientistName() {
		return scientistName;
	}

	public void setScientistName(String scientistName) {
		this.scientistName = scientistName;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getSpecie() {
		return specie;
	}

	public void setSpecie(String specie) {
		this.specie = specie;
	}

	public String getSpecieScientistName() {
		return specieScientistName;
	}

	public void setSpecieScientistName(String specieScientistName) {
		this.specieScientistName = specieScientistName;
	}

	public String getSpecieCode() {
		return specieCode;
	}

	public void setSpecieCode(String specieCode) {
		this.specieCode = specieCode;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTypeScientistName() {
		return typeScientistName;
	}

	public void setTypeScientistName(String typeScientistName) {
		this.typeScientistName = typeScientistName;
	}

	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((scientistName == null) ? 0 : scientistName.hashCode());
		result = prime * result + ((specie == null) ? 0 : specie.hashCode());
		result = prime * result + ((specieCode == null) ? 0 : specieCode.hashCode());
		result = prime * result + ((specieScientistName == null) ? 0 : specieScientistName.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((typeCode == null) ? 0 : typeCode.hashCode());
		result = prime * result + ((typeScientistName == null) ? 0 : typeScientistName.hashCode());
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
		if (!(obj instanceof RaceDto)) {
			return false;
		}
		RaceDto other = (RaceDto) obj;
		if (code == null) {
			if (other.code != null) {
				return false;
			}
		} else if (!code.equals(other.code)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (scientistName == null) {
			if (other.scientistName != null) {
				return false;
			}
		} else if (!scientistName.equals(other.scientistName)) {
			return false;
		}
		if (specie == null) {
			if (other.specie != null) {
				return false;
			}
		} else if (!specie.equals(other.specie)) {
			return false;
		}
		if (specieCode == null) {
			if (other.specieCode != null) {
				return false;
			}
		} else if (!specieCode.equals(other.specieCode)) {
			return false;
		}
		if (specieScientistName == null) {
			if (other.specieScientistName != null) {
				return false;
			}
		} else if (!specieScientistName.equals(other.specieScientistName)) {
			return false;
		}
		if (type == null) {
			if (other.type != null) {
				return false;
			}
		} else if (!type.equals(other.type)) {
			return false;
		}
		if (typeCode == null) {
			if (other.typeCode != null) {
				return false;
			}
		} else if (!typeCode.equals(other.typeCode)) {
			return false;
		}
		if (typeScientistName == null) {
			if (other.typeScientistName != null) {
				return false;
			}
		} else if (!typeScientistName.equals(other.typeScientistName)) {
			return false;
		}
		return true;
	}
	
	

}
