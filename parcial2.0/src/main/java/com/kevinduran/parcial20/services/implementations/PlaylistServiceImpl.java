package com.kevinduran.parcial20.services.implementations;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kevinduran.parcial20.models.dtos.SavePlaylistDTO;
import com.kevinduran.parcial20.models.dtos.UserAndListOfPlaylistDTO;
import com.kevinduran.parcial20.models.entities.Playlist;
import com.kevinduran.parcial20.models.entities.User;
import com.kevinduran.parcial20.repositories.PlaylistRepository;
import com.kevinduran.parcial20.repositories.UserRepository;
import com.kevinduran.parcial20.services.PlaylistService;
import com.kevinduran.parcial20.services.UserService;

@Service
public class PlaylistServiceImpl implements PlaylistService {

	@Autowired
	private UserService userService;
	
	@Autowired
	private PlaylistRepository playlistRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void save(SavePlaylistDTO info) throws Exception {
		
		User user = userService.findOneByUsername(info.getUser());
		
		if (user != null) {
			
			try {
				Playlist newPlaylist= new Playlist();
				
				newPlaylist.setTitle(info.getTitle());
				newPlaylist.setDescription(info.getDescription());
				newPlaylist.setUser(user);
				
				playlistRepository.save(newPlaylist);
				
			} catch (Exception e) {
				throw new Exception("Internal Server Error");
			}
		}else {
			throw new Exception("Usuario Inexistente");
		}
		
	}

	@Override
	public boolean existPlaylistRepeted(String nombrePlaylist, String username) {
		return playlistRepository.findByTitleAndUserUsername(nombrePlaylist, username).isPresent();
	}

	@Override
	public List<Playlist> showAllCoincidences(UUID id, String fragment) {
		return playlistRepository.findByUserCodeAndTitleContaining(id, fragment);
	}

	@Override
	public UserAndListOfPlaylistDTO getUserAndPlaylists(UUID uuid) throws Exception {
		Optional<User> user = userRepository.findById(uuid);
		
		if(user!=null) {
			List<Playlist> playlists = playlistRepository.findAllByUser(user);
			return new UserAndListOfPlaylistDTO(user, playlists);
		}else {
			throw new Exception();
		}
		
		
	}

	@Override
	public UserAndListOfPlaylistDTO getUserAndPlaylistsWithFragment(UUID uuid, String fragment) throws Exception {
		Optional<User> user = userRepository.findById(uuid);
		
		if(user!=null) {
			List<Playlist> playlists = playlistRepository.findAllByUserAndTitleContaining(user, fragment);
			return new UserAndListOfPlaylistDTO(user, playlists);
		}else {
			throw new Exception();
		}
	}

	/*
	@Override
	public List<Playlist> findAllByUserId(UUID id) {
		return playlistRepository.findAllByUserCode(id);
	}*/

	
	

}
