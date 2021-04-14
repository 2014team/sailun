package com.sailun.domain.entity;
import com.sailun.common.entity.BaseEntity;
 
/**
 * @ClassName: PageCreate
 * @Description: 页面创建
 * @author zhuzq
 * @date 2021年04月14日 14:56:53
 */ 
public class PageCreate extends BaseEntity{

	private static final long serialVersionUID = 1L;
	/**
	 * 主键
	 */
	private Integer pageCreateId;
	/**
	 * 模本名称
	 */
	private String templateName;
	/**
	 * 模本路径
	 */
	private String templatePath;
	/**
	 * 模本内容
	 */
	private String templateContent;
	/**
	 * 生成文件路径
	 */
	private String generatorFile;
	/**
	 * 排序
	 */
	private Integer sort;
	/**
	 * 页面配置ID
	 */
	private Integer pageConfigId;
 
	public Integer getPageCreateId(){
		return this.pageCreateId;
	}
	
	public void setPageCreateId(Integer pageCreateId){
		this.pageCreateId = pageCreateId;
	}
	public String getTemplateName(){
		return this.templateName;
	}
	
	public void setTemplateName(String templateName){
		this.templateName = templateName;
	}
	public String getTemplatePath(){
		return this.templatePath;
	}
	
	public void setTemplatePath(String templatePath){
		this.templatePath = templatePath;
	}
	public String getTemplateContent(){
		return this.templateContent;
	}
	
	public void setTemplateContent(String templateContent){
		this.templateContent = templateContent;
	}
	public String getGeneratorFile(){
		return this.generatorFile;
	}
	
	public void setGeneratorFile(String generatorFile){
		this.generatorFile = generatorFile;
	}
	public Integer getSort(){
		return this.sort;
	}
	
	public void setSort(Integer sort){
		this.sort = sort;
	}
	public Integer getPageConfigId(){
		return this.pageConfigId;
	}
	
	public void setPageConfigId(Integer pageConfigId){
		this.pageConfigId = pageConfigId;
	}
}