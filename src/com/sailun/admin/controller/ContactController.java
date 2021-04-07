package com.sailun.admin.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sailun.admin.domain.dto.ContactDto;
import com.sailun.admin.domain.vo.ContactVo;
import com.sailun.admin.service.ContactService;
import com.sailun.common.entity.JsonResult;
import com.sailun.common.entity.AdminResultByPage;
import com.sailun.admin.annotation.AdminControllerLog;

/**
 * @ClassName: ContactController
 * @Description: 联系我们
 * @author zhuzq
 * @date 2021年04月07日 23:01:41
 */
@Controller
public class ContactController {

	@Autowired
	private ContactService contactService;

	/**
	 * @Title: save
	 * @Description: 保存
	 * @author zhuzq
	 * @date 2021年04月07日 23:01:41
	 * @param contactVo
	 * @return
	 */
	@AdminControllerLog(description="联系我们保存")
	@ResponseBody
	@RequestMapping(value = "/admin/center/contact/save", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult save(ContactVo contactVo) {
		JsonResult result = new JsonResult();

		// 参数验证
		String errMsg = contactService.checkParam(contactVo);
		if (StringUtils.isNotBlank(errMsg)) {
			result.failure(errMsg);
			return result;
		}

		// 唯一性验证
		//errMsg = contactService.checkUnique(contactVo);
		//if (StringUtils.isNotBlank(errMsg)) {
		//	result.failure(errMsg);
		//	return result;
		//}
		// 保存
		boolean save = contactService.saveContact(contactVo);
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
	 * @date 2021年04月07日 23:01:41
	 * @param contactId
	 * @return
	 */
	@AdminControllerLog(description="联系我们删除")
	@ResponseBody
	@RequestMapping(value = "/admin/center/contact/delete", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult delete(Integer contactId) {
		JsonResult result = new JsonResult();

		// 验证参数
		if (null == contactId) {
			result.failure("主键不能为空");
			return result;
		}
		// 删除
		boolean delete = contactService.deleteContact(contactId);
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
	 * @date 2021年04月07日 23:01:41
	 * @param contactIdArr
	 * @return
	 */
	@AdminControllerLog(description="联系我们批量删除")
	@ResponseBody
	@RequestMapping(value = "/admin/center/contact/batch/delete", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult deleteByIdArr(@RequestParam("contactIdArr[]") Integer[] contactIdArr) {
		JsonResult result = new JsonResult();
		// 验证参数
		if (null == contactIdArr || contactIdArr.length < 1) {
			result.failure("请选项要删除的数据");
			return result;
		}
		// 删除
		Integer delete = contactService.deleteByBatch(contactIdArr);
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
	 * @date 2021年04月07日 23:01:41
	 * @param contactVo
	 * @return
	 */
	@AdminControllerLog(description="联系我们修改")
	@ResponseBody
	@RequestMapping(value = "/admin/center/contact/update", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult update(ContactVo contactVo) {
		JsonResult result = new JsonResult();

		// 验证参数
		Integer contactId = contactVo.getContactId();
		if (null == contactId) {
			result.failure("主键不能为空");
			return result;
		}
		String errMsg = contactService.checkParam(contactVo);
		if (StringUtils.isNotBlank(errMsg)) {
			result.failure(errMsg);
			return result;
		}

		// 唯一性验证
		//errMsg = contactService.checkUnique(contactVo);
		//if (StringUtils.isNotBlank(errMsg)) {
		//	result.failure(errMsg);
		//	return result;
		//}
		// 修改
		boolean update = contactService.updateContact(contactVo);
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
	 * @date 2021年04月07日 23:01:41
	 * @param contactVo
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/admin/center/contact/list", method = { RequestMethod.POST })
	public AdminResultByPage list(ContactVo contactVo, HttpServletRequest request) {

		Integer page = Integer.valueOf(request.getParameter("page"));
		Integer limit = Integer.valueOf(request.getParameter("limit"));

		AdminResultByPage jsonResult = new AdminResultByPage(page, limit);

		jsonResult = contactService.findByPage(contactVo, jsonResult);

		return jsonResult;
	}

	/**
	 * @Title: toList
	 * @Description: 列表UI
	 * @author zhuzq
	 * @date 2021年04月07日 23:01:41
	 * @return
	 */
	@RequestMapping(value = "/admin/center/contact/list/ui", method = { RequestMethod.GET })
	public String toList() {
		return "/admin/center/contact/contact_list";
	}

	/**
	 * @Title: edit
	 * @Description: 编辑
	 * @author zhuzq
	 * @date 2021年04月07日 23:01:41
	 * @param contactId
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/admin/center/contact/edit", method = { RequestMethod.GET, RequestMethod.POST })
	public String edit(Integer contactId, HttpServletRequest request) {
		// 编辑,为空新增
		if (null != contactId) {
			ContactDto entity = contactService.getContact(contactId);
			request.setAttribute("entity", entity);
		}
		return "/admin/center/contact/contact_edit";
	}
	
	/**
	 * @Title: get
	 * @Description: 查找
	 * @author zhuzq
	 * @date 2021年04月07日 23:01:41
	 * @param contactId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/admin/center/contact/get", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult get(Integer contactId) {

		JsonResult result = new JsonResult();
		// 验证参数
		if (null == contactId || contactId < 1) {
			result.failure("用户ID不能为空");
			return result;
		}
		ContactDto entity = contactService.getContact(contactId);
		result.success("entity", entity);
		return result;
	}

}
