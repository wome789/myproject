package com.ktrainbow.mvc.console.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ktrainbow.mvc.console.dao.ConsoleAboutUsMapper;
import com.ktrainbow.mvc.console.model.ConsoleAboutUs;
import com.ktrainbow.mvc.console.service.AboutUsService;

@Service
public class AboutUsServiceImpl implements AboutUsService{

	@Autowired
	private ConsoleAboutUsMapper aboutUsMapper;
		
	@Override
	@Transactional
	public int update(ConsoleAboutUs aboutUs) {
		aboutUs.setId(1);;
		if(null == aboutUs.getId()) {
			return aboutUsMapper.insertSelective(aboutUs);
		}else {
			return aboutUsMapper.updateByPrimaryKeySelective(aboutUs);
		}
		
	}
	@Override
	public ConsoleAboutUs findById(Integer id) {
		return aboutUsMapper.selectByPrimaryKey(id);
	}
	
	 
}
