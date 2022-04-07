package com.gym.s1.apply;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.gym.s1.MyJunitTest;

public class ApplyTest extends MyJunitTest{
	
	//멤버메서드 선언
	//접근지정자 [그외지정자] 리턴타입메서드명 메서드명(매개변수){메서드내용}	
	
	@Autowired
	private ApplyDAO applyDAO;
	
	//@Test
	public void traName()throws Exception{
		ApplyDTO applyDTO = new ApplyDTO();
		applyDTO.setTraNum(4L);
		Date a = Date.valueOf("2022-4-12");
		applyDTO.setDay(a);
		List<ApplyDTO> ar = applyDAO.timeList(applyDTO);
		assertNotEquals(0, ar.size());
	}
	
	//@Test
	public void applyTest()throws Exception{
		ApplyDTO applyDTO = new ApplyDTO();
		applyDTO.setApplyNum(101L);
		applyDTO.setMembershipNum(1L);
		int result = applyDAO.apply(applyDTO);
		assertEquals(1, result);
	}
	
	
	//@Test
	public void substringTest()throws Exception{
		String a = "12:00~13:00";
		int c = 0;
		if(a.substring(0,2).equals("9:")) {
			c = 1;
		}else if(a.substring(0,2).equals("10")) {
			c = 2;
		}else if(a.substring(0,2).equals("11")) {
			c = 3;
		}else if(a.substring(0,2).equals("12")) {
			c = 4;
		}else if(a.substring(0,2).equals("13")) {
			c = 5;
		}
		else if(a.substring(0,2).equals("14")) {
			c = 6;
		}
		else if(a.substring(0,2).equals("15")) {
			c = 7;
		}else if(a.substring(0,2).equals("16")) {
			c = 8;
		}else if(a.substring(0,2).equals("17")){
			c = 9;
		}else {
			c= 10;
		}
		System.out.println(c);
	}
	
	//@Test
	public void replaceTest()throws Exception{
		String a ="2022년3월2일";
		String b ="2022년3월21일";
		String c ="2022년10월2일";
		String d ="2022년11월12일";
		a=a.replace("년","-");
		a=a.replace("월","-");
		a=a.replace("일","");
		b=b.replace("년","-");
		b=b.replace("월","-");
		b=b.replace("일","");
		d=d.replace("년","-");
		d=d.replace("월","-");
		d=d.replace("일","");
		c=c.replace("년","-");
		c=c.replace("월","-");
		c=c.replace("일","");
		
		System.out.println(a);

		System.out.println(b);

		System.out.println(c);

		System.out.println(d);
		
	}

	//@Test
	public void dateTest()throws Exception{
		//Date date = new Date(2022,02,04);
		Date a = Date.valueOf("2022-2-4");
		System.out.println(a);
		
	}
	
	//@Test
	public void addTest()throws Exception {
		ApplyDTO applyDTO = new ApplyDTO();
		Date date = Date.valueOf("2022-2-4");
		applyDTO.setCategory(0L);
		applyDTO.setDay(date);
		applyDTO.setTime("1");
		applyDTO.setTraNum(246L);
		int result = applyDAO.addApply(applyDTO);
		assertEquals(1, result);
	}
	

}
