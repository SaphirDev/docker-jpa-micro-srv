/**
 * 
 */
package com.omar.microservice.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.omar.microservice.entity.User;

/**
 * @author Omar
 *
 */
@Repository
@Transactional
public class UserRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public List<User> findAll() {
		return entityManager.createQuery("select u from User u", User.class).getResultList();
	}

	public User add(User user) {
		entityManager.persist(user);
		return user;
	}

	public User update(User user) {
		return entityManager.merge(user);
	}

	public User findById(long id) {
		return entityManager.find(User.class, id);
	}

	public void deleteById(long id) {
		User user = findById(id);
		entityManager.remove(user);
	}

}
