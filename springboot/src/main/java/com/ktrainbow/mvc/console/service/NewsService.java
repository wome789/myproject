package com.ktrainbow.mvc.console.service;

import java.util.List;

import com.ktrainbow.common.mybatis.Page;
import com.ktrainbow.mvc.console.model.ConsoleNews;

public interface NewsService {
	
	public int update(ConsoleNews news);
	
	public ConsoleNews findById(Integer id);
	
	public List<ConsoleNews> findBySelective(ConsoleNews news);
	
	public Page<ConsoleNews> findByPage(ConsoleNews news,Page<ConsoleNews> page);

	public int delete(Integer valueOf);

}
