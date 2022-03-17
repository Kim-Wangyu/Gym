package com.gym.s1.board;

import java.util.List;

public interface BoardDAO {
	//add, list, detail, delete, update
	
	public int add(BoardDTO boardDTO)throws Exception;
	
	public List<BoardDTO> list(BoardDTO boardDTO)throws Exception;
	
	public BoardDTO detail(BoardDTO boardDTO)throws Exception;
	
	public int delete(BoardDTO boardDTO)throws Exception;
	
	public int update(BoardDTO boardDTO)throws Exception;
	
}
