package com.sailun.admin.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sailun.admin.domain.dto.UserDto;
import com.sailun.admin.util.SessionUtil;


@Controller
@RequestMapping("/admin/center/")
public class WelcomeController {
	
	@RequestMapping(value = "/welcome")
	public String toList(HttpServletRequest request) {
		UserDto user = SessionUtil.getSessionUser(request);
		if (null == user) {
			return "redirect:/admin/login.do";
		}
		request.setAttribute("user", user);
		return "/admin/welcome";
	}
}
