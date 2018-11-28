package com.ktrainbow.mvc.console.service;

import com.ktrainbow.mvc.console.model.ConsolePolicy;

public interface PolicyService {
	
	public int update(ConsolePolicy policy);
	
	public ConsolePolicy findById(Integer id);

}
