package com.ktrainbow.mvc.console.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ktrainbow.annotation.ReturnInterface;
import com.ktrainbow.mvc.console.model.ConsolePolicy;
import com.ktrainbow.mvc.console.service.PolicyService;

@Controller
@RequestMapping("/policy")
public class PolicyController {
	
	@Autowired
	private PolicyService policyService;
	
	@RequestMapping("/index")
	public String index(String id,Model model) {
		
		id = "1";
		
		if(StringUtils.isNotBlank(id)) {
			ConsolePolicy policy = policyService.findById(Integer.valueOf(id));
			model.addAttribute("policy", policy);
		}
		
		return "console/policy";
	}
	
	@RequestMapping("/update")
	@ReturnInterface
	public String update(ConsolePolicy policy,Model model) {
		policyService.update(policy);
		return "";
	}

}
