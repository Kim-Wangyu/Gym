package com.gym.s1.member;

import java.sql.Date;

public class MembershipDTO {
	private Long membershipNum;
	private Long memberNum;
	private Long traNum;
	private Long count;
	private Long price;
	private Long locker;
	private Long clothes;
	private Date startDate;
	private Date finishDate;
	
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
	public Long getTraNum() {
		return traNum;
	}
	public void setTraNum(Long traNum) {
		this.traNum = traNum;
	}
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public Long getLocker() {
		return locker;
	}
	public void setLocker(Long locker) {
		this.locker = locker;
	}
	public Long getClothes() {
		return clothes;
	}
	public void setClothes(Long clothes) {
		this.clothes = clothes;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getFinishDate() {
		return finishDate;
	}
	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
	}
	
	
}
