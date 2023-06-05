package com.kevinduran.parcial20.models.dtos;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class SaveSongDTO {

	@NotEmpty
	private String code_song;	
	
}
