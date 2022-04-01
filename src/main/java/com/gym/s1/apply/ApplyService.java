package com.gym.s1.apply;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplyService {
	@Autowired
	private ApplyDAO applyDAO;
	
	public int add(ApplyDTO applyDTO)throws Exception {
		return applyDAO.add(applyDTO);
	}
	
}
