package com.gym.s1.board.qna;

import java.util.List;

import com.gym.s1.board.BoardDTO;

public class QnaDTO extends BoardDTO{

	private List<QnaFileDTO> fileDTOs;

	public List<QnaFileDTO> getFileDTOs() {
		return fileDTOs;
	}

	public void setFileDTOs(List<QnaFileDTO> fileDTOs) {
		this.fileDTOs = fileDTOs;
	}
	
	
}
