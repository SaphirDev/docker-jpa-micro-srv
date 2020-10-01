/**
 * 
 */
package com.omar.microservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.omar.microservice.dto.UserDTO;
import com.omar.microservice.dto.UserDTOMapper;
import com.omar.microservice.entity.User;
import com.omar.microservice.repository.UserRepository;

/**
 * @author Omar
 *
 */
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserRepository repository;

	// This method get all users from db
	@GetMapping(value = "/getAll", headers = "Accept=application/json")
	public List<UserDTO> getAllUsers() {
		return UserDTOMapper.INSTANCE.toUserDTOs(repository.findAll());
	}

	// Add user
	@PostMapping(value = "/add", consumes = "application/json", produces = "application/json")
	public UserDTO addUser(@RequestBody UserDTO userDTO) {
		User user = repository.add(UserDTOMapper.INSTANCE.toUser(userDTO));
		return UserDTOMapper.INSTANCE.toUserDTO(user);
	}

	// Delete user
	@GetMapping(value = "/delete", headers = "Accept=application/json")
	public void deleteUser(@RequestParam("id") long id) {
		repository.deleteById(id);
	}

}
