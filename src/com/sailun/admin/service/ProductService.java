package com.sailun.admin.service;

import com.sailun.common.service.BaseService;
import com.sailun.admin.domain.entity.Product;
import com.sailun.admin.domain.vo.ProductVo;

import org.springframework.web.multipart.MultipartFile;

import com.sailun.admin.domain.dto.ProductDto;
import com.sailun.common.entity.AdminResultByPage;

/**
 * @ClassName: ProductDao
 * @Description: 产品展示
 * @author zhuzq
 * @date 2021年04月10日 10:55:15
 */
public interface ProductService extends BaseService<Product,Integer>{

	/**
	 * @Title: saveProduct
	 * @Description: 保存
	 * @author zhuzq
	 * @date 2021年04月10日 10:55:15
	 * @param productVo
	 * @return
	 */
	public boolean saveProduct(ProductVo productVo);

	/**
	 * @Title: deleteProduct
	 * @Description: 删除
	 * @author zhuzq
	 * @date 2021年04月10日 10:55:15
	 * @param productId
	 * @return
	 */
	public boolean deleteProduct(Integer productId);

	/**
	 * @Title: deleteByBatch
	 * @Description: 批量删除
	 * @author zhuzq
	 * @date 2021年04月10日 10:55:15
	 * @param productIdArr
	 * @return
	 */
	public int deleteByBatch(Integer[] productIdArr);

	/**
	 * @Title: updateProduct
	 * @Description: 修改
	 * @author zhuzq
	 * @date 2021年04月10日 10:55:15
	 * @param productVo
	 * @return
	 */
	public boolean updateProduct(ProductVo productVo);

	/**
	 * @Title: getProduct
	 * @Description: 根据productId获取对象
	 * @author zhuzq
	 * @date 2021年04月10日 10:55:15
	 * @param productId
	 * @return
	 */
	public ProductDto getProduct(Integer productId);

	/**
	 * @Title: findByPage
	 * @Description: 分页查找
	 * @author zhuzq
	 * @date 2021年04月10日 10:55:15
	 * @param productVo
	 * @param jsonResult
	 * @return
	 */
	public AdminResultByPage findByPage(ProductVo productVo, AdminResultByPage jsonResult);

	/**
	 * @Title: checkParam
	 * @Description: 参数验证
	 * @author zhuzq
	 * @date 2021年04月10日 10:55:15
	 * @param productVo
	 * @return
	 */
	public String checkParam(ProductVo productVo,MultipartFile file);

	/**
	 * @Title: checkUnique
	 * @Description: 唯一性验证
	 * @author zhuzq
	 * @date 2021年04月10日 10:55:15
	 * @param productVo
	 * @return
	 */
	public String checkUnique(ProductVo productVo);

}
