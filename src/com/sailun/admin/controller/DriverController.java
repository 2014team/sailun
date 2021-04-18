package com.sailun.admin.controller;

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
import com.sailun.domain.dto.DriverDto;
import com.sailun.domain.vo.DriverVo;
import com.sailun.service.DriverService;
import com.sailun.service.ImageService;
import com.sailun.annotation.AdminControllerLog;
import com.sailun.common.entity.AdminResultByPage;

/**
 * @ClassName: DriverController
 * @Description: 车手介绍
 * @author zhuzq
 * @date 2021年04月10日 18:08:19
 */
@Controller
public class DriverController {

	@Autowired
	private DriverService driverService;
	
	@Autowired
	private ImageService imageService;

	/**
	 * @Title: save
	 * @Description: 保存
	 * @author zhuzq
	 * @date 2021年04月10日 18:08:19
	 * @param driverVo
	 * @return
	 */
	@AdminControllerLog(description="车手介绍保存")
	@ResponseBody
	@RequestMapping(value = "/admin/center/driver/save", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult save(DriverVo driverVo,@RequestParam(value="file",required=false) MultipartFile file, HttpServletRequest request) {
		JsonResult result = new JsonResult();

		// 参数验证
		String errMsg = driverService.checkParam(driverVo,file);
		if (StringUtils.isNotBlank(errMsg)) {
			result.failure(errMsg);
			return result;
		}

		// 唯一性验证
		//errMsg = driverService.checkUnique(driverVo);
		//if (StringUtils.isNotBlank(errMsg)) {
		//	result.failure(errMsg);
		//	return result;
		//}
		
		if(file != null && !file.isEmpty()){
			String imageUrl = imageService.uploadImage(request, file, UploadPathEnum.DRIVER.getName(),false);
			driverVo.setCoverImage(imageUrl);
		}
		
		// 保存
		boolean save = driverService.saveDriver(driverVo);
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
	 * @date 2021年04月10日 18:08:19
	 * @param driverId
	 * @return
	 */
	@AdminControllerLog(description="车手介绍删除")
	@ResponseBody
	@RequestMapping(value = "/admin/center/driver/delete", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult delete(Integer driverId) {
		JsonResult result = new JsonResult();

		// 验证参数
		if (null == driverId) {
			result.failure("主键不能为空");
			return result;
		}
		// 删除
		boolean delete = driverService.deleteDriver(driverId);
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
	 * @date 2021年04月10日 18:08:19
	 * @param driverIdArr
	 * @return
	 */
	@AdminControllerLog(description="车手介绍批量删除")
	@ResponseBody
	@RequestMapping(value = "/admin/center/driver/batch/delete", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult deleteByIdArr(@RequestParam("driverIdArr[]") Integer[] driverIdArr) {
		JsonResult result = new JsonResult();
		// 验证参数
		if (null == driverIdArr || driverIdArr.length < 1) {
			result.failure("请选项要删除的数据");
			return result;
		}
		// 删除
		Integer delete = driverService.deleteByBatch(driverIdArr);
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
	 * @date 2021年04月10日 18:08:19
	 * @param driverVo
	 * @return
	 */
	@AdminControllerLog(description="车手介绍修改")
	@ResponseBody
	@RequestMapping(value = "/admin/center/driver/update", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult update(DriverVo driverVo,@RequestParam(value="file",required=false) MultipartFile file, HttpServletRequest request) {
		JsonResult result = new JsonResult();

		// 验证参数
		Integer driverId = driverVo.getDriverId();
		if (null == driverId) {
			result.failure("主键不能为空");
			return result;
		}
		String errMsg = driverService.checkParam(driverVo,file);
		if (StringUtils.isNotBlank(errMsg)) {
			result.failure(errMsg);
			return result;
		}
		
		if(file != null && !file.isEmpty()){
			String imageUrl = imageService.uploadImage(request, file, UploadPathEnum.DRIVER.getName(),false);
			driverVo.setCoverImage(imageUrl);
		}

		// 唯一性验证
		//errMsg = driverService.checkUnique(driverVo);
		//if (StringUtils.isNotBlank(errMsg)) {
		//	result.failure(errMsg);
		//	return result;
		//}
		// 修改
		boolean update = driverService.updateDriver(driverVo);
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
	 * @date 2021年04月10日 18:08:19
	 * @param driverVo
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/admin/center/driver/list", method = { RequestMethod.POST })
	public AdminResultByPage list(DriverVo driverVo, HttpServletRequest request) {

		Integer page = Integer.valueOf(request.getParameter("page"));
		Integer limit = Integer.valueOf(request.getParameter("limit"));

		AdminResultByPage jsonResult = new AdminResultByPage(page, limit);

		jsonResult = driverService.findByPage(driverVo, jsonResult);

		return jsonResult;
	}

	/**
	 * @Title: toList
	 * @Description: 列表UI
	 * @author zhuzq
	 * @date 2021年04月10日 18:08:19
	 * @return
	 */
	@RequestMapping(value = "/admin/center/driver/list/ui", method = { RequestMethod.GET })
	public String toList() {
		return "/admin/center/driver/driver_list";
	}

	/**
	 * @Title: edit
	 * @Description: 编辑
	 * @author zhuzq
	 * @date 2021年04月10日 18:08:19
	 * @param driverId
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/admin/center/driver/edit", method = { RequestMethod.GET, RequestMethod.POST })
	public String edit(Integer driverId, HttpServletRequest request) {
		// 编辑,为空新增
		if (null != driverId) {
			DriverDto entity = driverService.getDriver(driverId);
			request.setAttribute("entity", entity);
		}
		return "/admin/center/driver/driver_edit";
	}
	
	/**
	 * @Title: get
	 * @Description: 查找
	 * @author zhuzq
	 * @date 2021年04月10日 18:08:19
	 * @param driverId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/admin/center/driver/get", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult get(Integer driverId) {

		JsonResult result = new JsonResult();
		// 验证参数
		if (null == driverId || driverId < 1) {
			result.failure("用户ID不能为空");
			return result;
		}
		DriverDto entity = driverService.getDriver(driverId);
		result.success("entity", entity);
		return result;
	}

}
