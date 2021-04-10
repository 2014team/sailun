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

import com.sailun.admin.domain.dto.BannerDto;
import com.sailun.admin.domain.vo.BannerVo;
import com.sailun.admin.service.BannerService;
import com.sailun.admin.service.ImageService;
import com.sailun.common.entity.JsonResult;
import com.sailun.common.entity.AdminResultByPage;
import com.sailun.admin.annotation.AdminControllerLog;
import com.sailun.admin.constant.UploadPathEnum;

/**
 * @ClassName: BannerController
 * @Description: 首页广告
 * @author zhuzq
 * @date 2021年04月09日 20:47:19
 */
@Controller
public class BannerController {

	@Autowired
	private BannerService bannerService;
	@Autowired
	private ImageService imageService;

	/**
	 * @Title: save
	 * @Description: 保存
	 * @author zhuzq
	 * @date 2021年04月09日 20:47:19
	 * @param bannerVo
	 * @return
	 */
	@AdminControllerLog(description="首页广告保存")
	@ResponseBody
	@RequestMapping(value = "/admin/center/banner/save", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult save(BannerVo bannerVo,@RequestParam(value="file",required=false) MultipartFile file, HttpServletRequest request) {
		JsonResult result = new JsonResult();

		// 参数验证
		String errMsg = bannerService.checkParam(bannerVo,file);
		if (StringUtils.isNotBlank(errMsg)) {
			result.failure(errMsg);
			return result;
		}

		// 唯一性验证
		//errMsg = bannerService.checkUnique(bannerVo);
		//if (StringUtils.isNotBlank(errMsg)) {
		//	result.failure(errMsg);
		//	return result;
		//}
		
		if(null != file && !file.isEmpty()){
			String imageUrl = imageService.uploadImage(request, file, UploadPathEnum.INDEX_BANNER.getName(),false);
			bannerVo.setImageUrl(imageUrl);
		}
		
		
		// 保存
		boolean save = bannerService.saveBanner(bannerVo);
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
	 * @date 2021年04月09日 20:47:19
	 * @param bannerId
	 * @return
	 */
	@AdminControllerLog(description="首页广告删除")
	@ResponseBody
	@RequestMapping(value = "/admin/center/banner/delete", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult delete(Integer bannerId) {
		JsonResult result = new JsonResult();

		// 验证参数
		if (null == bannerId) {
			result.failure("主键不能为空");
			return result;
		}
		// 删除
		boolean delete = bannerService.deleteBanner(bannerId);
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
	 * @date 2021年04月09日 20:47:19
	 * @param bannerIdArr
	 * @return
	 */
	@AdminControllerLog(description="首页广告批量删除")
	@ResponseBody
	@RequestMapping(value = "/admin/center/banner/batch/delete", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult deleteByIdArr(@RequestParam("bannerIdArr[]") Integer[] bannerIdArr) {
		JsonResult result = new JsonResult();
		// 验证参数
		if (null == bannerIdArr || bannerIdArr.length < 1) {
			result.failure("请选项要删除的数据");
			return result;
		}
		// 删除
		Integer delete = bannerService.deleteByBatch(bannerIdArr);
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
	 * @date 2021年04月09日 20:47:19
	 * @param bannerVo
	 * @return
	 */
	@AdminControllerLog(description="首页广告修改")
	@ResponseBody
	@RequestMapping(value = "/admin/center/banner/update", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult update(BannerVo bannerVo,@RequestParam(value="file",required=false) MultipartFile file, HttpServletRequest request) {
		JsonResult result = new JsonResult();

		// 验证参数
		Integer bannerId = bannerVo.getBannerId();
		if (null == bannerId) {
			result.failure("主键不能为空");
			return result;
		}
		String errMsg = bannerService.checkParam(bannerVo,file);
		if (StringUtils.isNotBlank(errMsg)) {
			result.failure(errMsg);
			return result;
		}

		// 唯一性验证
		//errMsg = bannerService.checkUnique(bannerVo);
		//if (StringUtils.isNotBlank(errMsg)) {
		//	result.failure(errMsg);
		//	return result;
		//}
		
		if(file != null && !file.isEmpty()){
			String imageUrl = imageService.uploadImage(request, file, UploadPathEnum.INDEX_BANNER.getName(),false);
			bannerVo.setImageUrl(imageUrl);
		}
		
		// 修改
		boolean update = bannerService.updateBanner(bannerVo);
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
	 * @date 2021年04月09日 20:47:19
	 * @param bannerVo
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/admin/center/banner/list", method = { RequestMethod.POST })
	public AdminResultByPage list(BannerVo bannerVo, HttpServletRequest request) {

		Integer page = Integer.valueOf(request.getParameter("page"));
		Integer limit = Integer.valueOf(request.getParameter("limit"));

		AdminResultByPage jsonResult = new AdminResultByPage(page, limit);

		jsonResult = bannerService.findByPage(bannerVo, jsonResult);

		return jsonResult;
	}

	/**
	 * @Title: toList
	 * @Description: 列表UI
	 * @author zhuzq
	 * @date 2021年04月09日 20:47:19
	 * @return
	 */
	@RequestMapping(value = "/admin/center/banner/list/ui", method = { RequestMethod.GET })
	public String toList() {
		return "/admin/center/banner/banner_list";
	}

	/**
	 * @Title: edit
	 * @Description: 编辑
	 * @author zhuzq
	 * @date 2021年04月09日 20:47:19
	 * @param bannerId
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/admin/center/banner/edit", method = { RequestMethod.GET, RequestMethod.POST })
	public String edit(Integer bannerId, HttpServletRequest request) {
		// 编辑,为空新增
		if (null != bannerId) {
			BannerDto entity = bannerService.getBanner(bannerId);
			request.setAttribute("entity", entity);
		}
		return "/admin/center/banner/banner_edit";
	}
	
	/**
	 * @Title: get
	 * @Description: 查找
	 * @author zhuzq
	 * @date 2021年04月09日 20:47:19
	 * @param bannerId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/admin/center/banner/get", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult get(Integer bannerId) {

		JsonResult result = new JsonResult();
		// 验证参数
		if (null == bannerId || bannerId < 1) {
			result.failure("用户ID不能为空");
			return result;
		}
		BannerDto entity = bannerService.getBanner(bannerId);
		result.success("entity", entity);
		return result;
	}

}
