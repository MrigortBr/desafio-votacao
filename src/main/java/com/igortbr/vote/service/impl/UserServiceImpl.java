package com.igortbr.vote.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.igortbr.vote.dtos.UserDTO;
import com.igortbr.vote.exception.CustomException;
import com.igortbr.vote.exception.ErrorResponse;
import com.igortbr.vote.model.User;
import com.igortbr.vote.repository.UserRepository;
import com.igortbr.vote.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;
	
	@Override
	public void create(UserDTO userDTO) {
		User user = new User();
		user.setName(userDTO.getName());
		user.setCpf(userDTO.getCpf());
		repository.save(user);
	}

	@Override
	public List<User> listAll() {
		return repository.findAll();
	}

	@Override
	public User listById(String id) {
		return repository.findById(Long.parseLong(id)).orElseThrow(() -> new CustomException(ErrorResponse.USER_ID_NOT_EXISTS));
	}

	@Override
	public void delete(String id) {
		User user = listById(id);
		
		if (user != null) {
			repository.delete(user);
		}
		
	}

	@Override
	public void update(UserDTO userDTO, String id) {
		userDTO.setId(id);
        User user = listById(userDTO.getId());
        
        if (userDTO.getName() != null ) user.setName(userDTO.getName());
        if (userDTO.getCpf() != null ) user.setCpf(userDTO.getCpf());
        repository.save(user);
	}

}
