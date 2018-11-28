package com.ktrainbow.mvc.console.service;

import java.util.List;

import com.ktrainbow.common.mybatis.Page;
import com.ktrainbow.mvc.console.model.ConsolePic;

public interface PicService {
	
	public int update(ConsolePic pic);
	
	public ConsolePic findById(Integer id);
	
	public List<ConsolePic> findBySelective(ConsolePic pic);
	
	public Page<ConsolePic> findByPage(ConsolePic pic,Page<ConsolePic> page);

	public int delete(Integer valueOf);

}
