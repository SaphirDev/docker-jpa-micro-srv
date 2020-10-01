package com.omar.microservice.dto;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.omar.microservice.entity.User;

@Mapper
public abstract class UserDTOMapper {

	public static final UserDTOMapper INSTANCE = Mappers.getMapper(UserDTOMapper.class);

	public abstract UserDTO toUserDTO(User user);

	public abstract User toUser(UserDTO userDTO);

	public abstract List<UserDTO> toUserDTOs(List<User> users);

}