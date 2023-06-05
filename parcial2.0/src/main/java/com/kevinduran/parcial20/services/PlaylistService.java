package com.kevinduran.parcial20.services;

import java.util.List;
import java.util.UUID;

import com.kevinduran.parcial20.models.dtos.SavePlaylistDTO;
import com.kevinduran.parcial20.models.dtos.UserAndListOfPlaylistDTO;
import com.kevinduran.parcial20.models.entities.Playlist;

public interface PlaylistService {

	void save(SavePlaylistDTO info) throws Exception;
	public boolean existPlaylistRepeted(String nombrePlaylist, String username);
	List<Playlist> showAllCoincidences(UUID id, String fragment);
	UserAndListOfPlaylistDTO getUserAndPlaylists(UUID uuid) throws Exception;
	UserAndListOfPlaylistDTO getUserAndPlaylistsWithFragment(UUID uuid, String fragment) throws Exception;
}
