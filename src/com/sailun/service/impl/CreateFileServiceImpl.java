package com.sailun.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sailun.common.entity.AdminResultByPage;
import com.sailun.constant.PageConfigEnum;
import com.sailun.constant.StatusEnum;
import com.sailun.dao.BannerDao;
import com.sailun.dao.DriverDao;
import com.sailun.dao.NewsDao;
import com.sailun.dao.NewsTypeDao;
import com.sailun.dao.PageCreateDao;
import com.sailun.dao.ProductDao;
import com.sailun.dao.ProductTypeDao;
import com.sailun.domain.dto.NewsDto;
import com.sailun.domain.entity.Banner;
import com.sailun.domain.entity.Driver;
import com.sailun.domain.entity.News;
import com.sailun.domain.entity.NewsType;
import com.sailun.domain.entity.PageCreate;
import com.sailun.domain.entity.Product;
import com.sailun.domain.entity.ProductType;
import com.sailun.domain.vo.DriverVo;
import com.sailun.domain.vo.NewsTypeVo;
import com.sailun.domain.vo.NewsVo;
import com.sailun.domain.vo.ProductTypeVo;
import com.sailun.domain.vo.ProductVo;
import com.sailun.service.CreateFileSerivce;
import com.sailun.util.CreateFileUtil;
import com.sailun.util.DateUtil;
import com.sailun.util.FileUtil;
import com.sailun.util.ToolsUtil;


@Service
public class CreateFileServiceImpl implements CreateFileSerivce{
	
	private static org.slf4j.Logger logger = LoggerFactory.getLogger(CreateFileServiceImpl.class);
	
	@Autowired
	private BannerDao bannerDao;
	
	@Autowired
	private PageCreateDao pageCreateDao;
	@Autowired
	private ProductDao productDao;
	@Autowired
	private DriverDao driverDao;
	@Autowired
	private NewsTypeDao newsTypeDao;
	@Autowired
	private ProductTypeDao productTypeDao;
	@Autowired
	private NewsDao newsDao;
	
	
	
	
	@Override
	public void createFile(PageConfigEnum pageConfigEnum) {
		if(null == pageConfigEnum || pageConfigEnum.getValue() < 1 ){
			return;
		}
		Integer code = pageConfigEnum.getValue();
		logger.info("code="+code);
		
		// 首页Banner
		if(String.valueOf(pageConfigEnum.getValue()).equals(String.valueOf(PageConfigEnum.INDEX_BANNER.getValue()))){
			indexBannerCreateFile(pageConfigEnum);
		}else if(String.valueOf(pageConfigEnum.getValue()).equals(String.valueOf(PageConfigEnum.INDEX_PRODUCT.getValue()))){
			indexProductCreateFile(pageConfigEnum);
		}else if(String.valueOf(pageConfigEnum.getValue()).equals(String.valueOf(PageConfigEnum.DRIVER_DRIVER.getValue()))){
			driverCreateFile(pageConfigEnum);
		}else if(String.valueOf(pageConfigEnum.getValue()).equals(String.valueOf(PageConfigEnum.NEW_NEWSTYPE.getValue()))){
			newsTypeCreateFile(pageConfigEnum);
		}else if(String.valueOf(pageConfigEnum.getValue()).equals(String.valueOf(PageConfigEnum.PRODUCTTYPE.getValue()))){
			productTypeCreateFile(pageConfigEnum);
		}else if(String.valueOf(pageConfigEnum.getValue()).equals(String.valueOf(PageConfigEnum.INDEX_NEWS.getValue()))){
			newsCreateFile(pageConfigEnum);
		}
		
	}
	
	private void newsCreateFile(PageConfigEnum pageConfigEnum) {
	Map<String,Object> paramMap = new HashMap<String, Object>();
			
		Integer page = 1;
		Integer limit = 12;
	//		AdminResultByPage jsonResult = new AdminResultByPage(page, limit);
		NewsVo newsVo = new NewsVo();
		paramMap.put("newsVo", newsVo);
//		paramMap.put("page", jsonResult);
		
		List<NewsDto> list = newsDao.findListByPage(paramMap);
		if(null == list || list.size() < 1){
			logger.info("没有要生成的产品类型");
			return ;
		}
		if(null != list && list.size() > 0){
			for (NewsDto news : list) {
				Date createDate = news.getCreateDate();
				String createDateStr = DateUtil.format(createDate, "yyyy/MM/dd");
				news.setCreateDateStr(createDateStr);
			}
		}
		
		createFile(list, pageConfigEnum);
		
	}

