package com.gym.s1.noticeReplyTest;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.gym.s1.MyJunitTest;
import com.gym.s1.board.notice.reply.NoticeReplyDAO;
import com.gym.s1.board.notice.reply.NoticeReplyDTO;

public class NoticeReplyDAOTest extends MyJunitTest{

	@Autowired
	private NoticeReplyDAO noticeReplyDAO;
	
	//@Test
	public void addTest()throws Exception {
		NoticeReplyDTO noticeReplyDTO = new NoticeReplyDTO();
		noticeReplyDTO.setNum(500L);
		noticeReplyDTO.setContents("t1");
		noticeReplyDTO.setWriter("w1");
		
		int result= noticeReplyDAO.add(noticeReplyDTO);
		assertEquals(1, result);
		
	}
	
	//@Test
	public void listTest()throws Exception{
		NoticeReplyDTO noticeReplyDTO = new NoticeReplyDTO();
		List<NoticeReplyDTO> ar = noticeReplyDAO.list(noticeReplyDTO);
		assertNotEquals(0, ar.size());
	}
	
	//@Test
	public void updateTest()throws Exception{
	NoticeReplyDTO noticeReplyDTO = new NoticeReplyDTO();
	noticeReplyDTO.setReplyNum(22L);
	noticeReplyDTO.setContents("hhhhiiiih");
	int result = noticeReplyDAO.update(noticeReplyDTO);
	assertEquals(1, result);
	}
	
	//@Test
	public void deleteTest()throws Exception{
		NoticeReplyDTO noticeReplyDTO = new NoticeReplyDTO();
		noticeReplyDTO.setReplyNum(28L);
		int result= noticeReplyDAO.delete(noticeReplyDTO);
		assertEquals(1, result);
	}
}
