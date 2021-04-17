package com.sailun.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sailun.common.entity.AdminResultByPage;
import com.sailun.constant.StatusEnum;
import com.sailun.domain.dto.ProductDto;
import com.sailun.domain.entity.ProductType;
import com.sailun.domain.vo.ProductVo;
import com.sailun.service.ProductService;
import com.sailun.service.ProductTypeService;

@Controller
public class WebProductController {
	
	@Autowired
	private ProductService productService;
	@Autowired
	private ProductTypeService productTypeService;
	

	/**
	* @Title: index
	* @Description: 产品首页
	* @author zhuzq
	* @date  2021年4月15日 下午4:13:13
	* @return
	*/
	@RequestMapping("/product")
	public String index(ProductVo productVo, HttpServletRequest request,AdminResultByPage jsonResult){
		
		productVo.setStatus(StatusEnum.ON.getValue());
		jsonResult = productService.findByPage(productVo, jsonResult);
		request.setAttribute("result", jsonResult);
		
		if(null != productVo.getProductTypeId()){
			ProductType productType = productTypeService.get(Integer.valueOf(productVo.getProductTypeId()));
			
			request.setAttribute("productType", productType);
		}
		
		
		return "/web/product";
	}
	
	/**
	* @Title: detail
	* @Description: 产品详情
	* @author zhuzq
	* @date  2021年4月15日 下午9:07:44
	* @param newsId
	* @param request
	* @return
	*/
	@RequestMapping("/product/detail/{productId}")
	public String detail(@PathVariable("productId") String productId, HttpServletRequest request){
		if (StringUtils.isEmpty(productId)) {
			return "redirect:/";
		}
		ProductDto entity = productService.getProduct(Integer.valueOf(productId));

		request.setAttribute("entity", entity);
		return "/web/product_detail";
	}
	

	
	/**
	* @Title: detail
	* @Description: 产品分类
	* @author zhuzq
	* @date  2021年4月15日 下午9:08:02
	* @param newsId
	* @param newsVo
	* @param request
	* @return
	*/
	@RequestMapping("/product/type/{productTypeId}")
	public String detail(@PathVariable("productTypeId") String productTypeId, RedirectAttributes attr){
		attr.addAttribute("productTypeId", productTypeId);
		return "redirect:/product";
	}
	
	/**
	* @Title: searchByPage
	* @Description: 分页查找
	* @author zhuzq
	* @date  2021年4月15日 下午10:14:30
	* @param newsVo
	* @param request
	* @param page
	* @return
	*/
	@RequestMapping("/product/search/by/page")
	public String searchByPage(ProductVo productVo, HttpServletRequest request,AdminResultByPage resultByPage){
		productVo.setStatus(StatusEnum.ON.getValue());
		resultByPage = productService.findByPage(productVo, resultByPage);
		request.setAttribute("result", resultByPage);
		
		if(null != productVo.getProductTypeId()){
			ProductType productType = productTypeService.get(Integer.valueOf(productVo.getProductTypeId()));
			
			request.setAttribute("productType", productType);
		}
		
		return "/web/product_list";
	}
	
	
}
