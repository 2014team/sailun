
package com.sailun.tag;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sailun.domain.entity.ProductType;
import com.sailun.service.ProductTypeService;
import com.sailun.util.SpringConfigUtil;

public class ProductTypeTag {

	public static ProductTypeService  productTypeService = (ProductTypeService) SpringConfigUtil
			.getBean("productTypeServiceImpl");

	public static List<ProductType> getList(){
		Map<String,Object> paramMap = new HashMap<String, Object>();
		List<ProductType> list = productTypeService.select(paramMap);
		return list;
	}
	
	
	
}
