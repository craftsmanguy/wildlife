package com.ilmani.dream.wildlives.advert.persistence.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.ilmani.dream.wildlives.advert.persistence.entity.FormatEntity;

public class FormatDao {

	@PersistenceContext(unitName = "advertPu")
	private EntityManager em;

	public boolean isExists(String code) {
		boolean result = true;

		try {
			CriteriaBuilder builder = em.getCriteriaBuilder();
			CriteriaQuery<FormatEntity> criteriaQuery = builder.createQuery(FormatEntity.class);
			Root<FormatEntity> formatFromDb = criteriaQuery.from(FormatEntity.class);

			criteriaQuery.select(formatFromDb);
			List<Predicate> predicateList = new ArrayList<Predicate>();

			predicateList.add(builder.equal(formatFromDb.<String>get("code"), code));

			criteriaQuery.where(predicateList.toArray(new Predicate[] {}));
			em.createQuery(criteriaQuery).getSingleResult();
		} catch (NoResultException e) {
			result = false;
		}

		return result;
	}

	public FormatEntity findByCode(String code) throws NoResultException {

		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<FormatEntity> criteriaQuery = builder.createQuery(FormatEntity.class);
		Root<FormatEntity> formatFromDb = criteriaQuery.from(FormatEntity.class);

		criteriaQuery.select(formatFromDb);
		List<Predicate> predicateList = new ArrayList<Predicate>();

		predicateList.add(builder.equal(formatFromDb.<String>get("code"), code));

		criteriaQuery.where(predicateList.toArray(new Predicate[] {}));
		return em.createQuery(criteriaQuery).getSingleResult();
	}

	public Set<FormatEntity> getByAttributes(FormatEntity format) {

		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<FormatEntity> criteriaQuery = builder.createQuery(FormatEntity.class);
		Root<FormatEntity> formatFromDb = criteriaQuery.from(FormatEntity.class);

		criteriaQuery.select(formatFromDb);
		List<Predicate> predicateList = new ArrayList<Predicate>();

		if (format.getName() != null) {
			predicateList.add(builder.like(builder.upper(formatFromDb.<String>get("name")),
					"%" + format.getName().toUpperCase() + "%"));
		}
		if (format.getFeature() != null) {
			predicateList.add(builder.like(builder.upper(formatFromDb.<String>get("feature")),
					"%" + format.getFeature().toUpperCase() + "%"));
		}
//		predicateList.add(builder.equal(formatFromDb.get("isActive"), true));

		criteriaQuery.where(predicateList.toArray(new Predicate[] {}));
		criteriaQuery.orderBy(builder.asc(formatFromDb.get("name")));
		List<FormatEntity> results = em.createQuery(criteriaQuery).getResultList();
		return new HashSet<FormatEntity>(results);
	}

	public FormatEntity insert(FormatEntity format) {
		em.persist(format);
		return format;
	}

	public void delete(FormatEntity format) {
		em.remove(format);
	}

	public FormatEntity update(FormatEntity format) {
		em.merge(format);
		return format;
	}

}
