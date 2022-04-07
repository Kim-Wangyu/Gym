package com.gym.s1.board;

import java.util.List;


import com.gym.s1.util.Pager;


public interface BoardDAO {
	//add, list, detail, delete, update
	
	public int addFile(BoardFileDTO boardFileDTO) throws Exception;
	
	public int add(BoardDTO boardDTO)throws Exception;
	
	public List<BoardDTO> list(Pager pager)throws Exception;
	
	public BoardDTO detail(BoardDTO boardDTO)throws Exception;
	
	public int delete(BoardDTO boardDTO)throws Exception;
	
	public int update(BoardDTO boardDTO)throws Exception;

	public Long total(Pager pager)throws Exception;
	





	
}
