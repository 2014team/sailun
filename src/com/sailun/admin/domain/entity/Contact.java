package com.sailun.admin.domain.entity;
import com.sailun.common.entity.BaseEntity;
 
/**
 * @ClassName: Contact
 * @Description: 联系信息
 * @author zhuzq
 * @date 2021年04月05日 17:02:25
 */ 
public class Contact extends BaseEntity{

	private static final long serialVersionUID = 1L;
	/**
	 * 主键
	 */
	private Integer contactId;
	/**
	 * 电话
	 */
	private String mobileNum;
 
	public Integer getContactId(){
		return this.contactId;
	}
	
	public void setContactId(Integer contactId){
		this.contactId = contactId;
	}
	public String getMobileNum(){
		return this.mobileNum;
	}
	
	public void setMobileNum(String mobileNum){
		this.mobileNum = mobileNum;
	}
}