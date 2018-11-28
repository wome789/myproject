package com.ktrainbow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;

import com.ktrainbow.config.DataSourceConfig;


@SpringBootApplication
//实例化对象信息，用于读取properties文件
@EnableConfigurationProperties(value = { DataSourceConfig.class })
//扫描servlet(druid)
@ServletComponentScan
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
