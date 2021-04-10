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

import com.sailun.admin.annotation.AdminControllerLog;
import com.sailun.admin.constant.UploadPathEnum;
import com.sailun.admin.domain.dto.NewsDto;
import com.sailun.admin.domain.entity.NewsType;
import com.sailun.admin.domain.vo.NewsVo;
import com.sailun.admin.service.ImageService;
import com.sailun.admin.service.NewsService;
import com.sailun.admin.service.NewsTypeService;
import com.sailun.common.entity.AdminResultByPage;
import com.sailun.common.entity.JsonResult;

/**
 * @ClassName: NewsController
 * @Description: 资讯发布
 * @author zhuzq
 * @date 2021年04月10日 15:36:28
 */
@Controller
public class NewsController {

	@Autowired
	private NewsService newsService;
	@Autowired
	private ImageService imageService;
	@Autowired
	private NewsTypeService newsTypeService;

	/**
	 * @Title: save
	 * @Description: 保存
	 * @author zhuzq
	 * @date 2021年04月10日 15:36:28
	 * @param newsVo
	 * @return
	 */
	@AdminControllerLog(description="资讯发布保存")
	@ResponseBody
	@RequestMapping(value = "/admin/center/news/save", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult save(NewsVo newsVo,@RequestParam(value="file",required=false) MultipartFile file, HttpServletRequest request) {
		JsonResult result = new JsonResult();

		// 参数验证
		String errMsg = newsService.checkParam(newsVo,file);
		if (StringUtils.isNotBlank(errMsg)) {
			result.failure(errMsg);
			return result;
		}

		// 唯一性验证
		//errMsg = newsService.checkUnique(newsVo);
		//if (StringUtils.isNotBlank(errMsg)) {
		//	result.failure(errMsg);
		//	return result;
		//}
		
		if(file != null && !file.isEmpty()){
			String imageUrl = imageService.uploadImage(request, file, UploadPathEnum.NEWS.getName(),false);
			newsVo.setCoverImage(imageUrl);
		}
		
		
		// 保存
		boolean save = newsService.saveNews(newsVo);
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
	 * @date 2021年04月10日 15:36:28
	 * @param newsId
	 * @return
	 */
	@AdminControllerLog(description="资讯发布删除")
	@ResponseBody
	@RequestMapping(value = "/admin/center/news/delete", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult delete(Integer newsId) {
		JsonResult result = new JsonResult();

		// 验证参数
		if (null == newsId) {
			result.failure("主键不能为空");
			return result;
		}
		// 删除
		boolean delete = newsService.deleteNews(newsId);
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
	 * @date 2021年04月10日 15:36:28
	 * @param newsIdArr
	 * @return
	 */
	@AdminControllerLog(description="资讯发布批量删除")
	@ResponseBody
	@RequestMapping(value = "/admin/center/news/batch/delete", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult deleteByIdArr(@RequestParam("newsIdArr[]") Integer[] newsIdArr) {
		JsonResult result = new JsonResult();
		// 验证参数
		if (null == newsIdArr || newsIdArr.length < 1) {
			result.failure("请选项要删除的数据");
			return result;
		}
		// 删除
		Integer delete = newsService.deleteByBatch(newsIdArr);
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
	 * @date 2021年04月10日 15:36:28
	 * @param newsVo
	 * @return
	 */
	@AdminControllerLog(description="资讯发布修改")
	@ResponseBody
	@RequestMapping(value = "/admin/center/news/update", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult update(NewsVo newsVo,@RequestParam(value="file",required=false) MultipartFile file, HttpServletRequest request) {
		JsonResult result = new JsonResult();

		// 验证参数
		Integer newsId = newsVo.getNewsId();
		if (null == newsId) {
			result.failure("主键不能为空");
			return result;
		}
		String errMsg = newsService.checkParam(newsVo,file);
		if (StringUtils.isNotBlank(errMsg)) {
			result.failure(errMsg);
			return result;
		}

		// 唯一性验证
		//errMsg = newsService.checkUnique(newsVo);
		//if (StringUtils.isNotBlank(errMsg)) {
		//	result.failure(errMsg);
		//	return result;
		//}
		
		if(file != null && !file.isEmpty()){
			String imageUrl = imageService.uploadImage(request, file, UploadPathEnum.NEWS.getName(),false);
			newsVo.setCoverImage(imageUrl);
		}
		// 修改
		boolean update = newsService.updateNews(newsVo);
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
	 * @date 2021年04月10日 15:36:28
	 * @param newsVo
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/admin/center/news/list", method = { RequestMethod.POST })
	public AdminResultByPage list(NewsVo newsVo, HttpServletRequest request) {

		Integer page = Integer.valueOf(request.getParameter("page"));
		Integer limit = Integer.valueOf(request.getParameter("limit"));

		AdminResultByPage jsonResult = new AdminResultByPage(page, limit);

		jsonResult = newsService.findByPage(newsVo, jsonResult);

		return jsonResult;
	}

	/**
	 * @Title: toList
	 * @Description: 列表UI
	 * @author zhuzq
	 * @date 2021年04月10日 15:36:28
	 * @return
	 */
	@RequestMapping(value = "/admin/center/news/list/ui", method = { RequestMethod.GET })
	public String toList() {
		return "/admin/center/news/news_list";
	}

	/**
	 * @Title: edit
	 * @Description: 编辑
	 * @author zhuzq
	 * @date 2021年04月10日 15:36:28
	 * @param newsId
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/admin/center/news/edit", method = { RequestMethod.GET, RequestMethod.POST })
	public String edit(Integer newsId, HttpServletRequest request) {
		// 编辑,为空新增
		if (null != newsId) {
			NewsDto entity = newsService.getNews(newsId);
			request.setAttribute("entity", entity);
		}
		
		List<NewsType> newsTypeList = newsTypeService.select(new HashMap<String,Object>());
		request.setAttribute("newsTypeList", newsTypeList);
		
		return "/admin/center/news/news_edit";
	}
	
	/**
	 * @Title: get
	 * @Description: 查找
	 * @author zhuzq
	 * @date 2021年04月10日 15:36:28
	 * @param newsId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/admin/center/news/get", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult get(Integer newsId) {

		JsonResult result = new JsonResult();
		// 验证参数
		if (null == newsId || newsId < 1) {
			result.failure("用户ID不能为空");
			return result;
		}
		NewsDto entity = newsService.getNews(newsId);
		result.success("entity", entity);
		return result;
	}

}
