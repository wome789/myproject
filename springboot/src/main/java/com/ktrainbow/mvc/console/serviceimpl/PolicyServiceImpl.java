package com.ktrainbow.mvc.console.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ktrainbow.mvc.console.dao.ConsolePolicyMapper;
import com.ktrainbow.mvc.console.model.ConsolePolicy;
import com.ktrainbow.mvc.console.service.PolicyService;

@Service
public class PolicyServiceImpl implements PolicyService{

	@Autowired
	private ConsolePolicyMapper policyMapper;
		
	@Override
	@Transactional
	public int update(ConsolePolicy policy) {
		policy.setId(1);;
		if(null == policy.getId()) {
			return policyMapper.insertSelective(policy);
		}else {
			return policyMapper.updateByPrimaryKeySelective(policy);
		}
		
	}
	@Override
	public ConsolePolicy findById(Integer id) {
		return policyMapper.selectByPrimaryKey(id);
	}
	
	 
}
