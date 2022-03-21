package com.gym.s1.exercise;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.gym.s1.MyJunitTest;
import com.gym.s1.board.BoardDTO;
import com.gym.s1.board.exercise.ExerciseDAO;

public class ExerciseTest extends MyJunitTest{

	@Autowired
	private ExerciseDAO exerciseDAO;
	
	//@Test
	public void addTest()throws Exception {
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setContents("testContents");
		boardDTO.setTitle("testTitle");
		boardDTO.setWriter("testWriter");
		int result = exerciseDAO.add(boardDTO);
		assertEquals(result, 1);
	}
	
	//@Test
//	public void listTest()throws Exception{
//		
//		List<BoardDTO> ar = exerciseDAO.list();
//		assertNotEquals(0, ar.size());
//	}
	
	//@Test
	public void detailTest()throws Exception{
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setNum(21L);
		boardDTO = exerciseDAO.detail(boardDTO);
		assertNotNull(boardDTO);
	}
	
	//@Test
	public void deleteTest()throws Exception{
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setNum(21L);
		int result = exerciseDAO.delete(boardDTO);
		assertEquals(1, result);
	}
	
	@Test
	public void updateTest()throws Exception{
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setTitle("tsfs");
		boardDTO.setNum(3L);
		boardDTO.setContents("sfst");
		int result = exerciseDAO.update(boardDTO);
		assertEquals(1, result);
	}

}
