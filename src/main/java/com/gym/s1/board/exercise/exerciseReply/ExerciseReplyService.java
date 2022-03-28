package com.gym.s1.board.exercise.exerciseReply;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExerciseReplyService {
	@Autowired
	private ExerciseReplyDAO exerciseReplyDAO;
	
	public int delete(ExerciseReplyDTO exerciseReplyDTO)throws Exception{
		return exerciseReplyDAO.delete(exerciseReplyDTO);
	}
	
	public List<ExerciseReplyDTO> list(ExerciseReplyDTO exerciseReplyDTO)throws Exception{
		return exerciseReplyDAO.list(exerciseReplyDTO);
	}
	
	public int add(ExerciseReplyDTO exerciseReplyDTO)throws Exception{
		return exerciseReplyDAO.add(exerciseReplyDTO);
	}
	
	public int update(ExerciseReplyDTO exerciseReplyDTO)throws Exception{
		return exerciseReplyDAO.update(exerciseReplyDTO);
	}
}
