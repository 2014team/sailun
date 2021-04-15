package com.sailun.web.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sailun.domain.entity.Aboutus;
import com.sailun.service.AboutusService;

@Controller
public class WebAboutusController {
	
	@Autowired
	private AboutusService aboutusService;
	
	@RequestMapping("/aboutus")
	public String index( HttpServletRequest request){
		
		Map<String, Object> paramMap = null;
		Aboutus entity  = aboutusService.getOneByMap(paramMap);
		request.setAttribute("entity", entity);
		return "/web/aboutus";
	}

	
}
