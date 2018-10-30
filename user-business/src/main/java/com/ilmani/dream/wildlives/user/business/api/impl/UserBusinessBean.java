package com.ilmani.dream.wildlives.user.business.api.impl;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import com.ilmani.dream.wildlives.user.business.api.UserAdministrationLocal;

@Stateless(name = "UserBusinessBean")
@TransactionManagement(TransactionManagementType.BEAN)
public class UserBusinessBean implements UserAdministrationLocal {

}
