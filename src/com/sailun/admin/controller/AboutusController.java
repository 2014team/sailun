package com.sailun.admin.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sailun.admin.annotation.AdminControllerLog;
import com.sailun.admin.domain.dto.AboutusDto;
import com.sailun.admin.domain.entity.Aboutus;
import com.sailun.admin.domain.vo.AboutusVo;
import com.sailun.admin.service.AboutusService;
import com.sailun.common.entity.AdminResultByPage;
import com.sailun.common.entity.JsonResult;

/**
 * @ClassName: AboutusController
 * @Description: 关于我们
 * @author zhuzq
 * @date 2021年04月09日 23:08:53
 */
@Controller
public class AboutusController {

	@Autowired
	private AboutusService aboutusService;

	/**
	 * @Title: save
	 * @Description: 保存
	 * @author zhuzq
	 * @date 2021年04月09日 23:08:53
	 * @param aboutusVo
	 * @return
	 */
	@AdminControllerLog(description="关于我们保存")
	@ResponseBody
	@RequestMapping(value = "/admin/center/aboutus/save", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult save(AboutusVo aboutusVo) {
		JsonResult result = new JsonResult();

		// 参数验证
		String errMsg = aboutusService.checkParam(aboutusVo);
		if (StringUtils.isNotBlank(errMsg)) {
			result.failure(errMsg);
			return result;
		}

		// 唯一性验证
		//errMsg = aboutusService.checkUnique(aboutusVo);
		//if (StringUtils.isNotBlank(errMsg)) {
		//	result.failure(errMsg);
		//	return result;
		//}
		// 保存
		boolean save = aboutusService.saveAboutus(aboutusVo);
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
	 * @date 2021年04月09日 23:08:53
	 * @param aboutusId
	 * @return
	 */
	@AdminControllerLog(description="关于我们删除")
	@ResponseBody
	@RequestMapping(value = "/admin/center/aboutus/delete", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult delete(Integer aboutusId) {
		JsonResult result = new JsonResult();

		// 验证参数
		if (null == aboutusId) {
			result.failure("主键不能为空");
			return result;
		}
		// 删除
		boolean delete = aboutusService.deleteAboutus(aboutusId);
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
	 * @date 2021年04月09日 23:08:53
	 * @param aboutusIdArr
	 * @return
	 */
	@AdminControllerLog(description="关于我们批量删除")
	@ResponseBody
	@RequestMapping(value = "/admin/center/aboutus/batch/delete", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult deleteByIdArr(@RequestParam("aboutusIdArr[]") Integer[] aboutusIdArr) {
		JsonResult result = new JsonResult();
		// 验证参数
		if (null == aboutusIdArr || aboutusIdArr.length < 1) {
			result.failure("请选项要删除的数据");
			return result;
		}
		// 删除
		Integer delete = aboutusService.deleteByBatch(aboutusIdArr);
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
	 * @date 2021年04月09日 23:08:53
	 * @param aboutusVo
	 * @return
	 */
	@AdminControllerLog(description="关于我们修改")
	@ResponseBody
	@RequestMapping(value = "/admin/center/aboutus/update", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult update(AboutusVo aboutusVo) {
		JsonResult result = new JsonResult();

		// 验证参数
		Integer aboutusId = aboutusVo.getAboutusId();
		if (null == aboutusId) {
			result.failure("主键不能为空");
			return result;
		}
		String errMsg = aboutusService.checkParam(aboutusVo);
		if (StringUtils.isNotBlank(errMsg)) {
			result.failure(errMsg);
			return result;
		}

		// 唯一性验证
		//errMsg = aboutusService.checkUnique(aboutusVo);
		//if (StringUtils.isNotBlank(errMsg)) {
		//	result.failure(errMsg);
		//	return result;
		//}
		// 修改
		boolean update = aboutusService.updateAboutus(aboutusVo);
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
	 * @date 2021年04月09日 23:08:53
	 * @param aboutusVo
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/admin/center/aboutus/list", method = { RequestMethod.POST })
	public AdminResultByPage list(AboutusVo aboutusVo, HttpServletRequest request) {

		Integer page = Integer.valueOf(request.getParameter("page"));
		Integer limit = Integer.valueOf(request.getParameter("limit"));

		AdminResultByPage jsonResult = new AdminResultByPage(page, limit);

		jsonResult = aboutusService.findByPage(aboutusVo, jsonResult);

		return jsonResult;
	}

	/**
	 * @Title: toList
	 * @Description: 列表UI
	 * @author zhuzq
	 * @date 2021年04月09日 23:08:53
	 * @return
	 */
	@RequestMapping(value = "/admin/center/aboutus/list/ui", method = { RequestMethod.GET })
	public String toList(Model model) {
		List<Aboutus> list = aboutusService.select(new HashMap<String,Object>());
		if(null != list){
			Aboutus aboutus = list.get(0);
			model.addAttribute("entity", aboutus);
		}
		
		return "/admin/center/aboutus/aboutus_list";
	}

	/**
	 * @Title: edit
	 * @Description: 编辑
	 * @author zhuzq
	 * @date 2021年04月09日 23:08:53
	 * @param aboutusId
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/admin/center/aboutus/edit", method = { RequestMethod.GET, RequestMethod.POST })
	public String edit(Integer aboutusId, HttpServletRequest request,Model model) {
		// 编辑,为空新增
		List<Aboutus> list = aboutusService.select(new HashMap<String,Object>());
		if(null != list){
			Aboutus aboutus = list.get(0);
			model.addAttribute("entity", aboutus);
		}
		return "/admin/center/aboutus/aboutus_edit";
	}
	
	/**
	 * @Title: get
	 * @Description: 查找
	 * @author zhuzq
	 * @date 2021年04月09日 23:08:53
	 * @param aboutusId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/admin/center/aboutus/get", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult get(Integer aboutusId) {

		JsonResult result = new JsonResult();
		// 验证参数
		if (null == aboutusId || aboutusId < 1) {
			result.failure("用户ID不能为空");
			return result;
		}
		AboutusDto entity = aboutusService.getAboutus(aboutusId);
		result.success("entity", entity);
		return result;
	}

}
