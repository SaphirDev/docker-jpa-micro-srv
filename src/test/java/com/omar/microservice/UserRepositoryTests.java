package com.omar.microservice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import com.omar.microservice.entity.User;
import com.omar.microservice.repository.UserRepository;

@SpringBootTest
class UserRepositoryTests {

	@Autowired
	UserRepository repository;

	@Test
	@DirtiesContext
	void AddUser_Test() {

		User addedUser = repository.add(new User("test.id", "test name", "test@test.com"));
		User user = repository.findById(addedUser.getId());
		Assertions.assertNotNull(user);

	}

}
