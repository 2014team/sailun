package com.sailun.domain.entity;
import com.sailun.common.entity.BaseEntity;
 
/**
 * @ClassName: Contact
 * @Description: 联系我们
 * @author zhuzq
 * @date 2021年04月07日 23:01:43
 */ 
public class Contact extends BaseEntity{

	private static final long serialVersionUID = 1L;
	/**
	 * 主键
	 */
	private Integer contactId;
	/**
	 * 姓名
	 */
	private String username;
	/**
	 * 电话
	 */
	private String mobileNum;
	/**
	 * 邮箱
	 */
	private String email;
	/**
	 * 车辆品牌
	 */
	private String vehicleBrand;
	/**
	 * 型号
	 */
	private String type;
	/**
	 * 内容
	 */
	private String contents;
 
	public Integer getContactId(){
		return this.contactId;
	}
	
	public void setContactId(Integer contactId){
		this.contactId = contactId;
	}
	public String getUsername(){
		return this.username;
	}
	
	public void setUsername(String username){
		this.username = username;
	}
	public String getMobileNum(){
		return this.mobileNum;
	}
	
	public void setMobileNum(String mobileNum){
		this.mobileNum = mobileNum;
	}
	public String getEmail(){
		return this.email;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	public String getVehicleBrand(){
		return this.vehicleBrand;
	}
	
	public void setVehicleBrand(String vehicleBrand){
		this.vehicleBrand = vehicleBrand;
	}
	public String getType(){
		return this.type;
	}
	
	public void setType(String type){
		this.type = type;
	}
	public String getContents(){
		return this.contents;
	}
	
	public void setContents(String contents){
		this.contents = contents;
	}
}