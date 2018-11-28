package com.ktrainbow.mvc.console.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ktrainbow.mvc.console.dao.ConsoleWebSetMapper;
import com.ktrainbow.mvc.console.model.ConsoleWebSet;
import com.ktrainbow.mvc.console.service.WebSetService;

@Service
public class WebSetServiceImpl implements WebSetService{

	@Autowired
	private ConsoleWebSetMapper webSetMapper;
	
	@Override
	@Transactional
	public int update(ConsoleWebSet webSet) {
		webSet.setId(1);
		if(null == webSet.getId()) {
			return webSetMapper.insertSelective(webSet);
		}else {
			return webSetMapper.updateByPrimaryKeySelective(webSet);
		}
		
	}
	@Override
	public ConsoleWebSet findById(Integer id) {
		
		ConsoleWebSet webSet = webSetMapper.selectByPrimaryKey(id);
		return webSet;
	}
	
	 
}