	private void productTypeCreateFile(PageConfigEnum pageConfigEnum) {
		Map<String,Object> paramMap = new HashMap<String, Object>();
		
//		Integer page = 1;
//		Integer limit = 4;
//		AdminResultByPage jsonResult = new AdminResultByPage(page, limit);
		ProductTypeVo productTypeVo = new ProductTypeVo();
		paramMap.put("productTypeVo", productTypeVo);
//		paramMap.put("page", jsonResult);
		
		List<ProductType> list = productTypeDao.findByPage(paramMap);
		if(null == list || list.size() < 1){
			logger.info("没有要生成的产品类型");
			return ;
		}
		createFile(list, pageConfigEnum);
		
	}

	private void newsTypeCreateFile(PageConfigEnum pageConfigEnum) {
		Map<String,Object> paramMap = new HashMap<String, Object>();
		
//		Integer page = 1;
//		Integer limit = 4;
//		AdminResultByPage jsonResult = new AdminResultByPage(page, limit);
		NewsTypeVo entityVo = new NewsTypeVo();
		paramMap.put("newsTypeVo", entityVo);
//		paramMap.put("page", jsonResult);
		
		List<NewsType> list = newsTypeDao.findByPage(paramMap);
		if(null == list || list.size() < 1){
			logger.info("没有要生成的新闻类型");
			return ;
		}
		createFile(list, pageConfigEnum);
		
	}

	public void driverCreateFile(PageConfigEnum pageConfigEnum) {
		Map<String,Object> paramMap = new HashMap<String, Object>();
		
//		Integer page = 1;
//		Integer limit = 4;
//		AdminResultByPage jsonResult = new AdminResultByPage(page, limit);
		DriverVo driverVo = new DriverVo();
		driverVo.setStatus(StatusEnum.ON.getValue());
		paramMap.put("driverVo", driverVo);
//		paramMap.put("page", jsonResult);
		
		List<Driver> list = driverDao.findByPage(paramMap);
		if(null == list || list.size() < 1){
			logger.info("没有要生成车手图片");
			return ;
		}
		
		createFile(list, pageConfigEnum);
		
	}

	public void indexProductCreateFile(PageConfigEnum pageConfigEnum) {
		Map<String,Object> paramMap = new HashMap<String, Object>();
		
		
		Integer page = 1;
		Integer limit = 12;
		AdminResultByPage jsonResult = new AdminResultByPage(page, limit);
		ProductVo productVo = new ProductVo();
		productVo.setStatus(StatusEnum.ON.getValue());
		paramMap.put("productVo", productVo);
		paramMap.put("page", jsonResult);
		
		List<Product> list = productDao.findByPage(paramMap);
		if(null == list || list.size() < 1){
			logger.info("没有要生成产品图片");
			return ;
		}
		
		createFile(list, pageConfigEnum);
		
		
	}

	public void indexBannerCreateFile(PageConfigEnum pageConfigEnum) {
		Map<String,Object> paramMap = new HashMap<String, Object>();
		paramMap.put("status", StatusEnum.ON.getValue());
		List<Banner> list = bannerDao.select(paramMap);
		if(null == list || list.size() < 1){
			logger.info("没有要生成的Banner图片");
			return ;
		}
		createFile(list, pageConfigEnum);
		
	}
	
	
	private void createFile(List list ,PageConfigEnum pageConfigEnum){
		// 获取配置
		Map<String,Object> configParamMap = new HashMap<String, Object>();
		configParamMap.put("pageConfigId",pageConfigEnum.getValue());
		PageCreate pageCreate = pageCreateDao.getOneByMap(configParamMap);
		if(null == pageCreate || StringUtils.isEmpty(pageCreate.getTemplatePath()) || StringUtils.isEmpty(pageCreate.getGeneratorFile()) || StringUtils.isEmpty(pageCreate.getTemplateContent())){
			logger.info("没有找到相关配置");
			return ;
		}
		
		// 数据封装
		Map<String,Object> dataMap =new HashMap<String, Object>();
		dataMap.put("listItem", list);
		try {
			// 模板路径
			String templateName =  ToolsUtil.getWebRoot() + pageCreate.getTemplatePath();
			// 模板内容
			String templateContent = pageCreate.getTemplateContent();
			// 生成模板
			FileUtil.writeFile(templateName, templateContent, false);
			
			// 目标内容
			String content = CreateFileUtil.getTemplateHtml(pageCreate.getTemplatePath(), dataMap);
			// 目标文件生成路径
			String generatorFile = ToolsUtil.getWebRoot()+pageCreate.getGeneratorFile();
			// 生成模板
			// 目标文件生成
			FileUtil.writeFile(generatorFile, content, false);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
