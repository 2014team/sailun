package com.sailun.admin.domain.dto;
import com.sailun.admin.domain.entity.News;
 
/**
 * @ClassName: NewsDto
 * @Description: 资讯发布
 * @author zhuzq
 * @date 2021年04月10日 15:36:28
 */ 
public class NewsDto extends News{

	private static final long serialVersionUID = 1L;
	
	private String typeName;

	
	public String getTypeName() {
		return typeName;
	}

	
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
	
	
}