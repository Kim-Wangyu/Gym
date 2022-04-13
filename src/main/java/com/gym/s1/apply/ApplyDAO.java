package com.gym.s1.apply;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gym.s1.member.MemberDTO;
import com.gym.s1.member.MembershipDTO;
import com.gym.s1.member.TrainerDTO;

@Repository
public class ApplyDAO {
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.gym.s1.apply.ApplyDAO.";
	
	public int addApply(ApplyDTO applyDTO)throws Exception{
		return sqlSession.insert(NAMESPACE+"addApply",applyDTO);
	}
	
	public int apply(ApplyDTO applyDTO)throws Exception{
		return sqlSession.update(NAMESPACE+"apply",applyDTO);
	}
	public List<ApplyDTO> applyList(ApplyDTO applyDTO)throws Exception{
		return sqlSession.selectList(NAMESPACE+"applyList",applyDTO);
	}
	public MemberDTO trainerName(TrainerDTO trainerDTO)throws Exception{
		return sqlSession.selectOne(NAMESPACE+"trainerName",trainerDTO);
	}
	
	public List<ApplyDTO> timeList(ApplyDTO applyDTO)throws Exception{
		return sqlSession.selectList(NAMESPACE+"timeList",applyDTO);
	}
	
	public TrainerDTO findTraNum(TrainerDTO trainerDTO) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"findTraNum",trainerDTO);
	}
	public List<ApplyDTO> findApplyNum(ApplyDTO applyDTO) throws Exception{
		return sqlSession.selectList(NAMESPACE+"findApplyNum",applyDTO);
	}
	public MembershipDTO findMemberNum(MembershipDTO membershipDTO)throws Exception{
		return sqlSession.selectOne(NAMESPACE+"findMemberNum",membershipDTO);
	}
	public MembershipDTO findMembershipNum(MembershipDTO membershipDTO)throws Exception{
		return sqlSession.selectOne(NAMESPACE+"findMembershipNum",membershipDTO);
	}
	public MemberDTO findMemberName(MemberDTO memberDTO)throws Exception{
		return sqlSession.selectOne(NAMESPACE+"findMemberName",memberDTO);
	}
	public int countUpdate(MembershipDTO membershipDTO)throws Exception{
		return sqlSession.update(NAMESPACE+"countUpdate",membershipDTO);
	}
	public List<ApplyDTO> myApplyList(ApplyDTO applyDTO)throws Exception{
		return sqlSession.selectList(NAMESPACE+"myApplyList",applyDTO);
	}
	public List<ApplyDTO> myStudyList(ApplyDTO applyDTO)throws Exception{
		return sqlSession.selectList(NAMESPACE+"myStudyList",applyDTO);
	}
	public int applyDelete(ApplyDTO applyDTO)throws Exception{
		return sqlSession.update(NAMESPACE+"applyDelete",applyDTO);
	}
	public int studyDelete(ApplyDTO applyDTO)throws Exception{
		return sqlSession.delete(NAMESPACE+"studyDelete",applyDTO);
	}
	public ApplyDTO applyNum(ApplyDTO applyDTO)throws Exception{
		return sqlSession.selectOne(NAMESPACE+"applyNum",applyDTO);
	}
	public int setCount(MembershipDTO membershipDTO)throws Exception{
		return sqlSession.update(NAMESPACE+"setCount",membershipDTO);
	}
}
