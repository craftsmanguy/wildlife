package com.ilmani.dream.wildlives.advert.persistence.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.ilmani.dream.wildlives.advert.persistence.entity.AdvertEntity;

public class AdvertDao {

	@PersistenceContext(unitName = "advertPu")
	private EntityManager em;

	public AdvertEntity findByFunctionalId(String functionalId) throws NoResultException {

		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<AdvertEntity> criteriaQuery = builder.createQuery(AdvertEntity.class);
		Root<AdvertEntity> advertFromDb = criteriaQuery.from(AdvertEntity.class);

		criteriaQuery.select(advertFromDb);
		List<Predicate> predicateList = new ArrayList<Predicate>();

		predicateList.add(builder.equal(advertFromDb.<String>get("functionalIdentifier"), functionalId));

		criteriaQuery.where(predicateList.toArray(new Predicate[] {}));
		return em.createQuery(criteriaQuery).getSingleResult();
	}

	public boolean isExists(String functionalId) throws NoResultException {
		boolean result = true;
		try {
			findByFunctionalId(functionalId);
		} catch (NoResultException e) {
			result = false;
		}
		return result;
	}

	public List<AdvertEntity> getByAttributes(AdvertEntity advert) {

		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<AdvertEntity> criteriaQuery = builder.createQuery(AdvertEntity.class);
		Root<AdvertEntity> advertFromDb = criteriaQuery.from(AdvertEntity.class);

		criteriaQuery.select(advertFromDb);
		List<Predicate> predicateList = new ArrayList<Predicate>();

		if (advert.getFunctionalIdentifier() != null) {
			predicateList.add(builder.like(builder.upper(advertFromDb.<String>get("functionalIdentifier")),
					"%" + advert.getFunctionalIdentifier().toLowerCase() + "%"));
		}
		if (advert.getTitle() != null) {
			predicateList.add(builder.like(advertFromDb.<String>get("title"), "%" + advert.getTitle() + "%"));
		}

		criteriaQuery.where(predicateList.toArray(new Predicate[] {}));
		criteriaQuery.orderBy(builder.asc(advertFromDb.get("title")));
		return em.createQuery(criteriaQuery).getResultList();
	}

	public AdvertEntity insert(AdvertEntity advert) {
		advert.setId(UUID.randomUUID());
		em.persist(advert);
		return advert;

	}

	public void delete(AdvertEntity advert) {
		em.remove(advert);
	}

	public AdvertEntity update(AdvertEntity advert) {
		em.merge(advert);
		return advert;
	}

}
