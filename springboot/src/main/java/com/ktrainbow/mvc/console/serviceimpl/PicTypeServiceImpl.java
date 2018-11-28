package com.ktrainbow.mvc.console.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ktrainbow.mvc.console.dao.ConsolePicTypeMapper;
import com.ktrainbow.mvc.console.model.ConsolePicType;
import com.ktrainbow.mvc.console.service.PicTypeService;

@Service
public class PicTypeServiceImpl implements PicTypeService{

	@Autowired
	private ConsolePicTypeMapper picTypeMapper;
		
	@Override
	@Transactional
	public int update(ConsolePicType picType) {
		if(null == picType.getId()) {
			return picTypeMapper.insertSelective(picType);
		}else {
			return picTypeMapper.updateByPrimaryKeySelective(picType);
		}
		
	}
	@Override
	public ConsolePicType findById(Integer id) {
		return picTypeMapper.selectByPrimaryKey(id);
	}
	@Override
	public List<ConsolePicType> findAll() {
		return picTypeMapper.findAll();
	}
	
	 
}
