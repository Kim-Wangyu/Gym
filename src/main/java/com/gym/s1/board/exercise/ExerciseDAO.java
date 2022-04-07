package com.gym.s1.board.exercise;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.gym.s1.board.BoardDAO;
import com.gym.s1.board.BoardDTO;
import com.gym.s1.board.BoardFileDTO;
import com.gym.s1.util.Pager;

@Repository
public class ExerciseDAO implements BoardDAO {

	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE = "com.gym.s1.board.exercise.ExerciseDAO.";
	
	
	public Long total(Pager pager)throws Exception{
		return sqlSession.selectOne(NAMESPACE+"total",pager);
	}
	
	@Override
	public int add(BoardDTO boardDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"add",boardDTO);
	}

	@Override
	public List<BoardDTO> list(Pager pager) throws Exception {
		return sqlSession.selectList(NAMESPACE+"list",pager);
	}

	@Override
	public BoardDTO detail(BoardDTO boardDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"detail",boardDTO);
	}

	@Override
	public int delete(BoardDTO boardDTO) throws Exception {
		return sqlSession.delete(NAMESPACE+"delete",boardDTO);
	}

	@Override
	public int update(BoardDTO boardDTO) throws Exception {
		return sqlSession.update(NAMESPACE+"update",boardDTO);
	}
	
	public int addFile(BoardFileDTO boardFileDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"addFile", boardFileDTO);
		
	}
	public int deleteFile(BoardFileDTO boardFileDTO) throws Exception{
		return sqlSession.delete(NAMESPACE+"deleteFile",boardFileDTO);
	}


}
