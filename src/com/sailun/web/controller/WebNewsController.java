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
import com.sailun.domain.dto.NewsDto;
import com.sailun.domain.vo.NewsVo;
import com.sailun.service.NewsService;

@Controller
public class WebNewsController {
	
	@Autowired
	private NewsService newsService;
	
	/**
	* @Title: index
	* @Description: 新闻首页
	* @author zhuzq
	* @date  2021年4月15日 下午5:45:59
	* @return
	*/
	@RequestMapping("/news")
	public String detail( NewsVo newsVo, HttpServletRequest request){
		
		newsVo.setStatus(StatusEnum.ON.getValue());
		Integer page = 1;
		Integer limit = 10;
		AdminResultByPage jsonResult = new AdminResultByPage(page, limit);
		jsonResult = newsService.findByPage(newsVo, jsonResult);
		request.setAttribute("result", jsonResult);
		return "/web/news";
	}
	
	
	/**
	* @Title: detail
	* @Description: 新闻详情
	* @author zhuzq
	* @date  2021年4月15日 下午9:07:44
	* @param newsId
	* @param request
	* @return
	*/
	@RequestMapping("/news/detail/{newsId}")
	public String detail(@PathVariable("newsId") String newsId, HttpServletRequest request){
		if (StringUtils.isEmpty(newsId)) {
			return "redirect:/";
		}
		NewsDto entity = newsService.getNews(Integer.valueOf(newsId));

		request.setAttribute("entity", entity);
		
		return "/web/news_detail";
	}
	

	
	/**
	* @Title: detail
	* @Description: 新闻分类
	* @author zhuzq
	* @date  2021年4月15日 下午9:08:02
	* @param newsId
	* @param newsVo
	* @param request
	* @return
	*/
	@RequestMapping("/news/type/{newsTypeId}")
	public String detail(@PathVariable("newsTypeId") String newsTypeId, RedirectAttributes attr){
		attr.addAttribute("newsTypeId", newsTypeId);
		return "redirect:/news";
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
	@RequestMapping("/news/search/by/page")
	public String searchByPage(NewsVo newsVo, HttpServletRequest request,AdminResultByPage resultByPage){
		newsVo.setStatus(StatusEnum.ON.getValue());
		resultByPage = newsService.findByPage(newsVo, resultByPage);
		request.setAttribute("result", resultByPage);
		return "/web/news_list";
	}
	
	

	
}
