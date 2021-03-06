package com.gym.s1.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.gym.s1.board.BoardDTO;
import com.gym.s1.util.FileManager;
import com.gym.s1.util.Pager;

@Service
public class MemberService {
	
	@Autowired
	private MemberDAO memberDAO;
	@Autowired
	private FileManager fileManager;
	
	public int join(MemberDTO memberDTO, MultipartFile file)throws Exception{
		int result = memberDAO.join(memberDTO);
	
			String fileName=fileManager.save(file, "resources/upload/member/");
				
			MemberFileDTO memberFileDTO = new MemberFileDTO();
			memberFileDTO.setMemberNum(memberDTO.getMemberNum());
			memberFileDTO.setFileName(fileName);
			memberFileDTO.setOriName(file.getOriginalFilename());
				
			result = memberDAO.addFile(memberFileDTO);
			
		return result;
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
	public List<TrainerDTO> select(TrainerDTO trainerDTO)throws Exception{
		return memberDAO.select(trainerDTO);
	}
	public int buyAdd(MembershipDTO membershipDTO)throws Exception{
		return memberDAO.buyAdd(membershipDTO);
	}

	public MembershipDTO mypage(MembershipDTO membershipDTO)throws Exception{
		return memberDAO.mypage(membershipDTO);
	}
	public int deleteTrainer(TrainerDTO trainerDTO)throws Exception{
		return memberDAO.deleteTrainer(trainerDTO);

	}

}
