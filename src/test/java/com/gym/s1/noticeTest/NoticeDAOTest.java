package com.gym.s1.noticeTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.gym.s1.MyJunitTest;
import com.gym.s1.board.notice.NoticeDAO;
import com.gym.s1.board.notice.NoticeDTO;


public class NoticeDAOTest extends MyJunitTest {
	
	@Autowired
	private NoticeDAO noticeDAO;
	
	@Test
	public void addTest() throws Exception{
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setTitle("t3");
		noticeDTO.setContents("c3");
		noticeDTO.setWriter("w3");
		
		int result = noticeDAO.add(noticeDTO);
		assertEquals(1, result);
	}
	
	


}
