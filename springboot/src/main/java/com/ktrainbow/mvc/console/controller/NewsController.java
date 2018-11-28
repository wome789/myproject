package com.ktrainbow.mvc.console.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ktrainbow.annotation.ReturnInterface;
import com.ktrainbow.annotation.TableReturnInterface;
import com.ktrainbow.common.mybatis.Page;
import com.ktrainbow.mvc.console.model.ConsoleNews;
import com.ktrainbow.mvc.console.service.NewsService;

@Controller
@RequestMapping("/news")
public class NewsController {
	
	@Autowired
	private NewsService newsService;
	
	@RequestMapping("/index")
	public String picture(Model model) {
		return "console/news/news";
	}
	
	@RequestMapping("/updatePage")
	public String updatePage(String id,Model model) {
		
		if(StringUtils.isNotBlank(id)) {
			ConsoleNews news = newsService.findById(Integer.valueOf(id));
			model.addAttribute("news", news);
		}else {
			model.addAttribute("news", new ConsoleNews());
		}
		
		return "console/news/update";
	}
	
	@RequestMapping(value = "/find", produces = "application/json; charset=utf-8")
	@TableReturnInterface
	public Page<ConsoleNews> find(Integer page,Integer limit,ConsoleNews news,Model model) {
		
		Page<ConsoleNews> pageModel = new Page<ConsoleNews>();
		pageModel.setPageNum(page);
		pageModel.setPageSize(limit);
		news.setStatus(1);
		Page<ConsoleNews> result = newsService.findByPage(news, pageModel);
		
		return result;
	}
	
	@RequestMapping("/update")
	@ReturnInterface
	public String update(ConsoleNews news,Model model) {
		newsService.update(news);
		return "";
	}
	
	@RequestMapping("/delete")
	@ReturnInterface
	public String delete(String id,Model model) {
		newsService.delete(Integer.valueOf(id));
		return "";
	}

}
