package com.kevinduran.parcial20.services;

import java.util.List;

import com.kevinduran.parcial20.models.entities.Song;

public interface SongService {

	public List<Song> findAll();
	List<Song> findByTitle(String fragment);
}
