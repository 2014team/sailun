package com.sailun.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.sailun.constant.PageConfigEnum;
import com.sailun.service.CreateFileSerivce;

/**
 * @ClassName: IndexBannerInterceptor
 * @Description: 首页Banner
 * @author zhuzq
 * @date 2021年4月14日 下午4:46:20
 */
public class IndexBannerInterceptor implements HandlerInterceptor {
	
	
	@Autowired
	private CreateFileSerivce createFileSerivce;
	
	private static org.slf4j.Logger logger = LoggerFactory.getLogger(IndexBannerInterceptor.class);

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
			String path = request.getServletPath();
			logger.info("--------->" + path);
			createFileSerivce.createFile(PageConfigEnum.INDEX_BANNER);
	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		return true;
	}

}
