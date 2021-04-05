package com.sailun.admin.domain.entity;
import com.sailun.common.entity.BaseEntity;
 
/**
 * @ClassName: Menu
 * @Description: 菜单
 * @author zhuzq
 * @date 2020年05月04日 13:39:51
 */ 
public class Menu extends BaseEntity{

	private static final long serialVersionUID = 1L;
	/**
	 * 菜单ID
	 */
	private Integer menuId;
	/**
	 * 菜单名称
	 */
	private String menuName;
	/**
	 * 菜单url
	 */
	private String menuUrl;
	/**
	 * 有效标识 0:启用1：停用
	 */
	private Integer validFlag;
	/**
	 * 排序
	 */
	private Integer sortId;
	/**
	 * 0:菜单1：按钮
	 */
	private Integer menuType;
	/**
	 * 父类ID
	 */
	private String parentId;
	
	/**
	 * 图标
	 */
	private String icon;
 
	public Integer getMenuId(){
		return this.menuId;
	}
	
	public void setMenuId(Integer menuId){
		this.menuId = menuId;
	}
	public String getMenuName(){
		return this.menuName;
	}
	
	public void setMenuName(String menuName){
		this.menuName = menuName;
	}
	public String getMenuUrl(){
		return this.menuUrl;
	}
	
	public void setMenuUrl(String menuUrl){
		this.menuUrl = menuUrl;
	}
	public Integer getValidFlag(){
		return this.validFlag;
	}
	
	public void setValidFlag(Integer validFlag){
		this.validFlag = validFlag;
	}
	public Integer getSortId(){
		return this.sortId;
	}
	
	public void setSortId(Integer sortId){
		this.sortId = sortId;
	}
	public Integer getMenuType(){
		return this.menuType;
	}
	
	public void setMenuType(Integer menuType){
		this.menuType = menuType;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	
	public String getIcon() {
		return icon;
	}

	
	public void setIcon(String icon) {
		this.icon = icon;
	}
	
	
}