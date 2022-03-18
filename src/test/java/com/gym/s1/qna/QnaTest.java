package com.gym.s1.qna;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.gym.s1.MyJunitTest;
import com.gym.s1.board.BoardDTO;
import com.gym.s1.board.qna.QnaDAO;
import com.gym.s1.board.qna.QnaDTO;

public class QnaTest extends MyJunitTest{

	@Autowired
	private QnaDAO qnaDAO;
	
	//@Test
	public void addTest() throws Exception{
		
		QnaDTO qnaDTO = new QnaDTO();
		qnaDTO.setTitle("t1");
		qnaDTO.setContents("c1");
		qnaDTO.setWriter("w1");
		
	
		int result = qnaDAO.add(qnaDTO);
		assertEquals(1, result);
	}
	
	//@Test
	public void listTest() throws Exception{
		List<BoardDTO> ar = qnaDAO.list();
		assertNotEquals(0, ar.size());
	}
	
	//@Test
	public void detailTest() throws Exception{
		QnaDTO qnaDTO = new QnaDTO();
		
		qnaDTO.setNum(1L);
		BoardDTO boardDTO= qnaDAO.detail(qnaDTO);
		assertNotNull(boardDTO);
	}
	
	//@Test
	public void deleteTest() throws Exception{
		QnaDTO qnaDTO = new QnaDTO();
		
		qnaDTO.setNum(28L);
		int result= qnaDAO.delete(qnaDTO);
		assertEquals(1, result);
	}
	
	@Test
	public void updateTest() throws Exception{
		QnaDTO qnaDTO = new QnaDTO();
		
		qnaDTO.setTitle("t1");
		qnaDTO.setContents("c1");
		qnaDTO.setNum(1L);
		
		int result = qnaDAO.update(qnaDTO);
		
		assertEquals(1, result);
	}


}
