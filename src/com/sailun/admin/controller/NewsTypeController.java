package com.sailun.admin.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sailun.admin.domain.dto.NewsTypeDto;
import com.sailun.admin.domain.vo.NewsTypeVo;
import com.sailun.admin.service.NewsTypeService;
import com.sailun.common.entity.JsonResult;
import com.sailun.common.entity.AdminResultByPage;
import com.sailun.admin.annotation.AdminControllerLog;

/**
 * @ClassName: NewsTypeController
 * @Description: 新闻类别
 * @author zhuzq
 * @date 2021年04月10日 15:23:24
 */
@Controller
public class NewsTypeController {

	@Autowired
	private NewsTypeService newsTypeService;

	/**
	 * @Title: save
	 * @Description: 保存
	 * @author zhuzq
	 * @date 2021年04月10日 15:23:24
	 * @param newsTypeVo
	 * @return
	 */
	@AdminControllerLog(description="新闻类别保存")
	@ResponseBody
	@RequestMapping(value = "/admin/center/newsType/save", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult save(NewsTypeVo newsTypeVo) {
		JsonResult result = new JsonResult();

		// 参数验证
		String errMsg = newsTypeService.checkParam(newsTypeVo);
		if (StringUtils.isNotBlank(errMsg)) {
			result.failure(errMsg);
			return result;
		}

		// 唯一性验证
		//errMsg = newsTypeService.checkUnique(newsTypeVo);
		//if (StringUtils.isNotBlank(errMsg)) {
		//	result.failure(errMsg);
		//	return result;
		//}
		// 保存
		boolean save = newsTypeService.saveNewsType(newsTypeVo);
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
	 * @date 2021年04月10日 15:23:24
	 * @param newsTypeId
	 * @return
	 */
	@AdminControllerLog(description="新闻类别删除")
	@ResponseBody
	@RequestMapping(value = "/admin/center/newsType/delete", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult delete(Integer newsTypeId) {
		JsonResult result = new JsonResult();

		// 验证参数
		if (null == newsTypeId) {
			result.failure("主键不能为空");
			return result;
		}
		// 删除
		boolean delete = newsTypeService.deleteNewsType(newsTypeId);
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
	 * @date 2021年04月10日 15:23:24
	 * @param newsTypeIdArr
	 * @return
	 */
	@AdminControllerLog(description="新闻类别批量删除")
	@ResponseBody
	@RequestMapping(value = "/admin/center/newsType/batch/delete", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult deleteByIdArr(@RequestParam("newsTypeIdArr[]") Integer[] newsTypeIdArr) {
		JsonResult result = new JsonResult();
		// 验证参数
		if (null == newsTypeIdArr || newsTypeIdArr.length < 1) {
			result.failure("请选项要删除的数据");
			return result;
		}
		// 删除
		Integer delete = newsTypeService.deleteByBatch(newsTypeIdArr);
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
	 * @date 2021年04月10日 15:23:24
	 * @param newsTypeVo
	 * @return
	 */
	@AdminControllerLog(description="新闻类别修改")
	@ResponseBody
	@RequestMapping(value = "/admin/center/newsType/update", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult update(NewsTypeVo newsTypeVo) {
		JsonResult result = new JsonResult();

		// 验证参数
		Integer newsTypeId = newsTypeVo.getNewsTypeId();
		if (null == newsTypeId) {
			result.failure("主键不能为空");
			return result;
		}
		String errMsg = newsTypeService.checkParam(newsTypeVo);
		if (StringUtils.isNotBlank(errMsg)) {
			result.failure(errMsg);
			return result;
		}

		// 唯一性验证
		//errMsg = newsTypeService.checkUnique(newsTypeVo);
		//if (StringUtils.isNotBlank(errMsg)) {
		//	result.failure(errMsg);
		//	return result;
		//}
		// 修改
		boolean update = newsTypeService.updateNewsType(newsTypeVo);
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
	 * @date 2021年04月10日 15:23:24
	 * @param newsTypeVo
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/admin/center/newsType/list", method = { RequestMethod.POST })
	public AdminResultByPage list(NewsTypeVo newsTypeVo, HttpServletRequest request) {

		Integer page = Integer.valueOf(request.getParameter("page"));
		Integer limit = Integer.valueOf(request.getParameter("limit"));

		AdminResultByPage jsonResult = new AdminResultByPage(page, limit);

		jsonResult = newsTypeService.findByPage(newsTypeVo, jsonResult);

		return jsonResult;
	}

	/**
	 * @Title: toList
	 * @Description: 列表UI
	 * @author zhuzq
	 * @date 2021年04月10日 15:23:24
	 * @return
	 */
	@RequestMapping(value = "/admin/center/newsType/list/ui", method = { RequestMethod.GET })
	public String toList() {
		return "/admin/center/newsType/newsType_list";
	}

	/**
	 * @Title: edit
	 * @Description: 编辑
	 * @author zhuzq
	 * @date 2021年04月10日 15:23:24
	 * @param newsTypeId
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/admin/center/newsType/edit", method = { RequestMethod.GET, RequestMethod.POST })
	public String edit(Integer newsTypeId, HttpServletRequest request) {
		// 编辑,为空新增
		if (null != newsTypeId) {
			NewsTypeDto entity = newsTypeService.getNewsType(newsTypeId);
			request.setAttribute("entity", entity);
		}
		return "/admin/center/newsType/newsType_edit";
	}
	
	/**
	 * @Title: get
	 * @Description: 查找
	 * @author zhuzq
	 * @date 2021年04月10日 15:23:24
	 * @param newsTypeId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/admin/center/newsType/get", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult get(Integer newsTypeId) {

		JsonResult result = new JsonResult();
		// 验证参数
		if (null == newsTypeId || newsTypeId < 1) {
			result.failure("用户ID不能为空");
			return result;
		}
		NewsTypeDto entity = newsTypeService.getNewsType(newsTypeId);
		result.success("entity", entity);
		return result;
	}

}
