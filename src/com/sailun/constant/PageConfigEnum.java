
package com.sailun.constant;


public enum PageConfigEnum {
	
	INDEX_BANNER(100, "banner"), // 首页Banner
	INDEX_PRODUCT(200, "product"),// 首页产品
	DRIVER_DRIVER(300, "driver"),// 车手
	NEW_NEWSTYPE(400, "newsType"),// 新闻类别
	PRODUCTTYPE(500, "productType"),// 产品类别
	PAGECREATE(1000, "pageCreate"),
	;
	private int value;
	// 显示名称
	private String displayName;

	PageConfigEnum(int value, String displayName) {
		this.value = value;
		this.displayName = displayName;
	}

	public static String getNameByValue(Integer value) {
		PageConfigEnum type = getByValue(value);
		return null == type ? "" : type.name();
	}

	public static String getDisplayNameByValue(Integer value) {
		PageConfigEnum type = getByValue(value);
		return null == type ? "" : type.getDisplayName();
	}

	public static PageConfigEnum getByValue(Integer value) {
		if (null != value) {
			for (PageConfigEnum type : PageConfigEnum.values()) {
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
