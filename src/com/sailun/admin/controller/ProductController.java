package com.sailun.admin.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.sailun.common.entity.JsonResult;
import com.sailun.constant.UploadPathEnum;
import com.sailun.domain.dto.ProductDto;
import com.sailun.domain.entity.ProductType;
import com.sailun.domain.vo.ProductVo;
import com.sailun.service.ImageService;
import com.sailun.service.ProductService;
import com.sailun.service.ProductTypeService;
import com.sailun.common.entity.AdminResultByPage;
import com.sailun.annotation.AdminControllerLog;

/**
 * @ClassName: ProductController
 * @Description: 产品展示
 * @author zhuzq
 * @date 2021年04月10日 10:55:11
 */
@Controller
public class ProductController {

	@Autowired
	private ProductService productService;
	@Autowired
	private ImageService imageService;
	@Autowired
	private ProductTypeService productTypeService;

	/**
	 * @Title: save
	 * @Description: 保存
	 * @author zhuzq
	 * @date 2021年04月10日 10:55:11
	 * @param productVo
	 * @return
	 */
	@AdminControllerLog(description="产品展示保存")
	@ResponseBody
	@RequestMapping(value = "/admin/center/product/save", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult save(ProductVo productVo,@RequestParam(value="file",required=false) MultipartFile file, HttpServletRequest request) {
		JsonResult result = new JsonResult();

		// 参数验证
		String errMsg = productService.checkParam(productVo,file);
		if (StringUtils.isNotBlank(errMsg)) {
			result.failure(errMsg);
			return result;
		}

		// 唯一性验证
		//errMsg = productService.checkUnique(productVo);
		//if (StringUtils.isNotBlank(errMsg)) {
		//	result.failure(errMsg);
		//	return result;
		//}
		if(file != null && !file.isEmpty()){
			String imageUrl = imageService.uploadImage(request, file, UploadPathEnum.PRODUCT.getName(),false);
			productVo.setCoverImage(imageUrl);
		}
		
		// 保存
		boolean save = productService.saveProduct(productVo);
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
	 * @date 2021年04月10日 10:55:11
	 * @param productId
	 * @return
	 */
	@AdminControllerLog(description="产品展示删除")
	@ResponseBody
	@RequestMapping(value = "/admin/center/product/delete", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult delete(Integer productId) {
		JsonResult result = new JsonResult();

		// 验证参数
		if (null == productId) {
			result.failure("主键不能为空");
			return result;
		}
		// 删除
		boolean delete = productService.deleteProduct(productId);
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
	 * @date 2021年04月10日 10:55:11
	 * @param productIdArr
	 * @return
	 */
	@AdminControllerLog(description="产品展示批量删除")
	@ResponseBody
	@RequestMapping(value = "/admin/center/product/batch/delete", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult deleteByIdArr(@RequestParam("productIdArr[]") Integer[] productIdArr) {
		JsonResult result = new JsonResult();
		// 验证参数
		if (null == productIdArr || productIdArr.length < 1) {
			result.failure("请选项要删除的数据");
			return result;
		}
		// 删除
		Integer delete = productService.deleteByBatch(productIdArr);
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
	 * @date 2021年04月10日 10:55:11
	 * @param productVo
	 * @return
	 */
	@AdminControllerLog(description="产品展示修改")
	@ResponseBody
	@RequestMapping(value = "/admin/center/product/update", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult update(ProductVo productVo,@RequestParam(value="file",required=false) MultipartFile file, HttpServletRequest request) {
		JsonResult result = new JsonResult();

		// 验证参数
		Integer productId = productVo.getProductId();
		if (null == productId) {
			result.failure("主键不能为空");
			return result;
		}
		String errMsg = productService.checkParam(productVo,file);
		if (StringUtils.isNotBlank(errMsg)) {
			result.failure(errMsg);
			return result;
		}

		// 唯一性验证
		//errMsg = productService.checkUnique(productVo);
		//if (StringUtils.isNotBlank(errMsg)) {
		//	result.failure(errMsg);
		//	return result;
		//}
		
		if(file != null && !file.isEmpty()){
			String imageUrl = imageService.uploadImage(request, file, UploadPathEnum.PRODUCT.getName(),false);
			productVo.setCoverImage(imageUrl);
		}
		
		// 修改
		boolean update = productService.updateProduct(productVo);
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
	 * @date 2021年04月10日 10:55:11
	 * @param productVo
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/admin/center/product/list", method = { RequestMethod.POST })
	public AdminResultByPage list(ProductVo productVo, HttpServletRequest request) {

		Integer page = Integer.valueOf(request.getParameter("page"));
		Integer limit = Integer.valueOf(request.getParameter("limit"));

		AdminResultByPage jsonResult = new AdminResultByPage(page, limit);

		jsonResult = productService.findByPage(productVo, jsonResult);

		return jsonResult;
	}

	/**
	 * @Title: toList
	 * @Description: 列表UI
	 * @author zhuzq
	 * @date 2021年04月10日 10:55:11
	 * @return
	 */
	@RequestMapping(value = "/admin/center/product/list/ui", method = { RequestMethod.GET })
	public String toList() {
		return "/admin/center/product/product_list";
	}

	/**
	 * @Title: edit
	 * @Description: 编辑
	 * @author zhuzq
	 * @date 2021年04月10日 10:55:11
	 * @param productId
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/admin/center/product/edit", method = { RequestMethod.GET, RequestMethod.POST })
	public String edit(Integer productId, HttpServletRequest request) {
		// 编辑,为空新增
		if (null != productId) {
			ProductDto entity = productService.getProduct(productId);
			request.setAttribute("entity", entity);
		}
		
		
		List<ProductType> productTypeList = productTypeService.select(new HashMap<String,Object>());
		request.setAttribute("productTypeList", productTypeList);
		return "/admin/center/product/product_edit";
	}
	
	/**
	 * @Title: get
	 * @Description: 查找
	 * @author zhuzq
	 * @date 2021年04月10日 10:55:11
	 * @param productId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/admin/center/product/get", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult get(Integer productId) {

		JsonResult result = new JsonResult();
		// 验证参数
		if (null == productId || productId < 1) {
			result.failure("用户ID不能为空");
			return result;
		}
		ProductDto entity = productService.getProduct(productId);
		result.success("entity", entity);
		return result;
	}

}
