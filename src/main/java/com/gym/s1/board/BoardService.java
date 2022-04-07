package com.gym.s1.board;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.gym.s1.util.Pager;

public interface BoardService {
	
	public int add(BoardDTO boardDTO,MultipartFile[] files)throws Exception;
	
	public List<BoardDTO> list(Pager pager)throws Exception;
	
	public BoardDTO detail(BoardDTO boardDTO)throws Exception;
	
	public int delete(BoardDTO boardDTO)throws Exception;
	
	public int update(BoardDTO boardDTO,MultipartFile[] files)throws Exception;
	
	public List<BoardDTO> list2(Pager pager)throws Exception;
	
	
	
}
