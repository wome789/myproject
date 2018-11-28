package com.ktrainbow.mvc.console.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ktrainbow.common.mybatis.Page;
import com.ktrainbow.mvc.console.model.ConsoleNews;

public interface ConsoleNewsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ConsoleNews record);

    int insertSelective(ConsoleNews record);

    ConsoleNews selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ConsoleNews record);

    int updateByPrimaryKey(ConsoleNews record);
    
	List<ConsoleNews> findByPage(@Param("param") ConsoleNews news, Page<ConsoleNews> page);
	
    List<ConsoleNews> findBySelective(ConsoleNews news);
}