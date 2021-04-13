package com.sailun.admin.domain.dto;
import com.sailun.admin.domain.entity.Product;
 
/**
 * @ClassName: ProductDto
 * @Description: 产品展示
 * @author zhuzq
 * @date 2021年04月10日 10:55:12
 */ 
public class ProductDto extends Product{

	private static final long serialVersionUID = 1L;
	
	private String typeName;

	
	public String getTypeName() {
		return typeName;
	}

	
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
	
	
}