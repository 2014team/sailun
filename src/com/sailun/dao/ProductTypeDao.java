package com.sailun.dao;

import com.sailun.common.dao.BaseDao;
import com.sailun.domain.entity.ProductType;

import org.springframework.stereotype.Repository;

/**
 * @ClassName: ProductTypeDao
 * @Description: 产品类别
 * @author zhuzq
 * @date 2021年04月10日 13:18:26
 */
@Repository
public interface ProductTypeDao extends BaseDao<ProductType,Integer>{

}
