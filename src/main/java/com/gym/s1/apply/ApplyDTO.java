package com.gym.s1.apply;

import java.sql.Date;

public class ApplyDTO {
	private Long applyNum;
	private Long membershipNum;
	private Long memberNum;
	private Date day;
	private String time; //1 9-10 2 10-11
	private Long category;
	public Long getApplyNum() {
		return applyNum;
	}
	public void setApplyNum(Long applyNum) {
		this.applyNum = applyNum;
	}
	public Long getMembershipNum() {
		return membershipNum;
	}
	public void setMembershipNum(Long membershipNum) {
		this.membershipNum = membershipNum;
	}
	public Long getMemberNum() {
		return memberNum;
	}
	public void setMemberNum(Long memberNum) {
		this.memberNum = memberNum;
	}
	public Date getDay() {
		return day;
	}
	public void setDay(Date day) {
		this.day = day;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Long getCategory() {
		return category;
	}
	public void setCategory(Long category) {
		this.category = category;
	}
	
	
	
}

