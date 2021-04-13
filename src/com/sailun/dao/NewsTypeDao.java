package com.sailun.dao;

import com.sailun.common.dao.BaseDao;
import com.sailun.domain.entity.NewsType;

import org.springframework.stereotype.Repository;

/**
 * @ClassName: NewsTypeDao
 * @Description: 新闻类别
 * @author zhuzq
 * @date 2021年04月10日 15:23:25
 */
@Repository
public interface NewsTypeDao extends BaseDao<NewsType,Integer>{

}
