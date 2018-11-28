package com.ktrainbow.mvc.console.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ktrainbow.annotation.ReturnInterface;
import com.ktrainbow.annotation.TableReturnInterface;
import com.ktrainbow.common.mybatis.Page;
import com.ktrainbow.mvc.console.model.ConsolePic;
import com.ktrainbow.mvc.console.service.PicService;

@Controller
@RequestMapping("/picture")
public class PictureController {
	
	@Autowired
	private PicService picService;
	
	@RequestMapping("/index")
	public String picture(Model model) {
		return "console/picture/picture";
	}
	
	@RequestMapping("/updatePage")
	public String updatePage(String id,Model model) {
		
		if(StringUtils.isNotBlank(id)) {
			ConsolePic pic = picService.findById(Integer.valueOf(id));
			model.addAttribute("pic", pic);
		}else {
			model.addAttribute("pic", new ConsolePic());
		}
		
		return "console/picture/update";
	}
	
	@RequestMapping(value = "/find", produces = "application/json; charset=utf-8")
	@TableReturnInterface
	public Page<ConsolePic> find(Integer page,Integer limit,ConsolePic pic,Model model) {
		
		Page<ConsolePic> pageModel = new Page<ConsolePic>();
		pageModel.setPageNum(page);
		pageModel.setPageSize(limit);
		pic.setStatus(1);
		Page<ConsolePic> result = picService.findByPage(pic, pageModel);
		
		return result;
	}
	
	@RequestMapping("/update")
	@ReturnInterface
	public String update(ConsolePic pic,Model model) {
		picService.update(pic);
		return "";
	}
	
	@RequestMapping("/delete")
	@ReturnInterface
	public String delete(String id,Model model) {
		picService.delete(Integer.valueOf(id));
		return "";
	}

}
