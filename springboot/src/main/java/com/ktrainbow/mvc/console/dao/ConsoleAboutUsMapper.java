package com.ktrainbow.mvc.console.dao;

import com.ktrainbow.mvc.console.model.ConsoleAboutUs;

public interface ConsoleAboutUsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ConsoleAboutUs record);

    int insertSelective(ConsoleAboutUs record);

    ConsoleAboutUs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ConsoleAboutUs record);

    int updateByPrimaryKey(ConsoleAboutUs record);
}