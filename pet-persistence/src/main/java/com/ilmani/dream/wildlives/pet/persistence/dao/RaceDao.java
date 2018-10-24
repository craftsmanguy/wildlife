package com.ilmani.dream.wildlives.pet.persistence.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.ilmani.dream.wildlives.pet.persistence.entity.RaceEntity;

public class RaceDao {

	@PersistenceContext(unitName = "petPu")
	private EntityManager em;

	public RaceEntity findByIdenfier(RaceEntity race) {

		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<RaceEntity> criteriaQuery = builder.createQuery(RaceEntity.class);
		Root<RaceEntity> raceFromDb = criteriaQuery.from(RaceEntity.class);

		criteriaQuery.select(raceFromDb);
		List<Predicate> predicateList = new ArrayList<Predicate>();

		if (race.getName() != null) {
			predicateList.add(builder.equal(raceFromDb.<String>get("name"), race.getName()));
		}
		if (race.getSpecie() != null) {
			predicateList.add(builder.equal(raceFromDb.<String>get("specie"), race.getSpecie()));
		}
		if (race.getClan() != null) {
			predicateList.add(builder.equal(builder.upper(raceFromDb.<String>get("clan")), race.getClan()));
		}

		criteriaQuery.where(predicateList.toArray(new Predicate[] {}));
		return em.createQuery(criteriaQuery).getSingleResult();
	}

	public Set<RaceEntity> getByIdenfier(RaceEntity race) {

		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<RaceEntity> criteriaQuery = builder.createQuery(RaceEntity.class);
		Root<RaceEntity> raceFromDb = criteriaQuery.from(RaceEntity.class);

		criteriaQuery.select(raceFromDb);
		List<Predicate> predicateList = new ArrayList<Predicate>();

		if (race.getName() != null) {
			predicateList.add(builder.like(raceFromDb.<String>get("name"), "%" + race.getName() + "%"));
		}
		if (race.getSpecie() != null) {
			predicateList.add(builder.like(raceFromDb.<String>get("specie"), "%" + race.getSpecie() + "%"));
		}

		if (race.getClan() != null) {
			predicateList.add(builder.like(builder.upper(raceFromDb.<String>get("clan")),
					"%" + race.getClan().toUpperCase() + "%"));
		}

		criteriaQuery.where(predicateList.toArray(new Predicate[] {}));

		@SuppressWarnings("unchecked")
		Set<RaceEntity> races = (Set<RaceEntity>) em.createQuery(criteriaQuery).getResultList();
		return races;
	}

	public RaceEntity save(RaceEntity race) {
		em.persist(race);
		return race;
	}

	public void delete(RaceEntity race) {
		em.remove(race);
		em.flush();
	}

	public RaceEntity update(RaceEntity race) {
		em.merge(race);
		em.flush();
		return race;
	}

}
