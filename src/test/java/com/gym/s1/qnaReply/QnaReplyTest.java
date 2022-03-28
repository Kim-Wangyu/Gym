package com.gym.s1.qnaReply;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.gym.s1.MyJunitTest;
import com.gym.s1.board.qna.qnaReply.QnaReplyDAO;
import com.gym.s1.board.qna.qnaReply.QnaReplyDTO;

public class QnaReplyTest extends MyJunitTest{
	@Autowired
	private QnaReplyDAO qnaReplyDAO;
	
	//@Test
	public void listTest() throws Exception {
		QnaReplyDTO qnaReplyDTO = new QnaReplyDTO();
		qnaReplyDTO.setNum(181L);
		List<QnaReplyDTO> ar = qnaReplyDAO.list(qnaReplyDTO);
		
		assertNotEquals(0, ar.size());
	}
	//@Test
	public void deleteTest() throws Exception{
		QnaReplyDTO qnaReplyDTO = new QnaReplyDTO();
		qnaReplyDTO.setReplyNum(12L);
		int result = qnaReplyDAO.delete(qnaReplyDTO);
		assertEquals(1, result);
	}
	//@Test
	
}
