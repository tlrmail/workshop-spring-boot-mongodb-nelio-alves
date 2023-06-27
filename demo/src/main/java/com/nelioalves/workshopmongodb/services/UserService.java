package com.nelioalves.workshopmongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nelioalves.workshopmongodb.domain.User;
import com.nelioalves.workshopmongodb.dto.UserDTO;
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
		Optional<User> optional = repository.findOne(Example.of(new User(id,null,null)));
		User user = optional.get();
		if(user == null) {
			throw new ObjectNotFoundException("Objeto não encontrado.");
		}
		return user;
	}

	public User insert(User obj) {
		return repository.insert(obj);
	}
	
	public void delete(String id) {
		this.findById(id);
		repository.deleteById(id);
	}
	
	public User fromDTO(UserDTO userDTO) {
		return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
	}
}
