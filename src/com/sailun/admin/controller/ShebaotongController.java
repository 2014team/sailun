package com.sailun.admin.controller;

import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sailun.admin.constant.ShebaotongConstant;
import com.sailun.admin.service.ShebaotongService;
import com.sailun.common.util.HttpUtil;

@Controller
public class ShebaotongController {
	
	@Autowired
	private ShebaotongService shebaotongService;
	@ResponseBody
	@RequestMapping("/set")
	public String login(HttpServletRequest request){
		
		HttpSession httpSession = request.getSession();
		httpSession.setAttribute(httpSession.getId(), httpSession.getId());
		httpSession.setMaxInactiveInterval(10);
		
//		try {
//			Map<String,String> paramMap = shebaotongService.getLoginParam(ShebaotongConstant.ULR_LOGIN);
//			
//			Map<String,String> cookiesParamMap = shebaotongService.getCookies(ShebaotongConstant.ULR_LOGIN_SUBMIT, paramMap);
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		String ff  =( String ) httpSession.getAttribute(httpSession.getId());
		return ff;
	}
	
	@ResponseBody
	@RequestMapping("/get")
	public String xx(HttpServletRequest request){
		//return "/admin/center/shebaotong/shebaotong_list";
		HttpSession httpSession = request.getSession();
		String ff  =( String ) httpSession.getAttribute(httpSession.getId());
		return ff;
	}
	
	
	@RequestMapping("/admin/center/shebaotong/cal/ui")
	public String calList(){
		return "/admin/center/shebaotong/shebaotong_list";
	}

}
