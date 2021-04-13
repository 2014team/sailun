package com.sailun.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebAboutusController {
	
	@RequestMapping("/aboutus")
	public String index(){
		return "/web/aboutus";
	}

	
}
