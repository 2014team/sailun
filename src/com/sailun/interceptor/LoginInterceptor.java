package com.sailun.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.sailun.domain.dto.UserDto;
import com.sailun.util.LogUtil;
import com.sailun.util.SessionUtil;

/**
 * @ClassName: LoginInterceptor
 * @Description: 后台登录拦截器
 * @author zhuzq
 * @date 2020年5月14日 下午2:13:00
 */
public class LoginInterceptor implements HandlerInterceptor {

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String path = request.getServletPath();
		LogUtil.logInfo("--------->"+path);
		UserDto userDto = SessionUtil.getSessionUser(request);
		if (null == userDto) {
			response.sendRedirect("/admin/login");
			return false;
		}
		return true;
	}

}
