package com.gym.s1.board.exercise;

import java.util.List;

import com.gym.s1.board.BoardDTO;

public class ExerciseDTO extends BoardDTO {
	
	private List<ExerciseFileDTO> exFileDTOs;

	public List<ExerciseFileDTO> getExFileDTOs() {
		return exFileDTOs;
	}

	public void setExFileDTOs(List<ExerciseFileDTO> exFileDTOs) {
		this.exFileDTOs = exFileDTOs;
	}
	
	

}
