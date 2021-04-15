package com.sailun.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sailun.common.entity.AdminResultByPage;
import com.sailun.constant.StatusEnum;
import com.sailun.domain.dto.NewsDto;
import com.sailun.domain.dto.ProductDto;
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
		Integer limit = 4;
		
		AdminResultByPage jsonResult = new AdminResultByPage(page, limit);
		
		jsonResult = newsService.findByPage(newsVo, jsonResult);
		request.setAttribute("result", jsonResult);
		
		return "/web/news";
	}
	
	
	@RequestMapping("/news/detail/{newsId}")
	public String detail(@PathVariable("newsId") String newsId, HttpServletRequest request){
		if (StringUtils.isEmpty(newsId)) {
			return "redirect:/";
		}
		NewsDto entity = newsService.getNews(Integer.valueOf(newsId));

		request.setAttribute("entity", entity);
		
		return "/web/news/news_detail";
	}
	

	
	@RequestMapping("/news/type/{newsId}")
	public String detail(@PathVariable("newsId") String newsId, NewsVo newsVo, HttpServletRequest request){
		
		if(StringUtils.isNotEmpty(newsId) && !"all".equals(newsId)){
			newsVo.setNewsId(Integer.valueOf(newsId));
		}
		
		newsVo.setStatus(StatusEnum.ON.getValue());
		
		Integer page = Integer.valueOf(request.getParameter("page"));
		Integer limit = 4;

		AdminResultByPage jsonResult = new AdminResultByPage(page, limit);

		jsonResult = newsService.findByPage(newsVo, jsonResult);
		request.setAttribute("result", jsonResult);
		
		return "/web/common/news_list";
	}
	
	

	
}
