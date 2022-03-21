package com.gym.s1.qna;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.gym.s1.MyJunitTest;
import com.gym.s1.board.BoardDTO;
import com.gym.s1.board.qna.QnaDAO;
import com.gym.s1.board.qna.QnaDTO;
import com.gym.s1.util.Pager;

public class QnaTest extends MyJunitTest{

	@Autowired
	private QnaDAO qnaDAO;
	
	//@Test
	public void addTest() throws Exception{
		for(int i=1;i<=100;i++) {
		QnaDTO qnaDTO = new QnaDTO();
		qnaDTO.setTitle("t"+i);
		qnaDTO.setContents("c"+i);
		qnaDTO.setWriter("w"+i);
		int result = qnaDAO.add(qnaDTO);
			
		}	
		System.out.println("add finish");
	
	
	}
	
	//@Test
	public void listTest(Pager pager) throws Exception{
		List<BoardDTO> ar = qnaDAO.list(pager);
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
	
	//@Test
	public void updateTest() throws Exception{
		QnaDTO qnaDTO = new QnaDTO();
		
		qnaDTO.setTitle("t1");
		qnaDTO.setContents("c1");
		qnaDTO.setNum(1L);
		
		int result = qnaDAO.update(qnaDTO);
		
		assertEquals(1, result);
	}


}
