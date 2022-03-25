package com.gym.s1.board.notice.reply;

import java.sql.Date;

public class NoticeReplyDTO {

	private Long replyNum;
	private Long Num;
	private String contents;
	private String writer;
	private Date regDate;
	
	
	
	public Long getReplyNum() {
		return replyNum;
	}
	public void setReplyNum(Long replyNum) {
		this.replyNum = replyNum;
	}
	public Long getNum() {
		return Num;
	}
	public void setNum(Long num) {
		Num = num;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
	
	
}
