/**
 * 
 */
package com.omar.microservice.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
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

	public User findById(long id) {
		return entityManager.find(User.class, id);
	}

	public User findByUsername(String username) {
		TypedQuery<User> query = entityManager.createQuery("select u from User u where u.username=?1", User.class);
		query.setParameter(1, username);
		return query.getResultList().get(0);

	}

	public User add(User user) {
		entityManager.persist(user);
		return user;
	}

	public User update(User user) {
		return entityManager.merge(user);
	}

	public void deleteById(long id) {
		User user = findById(id);
		entityManager.remove(user);
	}

}
