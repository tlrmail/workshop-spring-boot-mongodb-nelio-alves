package com.nelioalves.workshopmongodb.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.nelioalves.workshopmongodb.domain.User;
import com.nelioalves.workshopmongodb.repository.UserRepository;

@Configuration
public class Instatiation implements CommandLineRunner{

	@Autowired
	private UserRepository repository;
	
	@Override
	public void run(String... args) throws Exception {

		repository.deleteAll();

		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		repository.saveAll(Arrays.asList(maria, alex, bob));
		
	}

}
