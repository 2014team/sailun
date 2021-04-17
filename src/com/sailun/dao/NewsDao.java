package com.sailun.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.sailun.common.dao.BaseDao;
import com.sailun.domain.dto.NewsDto;
import com.sailun.domain.entity.News;

/**
 * @ClassName: NewsDao
 * @Description: 资讯发布
 * @author zhuzq
 * @date 2021年04月10日 15:36:28
 */
@Repository
public interface NewsDao extends BaseDao<News,Integer>{

	public List<NewsDto> findListByPage(Map<String,Object> paramMap);
	
	public Integer findNewsListByPageCount(Map<String,Object> paramMap);
	public List<NewsDto> findNewsListByPage(Map<String,Object> paramMap);
	
	public Integer findListByPageCount(Map<String,Object> paramMap);
	
	public NewsDto getNews(Integer id);
}
