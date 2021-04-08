package com.sailun.admin.domain.entity;
import com.sailun.common.entity.BaseEntity;
 
/**
 * @ClassName: Banner
 * @Description: 广告 banner
 * @author zhuzq
 * @date 2021年04月09日 00:05:19
 */ 
public class Banner extends BaseEntity{

	private static final long serialVersionUID = 1L;
	/**
	 * 主键
	 */
	private Integer bannerId;
	/**
	 * 图片地址
	 */
	private String imageUrl;
	/**
	 * 跳转地址
	 */
	private String jumpUrl;
	/**
	 * 1:停用
	 */
	private Integer status;
 
	public Integer getBannerId(){
		return this.bannerId;
	}
	
	public void setBannerId(Integer bannerId){
		this.bannerId = bannerId;
	}
	public String getImageUrl(){
		return this.imageUrl;
	}
	
	public void setImageUrl(String imageUrl){
		this.imageUrl = imageUrl;
	}
	public String getJumpUrl(){
		return this.jumpUrl;
	}
	
	public void setJumpUrl(String jumpUrl){
		this.jumpUrl = jumpUrl;
	}
	public Integer getStatus(){
		return this.status;
	}
	
	public void setStatus(Integer status){
		this.status = status;
	}
}