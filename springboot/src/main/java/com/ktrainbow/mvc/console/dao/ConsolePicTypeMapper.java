package com.ktrainbow.mvc.console.dao;

import java.util.List;

import com.ktrainbow.mvc.console.model.ConsolePicType;

public interface ConsolePicTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ConsolePicType record);

    int insertSelective(ConsolePicType record);

    ConsolePicType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ConsolePicType record);

    int updateByPrimaryKey(ConsolePicType record);

	List<ConsolePicType> findAll();
}