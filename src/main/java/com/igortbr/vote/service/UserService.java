package com.igortbr.vote.service;

import java.util.List;

import com.igortbr.vote.dtos.UserDTO;
import com.igortbr.vote.model.User;

public interface UserService {
	void create(UserDTO userDTO);
	
	List<User> listAll();

	User listById(String id);
	
	void delete(String id);
	
	void update(UserDTO userDTO, String id);


}
