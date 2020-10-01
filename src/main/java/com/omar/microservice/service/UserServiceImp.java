/**
 * 
 */
package com.omar.microservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.omar.microservice.dto.UserDTO;
import com.omar.microservice.dto.UserDTOMapper;
import com.omar.microservice.entity.User;
import com.omar.microservice.repository.UserRepository;

/**
 * @author Omar
 *
 */
@Service
public class UserServiceImp implements UserService {

	@Autowired
	UserRepository reporitory;

	@Override
	public List<UserDTO> getAllUsers() {
		return UserDTOMapper.INSTANCE.toUserDTOs(reporitory.findAll());

	}

	@Override
	public UserDTO addUser(UserDTO userDTO) {
		User user = reporitory.add(UserDTOMapper.INSTANCE.toUser(userDTO));
		return UserDTOMapper.INSTANCE.toUserDTO(user);
	}

	@Override
	public boolean deleteUser(long id) {
		User user = reporitory.findById(id);
		if (user != null) {
			reporitory.deleteById(id);
			return true;
		}
		return false;
	}

}
