package com.kevinduran.parcial20.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.repository.ListCrudRepository;

import com.kevinduran.parcial20.models.entities.Playlist;
import com.kevinduran.parcial20.models.entities.User;

public interface PlaylistRepository 
			extends ListCrudRepository<Playlist, UUID> {

	Playlist findOneByTitle(String title);

	Optional<Playlist> findByTitleAndUserUsername(String nombrePlaylist, String username);
	
	List<Playlist> findByUserCodeAndTitleContaining(UUID id, String fragment);

	List<Playlist> findAllByUser(Optional<User> user);

	Optional<Playlist> findByUser(Optional<User> user);

	List<Playlist> findAllByUserAndTitleContaining(Optional<User> user, String fragment);

	Playlist findByCode(UUID uuid);

}
