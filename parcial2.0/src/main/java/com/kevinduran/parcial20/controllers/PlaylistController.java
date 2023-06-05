package com.kevinduran.parcial20.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kevinduran.parcial20.models.dtos.MessageDTO;
import com.kevinduran.parcial20.models.dtos.SavePlaylistDTO;
import com.kevinduran.parcial20.services.PlaylistService;
import com.kevinduran.parcial20.utils.RequestErrorHandler;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/playlist")
public class PlaylistController {

	@Autowired
	private PlaylistService playlistService;
	
	@Autowired
	private RequestErrorHandler errorHandler;
	
	@PostMapping("/")
	public ResponseEntity<?> savePlaylist(@RequestBody @Valid SavePlaylistDTO info, BindingResult validations){
		if (validations.hasErrors()) {
			return new ResponseEntity<>(
					errorHandler.mapErrors(validations.getFieldErrors()),
					HttpStatus.BAD_REQUEST);
		}
		
		try {
			
			boolean bool = playlistService.existPlaylistRepeted(info.getTitle(), info.getUser());
			
			if (bool) {
				return new ResponseEntity<>( new MessageDTO("Playlist ya existe para este usuario"), HttpStatus.BAD_REQUEST);
			}else {
				playlistService.save(info);
				return new ResponseEntity<>( new MessageDTO("Playlist creada con exito"), HttpStatus.CREATED);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(new MessageDTO("Ha sucedido un Error"), HttpStatus.BAD_REQUEST);
		}
		
	}
	
}
