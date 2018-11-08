package com.ilmani.dream.wildlives.user.administration.api.impl;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import com.ilmani.dream.wildlives.user.administration.api.UserAdministrationLocal;

@Stateless(name = "UserAdministrationBean")
@TransactionManagement(TransactionManagementType.BEAN)
public class UserAdministrationBean implements UserAdministrationLocal{

}
