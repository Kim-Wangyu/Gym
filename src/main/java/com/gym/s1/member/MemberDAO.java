package com.gym.s1.member;

import java.util.List;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.gym.s1.board.BoardDTO;
import com.gym.s1.util.Pager;
@Repository
public class MemberDAO {
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.gym.s1.member.MemberDAO.";
	
	public int join(MemberDTO memberDTO)throws Exception{
		return sqlSession.insert(NAMESPACE+"join",memberDTO);
	}

	public MemberDTO login(MemberDTO memberDTO)throws Exception{
		return sqlSession.selectOne(NAMESPACE+"login",memberDTO);
	}
	
	public int update(MemberDTO memberDTO)throws Exception{
		return sqlSession.update(NAMESPACE+"update",memberDTO);
	}
	public int pwupdate(MemberDTO memberDTO)throws Exception{
		return sqlSession.update(NAMESPACE+"pwupdate",memberDTO);
	}
	public List<MemberDTO>list(Pager pager) throws Exception{
		return sqlSession.selectList(NAMESPACE+"list",pager);
	}
	
	public MemberDTO detail(MemberDTO memberDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"detail",memberDTO);
	}
	public int upgrade(MemberDTO memberDTO)throws Exception{
		return sqlSession.update(NAMESPACE+"upgrade",memberDTO);
	}
	public Long total(Pager pager) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"total", pager);
	}
	public int trainerAdd(TrainerDTO trainerDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"trainerAdd",trainerDTO);
	}
	public int trainerUpdate(TrainerDTO trainerDTO)throws Exception{
		return sqlSession.update(NAMESPACE+"trainerUpdate",trainerDTO);
	}
	public TrainerDTO trainerDetail(TrainerDTO trainerDTO) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"trainerDetail",trainerDTO);
	}
	public List<TrainerDTO> select(TrainerDTO trainerDTO)throws Exception{
		return sqlSession.selectList(NAMESPACE+"select",trainerDTO);
	}
	public int buyAdd(MembershipDTO membershipDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"buyAdd",membershipDTO);
	}
	public int addFile(MemberFileDTO memberFileDTO)throws Exception{
		return sqlSession.insert(NAMESPACE+"addFile",memberFileDTO);
	}
	
}
