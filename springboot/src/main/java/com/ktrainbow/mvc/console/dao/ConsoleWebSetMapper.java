package com.ktrainbow.mvc.console.dao;

import com.ktrainbow.mvc.console.model.ConsoleWebSet;

public interface ConsoleWebSetMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ConsoleWebSet record);

    int insertSelective(ConsoleWebSet record);

    ConsoleWebSet selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ConsoleWebSet record);

    int updateByPrimaryKey(ConsoleWebSet record);
}