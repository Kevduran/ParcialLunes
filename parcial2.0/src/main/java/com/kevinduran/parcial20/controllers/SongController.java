package com.kevinduran.parcial20.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kevinduran.parcial20.models.entities.Song;
import com.kevinduran.parcial20.services.SongService;

@RestController
@RequestMapping("/song")
public class SongController {

	@Autowired
	private SongService songService;
	
	@GetMapping("/")
	public ResponseEntity<?> findAllSong(@RequestParam(value = "fragment", required = false) String fragment){
		
		if (fragment != null) {
			List<Song> songs = songService.findByTitle(fragment);
			return new ResponseEntity<>(songs, HttpStatus.OK);
		}else {
			List<Song> songs = songService.findAll();
			return new ResponseEntity<>(songs, HttpStatus.OK);
		}
		
	}
	
}
