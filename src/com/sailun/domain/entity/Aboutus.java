package com.sailun.domain.entity;
import com.sailun.common.entity.BaseEntity;
 
/**
 * @ClassName: Aboutus
 * @Description: 关于我们
 * @author zhuzq
 * @date 2021年04月09日 23:08:54
 */ 
public class Aboutus extends BaseEntity{

	private static final long serialVersionUID = 1L;
	/**
	 * 主键
	 */
	private Integer aboutusId;
	/*状态*/
	private Integer status;
	/**
	 * 内容
	 */
	private String content;
 
	public Integer getAboutusId(){
		return this.aboutusId;
	}
	
	public void setAboutusId(Integer aboutusId){
		this.aboutusId = aboutusId;
	}
	public String getContent(){
		return this.content;
	}
	
	public void setContent(String content){
		this.content = content;
	}

	
	public Integer getStatus() {
		return status;
	}

	
	public void setStatus(Integer status) {
		this.status = status;
	}
	
}