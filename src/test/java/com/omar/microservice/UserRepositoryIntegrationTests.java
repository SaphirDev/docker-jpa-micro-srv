package com.omar.microservice;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;

import com.omar.microservice.entity.User;
import com.omar.microservice.repository.UserRepository;

@SpringBootTest
@AutoConfigureTestEntityManager

class UserRepositoryIntegrationTests {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	UserRepository userRepository;

	@Test
	@Transactional
	void AddUser_Test() {

		entityManager.persist(new User("test.id", "test name", "test@test.com"));
		entityManager.flush();

		User user = userRepository.findByUsername("test.id");
		Assertions.assertNotNull(user);
		assertThat(user.getName(), equalTo("test name"));

	}

}
