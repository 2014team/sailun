package com.sailun.service;

import com.sailun.common.service.BaseService;
import com.sailun.domain.dto.ProductTypeDto;
import com.sailun.domain.entity.ProductType;
import com.sailun.domain.vo.ProductTypeVo;
import com.sailun.common.entity.AdminResultByPage;

/**
 * @ClassName: ProductTypeDao
 * @Description: 产品类别
 * @author zhuzq
 * @date 2021年04月10日 13:18:29
 */
public interface ProductTypeService extends BaseService<ProductType,Integer>{

	/**
	 * @Title: saveProductType
	 * @Description: 保存
	 * @author zhuzq
	 * @date 2021年04月10日 13:18:29
	 * @param productTypeVo
	 * @return
	 */
	public boolean saveProductType(ProductTypeVo productTypeVo);

	/**
	 * @Title: deleteProductType
	 * @Description: 删除
	 * @author zhuzq
	 * @date 2021年04月10日 13:18:29
	 * @param productTypeId
	 * @return
	 */
	public boolean deleteProductType(Integer productTypeId);

	/**
	 * @Title: deleteByBatch
	 * @Description: 批量删除
	 * @author zhuzq
	 * @date 2021年04月10日 13:18:29
	 * @param productTypeIdArr
	 * @return
	 */
	public int deleteByBatch(Integer[] productTypeIdArr);

	/**
	 * @Title: updateProductType
	 * @Description: 修改
	 * @author zhuzq
	 * @date 2021年04月10日 13:18:29
	 * @param productTypeVo
	 * @return
	 */
	public boolean updateProductType(ProductTypeVo productTypeVo);

	/**
	 * @Title: getProductType
	 * @Description: 根据productTypeId获取对象
	 * @author zhuzq
	 * @date 2021年04月10日 13:18:29
	 * @param productTypeId
	 * @return
	 */
	public ProductTypeDto getProductType(Integer productTypeId);

	/**
	 * @Title: findByPage
	 * @Description: 分页查找
	 * @author zhuzq
	 * @date 2021年04月10日 13:18:29
	 * @param productTypeVo
	 * @param jsonResult
	 * @return
	 */
	public AdminResultByPage findByPage(ProductTypeVo productTypeVo, AdminResultByPage jsonResult);

	/**
	 * @Title: checkParam
	 * @Description: 参数验证
	 * @author zhuzq
	 * @date 2021年04月10日 13:18:29
	 * @param productTypeVo
	 * @return
	 */
	public String checkParam(ProductTypeVo productTypeVo);

	/**
	 * @Title: checkUnique
	 * @Description: 唯一性验证
	 * @author zhuzq
	 * @date 2021年04月10日 13:18:29
	 * @param productTypeVo
	 * @return
	 */
	public String checkUnique(ProductTypeVo productTypeVo);

}
