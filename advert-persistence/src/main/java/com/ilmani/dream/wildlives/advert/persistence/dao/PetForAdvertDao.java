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

import com.ilmani.dream.wildlives.advert.persistence.entity.PetForAdvertEntity;

public class PetForAdvertDao {

	@PersistenceContext(unitName = "advertPu")
	private EntityManager em;

	public PetForAdvertEntity findByFunctionalIdentifier(String functionalId) throws NoResultException {

		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<PetForAdvertEntity> criteriaQuery = builder.createQuery(PetForAdvertEntity.class);
		Root<PetForAdvertEntity> petFromDb = criteriaQuery.from(PetForAdvertEntity.class);

		criteriaQuery.select(petFromDb);
		List<Predicate> predicateList = new ArrayList<Predicate>();

		predicateList.add(builder.equal(petFromDb.<String>get("functionalIdentifier"), functionalId));

		criteriaQuery.where(predicateList.toArray(new Predicate[] {}));
		return em.createQuery(criteriaQuery).getSingleResult();
	}

}
