package com.nelioalves.workshopmongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.nelioalves.workshopmongodb.domain.Post;
import com.nelioalves.workshopmongodb.domain.User;
import com.nelioalves.workshopmongodb.repository.PostRepository;
import com.nelioalves.workshopmongodb.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repository;
	
	public List<Post> findAll(){
		return repository.findAll(); 
	}
	
	public Post findById(String id) {
		Optional<Post> optional = repository.findOne(Example.of(new Post(id,null,null,null,null)));
		Post post = optional.get();
		if(post == null) {
			throw new ObjectNotFoundException("Objeto não encontrado.");
		}
		return post;
	}
	
	public List<Post> findByTitle(String text){
		return repository.searchTitle(text);
	}
}
