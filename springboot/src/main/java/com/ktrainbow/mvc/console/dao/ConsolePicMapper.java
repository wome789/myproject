package com.ktrainbow.mvc.console.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ktrainbow.common.mybatis.Page;
import com.ktrainbow.mvc.console.model.ConsolePic;

public interface ConsolePicMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ConsolePic record);

    int insertSelective(ConsolePic record);

    ConsolePic selectByPrimaryKey(Integer id);
    
    List<ConsolePic> findBySelective(ConsolePic pic);

    int updateByPrimaryKeySelective(ConsolePic record);

    int updateByPrimaryKey(ConsolePic record);

	List<ConsolePic> findByPage(@Param("param") ConsolePic pic, Page<ConsolePic> page);
}