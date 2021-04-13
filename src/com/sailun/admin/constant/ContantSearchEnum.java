
package com.sailun.admin.constant;

/**
 * @ClassName: ContantSearchEnum
 * @Description: 联系我们
 * @author zhuzq
 * @date 2020年4月16日 下午3:46:06
 */
public enum ContantSearchEnum {
	NAME(1, "姓名"), 
	MOBILENUM(2, "电话"),
	EMAIL(3, "邮箱"),;
	

	private Integer value;

	private String name;

	private ContantSearchEnum(int value, String name) {
		this.value = value;
		this.name = name;
	}

	public static String getNameByValue(Integer value) {
		ContantSearchEnum[] menuTypeEnumArr = ContantSearchEnum.values();
		for (ContantSearchEnum menuTypeEnum : menuTypeEnumArr) {
			Integer valueEnum = menuTypeEnum.value;
			if (valueEnum.equals(value)) {
				return menuTypeEnum.name;
			}
		}
		return null;
	}

	
	public Integer getValue() {
		return value;
	}

	
	public void setValue(Integer value) {
		this.value = value;
	}

	
	public String getName() {
		return name;
	}

	
	public void setName(String name) {
		this.name = name;
	}
	
	
}
