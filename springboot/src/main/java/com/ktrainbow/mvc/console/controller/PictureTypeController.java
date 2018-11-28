package com.ktrainbow.mvc.console.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ktrainbow.annotation.ReturnInterface;
import com.ktrainbow.mvc.console.model.ConsolePicType;
import com.ktrainbow.mvc.console.service.PicTypeService;

@Controller
@RequestMapping("/pictureType")
public class PictureTypeController {
	
	@Autowired
	private PicTypeService picTypeService;
	
	@RequestMapping("/findAll")
	@ReturnInterface
	public List<ConsolePicType> findAll(ConsolePicType picType,Model model) {
		return picTypeService.findAll();
	}

}
