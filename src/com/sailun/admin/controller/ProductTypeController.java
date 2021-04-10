package com.sailun.admin.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sailun.admin.domain.dto.ProductTypeDto;
import com.sailun.admin.domain.vo.ProductTypeVo;
import com.sailun.admin.service.ProductTypeService;
import com.sailun.common.entity.JsonResult;
import com.sailun.common.entity.AdminResultByPage;
import com.sailun.admin.annotation.AdminControllerLog;

/**
 * @ClassName: ProductTypeController
 * @Description: 产品类别
 * @author zhuzq
 * @date 2021年04月10日 13:18:25
 */
@Controller
public class ProductTypeController {

	@Autowired
	private ProductTypeService productTypeService;

	/**
	 * @Title: save
	 * @Description: 保存
	 * @author zhuzq
	 * @date 2021年04月10日 13:18:25
	 * @param productTypeVo
	 * @return
	 */
	@AdminControllerLog(description="产品类别保存")
	@ResponseBody
	@RequestMapping(value = "/admin/center/productType/save", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult save(ProductTypeVo productTypeVo) {
		JsonResult result = new JsonResult();

		// 参数验证
		String errMsg = productTypeService.checkParam(productTypeVo);
		if (StringUtils.isNotBlank(errMsg)) {
			result.failure(errMsg);
			return result;
		}

		// 唯一性验证
		//errMsg = productTypeService.checkUnique(productTypeVo);
		//if (StringUtils.isNotBlank(errMsg)) {
		//	result.failure(errMsg);
		//	return result;
		//}
		// 保存
		boolean save = productTypeService.saveProductType(productTypeVo);
		if (save) {
			result.success();
		} else {
			result.failure();
		}

		return result;
	}

	/**
	 * @Title: delete
	 * @Description: 删除
	 * @author zhuzq
	 * @date 2021年04月10日 13:18:25
	 * @param productTypeId
	 * @return
	 */
	@AdminControllerLog(description="产品类别删除")
	@ResponseBody
	@RequestMapping(value = "/admin/center/productType/delete", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult delete(Integer productTypeId) {
		JsonResult result = new JsonResult();

		// 验证参数
		if (null == productTypeId) {
			result.failure("主键不能为空");
			return result;
		}
		// 删除
		boolean delete = productTypeService.deleteProductType(productTypeId);
		if (delete) {
			result.success();
		} else {
			result.failure();
		}

		return result;
	}

	/**
	 * @Title: batchDelete
	 * @Description: 批量删除
	 * @author zhuzq
	 * @date 2021年04月10日 13:18:25
	 * @param productTypeIdArr
	 * @return
	 */
	@AdminControllerLog(description="产品类别批量删除")
	@ResponseBody
	@RequestMapping(value = "/admin/center/productType/batch/delete", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult deleteByIdArr(@RequestParam("productTypeIdArr[]") Integer[] productTypeIdArr) {
		JsonResult result = new JsonResult();
		// 验证参数
		if (null == productTypeIdArr || productTypeIdArr.length < 1) {
			result.failure("请选项要删除的数据");
			return result;
		}
		// 删除
		Integer delete = productTypeService.deleteByBatch(productTypeIdArr);
		if (null != delete && delete > 0) {
			result.success();
		} else {
			result.failure();
		}

		return result;
	}

	/**
	 * @Title: update
	 * @Description: 修改
	 * @author zhuzq
	 * @date 2021年04月10日 13:18:25
	 * @param productTypeVo
	 * @return
	 */
	@AdminControllerLog(description="产品类别修改")
	@ResponseBody
	@RequestMapping(value = "/admin/center/productType/update", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult update(ProductTypeVo productTypeVo) {
		JsonResult result = new JsonResult();

		// 验证参数
		Integer productTypeId = productTypeVo.getProductTypeId();
		if (null == productTypeId) {
			result.failure("主键不能为空");
			return result;
		}
		String errMsg = productTypeService.checkParam(productTypeVo);
		if (StringUtils.isNotBlank(errMsg)) {
			result.failure(errMsg);
			return result;
		}

		// 唯一性验证
		//errMsg = productTypeService.checkUnique(productTypeVo);
		//if (StringUtils.isNotBlank(errMsg)) {
		//	result.failure(errMsg);
		//	return result;
		//}
		// 修改
		boolean update = productTypeService.updateProductType(productTypeVo);
		if (update) {
			result.success();
		} else {
			result.failure();
		}

		return result;
	}

	/**
	 * @Title: list
	 * @Description: 分页查找
	 * @author zhuzq
	 * @date 2021年04月10日 13:18:25
	 * @param productTypeVo
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/admin/center/productType/list", method = { RequestMethod.POST })
	public AdminResultByPage list(ProductTypeVo productTypeVo, HttpServletRequest request) {

		Integer page = Integer.valueOf(request.getParameter("page"));
		Integer limit = Integer.valueOf(request.getParameter("limit"));

		AdminResultByPage jsonResult = new AdminResultByPage(page, limit);

		jsonResult = productTypeService.findByPage(productTypeVo, jsonResult);

		return jsonResult;
	}

	/**
	 * @Title: toList
	 * @Description: 列表UI
	 * @author zhuzq
	 * @date 2021年04月10日 13:18:25
	 * @return
	 */
	@RequestMapping(value = "/admin/center/productType/list/ui", method = { RequestMethod.GET })
	public String toList() {
		return "/admin/center/productType/productType_list";
	}

	/**
	 * @Title: edit
	 * @Description: 编辑
	 * @author zhuzq
	 * @date 2021年04月10日 13:18:25
	 * @param productTypeId
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/admin/center/productType/edit", method = { RequestMethod.GET, RequestMethod.POST })
	public String edit(Integer productTypeId, HttpServletRequest request) {
		// 编辑,为空新增
		if (null != productTypeId) {
			ProductTypeDto entity = productTypeService.getProductType(productTypeId);
			request.setAttribute("entity", entity);
		}
		return "/admin/center/productType/productType_edit";
	}
	
	/**
	 * @Title: get
	 * @Description: 查找
	 * @author zhuzq
	 * @date 2021年04月10日 13:18:25
	 * @param productTypeId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/admin/center/productType/get", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult get(Integer productTypeId) {

		JsonResult result = new JsonResult();
		// 验证参数
		if (null == productTypeId || productTypeId < 1) {
			result.failure("用户ID不能为空");
			return result;
		}
		ProductTypeDto entity = productTypeService.getProductType(productTypeId);
		result.success("entity", entity);
		return result;
	}

}
