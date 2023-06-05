package com.kevinduran.parcial20.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kevinduran.parcial20.models.entities.Song;
import com.kevinduran.parcial20.repositories.SongRepository;
import com.kevinduran.parcial20.services.SongService;

@Service
public class SongServiceImpl implements SongService {

	@Autowired
	private SongRepository songRepository;
	
	@Override
	public List<Song> findAll() {
		return songRepository.findAll();
	}

	@Override
	public List<Song> findByTitle(String fragment) {
		
		return songRepository.findByTitleContaining(fragment);
		
	}
	
}
