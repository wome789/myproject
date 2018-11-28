package com.ktrainbow.mvc.console.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ktrainbow.annotation.ReturnInterface;
import com.ktrainbow.mvc.console.model.ConsoleWebSet;
import com.ktrainbow.mvc.console.service.WebSetService;

@Controller
@RequestMapping("/webSet")
public class WebSetController {
	
	@Autowired
	private WebSetService webSetService;
	
	@RequestMapping("/index")
	public String webset(String id,Model model) throws Exception {
		
		id = "1";
		
		if(StringUtils.isNotBlank(id)) {
			ConsoleWebSet webSet = webSetService.findById(Integer.valueOf(id));
			model.addAttribute("webSet", webSet);
		}else {
			model.addAttribute("webSet", new ConsoleWebSet());
		}
		
		return "console/webset";
	}
	
	@RequestMapping("/update")
	@ReturnInterface
	public String update(ConsoleWebSet webSet,Model model) throws Exception {
		webSetService.update(webSet);
		return "";
	}

}
