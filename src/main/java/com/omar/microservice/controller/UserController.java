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
import com.omar.microservice.service.UserService;

/**
 * @author Omar
 *
 */
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	// This method get all users from db
	@GetMapping(value = "/getAll", headers = "Accept=application/json")
	public List<UserDTO> getAllUsers() {
		return userService.getAllUsers();
	}

	// Add user
	@PostMapping(value = "/add", consumes = "application/json", produces = "application/json")
	public UserDTO addUser(@RequestBody UserDTO userDTO) {
		return userService.addUser(userDTO);
	}

	// Delete user
	@GetMapping(value = "/delete", produces = "application/json")
	public String deleteUser(@RequestParam("id") long id) {
		return userService.deleteUser(id) ? "success" : "User not found!";
	}

}
