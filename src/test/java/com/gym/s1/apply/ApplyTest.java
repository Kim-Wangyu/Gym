package com.gym.s1.apply;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.gym.s1.MyJunitTest;

public class ApplyTest extends MyJunitTest{
	
	//멤버메서드 선언
	//접근지정자 [그외지정자] 리턴타입메서드명 메서드명(매개변수){메서드내용}	
	
	@Autowired
	private ApplyDAO applyDAO;

	
	//@Test
	public void dateTest()throws Exception{
		//Date date = new Date(2022,02,04);
		Date a = Date.valueOf("2022-02-04");
		System.out.println(a);
		
	}
	
	//@Test
	public void addTest()throws Exception {
		ApplyDTO applyDTO = new ApplyDTO();
		Date date = Date.valueOf("2022-02-04");
		applyDTO.setCategory(0L);
		applyDTO.setDay(date);
		applyDTO.setTime(1L);
		applyDTO.setTrainerNum(1L);
		int result = applyDAO.add(applyDTO);
		assertEquals(1, result);
	}
	

}
