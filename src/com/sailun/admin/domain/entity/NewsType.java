package com.sailun.admin.domain.entity;
import com.sailun.common.entity.BaseEntity;
 
/**
 * @ClassName: NewsType
 * @Description: 新闻类别
 * @author zhuzq
 * @date 2021年04月10日 15:23:26
 */ 
public class NewsType extends BaseEntity{

	private static final long serialVersionUID = 1L;
	/**
	 * 主键
	 */
	private Integer newsTypeId;
	/**
	 * 分类名称
	 */
	private String typeName;
 
	public Integer getNewsTypeId(){
		return this.newsTypeId;
	}
	
	public void setNewsTypeId(Integer newsTypeId){
		this.newsTypeId = newsTypeId;
	}
	public String getTypeName(){
		return this.typeName;
	}
	
	public void setTypeName(String typeName){
		this.typeName = typeName;
	}
}