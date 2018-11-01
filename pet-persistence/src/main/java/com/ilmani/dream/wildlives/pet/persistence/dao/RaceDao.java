package com.ilmani.dream.wildlives.pet.persistence.dao;

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

import com.ilmani.dream.wildlives.pet.persistence.entity.RaceEntity;

public class RaceDao {

	@PersistenceContext(unitName = "petPu")
	private EntityManager em;

	public RaceEntity findByUniqueAttributConstraint(RaceEntity race) throws NoResultException {

		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<RaceEntity> criteriaQuery = builder.createQuery(RaceEntity.class);
		Root<RaceEntity> raceFromDb = criteriaQuery.from(RaceEntity.class);

		criteriaQuery.select(raceFromDb);
		List<Predicate> predicateList = new ArrayList<Predicate>();

		predicateList.add(builder.equal(builder.upper(raceFromDb.<String>get("name")), race.getName()));
		predicateList.add(builder.equal(builder.upper(raceFromDb.<String>get("specie")), race.getSpecie()));
		predicateList.add(builder.equal(builder.upper(raceFromDb.<String>get("clan")), race.getClan()));
		predicateList.add(builder.equal(raceFromDb.get("isActive"), true));

		criteriaQuery.where(predicateList.toArray(new Predicate[] {}));
		return em.createQuery(criteriaQuery).getSingleResult();
	}

	public Set<RaceEntity> getByAttributes(RaceEntity race) {

		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<RaceEntity> criteriaQuery = builder.createQuery(RaceEntity.class);
		Root<RaceEntity> raceFromDb = criteriaQuery.from(RaceEntity.class);

		criteriaQuery.select(raceFromDb);
		List<Predicate> predicateList = new ArrayList<Predicate>();

		if (race.getName() != null) {
			predicateList.add(builder.like(builder.upper(raceFromDb.<String>get("name")),
					"%" + race.getName().toUpperCase() + "%"));
		}
		if (race.getSpecie() != null) {
			predicateList.add(builder.like(builder.upper(raceFromDb.<String>get("specie")),
					"%" + race.getSpecie().toUpperCase() + "%"));
		}

		if (race.getClan() != null) {
			predicateList.add(builder.like(builder.upper(raceFromDb.<String>get("clan")),
					"%" + race.getClan().toUpperCase() + "%"));
		}
		predicateList.add(builder.equal(raceFromDb.get("isActive"), true));

		criteriaQuery.where(predicateList.toArray(new Predicate[] {}));
		criteriaQuery.orderBy(builder.asc(raceFromDb.get("name")));
		List<RaceEntity> results = em.createQuery(criteriaQuery).getResultList();
		return new HashSet<RaceEntity>(results);
	}

	public RaceEntity insert(RaceEntity race) {
		em.persist(race);
		return race;
	}

	public void delete(RaceEntity race) {
		em.remove(race);
	}

	public RaceEntity update(RaceEntity race) {
		em.merge(race);
		return race;
	}

}
