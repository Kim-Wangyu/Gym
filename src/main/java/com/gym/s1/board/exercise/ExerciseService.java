package com.gym.s1.board.exercise;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gym.s1.board.BoardDTO;
import com.gym.s1.board.BoardService;
import com.gym.s1.util.Pager;
@Service
public class ExerciseService implements BoardService {
	
	@Autowired
	private ExerciseDAO exerciseDAO;
	
	@Override
	public int add(BoardDTO boardDTO) throws Exception {
		return exerciseDAO.add(boardDTO);
	}
	
	@Override
	public List<BoardDTO> list2(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		pager.makeNum();
		pager.makePageNum(exerciseDAO.total(pager));
		pager.setStartNum(1L);
		pager.setLastNum(5L);
		return exerciseDAO.list(pager);
	}

	@Override
	public List<BoardDTO> list(Pager pager) throws Exception {
		pager.makeNum();
		pager.makePageNum(exerciseDAO.total(pager));
		return exerciseDAO.list(pager);
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
