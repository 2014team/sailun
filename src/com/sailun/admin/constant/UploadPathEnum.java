
package com.sailun.admin.constant;

/**
 * @ClassName: UploadPathEnum
 * @Description: 上传路径
 * @author zhuzq
 * @date 2021年4月9日 下午9:55:45
 */
public enum UploadPathEnum {
	INDEX_BANNER(1, "/upload/banner"), // 首页banner
	ABOUT_US(2, "/upload/aboutus"), // 关于我们
	;

	private Integer value;

	private String name;

	private UploadPathEnum(int value, String name) {
		this.value = value;
		this.name = name;
	}

	public static String getNameByValue(Integer value) {
		UploadPathEnum[] menuTypeEnumArr = UploadPathEnum.values();
		for (UploadPathEnum menuTypeEnum : menuTypeEnumArr) {
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
