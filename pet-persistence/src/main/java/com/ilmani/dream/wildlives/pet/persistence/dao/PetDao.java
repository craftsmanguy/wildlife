package com.ilmani.dream.wildlives.pet.persistence.dao;

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

import com.ilmani.dream.wildlives.pet.persistence.entity.PetEntity;

public class PetDao {

	@PersistenceContext(unitName = "petPu")
	private EntityManager em;

	public PetEntity findByIdentifier(PetEntity pet) throws NoResultException {

		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<PetEntity> criteriaQuery = builder.createQuery(PetEntity.class);
		Root<PetEntity> petFromDb = criteriaQuery.from(PetEntity.class);

		criteriaQuery.select(petFromDb);
		List<Predicate> predicateList = new ArrayList<Predicate>();

		predicateList.add(builder.equal(builder.lower(petFromDb.<String>get("functionalIdentifier")),
				pet.getFunctionalIdentifier().toLowerCase()));

		criteriaQuery.where(predicateList.toArray(new Predicate[] {}));
		return em.createQuery(criteriaQuery).getSingleResult();
	}

	public List<PetEntity> getByAttributes(PetEntity pet) {

		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<PetEntity> criteriaQuery = builder.createQuery(PetEntity.class);
		Root<PetEntity> petFromDb = criteriaQuery.from(PetEntity.class);

		criteriaQuery.select(petFromDb);
		List<Predicate> predicateList = new ArrayList<Predicate>();

		if (pet.getFunctionalIdentifier() != null) {
			predicateList.add(builder.like(builder.upper(petFromDb.<String>get("functionalIdentifier")),
					"%" + pet.getFunctionalIdentifier().toLowerCase() + "%"));
		}
		if (pet.getName() != null) {
			predicateList.add(builder.like(petFromDb.<String>get("name"), "%" + pet.getName() + "%"));
		}

		criteriaQuery.where(predicateList.toArray(new Predicate[] {}));
		criteriaQuery.orderBy(builder.asc(petFromDb.get("name")));
		return em.createQuery(criteriaQuery).getResultList();
	}

	public PetEntity insert(PetEntity pet) {
		pet.setId(UUID.randomUUID());
		em.persist(pet);
		return pet;

	}

	public void delete(PetEntity pet) {
		em.remove(pet);

	}

	public PetEntity update(PetEntity pet) {
		em.merge(pet);
		return pet;
	}

}
