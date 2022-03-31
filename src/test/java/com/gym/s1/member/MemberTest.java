package com.gym.s1.member;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.gym.s1.MyJunitTest;

public class MemberTest extends MyJunitTest {
	
	@Autowired
	private MemberDAO memberDAO;
	
	//@Test
	public void joinTest()throws Exception{
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("master");
		memberDTO.setName("testnamee");
		memberDTO.setPw("11");
		memberDTO.setPhone("testphone");
		int result =memberDAO.join(memberDTO);
		assertEquals(result, 1);
	}
	
	//@Test
	public void loginTest()throws Exception{
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("master");
		memberDTO.setPw("master");
		memberDTO = memberDAO.login(memberDTO);
		assertNotNull(memberDTO);
	}
	//@Test
	public void updateTest()throws Exception{
		MemberDTO memberDTO =new MemberDTO();
		memberDTO.setId("3333");
		memberDTO.setName("7777");
		memberDTO.setPhone("7777");
		int result = memberDAO.update(memberDTO);
		assertNotNull(memberDTO);
	}
	@Test
	public void pwupdate() throws Exception{
		MemberDTO memberDTO =new MemberDTO();
		memberDTO.setId("chaechae");
		memberDTO.setPw("chaerin");
		int result = memberDAO.pwupdate(memberDTO);
		assertNotNull(memberDTO);
	}

}
