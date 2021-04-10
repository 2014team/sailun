
package com.sailun.admin.tag;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sailun.admin.domain.entity.NewsType;
import com.sailun.admin.service.NewsTypeService;
import com.sailun.common.util.SpringConfigUtil;

public class NewsTypeTag {

	public static NewsTypeService  newsTypeService = (NewsTypeService) SpringConfigUtil
			.getBean("newsTypeServiceImpl");

	public static List<NewsType> getList(){
		Map<String,Object> paramMap = new HashMap<String, Object>();
		List<NewsType> list = newsTypeService.select(paramMap);
		return list;
	}
	
	
	
}
