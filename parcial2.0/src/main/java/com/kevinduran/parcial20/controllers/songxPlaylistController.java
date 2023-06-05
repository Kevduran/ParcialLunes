package com.kevinduran.parcial20.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kevinduran.parcial20.models.dtos.MessageDTO;
import com.kevinduran.parcial20.models.dtos.SaveSongDTO;
import com.kevinduran.parcial20.services.SongxPlaylistService;

@RestController
@RequestMapping("/playlist")
public class songxPlaylistController {

	@Autowired
	private SongxPlaylistService songxPlaylistService;
	
	//@Autowired
	//private PlaylistService playlistService;
	
	@PostMapping("/add/{playlist_code}")
	public ResponseEntity<?> addCancionToPlaylist(@PathVariable String playlist_code, 
											@RequestBody SaveSongDTO saveSong){
		
		UUID playlist_codeUuid = UUID.fromString(playlist_code);
		
		UUID song_codeUuid = UUID.fromString(saveSong.getCode_song());
		
		songxPlaylistService.save(playlist_codeUuid, song_codeUuid);
		
		return new ResponseEntity<>(new MessageDTO("Cancion Agregada a la Playlist"), HttpStatus.CREATED);
		
	}
	
	/*
	
	@GetMapping("/{playlist}")
	public ResponseEntity<?> findallsongs(@PathVariable("playlist") UUID playlist){
		if(playlist == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró codigo de playlist");
		}
		Playlist playlist = playlistService.findByCode(playlist);
		
		if(playlistSongs == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró ningúna playlist con el identificador proporcionado");
		}else {
			List<SongXPlaylist> songs= songXplayService.findSongsByPlaylist(playlistSongs);
			return new ResponseEntity<>(songs, HttpStatus.OK);
		}
		*/
}
