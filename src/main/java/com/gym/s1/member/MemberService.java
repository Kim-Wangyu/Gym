package com.gym.s1.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gym.s1.board.BoardDTO;
import com.gym.s1.util.Pager;

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
	public List<MemberDTO> list(Pager pager) throws Exception{
		pager.makeNum();
		pager.makePageNum(memberDAO.total(pager));
		List<MemberDTO>ar = memberDAO.list(pager);
		return ar;
	}
	public MemberDTO detail(MemberDTO memberDTO)throws Exception{
		return memberDAO.detail(memberDTO);
	}
	public int upgrade(MemberDTO memberDTO)throws Exception{
		return memberDAO.upgrade(memberDTO);
	}

	public int trainerAdd(TrainerDTO trainerDTO) throws Exception{ 
		return memberDAO.trainerAdd(trainerDTO);
	}
	public int trainerUpdate(TrainerDTO trainerDTO)throws Exception{
		return memberDAO.trainerUpdate(trainerDTO);
	}
	public TrainerDTO trainerDetail(TrainerDTO trainerDTO) throws Exception{
		return memberDAO.trainerDetail(trainerDTO);
	}

}
