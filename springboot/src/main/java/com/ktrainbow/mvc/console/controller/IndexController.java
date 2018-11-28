package com.ktrainbow.mvc.console.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/console")
public class IndexController {
	
	@RequestMapping("/indexs")
	public String index(Model model) {
		String w="Welcome FreeMarker!";
        model.addAttribute("w",w);
		return "index";
	}
	
	@RequestMapping("/index")
	public String console(Model model) {
		return "console/index";
	}
	
}
