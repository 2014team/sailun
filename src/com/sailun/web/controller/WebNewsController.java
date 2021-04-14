package com.sailun.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebNewsController {
	

	@RequestMapping("/news")
	public String index(){
		return "/web/news";
	}
	
	@RequestMapping("/news/detail")
	public String detail(){
		return "/web/news_detail";
	}

	
}
