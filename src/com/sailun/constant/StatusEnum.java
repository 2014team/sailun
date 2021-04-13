
package com.sailun.constant;


public enum StatusEnum {
	ON(0, "启用"), // 启用
	OFF(1, "停用"),// 停用
	;

	private int value;
	// 显示名称
	private String displayName;

	StatusEnum(int value, String displayName) {
		this.value = value;
		this.displayName = displayName;
	}

	public static String getNameByValue(Integer value) {
		StatusEnum type = getByValue(value);
		return null == type ? "" : type.name();
	}

	public static String getDisplayNameByValue(Integer value) {
		StatusEnum type = getByValue(value);
		return null == type ? "" : type.getDisplayName();
	}

	public static StatusEnum getByValue(Integer value) {
		if (null != value) {
			for (StatusEnum type : StatusEnum.values()) {
				if (type.getValue() == value) {
					return type;
				}
			}
		}
		return null;
	}

	public static int getValueByName(String name) {
		if (null != name && "".equals(name.trim())) {
			StatusEnum type = StatusEnum.valueOf(name);
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
