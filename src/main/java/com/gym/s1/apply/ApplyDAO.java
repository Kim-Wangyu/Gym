package com.gym.s1.apply;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ApplyDAO {
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.gym.s1.apply.ApplyDAO.";
	
	public int addApply(ApplyDTO applyDTO)throws Exception{
		return sqlSession.insert(NAMESPACE+"addApply",applyDTO);
	}
}
