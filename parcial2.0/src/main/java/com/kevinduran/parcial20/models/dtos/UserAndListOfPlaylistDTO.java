package com.kevinduran.parcial20.models.dtos;

import java.util.List;
import java.util.Optional;

import com.kevinduran.parcial20.models.entities.Playlist;
import com.kevinduran.parcial20.models.entities.User;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class UserAndListOfPlaylistDTO {

	@NotEmpty
	private Optional<User> user;
	
	
	private List<Playlist> playlists;

	public UserAndListOfPlaylistDTO(Optional<User> user, List<Playlist> playlists2) {
		this.user = user;
		this.playlists = playlists2;
	}
	
	
}
