package com.gym.s1.board.exercise.exerciseReply;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ExerciseReplyDAO {
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.gym.s1.board.exercise.exerciseReply.ExerciseReplyDAO.";
	
	public int delete(ExerciseReplyDTO exerciseReplyDTO)throws Exception{
		return sqlSession.delete(NAMESPACE+"delete",exerciseReplyDTO);
	}
	
	public List<ExerciseReplyDTO> list(ExerciseReplyDTO exerciseReplyDTO)throws Exception{
		return sqlSession.selectList(NAMESPACE+"list",exerciseReplyDTO);
	}
	
	public int add(ExerciseReplyDTO exerciseReplyDTO)throws Exception{
		return sqlSession.insert(NAMESPACE+"add",exerciseReplyDTO);
	}
	
	public int update(ExerciseReplyDTO exerciseReplyDTO)throws Exception{
		return sqlSession.update(NAMESPACE+"update",exerciseReplyDTO);
	}
	
}
