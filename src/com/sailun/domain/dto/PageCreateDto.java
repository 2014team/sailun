package com.sailun.domain.dto;
import com.sailun.domain.entity.PageCreate;
 
/**
 * @ClassName: PageCreateDto
 * @Description: 页面创建
 * @author zhuzq
 * @date 2021年04月14日 14:56:52
 */ 
public class PageCreateDto extends PageCreate{

	private static final long serialVersionUID = 1L;
	
	private String configPageName;

	public String getConfigPageName() {
		return configPageName;
	}

	public void setConfigPageName(String configPageName) {
		this.configPageName = configPageName;
	}
	
	
}