package com.sailun.admin.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sailun.annotation.AdminControllerLog;
import com.sailun.common.entity.AdminResultByPage;
import com.sailun.common.entity.JsonResult;
import com.sailun.domain.dto.PageConfigDto;
import com.sailun.domain.entity.PageConfig;
import com.sailun.domain.vo.PageConfigVo;
import com.sailun.service.PageConfigService;

/**
 * @ClassName: PageConfigController
 * @Description: 页面配置
 * @author zhuzq
 * @date 2021年04月14日 14:37:29
 */
@Controller
public class PageConfigController {

	@Autowired
	private PageConfigService pageConfigService;

	/**
	 * @Title: save
	 * @Description: 保存
	 * @author zhuzq
	 * @date 2021年04月14日 14:37:29
	 * @param pageConfigVo
	 * @return
	 */
	@AdminControllerLog(description="页面配置保存")
	@ResponseBody
	@RequestMapping(value = "/admin/center/pageConfig/save", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult save(PageConfigVo pageConfigVo) {
		JsonResult result = new JsonResult();

		// 参数验证
		String errMsg = pageConfigService.checkParam(pageConfigVo);
		if (StringUtils.isNotBlank(errMsg)) {
			result.failure(errMsg);
			return result;
		}

		// 唯一性验证
		errMsg = pageConfigService.checkUnique(pageConfigVo);
		if (StringUtils.isNotBlank(errMsg)) {
			result.failure(errMsg);
			return result;
		}
		// 保存
		boolean save = pageConfigService.savePageConfig(pageConfigVo);
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
	 * @date 2021年04月14日 14:37:29
	 * @param pageConfigId
	 * @return
	 */
	@AdminControllerLog(description="页面配置删除")
	@ResponseBody
	@RequestMapping(value = "/admin/center/pageConfig/delete", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult delete(Integer pageConfigId) {
		JsonResult result = new JsonResult();

		// 验证参数
		if (null == pageConfigId) {
			result.failure("主键不能为空");
			return result;
		}
		// 删除
		boolean delete = pageConfigService.deletePageConfig(pageConfigId);
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
	 * @date 2021年04月14日 14:37:29
	 * @param pageConfigIdArr
	 * @return
	 */
	@AdminControllerLog(description="页面配置批量删除")
	@ResponseBody
	@RequestMapping(value = "/admin/center/pageConfig/batch/delete", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult deleteByIdArr(@RequestParam("pageConfigIdArr[]") Integer[] pageConfigIdArr) {
		JsonResult result = new JsonResult();
		// 验证参数
		if (null == pageConfigIdArr || pageConfigIdArr.length < 1) {
			result.failure("请选项要删除的数据");
			return result;
		}
		// 删除
		Integer delete = pageConfigService.deleteByBatch(pageConfigIdArr);
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
	 * @date 2021年04月14日 14:37:29
	 * @param pageConfigVo
	 * @return
	 */
	@AdminControllerLog(description="页面配置修改")
	@ResponseBody
	@RequestMapping(value = "/admin/center/pageConfig/update", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult update(PageConfigVo pageConfigVo) {
		JsonResult result = new JsonResult();

		// 验证参数
		Integer pageConfigId = pageConfigVo.getPageConfigId();
		if (null == pageConfigId) {
			result.failure("主键不能为空");
			return result;
		}
		String errMsg = pageConfigService.checkParam(pageConfigVo);
		if (StringUtils.isNotBlank(errMsg)) {
			result.failure(errMsg);
			return result;
		}

		// 唯一性验证
		errMsg = pageConfigService.checkUnique(pageConfigVo);
		if (StringUtils.isNotBlank(errMsg)) {
			result.failure(errMsg);
			return result;
		}
		// 修改
		boolean update = pageConfigService.updatePageConfig(pageConfigVo);
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
	 * @date 2021年04月14日 14:37:29
	 * @param pageConfigVo
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/admin/center/pageConfig/list", method = { RequestMethod.POST })
	public AdminResultByPage list(PageConfigVo pageConfigVo, HttpServletRequest request) {

		Integer page = Integer.valueOf(request.getParameter("page"));
		Integer limit = Integer.valueOf(request.getParameter("limit"));

		AdminResultByPage jsonResult = new AdminResultByPage(page, limit);

		jsonResult = pageConfigService.findByPage(pageConfigVo, jsonResult);

		return jsonResult;
	}

	/**
	 * @Title: toList
	 * @Description: 列表UI
	 * @author zhuzq
	 * @date 2021年04月14日 14:37:29
	 * @return
	 */
	@RequestMapping(value = "/admin/center/pageConfig/list/ui", method = { RequestMethod.GET })
	public String toList() {
		return "/admin/center/pageConfig/pageConfig_list";
	}

	/**
	 * @Title: edit
	 * @Description: 编辑
	 * @author zhuzq
	 * @date 2021年04月14日 14:37:29
	 * @param pageConfigId
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/admin/center/pageConfig/edit", method = { RequestMethod.GET, RequestMethod.POST })
	public String edit(Integer pageConfigId, HttpServletRequest request) {
		// 编辑,为空新增
		if (null != pageConfigId) {
			PageConfigDto entity = pageConfigService.getPageConfig(pageConfigId);
			request.setAttribute("entity", entity);
		}
		return "/admin/center/pageConfig/pageConfig_edit";
	}
	
	/**
	 * @Title: get
	 * @Description: 查找
	 * @author zhuzq
	 * @date 2021年04月14日 14:37:29
	 * @param pageConfigId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/admin/center/pageConfig/get", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult get(Integer pageConfigId) {

		JsonResult result = new JsonResult();
		// 验证参数
		if (null == pageConfigId || pageConfigId < 1) {
			result.failure("用户ID不能为空");
			return result;
		}
		PageConfigDto entity = pageConfigService.getPageConfig(pageConfigId);
		result.success("entity", entity);
		return result;
	}

}
