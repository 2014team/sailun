
package com.sailun.domain.entity;

import com.sailun.common.entity.BaseEntity;

/**
 * @ClassName: News
 * @Description: 资讯发布
 * @author zhuzq
 * @date 2021年04月10日 15:36:29
 */
public class News extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	private Integer newsId;

	/**
	 * 标题
	 */
	private String title;

	/**
	 * 封面图片
	 */
	private String coverImage;

	/**
	 * 简介描述
	 */
	private String describe;

	/**
	 * 内容介绍
	 */
	private String content;

	/**
	 * 0:上架1：下架
	 */
	private Integer status;

	/**
	 * 新闻类别Id
	 */
	private Integer newsTypeId;
	
	private Integer sort;

	public Integer getNewsId() {
		return this.newsId;
	}

	public void setNewsId(Integer newsId) {
		this.newsId = newsId;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCoverImage() {
		return this.coverImage;
	}

	public void setCoverImage(String coverImage) {
		this.coverImage = coverImage;
	}

	public String getDescribe() {
		return this.describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getNewsTypeId() {
		return this.newsTypeId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setNewsTypeId(Integer newsTypeId) {
		this.newsTypeId = newsTypeId;
	}

	
	public Integer getSort() {
		return sort;
	}

	
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	

}