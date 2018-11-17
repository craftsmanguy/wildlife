package com.ilmani.dream.wildlives.advert.business.facade;

import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import com.ilmani.dream.wildlives.advert.business.port.AdvertBusinessDomain;
import com.ilmani.dream.wildlives.advert.business.port.FormatBusinessDomain;
import com.ilmani.dream.wildlives.framework.dto.advert.AbstractAdvertDto;
import com.ilmani.dream.wildlives.framework.dto.advert.AbstractFormatDto;

public class AdvertBusinessFacade {

	@Inject
	private AdvertBusinessDomain advertDomain;

	@Inject
	private FormatBusinessDomain formatDomain;

	public AbstractAdvertDto saveAdvert(AbstractAdvertDto advert) {
		return advertDomain.saveAdvert(advert);
	}

	public boolean isAdvertExists(String id) {
		return advertDomain.isExists(id);
	}

	public void deleteAdvert(String id) {
		advertDomain.delete(id);
	}

	public AbstractAdvertDto findAdvertById(String id) {
		return advertDomain.findById(id);
	}

	public Set<AbstractFormatDto> searchFormatByAttributs(AbstractFormatDto format) {
		return formatDomain.search(format);
	}

	public List<AbstractAdvertDto> getAdvertByAttributes(AbstractAdvertDto advert) {
		return advertDomain.getAdvertByAttributes(advert);
	}

}
