package com.kevinduran.parcial20.repositories;

import java.util.UUID;

import org.springframework.data.repository.ListCrudRepository;

import com.kevinduran.parcial20.models.entities.User;

public interface UserRepository 
			extends ListCrudRepository<User, UUID>{

	User findOneByUsername(String username);
	
	User findByCode(UUID code);
	
}
