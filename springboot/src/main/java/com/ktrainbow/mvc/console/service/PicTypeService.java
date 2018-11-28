package com.ktrainbow.mvc.console.service;

import java.util.List;

import com.ktrainbow.mvc.console.model.ConsolePicType;

public interface PicTypeService {
	
	public int update(ConsolePicType picType);
	
	public ConsolePicType findById(Integer id);
	
	public List<ConsolePicType> findAll();

}
