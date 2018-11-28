package com.ktrainbow.mvc.console.dao;

import com.ktrainbow.mvc.console.model.ConsolePolicy;

public interface ConsolePolicyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ConsolePolicy record);

    int insertSelective(ConsolePolicy record);

    ConsolePolicy selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ConsolePolicy record);

    int updateByPrimaryKey(ConsolePolicy record);
}