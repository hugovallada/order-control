package com.github.hugovallada.orderscontrol.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.hugovallada.orderscontrol.entities.User;
import com.github.hugovallada.orderscontrol.repositories.UserRepository;

@Service
public class UserService {
	
	private UserRepository repository;
	
	@Autowired
	public UserService(UserRepository repository) {
		this.repository = repository;
	}
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> user = repository.findById(id);
		return user.get();
	}
}
