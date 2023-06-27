package com.nelioalves.workshopmongodb.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.nelioalves.workshopmongodb.domain.Post;
import com.nelioalves.workshopmongodb.domain.User;
import com.nelioalves.workshopmongodb.dto.AuthorDTO;
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
		postRepository.deleteAll();

		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		

		
		Post post01 = new Post(null, sdf.parse("21/03/2018"), "Partiu Viagem!", "Vou viajar para Sampa, abraços!", new AuthorDTO(maria));
		Post post02 = new Post(null, sdf.parse("23/08/2018"), "Bom dia!", "Acordei Feliz hoje!", new AuthorDTO(maria));
		
		postRepository.saveAll(Arrays.asList(post01, post02));
		maria.getPosts().addAll(Arrays.asList(post01, post02));
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
	}

}
