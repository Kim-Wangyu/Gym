package com.gym.s1.apply;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplyService {
	@Autowired
	private ApplyDAO applyDAO;
}
