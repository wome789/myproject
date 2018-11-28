package com.ktrainbow.mvc.console.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ktrainbow.annotation.ReturnInterface;
import com.ktrainbow.mvc.console.model.ConsoleAboutUs;
import com.ktrainbow.mvc.console.service.AboutUsService;

@Controller
@RequestMapping("/aboutUs")
public class AboutUsController {
	
	@Autowired
	private AboutUsService aboutUsService;
	
	@RequestMapping("/index")
	public String aboutUs(String id,Model model) {
		
		id = "1";
		
		if(StringUtils.isNotBlank(id)) {
			ConsoleAboutUs aboutUs = aboutUsService.findById(Integer.valueOf(id));
			model.addAttribute("aboutUs", aboutUs);
		}
		
		return "console/aboutus";
	}
	
	@RequestMapping("/update")
	@ReturnInterface
	public String update(ConsoleAboutUs aboutUs,Model model) {
		aboutUsService.update(aboutUs);
		return "";
	}

}
