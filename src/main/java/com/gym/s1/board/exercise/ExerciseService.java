package com.gym.s1.board.exercise;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gym.s1.board.BoardDTO;
import com.gym.s1.board.BoardService;
@Service
public class ExerciseService implements BoardService {
	
	@Autowired
	private ExerciseDAO exerciseDAO;
	
	@Override
	public int add(BoardDTO boardDTO) throws Exception {
		return exerciseDAO.add(boardDTO);
	}

	@Override
	public List<BoardDTO> list() throws Exception {
		return exerciseDAO.list();
	}

	@Override
	public BoardDTO detail(BoardDTO boardDTO) throws Exception {
		return exerciseDAO.detail(boardDTO);
	}

	@Override
	public int delete(BoardDTO boardDTO) throws Exception {
		return exerciseDAO.delete(boardDTO);
	}

	@Override
	public int update(BoardDTO boardDTO) throws Exception {
		return exerciseDAO.update(boardDTO);
	}

}
