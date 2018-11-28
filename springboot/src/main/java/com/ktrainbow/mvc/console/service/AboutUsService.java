package com.ktrainbow.mvc.console.service;

import com.ktrainbow.mvc.console.model.ConsoleAboutUs;

public interface AboutUsService {
	
	public int update(ConsoleAboutUs aboutUs);
	
	public ConsoleAboutUs findById(Integer id);

}
