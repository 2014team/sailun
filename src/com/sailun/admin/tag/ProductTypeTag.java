
package com.sailun.admin.tag;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sailun.admin.domain.entity.ProductType;
import com.sailun.admin.service.ProductTypeService;
import com.sailun.common.util.SpringConfigUtil;

public class ProductTypeTag {

	public static ProductTypeService  productTypeService = (ProductTypeService) SpringConfigUtil
			.getBean("productTypeServiceImpl");

	public static List<ProductType> getList(){
		Map<String,Object> paramMap = new HashMap<String, Object>();
		List<ProductType> list = productTypeService.select(paramMap);
		return list;
	}
	
	
	
}
