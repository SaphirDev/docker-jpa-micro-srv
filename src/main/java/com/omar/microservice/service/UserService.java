/**
 * 
 */
package com.omar.microservice.service;

import java.util.List;

import com.omar.microservice.dto.UserDTO;

/**
 * @author Omar
 *
 */
public interface UserService {

	public List<UserDTO> getAllUsers();

	public UserDTO addUser(UserDTO userDTO);

	public boolean deleteUser(long id);

}
