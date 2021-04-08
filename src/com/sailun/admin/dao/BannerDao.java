package com.sailun.admin.dao;

import com.sailun.common.dao.BaseDao;
import org.springframework.stereotype.Repository;
import com.sailun.admin.domain.entity.Banner;

/**
 * @ClassName: BannerDao
 * @Description: 广告 banner
 * @author zhuzq
 * @date 2021年04月09日 00:05:18
 */
@Repository
public interface BannerDao extends BaseDao<Banner,Integer>{

}
