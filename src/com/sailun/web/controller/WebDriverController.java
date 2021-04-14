package com.sailun.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebDriverController {
	
	@RequestMapping("/driver")
	public String index(){
		return "/web/driver";
	}
	@RequestMapping("/detail/detail")
	public String detail(){
		return "/web/driver_detail";
	}

	
}
