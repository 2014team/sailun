package com.sailun.service.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sailun.annotation.AdminServiceLog;
import com.sailun.common.entity.AdminResultByPage;
import com.sailun.common.service.impl.BaseServiceImpl;
import com.sailun.dao.ProductDao;
import com.sailun.domain.dto.ProductDto;
import com.sailun.domain.entity.Product;
import com.sailun.domain.vo.ProductVo;
import com.sailun.service.ProductService;

/**
 * @ClassName: ProductServiceImpl
 * @Description: 产品展示
 * @author zhuzq
 * @date 2021年04月10日 10:55:15
 */
@Service
public class ProductServiceImpl extends BaseServiceImpl<Product,Integer>  implements ProductService {
	
	@Autowired
	private ProductDao productDao;


	/**
	 * @Title: saveProduct
	 * @Description: 保存
	 * @author zhuzq
	 * @date 2021年04月10日 10:55:15
	 * @param productVo
	 * @return
	 */
	@AdminServiceLog(description="产品展示保存")
	@Override
	public boolean saveProduct(ProductVo productVo) {
		// ProductVo转Product
		Product product = convertProduct(productVo);
		Integer result = productDao.save(product);
		if (null != result && result > 0) {
			return true;
		}
		return false;
	}

	/**
	 * @Title: deleteProduct
	 * @Description: 删除
	 * @author zhuzq
	 * @date 2021年04月10日 10:55:15
	 * @param productId
	 * @return
	 */
	@AdminServiceLog(description="产品展示 删除")
	@Override
	public boolean deleteProduct(Integer productId) {
		Integer result = productDao.delete(productId);
		if (null != result && result > 0) {
			return true;
		}
		return false;
	}

	/**
	 * @Title: deleteByBatch
	 * @Description: 批量删除
	 * @author zhuzq
	 * @date 2021年04月10日 10:55:15
	 * @param productIdArr
	 * @return
	 */
	@AdminServiceLog(description="产品展示 批量删除")
	@Override
	public int deleteByBatch(Integer[] productIdArr) {
		List<Integer> productIdList = Arrays.asList(productIdArr);
		return productDao.deleteByBatch(productIdList);
	}

	/**
	 * @Title: updateProduct
	 * @Description: 修改
	 * @author zhuzq
	 * @date 2021年04月10日 10:55:15
	 * @param productVo
	 * @return
	 */
	@AdminServiceLog(description="产品展示 批量修改")
	@Override
	public boolean updateProduct(ProductVo productVo) {
		// ProductVo转Product
		Product product = convertProduct(productVo);
		Integer result = productDao.update(product);
		if (null != result && result > 0) {
			return true;
		}
		return false;
	}

	/**
	 * @Title: getProduct
	 * @Description: 根据productId获取产品展示
	 * @author zhuzq
	 * @date 2021年04月10日 10:55:15
	 * @param productId
	 * @return
	 */
	 @AdminServiceLog(description="产品展示根据productId获取产品展示")
	@Override
	public ProductDto getProduct(Integer productId) {
		ProductDto productDTO = productDao.getProduct(productId);
		return productDTO;
	}

	/**
	 * @Title: findByPage
	 * @Description: 分页查找
	 * @author zhuzq
	 * * @date 2021年04月10日 10:55:15
	 * @param productVo
	 * @param jsonResult
	 * @return
	 */
	@AdminServiceLog(description="产品展示分页查找")
	@Override
	public AdminResultByPage findByPage(ProductVo productVo, AdminResultByPage jsonResult) {
		//创建日期处理
		String createDateStr = productVo.getCreateDateStr();
		if(StringUtils.isNotBlank(createDateStr)){
			String[] createDateArr = createDateStr.split("~");
			if(null != createDateArr && createDateArr.length ==2){
				productVo.setBeginDate(createDateArr[0]);
				productVo.setEndDate(createDateArr[1]);
			}
		}
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("productVo", productVo);
		paramMap.put("page", jsonResult);
		
				

		int count = productDao.findListByPageCount(paramMap);

		if (count > 0) {
			List<ProductDto> dataList = productDao.findListByPage(paramMap);
			jsonResult.setData(dataList);
			jsonResult.setCount(count);
		}
		return jsonResult;
	}

	/**
	 * @Title: checkParam
	 * @Description: 参数验证
	 * @author zhuzq
	 * @date 2021年04月10日 10:55:15
	 * @param productVo
	 * @return
	 */
	@Override
	public String checkParam(ProductVo productVo,MultipartFile file) {
	    String title = productVo.getTitle();
		if (StringUtils.isBlank(title)) {
			return "标题不能为空";
		}
	    String coverImage = productVo.getCoverImage();
		if (StringUtils.isBlank(coverImage) && (null == file || file.isEmpty())) {
			return "封面图片不能为空";
		}
	    String describe = productVo.getDescribe();
		if (StringUtils.isBlank(describe)) {
			return "简介描述不能为空";
		}
//	    String content = productVo.getContent();
//		if (StringUtils.isBlank(content)) {
//			return "内容介绍不能为空";
//		}
		Integer status = productVo.getStatus();
		if (null == status) {
			return "0:上架1：下架不能为空";
		}
		return null;
	}


	/**
	 * @Title: checkUnique
	 * @Description: 唯一性验证
	 * @author zhuzq
	 * @date 2021年04月10日 10:55:15
	 * @param productVo
	 * @return
	 */
	@Override
	public String checkUnique(ProductVo ProductVo) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("title", ProductVo.getTitle());
		List<Product> productList = productDao.select(paramMap);
		if (null == productList || productList.size() < 1) {
			return null;
		}

		Integer productId = ProductVo.getProductId();
		if (null != productId) {
			for (Product entity : productList) {
				if (!entity.getProductId().equals(productId) && entity.getTitle().equals(ProductVo.getTitle())) {
					return "标题已经存在";
				}
			}
		} else {
			return "标题已经存在";
		}
		return null;

	}

	/**
	 * @Title: convertProduct
	 * @Description: ProductVo转Product
	 * @author zhuzq
	 * @date 2021年04月10日 10:55:15
	 * @param productVo
	 * @return
	 */
	private Product convertProduct(ProductVo productVo) {
		Product product = new Product();
		product.setProductId(productVo.getProductId());
		product.setTitle(productVo.getTitle());
		product.setCoverImage(productVo.getCoverImage());
		product.setDescribe(productVo.getDescribe());
		product.setContent(productVo.getContent());
		product.setStatus(productVo.getStatus());
		product.setCreateDate(productVo.getCreateDate());
		product.setUpdateDate(productVo.getUpdateDate());
		product.setProductTypeId(productVo.getProductTypeId());
		product.setSort(productVo.getSort());
		return product;
	}

	/**
	 * @Title: convertProductDto
	 * @Description: Product转ProductDto
	 * @author zhuzq
	 * @date 2021年04月10日 10:55:15
	 * @param product
	 * @return
	 */
	private ProductDto convertProductDto(Product product) {
		ProductDto dto = new ProductDto();
		dto.setProductId(product.getProductId());
		dto.setTitle(product.getTitle());
		dto.setCoverImage(product.getCoverImage());
		dto.setDescribe(product.getDescribe());
		dto.setContent(product.getContent());
		dto.setStatus(product.getStatus());
		dto.setCreateDate(product.getCreateDate());
		dto.setUpdateDate(product.getUpdateDate());
		dto.setProductTypeId(product.getProductTypeId());
		dto.setSort(product.getSort());
		return dto;
	}
	
}
