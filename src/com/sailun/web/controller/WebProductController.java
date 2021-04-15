package com.sailun.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sailun.domain.dto.ProductDto;
import com.sailun.service.ProductService;

@Controller
public class WebProductController {
	
	@Autowired
	private ProductService productService;
	

	/**
	* @Title: index
	* @Description: 产品首页
	* @author zhuzq
	* @date  2021年4月15日 下午4:13:13
	* @return
	*/
	@RequestMapping("/product")
	public String index(){
		return "/web/product";
	}
	
	/**
	* @Title: detail
	* @Description: 产品详情
	* @author zhuzq
	* @date  2021年4月15日 下午4:12:50
	* @param id
	* @param request
	* @return
	*/
	@RequestMapping("/product/detail/{id}")
	public String detail(@PathVariable String id, HttpServletRequest request) {
		if (StringUtils.isEmpty(id)) {
			return "redirect:/";
		}
		ProductDto entity = productService.getProduct(Integer.valueOf(id));

		request.setAttribute("entity", entity);
		return "/web/product_detail";
	}
	
}
