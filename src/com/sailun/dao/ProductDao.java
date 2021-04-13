package com.sailun.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.sailun.common.dao.BaseDao;
import com.sailun.domain.dto.ProductDto;
import com.sailun.domain.entity.Product;

/**
 * @ClassName: ProductDao
 * @Description: 产品展示
 * @author zhuzq
 * @date 2021年04月10日 10:55:12
 */
@Repository
public interface ProductDao extends BaseDao<Product,Integer>{
	
	public List<ProductDto> findListByPage(Map<String,Object> paramMap);
	
	public Integer findListByPageCount(Map<String,Object> paramMap);
	
	public ProductDto getProduct(Integer id);

}
