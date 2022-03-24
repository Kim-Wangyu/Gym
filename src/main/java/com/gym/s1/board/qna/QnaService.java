package com.gym.s1.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gym.s1.board.BoardDTO;
import com.gym.s1.board.BoardService;
import com.gym.s1.util.Pager;

@Service
public class QnaService implements BoardService{
	
	@Autowired
	private QnaDAO qnaDAO;
	
	public int add(BoardDTO boardDTO) throws Exception{
		return qnaDAO.add(boardDTO);
	}
	
	public List<BoardDTO> list(Pager pager) throws Exception{
		pager.makeNum();
		pager.makePageNum(qnaDAO.total(pager));
		List<BoardDTO>ar = qnaDAO.list(pager);
		return ar;
	}

	@Override
	public BoardDTO detail(BoardDTO boardDTO) throws Exception {
		
		return qnaDAO.detail(boardDTO);
	}

	@Override
	public int delete(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.delete(boardDTO);
	}

	@Override
	public int update(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.update(boardDTO);

	}
	

	

}
