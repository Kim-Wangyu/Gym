package com.gym.s1.board.notice.reply;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoticeReplyService {
	
	@Autowired
	private NoticeReplyDAO noticeReplyDAO;
	
	public int add(NoticeReplyDTO noticeReplyDTO) throws Exception{
		return noticeReplyDAO.add(noticeReplyDTO);
	}
	
	public List<NoticeReplyDTO> list(NoticeReplyDTO noticeReplyDTO)throws Exception{
		return noticeReplyDAO.list(noticeReplyDTO);
	}

}
