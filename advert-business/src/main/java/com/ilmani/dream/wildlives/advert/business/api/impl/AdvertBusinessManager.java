package com.ilmani.dream.wildlives.advert.business.api.impl;

import static com.ilmani.dream.wildlives.framework.security.SecurityInformationFacade.getInstance;


import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import com.ilmani.dream.wildlives.advert.business.api.AdvertBusinessLocal;

@Stateless(name = "AdvertBusinessManager")
@TransactionManagement(TransactionManagementType.BEAN)
public class AdvertBusinessManager implements AdvertBusinessLocal {

}
