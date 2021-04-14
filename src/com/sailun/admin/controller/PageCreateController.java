package com.sailun.admin.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sailun.domain.dto.PageCreateDto;
import com.sailun.domain.vo.PageCreateVo;
import com.sailun.service.PageCreateService;
import com.sailun.common.entity.JsonResult;
import com.sailun.common.entity.AdminResultByPage;
import com.sailun.annotation.AdminControllerLog;

/**
 * @ClassName: PageCreateController
 * @Description: 页面创建
 * @author zhuzq
 * @date 2021年04月14日 14:56:52
 */
@Controller
public class PageCreateController {

	@Autowired
	private PageCreateService pageCreateService;

	/**
	 * @Title: save
	 * @Description: 保存
	 * @author zhuzq
	 * @date 2021年04月14日 14:56:52
	 * @param pageCreateVo
	 * @return
	 */
	@AdminControllerLog(description="页面创建保存")
	@ResponseBody
	@RequestMapping(value = "/admin/center/pageCreate/save", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult save(PageCreateVo pageCreateVo) {
		JsonResult result = new JsonResult();

		// 参数验证
		String errMsg = pageCreateService.checkParam(pageCreateVo);
		if (StringUtils.isNotBlank(errMsg)) {
			result.failure(errMsg);
			return result;
		}

		// 唯一性验证
		//errMsg = pageCreateService.checkUnique(pageCreateVo);
		//if (StringUtils.isNotBlank(errMsg)) {
		//	result.failure(errMsg);
		//	return result;
		//}
		// 保存
		boolean save = pageCreateService.savePageCreate(pageCreateVo);
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
	 * @date 2021年04月14日 14:56:52
	 * @param pageCreateId
	 * @return
	 */
	@AdminControllerLog(description="页面创建删除")
	@ResponseBody
	@RequestMapping(value = "/admin/center/pageCreate/delete", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult delete(Integer pageCreateId) {
		JsonResult result = new JsonResult();

		// 验证参数
		if (null == pageCreateId) {
			result.failure("主键不能为空");
			return result;
		}
		// 删除
		boolean delete = pageCreateService.deletePageCreate(pageCreateId);
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
	 * @date 2021年04月14日 14:56:52
	 * @param pageCreateIdArr
	 * @return
	 */
	@AdminControllerLog(description="页面创建批量删除")
	@ResponseBody
	@RequestMapping(value = "/admin/center/pageCreate/batch/delete", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult deleteByIdArr(@RequestParam("pageCreateIdArr[]") Integer[] pageCreateIdArr) {
		JsonResult result = new JsonResult();
		// 验证参数
		if (null == pageCreateIdArr || pageCreateIdArr.length < 1) {
			result.failure("请选项要删除的数据");
			return result;
		}
		// 删除
		Integer delete = pageCreateService.deleteByBatch(pageCreateIdArr);
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
	 * @date 2021年04月14日 14:56:52
	 * @param pageCreateVo
	 * @return
	 */
	@AdminControllerLog(description="页面创建修改")
	@ResponseBody
	@RequestMapping(value = "/admin/center/pageCreate/update", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult update(PageCreateVo pageCreateVo) {
		JsonResult result = new JsonResult();

		// 验证参数
		Integer pageCreateId = pageCreateVo.getPageCreateId();
		if (null == pageCreateId) {
			result.failure("主键不能为空");
			return result;
		}
		String errMsg = pageCreateService.checkParam(pageCreateVo);
		if (StringUtils.isNotBlank(errMsg)) {
			result.failure(errMsg);
			return result;
		}

		// 唯一性验证
		//errMsg = pageCreateService.checkUnique(pageCreateVo);
		//if (StringUtils.isNotBlank(errMsg)) {
		//	result.failure(errMsg);
		//	return result;
		//}
		// 修改
		boolean update = pageCreateService.updatePageCreate(pageCreateVo);
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
	 * @date 2021年04月14日 14:56:52
	 * @param pageCreateVo
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/admin/center/pageCreate/list", method = { RequestMethod.POST })
	public AdminResultByPage list(PageCreateVo pageCreateVo, HttpServletRequest request) {

		Integer page = Integer.valueOf(request.getParameter("page"));
		Integer limit = Integer.valueOf(request.getParameter("limit"));

		AdminResultByPage jsonResult = new AdminResultByPage(page, limit);

		jsonResult = pageCreateService.findByPage(pageCreateVo, jsonResult);

		return jsonResult;
	}

	/**
	 * @Title: toList
	 * @Description: 列表UI
	 * @author zhuzq
	 * @date 2021年04月14日 14:56:52
	 * @return
	 */
	@RequestMapping(value = "/admin/center/pageCreate/list/ui", method = { RequestMethod.GET })
	public String toList() {
		return "/admin/center/pageCreate/pageCreate_list";
	}

	/**
	 * @Title: edit
	 * @Description: 编辑
	 * @author zhuzq
	 * @date 2021年04月14日 14:56:52
	 * @param pageCreateId
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/admin/center/pageCreate/edit", method = { RequestMethod.GET, RequestMethod.POST })
	public String edit(Integer pageCreateId, HttpServletRequest request) {
		// 编辑,为空新增
		if (null != pageCreateId) {
			PageCreateDto entity = pageCreateService.getPageCreate(pageCreateId);
			request.setAttribute("entity", entity);
		}
		return "/admin/center/pageCreate/pageCreate_edit";
	}
	
	/**
	 * @Title: get
	 * @Description: 查找
	 * @author zhuzq
	 * @date 2021年04月14日 14:56:52
	 * @param pageCreateId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/admin/center/pageCreate/get", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult get(Integer pageCreateId) {

		JsonResult result = new JsonResult();
		// 验证参数
		if (null == pageCreateId || pageCreateId < 1) {
			result.failure("用户ID不能为空");
			return result;
		}
		PageCreateDto entity = pageCreateService.getPageCreate(pageCreateId);
		result.success("entity", entity);
		return result;
	}
	

}
