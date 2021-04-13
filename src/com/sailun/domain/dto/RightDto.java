
package com.sailun.domain.dto;

import java.util.Date;
import java.util.List;

import com.sailun.common.entity.BaseEntity;
import com.sailun.domain.entity.Menu;

public class RightDto extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	 * 最后更新日期
	 */
	private Date lastDate;

	/**
	* 菜单
	*/
	private List<Menu> menuList;

	public Date getLastDate() {

		return lastDate;
	}

	public void setLastDate(Date lastDate) {

		this.lastDate = lastDate;
	}

	public List<Menu> getMenuList() {

		return menuList;
	}

	public void setMenuList(List<Menu> menuList) {

		this.menuList = menuList;
	}

	public RightDto(Date lastDate, List<Menu> menuList) {
		super();
		this.lastDate = lastDate;
		this.menuList = menuList;
	}

}