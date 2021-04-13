package com.sailun.admin.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sailun.admin.dao.ProductTypeDao;
import com.sailun.admin.domain.entity.ProductType;
import com.sailun.admin.service.ProductTypeService;
import com.sailun.common.service.impl.BaseServiceImpl;
import com.sailun.admin.domain.vo.ProductTypeVo;
import com.sailun.admin.domain.dto.ProductTypeDto;
import com.sailun.common.entity.AdminResultByPage;
import com.sailun.admin.annotation.AdminServiceLog;

/**
 * @ClassName: ProductTypeServiceImpl
 * @Description: 产品类别
 * @author zhuzq
 * @date 2021年04月10日 13:18:29
 */
@Service
public class ProductTypeServiceImpl extends BaseServiceImpl<ProductType,Integer>  implements ProductTypeService {
	
	@Autowired
	private ProductTypeDao productTypeDao;


	/**
	 * @Title: saveProductType
	 * @Description: 保存
	 * @author zhuzq
	 * @date 2021年04月10日 13:18:29
	 * @param productTypeVo
	 * @return
	 */
	@AdminServiceLog(description="产品类别保存")
	@Override
	public boolean saveProductType(ProductTypeVo productTypeVo) {
		// ProductTypeVo转ProductType
		ProductType productType = convertProductType(productTypeVo);
		Integer result = productTypeDao.save(productType);
		if (null != result && result > 0) {
			return true;
		}
		return false;
	}

	/**
	 * @Title: deleteProductType
	 * @Description: 删除
	 * @author zhuzq
	 * @date 2021年04月10日 13:18:29
	 * @param productTypeId
	 * @return
	 */
	@AdminServiceLog(description="产品类别 删除")
	@Override
	public boolean deleteProductType(Integer productTypeId) {
		Integer result = productTypeDao.delete(productTypeId);
		if (null != result && result > 0) {
			return true;
		}
		return false;
	}

	/**
	 * @Title: deleteByBatch
	 * @Description: 批量删除
	 * @author zhuzq
	 * @date 2021年04月10日 13:18:29
	 * @param productTypeIdArr
	 * @return
	 */
	@AdminServiceLog(description="产品类别 批量删除")
	@Override
	public int deleteByBatch(Integer[] productTypeIdArr) {
		List<Integer> productTypeIdList = Arrays.asList(productTypeIdArr);
		return productTypeDao.deleteByBatch(productTypeIdList);
	}

	/**
	 * @Title: updateProductType
	 * @Description: 修改
	 * @author zhuzq
	 * @date 2021年04月10日 13:18:29
	 * @param productTypeVo
	 * @return
	 */
	@AdminServiceLog(description="产品类别 批量修改")
	@Override
	public boolean updateProductType(ProductTypeVo productTypeVo) {
		// ProductTypeVo转ProductType
		ProductType productType = convertProductType(productTypeVo);
		Integer result = productTypeDao.update(productType);
		if (null != result && result > 0) {
			return true;
		}
		return false;
	}

	/**
	 * @Title: getProductType
	 * @Description: 根据productTypeId获取产品类别
	 * @author zhuzq
	 * @date 2021年04月10日 13:18:29
	 * @param productTypeId
	 * @return
	 */
	 @AdminServiceLog(description="产品类别根据productTypeId获取产品类别")
	@Override
	public ProductTypeDto getProductType(Integer productTypeId) {
		ProductTypeDto productTypeDTO = null;
		ProductType productType = productTypeDao.get(productTypeId);
		if (null != productType) {
			productTypeDTO = convertProductTypeDto(productType);
		}
		return productTypeDTO;
	}

	/**
	 * @Title: findByPage
	 * @Description: 分页查找
	 * @author zhuzq
	 * * @date 2021年04月10日 13:18:29
	 * @param productTypeVo
	 * @param jsonResult
	 * @return
	 */
	@AdminServiceLog(description="产品类别分页查找")
	@Override
	public AdminResultByPage findByPage(ProductTypeVo productTypeVo, AdminResultByPage jsonResult) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("productTypeVo", productTypeVo);
		paramMap.put("page", jsonResult);

		int count = productTypeDao.findByPageCount(paramMap);

		if (count > 0) {
			List<ProductTypeDto> dataList = null;
			List<ProductType> productTypeList = findByPage(paramMap);
			if (null != productTypeList && productTypeList.size() > 0) {
				dataList = new ArrayList<ProductTypeDto>();
				for (ProductType productType : productTypeList) {
					// ProductType转ProductTypeDTO
					ProductTypeDto productTypeDTO = convertProductTypeDto(productType);
					dataList.add(productTypeDTO);
				}
			}
			jsonResult.setData(dataList);
			jsonResult.setCount(count);
		}
		return jsonResult;
	}

	/**
	 * @Title: checkParam
	 * @Description: 参数验证
	 * @author zhuzq
	 * @date 2021年04月10日 13:18:29
	 * @param productTypeVo
	 * @return
	 */
	@Override
	public String checkParam(ProductTypeVo productTypeVo) {
	    String typeName = productTypeVo.getTypeName();
		if (StringUtils.isBlank(typeName)) {
			return "分类名称不能为空";
		}
		return null;
	}


	/**
	 * @Title: checkUnique
	 * @Description: 唯一性验证
	 * @author zhuzq
	 * @date 2021年04月10日 13:18:29
	 * @param productTypeVo
	 * @return
	 */
	@Override
	public String checkUnique(ProductTypeVo ProductTypeVo) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("typeName", ProductTypeVo.getTypeName());
		List<ProductType> productTypeList = productTypeDao.select(paramMap);
		if (null == productTypeList || productTypeList.size() < 1) {
			return null;
		}

		Integer productTypeId = ProductTypeVo.getProductTypeId();
		if (null != productTypeId) {
			for (ProductType entity : productTypeList) {
				if (!entity.getProductTypeId().equals(productTypeId) && entity.getTypeName().equals(ProductTypeVo.getTypeName())) {
					return "分类名称已经存在";
				}
			}
		} else {
			return "分类名称已经存在";
		}
		return null;

	}

	/**
	 * @Title: convertProductType
	 * @Description: ProductTypeVo转ProductType
	 * @author zhuzq
	 * @date 2021年04月10日 13:18:29
	 * @param productTypeVo
	 * @return
	 */
	private ProductType convertProductType(ProductTypeVo productTypeVo) {
		ProductType productType = new ProductType();
		productType.setProductTypeId(productTypeVo.getProductTypeId());
		productType.setTypeName(productTypeVo.getTypeName());
		productType.setCreateDate(productTypeVo.getCreateDate());
		productType.setUpdateDate(productTypeVo.getUpdateDate());
		return productType;
	}

	/**
	 * @Title: convertProductTypeDto
	 * @Description: ProductType转ProductTypeDto
	 * @author zhuzq
	 * @date 2021年04月10日 13:18:29
	 * @param productType
	 * @return
	 */
	private ProductTypeDto convertProductTypeDto(ProductType productType) {
		ProductTypeDto dto = new ProductTypeDto();
		dto.setProductTypeId(productType.getProductTypeId());
		dto.setTypeName(productType.getTypeName());
		dto.setCreateDate(productType.getCreateDate());
		dto.setUpdateDate(productType.getUpdateDate());
		return dto;
	}
	
}
