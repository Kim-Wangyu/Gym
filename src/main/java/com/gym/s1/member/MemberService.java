package com.gym.s1.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
	
	@Autowired
	private MemberDAO memberDAO;
	
	public int join(MemberDTO memberDTO)throws Exception{
		return memberDAO.join(memberDTO);
	}
	
	public MemberDTO login(MemberDTO memberDTO)throws Exception{
		return memberDAO.login(memberDTO);
	}
	public int update(MemberDTO memberDTO)throws Exception{
		return memberDAO.update(memberDTO);
	}
	public int pwupdate(MemberDTO memberDTO)throws Exception{
		return memberDAO.pwupdate(memberDTO);
	}
}
