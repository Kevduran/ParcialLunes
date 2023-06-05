package com.kevinduran.parcial20.repositories;

import java.util.UUID;

import org.springframework.data.repository.ListCrudRepository;

import com.kevinduran.parcial20.models.entities.SongxPlaylist;

public interface SongxPlaylistRepository 
		extends ListCrudRepository<SongxPlaylist, UUID> {

	
	
}
