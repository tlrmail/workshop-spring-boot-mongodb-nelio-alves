package com.nelioalves.workshopmongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nelioalves.workshopmongodb.domain.User;
import com.nelioalves.workshopmongodb.repository.UserRepository;
import com.nelioalves.workshopmongodb.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll(); 
	}
	
	public User findById(String id) {
		Optional<User> optional = repository.findById(id);
		User user = optional.get();
		if(user == null) {
			throw new ObjectNotFoundException("Objeto não encontrado.");
		}
		return user;
	}
	
}
