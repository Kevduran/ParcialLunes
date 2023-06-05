package com.kevinduran.parcial20.services;

import java.util.UUID;

import com.kevinduran.parcial20.models.dtos.SaveUserDTO;
import com.kevinduran.parcial20.models.entities.User;

public interface UserService {

	public void save(SaveUserDTO info) throws Exception;

	public User findOneByUsername(String username) throws Exception;
	
	User findOneByCode(UUID uuid) throws Exception;
	
}
