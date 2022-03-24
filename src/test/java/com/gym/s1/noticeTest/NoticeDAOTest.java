package com.gym.s1.noticeTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.gym.s1.MyJunitTest;
import com.gym.s1.board.BoardDAO;
import com.gym.s1.board.BoardDTO;
import com.gym.s1.board.notice.NoticeDAO;
import com.gym.s1.board.notice.NoticeDTO;


public class NoticeDAOTest extends MyJunitTest {
	
	@Autowired
	private NoticeDAO noticeDAO;
	
	//@Test
	public void updateTest()throws Exception{
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setNum(3L);
		noticeDTO.setTitle("tup1");
		noticeDTO.setContents("cup1");
		
		int result = noticeDAO.update(noticeDTO);
		assertEquals(1, result);
	}
	
	@Test
	public void addTest() throws Exception{
		for(int i=0;i<200;i++) {
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setTitle("t"+i);
		noticeDTO.setContents("c"+i);
		noticeDTO.setWriter("w"+i);
		
		int result = noticeDAO.add(noticeDTO);
		}
		
	}
	
	//@Test 
	public void listTest() throws Exception{
	//	List<BoardDTO> ar =noticeDAO.list();
	//	assertNotEquals(0, ar.size());
	}
	
	//@Test
	public void detailTest()throws Exception{
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setNum(2L);
		
		BoardDTO boardDTO= noticeDAO.detail(noticeDTO);
		assertNotNull(boardDTO);
		
	}
	
	//@Test
	public void deleteTest()throws Exception{
		NoticeDTO noticeDTO = new NoticeDTO();
		//noticeDTO.setNum(2L);
		//noticeDTO.setTitle("t13");
		int result = noticeDAO.delete(noticeDTO);
		assertEquals(1, result);
		
	}


}
