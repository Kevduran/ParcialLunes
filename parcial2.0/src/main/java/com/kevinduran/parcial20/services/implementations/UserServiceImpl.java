package com.kevinduran.parcial20.services.implementations;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kevinduran.parcial20.models.dtos.SaveUserDTO;
import com.kevinduran.parcial20.models.entities.User;
import com.kevinduran.parcial20.repositories.UserRepository;
import com.kevinduran.parcial20.services.UserService;

import jakarta.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	@Transactional(rollbackOn = Exception.class)
	public void save(SaveUserDTO info) throws Exception {
		
		User newUser = new User();
		newUser.setUsername(info.getUsername());
		newUser.setEmail(info.getEmail());
		newUser.setPassword(info.getPassword());
		
		User user = userRepository.findOneByUsername(info.getUsername());
		
		if (user!=null) {
			throw new Exception("Usuario Duplicado");
		}else {
			userRepository.save(newUser);
		}
	}


	@Override
	public User findOneByUsername(String username) {
		return userRepository.findOneByUsername(username);
	}


	@Override
	public User findOneByCode(UUID uuid) throws Exception {
		return userRepository.findByCode(uuid);
	}

}
