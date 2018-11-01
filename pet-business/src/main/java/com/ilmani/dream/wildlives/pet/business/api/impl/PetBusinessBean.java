package com.ilmani.dream.wildlives.pet.business.api.impl;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import com.ilmani.dream.wildlives.pet.business.api.PetBusinessLocal;

@Stateless(name = "PetBusinessBean")
@TransactionManagement(TransactionManagementType.BEAN)
public class PetBusinessBean implements PetBusinessLocal{

}
