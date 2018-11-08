package com.ilmani.dream.wildlives.advert.persistence.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.ilmani.dream.wildlives.advert.persistence.entity.UserForAdvertEntity;

public class UserForAdvertDao {

	@PersistenceContext(unitName = "advertPu")
	private EntityManager em;

	public UserForAdvertEntity findUserByPseudonym(String pseudonym) throws NoResultException {

		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<UserForAdvertEntity> criteriaQuery = builder.createQuery(UserForAdvertEntity.class);
		Root<UserForAdvertEntity> userFromDb = criteriaQuery.from(UserForAdvertEntity.class);

		criteriaQuery.select(userFromDb);
		List<Predicate> predicateList = new ArrayList<Predicate>();

		predicateList.add(builder.equal(userFromDb.<String>get("pseudonym"), pseudonym));

		criteriaQuery.where(predicateList.toArray(new Predicate[] {}));
		return em.createQuery(criteriaQuery).getSingleResult();
	}

}
