package com.omar.microservice;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.autoconfigure.transaction.TransactionAutoConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.omar.microservice.dto.UserDTO;
import com.omar.microservice.entity.User;
import com.omar.microservice.repository.UserRepository;
import com.omar.microservice.service.UserService;

//@SpringBootTest(classes = { DockerJpaMicroSrvApplicationTest.class })
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = DockerJpaMicroSrvApplication.class)
@EnableAutoConfiguration(exclude = { JpaRepositoriesAutoConfiguration.class, DataSourceAutoConfiguration.class,
		DataSourceTransactionManagerAutoConfiguration.class, HibernateJpaAutoConfiguration.class,
		TransactionAutoConfiguration.class })

class UserServiceTests {

	@Autowired
	private UserService userService;

	@MockBean
	private UserRepository userRepository;

	@BeforeEach
	public void setUp() {
		Mockito.when(userRepository.add(Mockito.any(User.class)))
				.thenReturn(new User("test.id", "test name", "test@test.com"));
	}

	@Test
	void AddUser_Service_Test() {

		UserDTO userDTO = new UserDTO();
		userDTO.setUsername("test.id");
		userDTO.setName("test name");
		userDTO.setEmail("test@test.com");
		UserDTO addedUserDTO = userService.addUser(userDTO);

		Assertions.assertNotNull(addedUserDTO);
		assertThat(addedUserDTO.getUsername(), equalTo("test.id"));
		assertThat(addedUserDTO.getName(), equalTo("test name"));
		assertThat(addedUserDTO.getEmail(), equalTo("test@test.com"));
	}

}
