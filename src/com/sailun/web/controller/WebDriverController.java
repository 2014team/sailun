package com.sailun.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sailun.domain.dto.DriverDto;
import com.sailun.service.DriverService;

@Controller
public class WebDriverController {
	
	@Autowired
	private DriverService driverService;
	
	/**
	* @Title: index
	* @Description: 车手首页
	* @author zhuzq
	* @date  2021年4月15日 下午4:13:54
	* @return
	*/
	@RequestMapping("/driver")
	public String index(){
		return "/web/driver";
	}
	
	/**
	* @Title: detail
	* @Description: 车手详情
	* @author zhuzq
	* @date  2021年4月15日 下午4:12:50
	* @param id
	* @param request
	* @return
	*/
	@RequestMapping("/driver/detail/{id}")
	public String detail(@PathVariable String id, HttpServletRequest request) {
		if (StringUtils.isEmpty(id)) {
			return "redirect:/";
		}
		DriverDto entity = driverService.getDriver(Integer.valueOf(id));
		request.setAttribute("entity", entity);
		return "/web/driver_detail";
	}

	
}
