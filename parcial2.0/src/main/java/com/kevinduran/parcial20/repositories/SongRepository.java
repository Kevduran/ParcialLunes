package com.kevinduran.parcial20.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.ListCrudRepository;

import com.kevinduran.parcial20.models.entities.Song;

public interface SongRepository 
			extends ListCrudRepository<Song, UUID> {

	List<Song> findByTitleContaining(String title);
	Song findByCode(UUID code);
}
