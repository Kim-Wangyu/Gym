package com.gym.s1.exercise;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.gym.s1.MyJunitTest;
import com.gym.s1.board.exercise.exerciseReply.ExerciseReplyDAO;
import com.gym.s1.board.exercise.exerciseReply.ExerciseReplyDTO;

public class ExerciseReplyTest extends MyJunitTest {
	
	@Autowired
	private ExerciseReplyDAO exerciseReplyDAO;
	
	//@Test
	public void deleteTest()throws Exception{
		ExerciseReplyDTO exerciseReplyDTO = new ExerciseReplyDTO();
		exerciseReplyDTO.setReplyNum(1L);
		int result = exerciseReplyDAO.delete(exerciseReplyDTO);
		assertEquals(1, result);
	}
	
	//@Test
	public void listTest()throws Exception{
		ExerciseReplyDTO exerciseReplyDTO = new ExerciseReplyDTO();
		exerciseReplyDTO.setNum(482L);
		List<ExerciseReplyDTO> al= exerciseReplyDAO.list(exerciseReplyDTO);
		assertNotEquals(0, al);
	}
	
	//@Test
	public void addTest()throws Exception {
		ExerciseReplyDTO exerciseReplyDTO= new ExerciseReplyDTO();
		exerciseReplyDTO.setNum(286L);
		exerciseReplyDTO.setWriter("wirter3");
		exerciseReplyDTO.setContents("test");
		int result = exerciseReplyDAO.add(exerciseReplyDTO);
		assertEquals(1, result);
		
	}
	
	//@Test
	public void updateTest()throws Exception{
		ExerciseReplyDTO exerciseReplyDTO= new ExerciseReplyDTO();
		exerciseReplyDTO.setContents("test");
		exerciseReplyDTO.setReplyNum(86L);
		int result = exerciseReplyDAO.update(exerciseReplyDTO);
		assertEquals(1, result);
	}

}
