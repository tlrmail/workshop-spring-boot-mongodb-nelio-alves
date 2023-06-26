package com.nelioalves.workshopmongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.nelioalves.workshopmongodb.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

	
	
}
