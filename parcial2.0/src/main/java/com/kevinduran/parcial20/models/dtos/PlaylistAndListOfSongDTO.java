package com.kevinduran.parcial20.models.dtos;

import java.util.List;
import java.util.Optional;

import com.kevinduran.parcial20.models.entities.Playlist;
import com.kevinduran.parcial20.models.entities.Song;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class PlaylistAndListOfSongDTO {

	@NotEmpty
	private Optional<Playlist> playlist;
	
	private List<Song> songs;

	public PlaylistAndListOfSongDTO(@NotEmpty Optional<Playlist> playlist, List<Song> songs) {
		super();
		this.playlist = playlist;
		this.songs = songs;
	}
	
}
