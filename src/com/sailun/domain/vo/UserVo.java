package com.sailun.domain.vo;

import com.sailun.common.entity.BaseEntity;
import com.sailun.domain.entity.User;

public class UserVo extends User {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 开始日期
	 */
	private String startDate;
	/**
	 * 结束日期
	 * */
	private String endDate;
	
	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
}
