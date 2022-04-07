package com.gym.s1.apply;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gym.s1.member.MemberDTO;
import com.gym.s1.member.MembershipDTO;
import com.gym.s1.member.TrainerDTO;

@Service
public class ApplyService {
	@Autowired
	private ApplyDAO applyDAO;
	
	public int addApply(ApplyDTO applyDTO)throws Exception {
		return applyDAO.addApply(applyDTO);
	}
	
	public int apply(ApplyDTO applyDTO)throws Exception{
		return applyDAO.apply(applyDTO);
	}
	

	public List<ApplyDTO> applyList(ApplyDTO applyDTO) throws Exception{
		return applyDAO.applyList(applyDTO);
	}
	
	public MemberDTO trainerName(TrainerDTO trainerDTO)throws Exception{
		return applyDAO.trainerName(trainerDTO);
	}
	
	public List<ApplyDTO> timeList(ApplyDTO applyDTO) throws Exception{
		return applyDAO.timeList(applyDTO);
	}
	public TrainerDTO findTraNum(TrainerDTO trainerDTO) throws Exception{
		return applyDAO.findTraNum(trainerDTO);
	}
	public List<ApplyDTO> findApplyNum(ApplyDTO applyDTO)throws Exception{
		return applyDAO.findApplyNum(applyDTO);
	}
	public MembershipDTO findMembershipNum(MembershipDTO membershipDTO)throws Exception{
		return applyDAO.findMembershipNum(membershipDTO);
	}
	
}
