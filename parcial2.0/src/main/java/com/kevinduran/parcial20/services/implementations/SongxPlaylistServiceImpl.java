package com.kevinduran.parcial20.services.implementations;

import java.sql.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kevinduran.parcial20.models.entities.Playlist;
import com.kevinduran.parcial20.models.entities.Song;
import com.kevinduran.parcial20.models.entities.SongxPlaylist;
import com.kevinduran.parcial20.repositories.PlaylistRepository;
import com.kevinduran.parcial20.repositories.SongRepository;
import com.kevinduran.parcial20.repositories.SongxPlaylistRepository;
import com.kevinduran.parcial20.services.SongxPlaylistService;

@Service
public class SongxPlaylistServiceImpl implements SongxPlaylistService{

	@Autowired
	private SongRepository songRepository;
	
	@Autowired
	private PlaylistRepository playlistRepository;
	
	@Autowired
	private SongxPlaylistRepository songxPlaylistRepository;
	
	@Override
	public void save(UUID playlist_code, UUID song_code) {
		
		//TODO: Verificar que existan las canciones y no e dupliquen
		
		Song song = songRepository.findByCode(song_code);
		Playlist playlist = playlistRepository.findByCode(playlist_code);
		
		
		SongxPlaylist songxPlaylist = new SongxPlaylist();
		
		songxPlaylist.setSong(song);
		songxPlaylist.setPlaylist(playlist);
		Date date = new Date(0);
		songxPlaylist.setDate_added(date);
		
		songxPlaylistRepository.save(songxPlaylist);
		
	}
	
}
