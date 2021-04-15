package com.sailun.interceptor;

import java.util.SortedMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.sailun.constant.MenuTypeEnum;
import com.sailun.constant.PageConfigEnum;
import com.sailun.service.CreateFileSerivce;
import com.sailun.util.HttpUtil;

/**
 * @ClassName: IndexBannerInterceptor
 * @Description: 首页Banner
 * @author zhuzq
 * @date 2021年4月14日 下午4:46:20
 */
public class CreateFileInterceptor implements HandlerInterceptor {
	
	
	@Autowired
	private CreateFileSerivce createFileSerivce;
	
	private static org.slf4j.Logger logger = LoggerFactory.getLogger(CreateFileInterceptor.class);

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
			String path = "url:" + request.getRequestURL();
			
			//SortedMap<String, Object> paramMap = HttpUtil.getRequestParams2(request);
			logger.info("--------->" + path);
			if(StringUtils.isNotEmpty(path)){
				if(path.indexOf(PageConfigEnum.INDEX_BANNER.getDisplayName()) != -1){
					createFileSerivce.createFile(PageConfigEnum.INDEX_BANNER);
				}else if(path.indexOf(PageConfigEnum.INDEX_PRODUCT.getDisplayName()) != -1){
					createFileSerivce.createFile(PageConfigEnum.INDEX_PRODUCT);
				}else if(path.indexOf(PageConfigEnum.DRIVER_DRIVER.getDisplayName()) != -1){
					createFileSerivce.createFile(PageConfigEnum.DRIVER_DRIVER);
				}else if(path.indexOf(PageConfigEnum.PAGECREATE.getDisplayName()) != -1){
					String pageConfigId = request.getParameter("pageConfigId");
					if(StringUtils.isNotEmpty(pageConfigId)){
						PageConfigEnum menuTypeEnum = PageConfigEnum.getByValue(Integer.valueOf(pageConfigId));
						createFileSerivce.createFile(menuTypeEnum);
					}
				}
			}
			
			
			
	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//SortedMap<String, Object> paramMap = HttpUtil.getRequestParams2(request);
		return true;
	}

}
