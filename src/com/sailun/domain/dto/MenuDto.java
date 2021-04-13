
package com.sailun.domain.dto;

import java.util.List;

import com.sailun.common.entity.BaseEntity;
import com.sailun.domain.entity.Menu;

/**
 * @ClassName: MenuDto
 * @Description: 菜单
 * @author zhuzq
 * @date 2020年05月04日 13:39:50
 */
public class MenuDto extends Menu {

	private static final long serialVersionUID = 1L;

	private List<MenuDto> childList;

	
	public List<MenuDto> getChildList() {
		return childList;
	}

	
	public void setChildList(List<MenuDto> childList) {
		this.childList = childList;
	}

	
	

}