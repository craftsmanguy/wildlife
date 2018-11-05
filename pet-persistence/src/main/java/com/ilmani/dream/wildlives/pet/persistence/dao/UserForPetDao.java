package com.ilmani.dream.wildlives.pet.persistence.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.ilmani.dream.wildlives.pet.persistence.entity.UserForPetEntity;

public class UserForPetDao {

	@PersistenceContext(unitName = "petPu")
	private EntityManager em;

	public UserForPetEntity findUserByPseudonym(String pseudonym) throws NoResultException {

		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<UserForPetEntity> criteriaQuery = builder.createQuery(UserForPetEntity.class);
		Root<UserForPetEntity> userFromDb = criteriaQuery.from(UserForPetEntity.class);

		criteriaQuery.select(userFromDb);
		List<Predicate> predicateList = new ArrayList<Predicate>();

		predicateList.add(builder.equal(userFromDb.<String>get("pseudonym"), pseudonym));

		criteriaQuery.where(predicateList.toArray(new Predicate[] {}));
		return em.createQuery(criteriaQuery).getSingleResult();
	}

}
