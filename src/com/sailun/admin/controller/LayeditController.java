package com.sailun.admin.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.sailun.admin.constant.UploadPathEnum;
import com.sailun.admin.service.ImageService;
import com.sailun.common.util.HttpUtil;

import net.sf.json.JSONObject;

/**
* @ClassName: LayeditController
* @Description: 富文本图片上传
* @author zhuzq
* @date 2021年4月9日 下午11:40:34
* https://www.layui.com/doc/modules/layedit.html
*/
@Controller
public class LayeditController {
	@Autowired
	private ImageService imageService;
	
	
	@ResponseBody
	@RequestMapping(value = "/admin/center/upload/image", method = RequestMethod.POST)
	public String upload(HttpServletRequest request, @RequestParam("file") MultipartFile[] files) {
		try {
			SortedMap<String, Object> paramMap = HttpUtil.getRequestParams2(request);
			
			// 两个Map用于返回规定格式参数
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> map2 = new HashMap<String, Object>();
			// 本来就是单图，这个foreach没啥用
			for (MultipartFile file : files) {
				if (!file.isEmpty()) {
					String origName = file.getOriginalFilename();// 文件原名称
					System.out.println("上传的文件原名称:" + origName);

					String imageUrl = imageService.uploadImage(request, file, UploadPathEnum.LAYEDIT.getName(), false);

					map.put("code", 0);// 0表示成功，1失败
					map.put("msg", "上传成功");// 提示消息
					map.put("data", map2);
					map2.put("src", imageUrl);// 图片url
					map2.put("title", origName);// 图片名称，这个会显示在输入框里
					JSONObject jsonObject = JSONObject.fromObject(map);
					String result = jsonObject.toString();
					return result;
				}
			}
			map.put("code", 1);// 0表示成功，1失败
			map.put("msg", "上传失败");// 提示消息
			map.put("data", map2);
			map2.put("src", "");// 图片url
			map2.put("title", "图片丢失");// 图片名称，这个会显示在输入框里
			JSONObject jsonObject = JSONObject.fromObject(map);
			String result = jsonObject.toString();
			return result;
		}
		catch (Exception e) {
		}
		return null;
	}
}
