package com.sailun.filter;
 
 
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sailun.common.entity.PageBean;
import com.sailun.util.HttpUtil;
import com.sailun.util.ToolsUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
 
public class AppStepFilter implements Filter {
 
 
 
	@Override
	public void destroy() {
	}
 
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
 
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		SortedMap<String, Object> paramMap = HttpUtil.getRequestParams2(httpRequest);
		
		//判断是否手机
		boolean judgeIsMoblie = ToolsUtil.judgeIsMoblie(httpRequest);
		if(judgeIsMoblie){
			paramMap.put("step", 4);
		}
		ParameterRequestWrapper bodyReaderHttpServletRequestWrapper = new ParameterRequestWrapper(httpRequest,paramMap);
		 //继续向后传递修改后的request,拦截器不能实现。
        chain.doFilter(bodyReaderHttpServletRequestWrapper, response);
 
	}
 
	@Override
	public void init(FilterConfig config){
 
	}
}