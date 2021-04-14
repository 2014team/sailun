package com.sailun.domain.entity;
import com.sailun.common.entity.BaseEntity;
 
/**
 * @ClassName: PageConfig
 * @Description: 页面配置
 * @author zhuzq
 * @date 2021年04月14日 14:37:30
 */ 
public class PageConfig extends BaseEntity{

	private static final long serialVersionUID = 1L;
	/**
	 * 主键
	 */
	private Integer pageConfigId;
	/**
	 * 配置页面
	 */
	private String configPageName;
	/**
	 * 编号
	 */
	private String code;
 
	public Integer getPageConfigId(){
		return this.pageConfigId;
	}
	
	public void setPageConfigId(Integer pageConfigId){
		this.pageConfigId = pageConfigId;
	}
	public String getConfigPageName(){
		return this.configPageName;
	}
	
	public void setConfigPageName(String configPageName){
		this.configPageName = configPageName;
	}
	public String getCode(){
		return this.code;
	}
	
	public void setCode(String code){
		this.code = code;
	}
}