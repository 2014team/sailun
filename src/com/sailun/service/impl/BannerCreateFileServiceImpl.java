package com.sailun.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sailun.admin.controller.ContactController;
import com.sailun.constant.StatusEnum;
import com.sailun.dao.BannerDao;
import com.sailun.domain.entity.Banner;
import com.sailun.service.CreateFileSerivce;
import com.sailun.util.CreateFileUtil;

@Service
public class BannerCreateFileServiceImpl extends CreateFileSerivce{
	
	private static org.slf4j.Logger logger = LoggerFactory.getLogger(BannerCreateFileServiceImpl.class);
	
	@Autowired
	private BannerDao bannerDao;
	
	@Override
	public void createFile() {
		
		Map<String,Object> paramMap = new HashMap<String, Object>();
		paramMap.put("status", StatusEnum.ON.getValue());
		List<Banner> bannerList = bannerDao.select(paramMap);
		if(null == bannerList || bannerList.size() < 1){
			logger.info("没有要生成的Banner图片");
			return ;
		}
		
		Map<String,Object> dataMap =new HashMap<String, Object>();
		dataMap.put("listItem", bannerList);
		String templateName = "banner.html";
		try {
			
			String html = CreateFileUtil.getTemplateHtml(templateName, dataMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
