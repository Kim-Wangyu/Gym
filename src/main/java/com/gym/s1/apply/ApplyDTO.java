package com.gym.s1.apply;

import java.sql.Date;

public class ApplyDTO {
	private Long applyNum;
	private Long membershipNum;
	private Long trainerNum;
	private Date day;
	private Long time;
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
	public Long getTrainerNum() {
		return trainerNum;
	}
	public void setTrainerNum(Long trainerNum) {
		this.trainerNum = trainerNum;
	}
	public Date getDay() {
		return day;
	}
	public void setDay(Date day) {
		this.day = day;
	}
	public Long getTime() {
		return time;
	}
	public void setTime(Long time) {
		this.time = time;
	}
	public Long getCategory() {
		return category;
	}
	public void setCategory(Long category) {
		this.category = category;
	}
	
}

