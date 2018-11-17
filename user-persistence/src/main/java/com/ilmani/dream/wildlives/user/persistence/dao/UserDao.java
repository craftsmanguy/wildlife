package com.ilmani.dream.wildlives.user.persistence.dao;

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

import com.ilmani.dream.wildlives.user.persistence.entity.UserEntity;

public class UserDao {

	@PersistenceContext(unitName = "userPu")
	private EntityManager em;

	public UserEntity saveUser(UserEntity user) {
		user.setId(UUID.randomUUID());
		em.persist(user);
		return user;
	}

	public boolean isEmailExists(String email) throws NoResultException {
		boolean result = true;
		try {
			findByEmail(email);
		} catch (NoResultException e) {
			result = false;
		}
		return result;
	}

	public boolean isPseudonymExists(String pseudonym) {
		boolean result = true;
		try {
			findByPseudonym(pseudonym);
		} catch (NoResultException e) {
			result = false;
		}
		return result;
	}

	public UserEntity findByEmail(String email) throws NoResultException {

		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<UserEntity> criteriaQuery = builder.createQuery(UserEntity.class);
		Root<UserEntity> userFromDb = criteriaQuery.from(UserEntity.class);

		criteriaQuery.select(userFromDb);
		List<Predicate> predicateList = new ArrayList<Predicate>();

		predicateList.add(builder.equal(userFromDb.<String>get("email"), email));

		criteriaQuery.where(predicateList.toArray(new Predicate[] {}));
		return em.createQuery(criteriaQuery).getSingleResult();
	}

	public UserEntity findByPseudonym(String pseudonym) throws NoResultException {

		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<UserEntity> criteriaQuery = builder.createQuery(UserEntity.class);
		Root<UserEntity> userFromDb = criteriaQuery.from(UserEntity.class);

		criteriaQuery.select(userFromDb);
		List<Predicate> predicateList = new ArrayList<Predicate>();

		predicateList.add(builder.equal(userFromDb.<String>get("pseudonym"), pseudonym));

		criteriaQuery.where(predicateList.toArray(new Predicate[] {}));
		return em.createQuery(criteriaQuery).getSingleResult();
	}

	public boolean isProfilExists(String email, String password) throws NoResultException {
		String passwordDb = findPasswordByEmail(email);
		StringBuffer queryBuilder = new StringBuffer();
		queryBuilder.append("SELECT users.pass =  crypt('").append(password).append("', '").append(passwordDb)
				.append("') FROM PARTICIPANT as users WHERE users.email = '").append(email).append("';");

		return (boolean) em.createNativeQuery(queryBuilder.toString()).getSingleResult();
	}

	private String findPasswordByEmail(String email) throws NoResultException {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<UserEntity> criteriaQuery = builder.createQuery(UserEntity.class);
		Root<UserEntity> userFromDb = criteriaQuery.from(UserEntity.class);

		criteriaQuery.select(userFromDb);
		List<Predicate> predicateList = new ArrayList<Predicate>();

		predicateList.add(builder.equal(userFromDb.<String>get("email"), email));

		criteriaQuery.where(predicateList.toArray(new Predicate[] {}));
		return em.createQuery(criteriaQuery).getSingleResult().getPass();
	}

	public String findPseudonymByEmail(String email) throws NoResultException {

		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<UserEntity> criteriaQuery = builder.createQuery(UserEntity.class);
		Root<UserEntity> userFromDb = criteriaQuery.from(UserEntity.class);

		criteriaQuery.select(userFromDb);
		List<Predicate> predicateList = new ArrayList<Predicate>();

		predicateList.add(builder.equal(userFromDb.<String>get("email"), email));

		criteriaQuery.where(predicateList.toArray(new Predicate[] {}));
		return em.createQuery(criteriaQuery).getSingleResult().getPseudonym();
	}

}
