
package com.sailun.constant;


public enum PageConfigEnum {
	INDEX_BANNER(100, "首页Banner"), // 首页Banner
	INDEX_PRODUCT(200, "首页产品"),// 首页产品
	;
	private int value;
	// 显示名称
	private String displayName;

	PageConfigEnum(int value, String displayName) {
		this.value = value;
		this.displayName = displayName;
	}

	public static String getNameByValue(Integer value) {
		MenuTypeEnum type = getByValue(value);
		return null == type ? "" : type.name();
	}

	public static String getDisplayNameByValue(Integer value) {
		MenuTypeEnum type = getByValue(value);
		return null == type ? "" : type.getDisplayName();
	}

	public static MenuTypeEnum getByValue(Integer value) {
		if (null != value) {
			for (MenuTypeEnum type : MenuTypeEnum.values()) {
				if (type.getValue() == value) {
					return type;
				}
			}
		}
		return null;
	}

	public static int getValueByName(String name) {
		if (null != name && "".equals(name.trim())) {
			PageConfigEnum type = PageConfigEnum.valueOf(name);
			return null == type ? 0 : type.value;
		}
		return 0;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
}
