package com.sailun.domain.dto;
import com.sailun.domain.entity.News;
 
/**
 * @ClassName: NewsDto
 * @Description: 资讯发布
 * @author zhuzq
 * @date 2021年04月10日 15:36:28
 */ 
public class NewsDto extends News{

	private static final long serialVersionUID = 1L;
	
	private String typeName;
	
	private String createDateStr;

	
	public String getTypeName() {
		return typeName;
	}

	
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}


	
	public String getCreateDateStr() {
		return createDateStr;
	}


	
	public void setCreateDateStr(String createDateStr) {
		this.createDateStr = createDateStr;
	}
	
	
	
}