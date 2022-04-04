package com.gym.s1.member;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.gym.s1.MyJunitTest;
import com.gym.s1.board.BoardDTO;
import com.gym.s1.util.Pager;

public class MemberTest extends MyJunitTest {
	
	@Autowired
	private MemberDAO memberDAO;
	
	//@Test
	public void joinTest()throws Exception{
		MemberDTO memberDTO = new MemberDTO();
		for(int i=0;i<50;i++) {
			memberDTO.setId("idid"+i);
		memberDTO.setName("tname"+i);
		memberDTO.setPw("pwpwpw"+i);
		memberDTO.setPhone("testph"+i);
		int result =memberDAO.join(memberDTO);
		
		assertEquals(result, 1);
		}
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
	//@Test
	public void pwupdate() throws Exception{
		MemberDTO memberDTO =new MemberDTO();
		memberDTO.setId("chaechae");
		memberDTO.setPw("chaerin");
		int result = memberDAO.pwupdate(memberDTO);
		assertNotNull(memberDTO);
	}
	//@Test
	public void list(Pager pager) throws Exception{
		List<MemberDTO> ar = memberDAO.list(pager);
		assertNotNull(ar);
	}
	//@Test
	public void upgrade() throws Exception{
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setMemberNum(43L);
		memberDTO.setGrade(1L);

		int result =memberDAO.upgrade(memberDTO);
		
		assertEquals(result, 1);
	}
	//@Test
	public void traup()throws Exception{
		TrainerDTO trainerDTO = new TrainerDTO();
		trainerDTO.setMemberNum(129L);
		trainerDTO.setPrice("80000");
		trainerDTO.setCategory(1L);
		int result =memberDAO.trainerUpdate(trainerDTO);
		
		assertEquals(result, 1);
	}
	@Test
	public void select()throws Exception{
		TrainerDTO trainerDTO = new TrainerDTO();
		List<MemberDTO> ar = memberDAO.select(trainerDTO);
		assertNotNull(ar);
	}
}
