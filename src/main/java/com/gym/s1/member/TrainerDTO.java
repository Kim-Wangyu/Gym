package com.gym.s1.member;

import java.util.List;

public class TrainerDTO {
	private Long traNum;
	private Long memberNum;
	private String price;
	private Long category;
	private MemberDTO memberDTOs;
	

	public MemberDTO getMemberDTOs() {
		return memberDTOs;
	}
	public void setMemberDTOs(MemberDTO memberDTOs) {
		this.memberDTOs = memberDTOs;
	}
	public Long getTraNum() {
		return traNum;
	}
	public void setTraNum(Long traNum) {
		this.traNum = traNum;
	}
	public Long getMemberNum() {
		return memberNum;
	}
	public void setMemberNum(Long memberNum) {
		this.memberNum = memberNum;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public Long getCategory() {
		return category;
	}
	public void setCategory(Long category) {
		this.category = category;
	}
	
	
		
}
