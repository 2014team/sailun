package com.sailun.admin.dao;

import com.sailun.common.dao.BaseDao;
import org.springframework.stereotype.Repository;
import com.sailun.admin.domain.entity.NewsType;

/**
 * @ClassName: NewsTypeDao
 * @Description: 新闻类别
 * @author zhuzq
 * @date 2021年04月10日 15:23:25
 */
@Repository
public interface NewsTypeDao extends BaseDao<NewsType,Integer>{

}
