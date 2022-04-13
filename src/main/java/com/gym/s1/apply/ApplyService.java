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
	public MembershipDTO findMemberNum(MembershipDTO membershipDTO)throws Exception{
		return applyDAO.findMemberNum(membershipDTO);
	}
	public MemberDTO findMemberName(MemberDTO memberDTO)throws Exception{
		return applyDAO.findMemberName(memberDTO);
	}
	public int countUpdate(MembershipDTO membershipDTO)throws Exception{
		return applyDAO.countUpdate(membershipDTO);
	}
	public List<ApplyDTO> myApplyList(ApplyDTO applyDTO)throws Exception{
		return applyDAO.myApplyList(applyDTO);
	}
	public List<ApplyDTO> myStudyList(ApplyDTO applyDTO)throws Exception{
		return applyDAO.myStudyList(applyDTO);
	}
	public int applyDelete(ApplyDTO applyDTO)throws Exception{
		return applyDAO.applyDelete(applyDTO);
	}
	public int studyDelete(ApplyDTO applyDTO)throws Exception{
		return applyDAO.studyDelete(applyDTO);
	}
	public ApplyDTO applyNum(ApplyDTO applyDTO)throws Exception{
		return applyDAO.applyNum(applyDTO);
	}
	public int setCount(MembershipDTO membershipDTO)throws Exception{
		return applyDAO.setCount(membershipDTO);
	}
	
}
