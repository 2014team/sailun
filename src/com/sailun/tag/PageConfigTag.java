
package com.sailun.tag;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sailun.domain.entity.PageConfig;
import com.sailun.service.PageConfigService;
import com.sailun.util.SpringConfigUtil;

public class PageConfigTag {

	public static PageConfigService  pageConfigService = (PageConfigService) SpringConfigUtil
			.getBean("pageConfigServiceImpl");

	public static List<PageConfig> getList(){
		Map<String,Object> paramMap = new HashMap<String, Object>();
		List<PageConfig> list = pageConfigService.select(paramMap);
		return list;
	}
	
	
	
}
