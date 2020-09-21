/**
 * 
 */
package com.omar.microservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
	UserRepository reporitory;

	// This method get all users from db
	@RequestMapping(value = "/getAll", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<User> getAllUsers() {
		return reporitory.findAll();
	}

	@PostMapping(value = "/add", consumes = "application/json", produces = "application/json")
	public User addUser(@RequestBody User user) {
		return reporitory.add(user);
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET, headers = "Accept=application/json")
	public void addUser(@RequestParam("id") long id) {
		reporitory.deleteById(id);
	}

}
