package com.sailun.admin.domain.entity;
import com.sailun.common.entity.BaseEntity;
 
/**
 * @ClassName: Driver
 * @Description: 车手介绍
 * @author zhuzq
 * @date 2021年04月10日 18:08:20
 */ 
public class Driver extends BaseEntity{

	private static final long serialVersionUID = 1L;
	/**
	 * 主键
	 */
	private Integer driverId;
	/**
	 * 车手名称
	 */
	private String driverName;
	/**
	 * 封面图片
	 */
	private String coverImage;
	/**
	 * 内容介绍
	 */
	private String content;
	/**
	 * 0:上架1：下架
	 */
	private Integer status;
 
	public Integer getDriverId(){
		return this.driverId;
	}
	
	public void setDriverId(Integer driverId){
		this.driverId = driverId;
	}
	public String getDriverName(){
		return this.driverName;
	}
	
	public void setDriverName(String driverName){
		this.driverName = driverName;
	}
	public String getCoverImage(){
		return this.coverImage;
	}
	
	public void setCoverImage(String coverImage){
		this.coverImage = coverImage;
	}
	public String getContent(){
		return this.content;
	}
	
	public void setContent(String content){
		this.content = content;
	}
	public Integer getStatus(){
		return this.status;
	}
	
	public void setStatus(Integer status){
		this.status = status;
	}
}