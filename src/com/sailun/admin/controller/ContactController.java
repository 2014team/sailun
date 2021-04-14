package com.sailun.admin.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sailun.annotation.AdminControllerLog;
import com.sailun.common.entity.AdminResultByPage;
import com.sailun.common.entity.JsonResult;
import com.sailun.constant.ContantSearchEnum;
import com.sailun.domain.dto.ContactDto;
import com.sailun.domain.entity.Contact;
import com.sailun.domain.vo.ContactVo;
import com.sailun.service.ContactService;
import com.sailun.util.DateUtil;
import com.sailun.util.ExcelUtil;


/**
 * @ClassName: ContactController
 * @Description: 联系我们
 * @author zhuzq
 * @date 2021年04月07日 23:01:41
 */
@Controller
public class ContactController {
	
	private static org.slf4j.Logger logger = LoggerFactory.getLogger(ContactController.class);

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
		
		String searchValue = contactVo.getSearchValue();
		String searchKey = contactVo.getSearchKey();
		if(ContantSearchEnum.NAME.getValue().toString().equals(searchKey)){
			contactVo.setUsername(searchValue);
		}else if(ContantSearchEnum.MOBILENUM.getValue().toString().equals(searchKey)){
			contactVo.setMobileNum(searchValue);
		}else if(ContantSearchEnum.EMAIL.getValue().toString().equals(searchKey)){
			contactVo.setEmail(searchValue);
		}

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
	* @Title: edit
	* @Description: 详情
	* @author zhuzq
	* @date  2021年4月8日 下午10:04:31
	* @param contactId
	* @param request
	* @return
	*/
	@RequestMapping(value = "/admin/center/contact/detail", method = { RequestMethod.GET, RequestMethod.POST })
	public String detail(Integer contactId, HttpServletRequest request) {
		// 编辑,为空新增
		if (null != contactId) {
			ContactDto entity = contactService.getContact(contactId);
			request.setAttribute("entity", entity);
		}
		return "/admin/center/contact/contact_detail";
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
	
	
	
	/**
	* @Title: export
	* @Description: 导出
	* @author zhuzq
	* @date  2021年4月8日 下午10:45:48
	* @param contactIdArr
	*/
	@AdminControllerLog(description="联系我们导出")
	@RequestMapping(value = "/admin/center/contact/export", method = { RequestMethod.GET, RequestMethod.POST })
	public void export(String contactIdArr,HttpServletRequest request,HttpServletResponse response) {
		// 验证参数
		if (StringUtils.isEmpty(contactIdArr)) {
			logger.error("请选项要删除的数据");
		}
		// 删除
		List<String> contactIdList = Arrays.asList(contactIdArr.split(","));
		
		// 查询需要导出的数据
		Map<String,Object> paramMap = new HashMap<String, Object>();
		paramMap.put("list", contactIdList);
		List<Contact> dataList = contactService.getByBatch(paramMap);
		if(null == dataList ||  dataList.size() < 1){
			logger.error("没有查询要导出的数据");
			return ;
		}
		
		String [] columnWidth ={"10","15","15","10","10","40","20"}; 
		String[][] columnNames =  new String[][] {
			{"姓名","电话","邮箱","车辆品牌","型号","内容","创建日期"}, 
			{"username","mobileNum","email","vehicleBrand","type","contents","createDate"}
			};
			
		List<Map<String,Object>> dataRows = new LinkedList<Map<String,Object>>();
		if(null != dataList && dataList.size() > 0){
			for (Contact c : dataList) {
			 Map<String, Object> map = new HashMap<String, Object>();
			 map.put("username",c.getUsername());
			 map.put("mobileNum", c.getMobileNum());
			 map.put("email", c.getEmail());
			 map.put("vehicleBrand", c.getVehicleBrand());
			 map.put("type", c.getType());
			 map.put("contents",c.getContents());
			 map.put("createDate",DateUtil.format(c.getCreateDate(), DateUtil.DATE_YYYY_MM_DD_HH_MM_SS));
			 dataRows.add(map);
			}	
		}
		
		String excelName = "联系我们"+ExcelUtil.getFileName();
		ExcelUtil.exportExcel(request, response, excelName, columnWidth, columnNames, dataRows);
		
		
	}

}
