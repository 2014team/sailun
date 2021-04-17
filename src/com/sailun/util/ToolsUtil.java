
package com.sailun.util;

import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

public class ToolsUtil {

	/**
	 * @Title: trimString
	 * @Description: 数值转字符串
	 * @author zhuzq
	 * @date 2020年5月2日 下午9:03:04
	 * @param arr
	 * @return
	 */
	public static String trim(Integer[] arr) {

		if (null == arr || arr.length < 1) {
			return "";
		}
		return StringUtils.strip(Arrays.asList(arr).toString(), "[]").replaceAll("\\s*", "");

	}

	/**
	 * 获取用户真实IP地址，不使用request.getRemoteAddr();的原因是有可能用户使用了代理软件方式避免真实IP地址。
	 * 可是，如果通过了多级反向代理的话，X-Forwarded-For的值并不止一个，而是一串IP值，究竟哪个才是真正的用户端的真实IP呢？
	 * 答案是取X-Forwarded-For中第一个非unknown的有效IP字符串
	 * 
	 * @param request
	 * @return
	 */
	public static String getIpAddress(HttpServletRequest request) {

		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
			if ("127.0.0.1".equals(ip) || "0:0:0:0:0:0:0:1".equals(ip)) {
				// 根据网卡取本机配置的IP
				InetAddress inet = null;
				try {
					inet = InetAddress.getLocalHost();
				}
				catch (UnknownHostException e) {
					e.printStackTrace();
				}
				ip = inet.getHostAddress();
			}
		}
		return ip;
	}
	
	public static String getWebRoot() {
//		String classPath = getClassPath();
//		if ( StringUtils.isEmpty(classPath)) {
//			return "";
//		}
//		int index = classPath.indexOf("WEB-INF/classes/");
//		if (index == -1) {
//			return "";
//		}
//		return classPath.substring(0, index);
		return Global.getSysRootPath();
	}
	
	
	/**
	 * 获取classes目录路径 如:F:/email3/WebRoot/WEB-INF/classes/
	 * 
	 * @return
	 */
	public static String getClassPath() {
		String classPath = "";
		URL webRootUrl = ToolsUtil.class.getResource("");
		if (webRootUrl == null) {
			webRootUrl = ToolsUtil.class.getClassLoader().getResource("");
		}
		if (webRootUrl == null) {
			webRootUrl = Thread.currentThread().getContextClassLoader().getResource("");
		}
		if (webRootUrl == null) {
			String webRoot = System.getProperty("web.root");// spring保存在系统中的根路径变量
			classPath = StringUtils.isEmpty(webRoot) ? null : (webRoot + "/WEB-INF/classes/");
			if (StringUtils.isEmpty(classPath)) {
				return "";
			} else {
				return classPath;
			}
		}
		classPath = webRootUrl.getPath().substring(1);
		classPath = classPath.substring(0, classPath.indexOf("/WEB-INF/classes/")) + "/WEB-INF/classes/";
		return classPath;
	}

}
