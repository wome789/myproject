package com.ktrainbow.mvc.console.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ktrainbow.common.mybatis.Page;
import com.ktrainbow.mvc.console.dao.ConsoleNewsMapper;
import com.ktrainbow.mvc.console.model.ConsoleNews;
import com.ktrainbow.mvc.console.service.NewsService;

@Service
public class NewsServiceImpl implements NewsService{

	@Autowired
	private ConsoleNewsMapper newsMapper;
		
	@Override
	@Transactional
	public int update(ConsoleNews news) {
		if(null == news.getId()) {
			return newsMapper.insertSelective(news);
		}else {
			return newsMapper.updateByPrimaryKeySelective(news);
		}
		
	}
	@Override
	public ConsoleNews findById(Integer id) {
		return newsMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public List<ConsoleNews> findBySelective(ConsoleNews news) {
		return newsMapper.findBySelective(news);
	}
	
	@Override
	public Page<ConsoleNews> findByPage(ConsoleNews news, Page<ConsoleNews> page) {
		page.setResults(newsMapper.findByPage(news, page));
		return page;
	}
	
	@Override
	@Transactional
	public int delete(Integer id) {
		ConsoleNews news = new ConsoleNews();
		news.setId(id);
		news.setStatus(0);
		return newsMapper.updateByPrimaryKeySelective(news);
	}
	
	 
}
