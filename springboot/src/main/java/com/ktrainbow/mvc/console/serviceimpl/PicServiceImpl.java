package com.ktrainbow.mvc.console.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ktrainbow.common.mybatis.Page;
import com.ktrainbow.mvc.console.dao.ConsolePicMapper;
import com.ktrainbow.mvc.console.model.ConsolePic;
import com.ktrainbow.mvc.console.service.PicService;

@Service
public class PicServiceImpl implements PicService{

	@Autowired
	private ConsolePicMapper picMapper;
		
	@Override
	@Transactional
	public int update(ConsolePic pic) {
		if(null == pic.getId()) {
			return picMapper.insertSelective(pic);
		}else {
			return picMapper.updateByPrimaryKeySelective(pic);
		}
		
	}
	@Override
	public ConsolePic findById(Integer id) {
		return picMapper.selectByPrimaryKey(id);
	}
	@Override
	public List<ConsolePic> findBySelective(ConsolePic pic) {
		return picMapper.findBySelective(pic);
	}
	@Override
	public Page<ConsolePic> findByPage(ConsolePic pic, Page<ConsolePic> page) {
		page.setResults(picMapper.findByPage(pic, page));
		return page;
	}
	
	@Override
	@Transactional
	public int delete(Integer id) {
		ConsolePic pic = new ConsolePic();
		pic.setId(id);
		pic.setStatus(0);
		return picMapper.updateByPrimaryKeySelective(pic);
	}
	
	 
}
