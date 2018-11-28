package com.ktrainbow.mvc.console.service;

import com.ktrainbow.mvc.console.model.ConsoleWebSet;

public interface WebSetService {
	
	public int update(ConsoleWebSet webSet) ;
	
	public ConsoleWebSet findById(Integer id);

}
