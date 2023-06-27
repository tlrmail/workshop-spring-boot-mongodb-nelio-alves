package com.nelioalves.workshopmongodb.dto;

import java.io.Serializable;

import com.nelioalves.workshopmongodb.domain.User;

public class AuthorDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	
	public AuthorDTO() {

	}

	public AuthorDTO(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public AuthorDTO(User user) {
		this.id = user.getId();
		this.name = user.getName();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
}
