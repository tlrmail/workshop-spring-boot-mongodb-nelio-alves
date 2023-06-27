package com.nelioalves.workshopmongodb.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.nelioalves.workshopmongodb.domain.Post;
import com.nelioalves.workshopmongodb.domain.User;
import com.nelioalves.workshopmongodb.repository.PostRepository;
import com.nelioalves.workshopmongodb.repository.UserRepository;

@Configuration
public class Instatiation implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		userRepository.deleteAll();

		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		Post post01 = new Post(null, sdf.parse("21/03/2018"), "Partiu Viagem!", "Vou viajar para Sampa, abraços!", maria);
		Post post02 = new Post(null, sdf.parse("23/08/2018"), "Bom dia!", "Acordei Feliz hoje!", maria);
		
		postRepository.saveAll(Arrays.asList(post01, post02));
	}

}
