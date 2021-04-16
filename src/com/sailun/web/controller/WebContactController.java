package com.sailun.web.controller;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sailun.common.entity.JsonResult;
import com.sailun.domain.vo.ContactVo;
import com.sailun.service.ContactService;

@Controller
public class WebContactController {
	
	@Autowired
	private ContactService contactService;
	
	@RequestMapping("/contact")
	public String index(){
		return "/web/contact";
	}
	
	
	/**
	* @Title: save
	* @Description: 保存
	* @author zhuzq
	* @date  2021年4月16日 下午5:27:58
	* @param contactVo
	* @return
	*/
	@ResponseBody
	@RequestMapping("/contact/save")
	public JsonResult save(ContactVo contactVo){
		JsonResult result = new JsonResult();
		String checkParam = contactService.checkParam(contactVo);
		if(StringUtils.isNotBlank(checkParam)){
			result.failure(checkParam);
			return result;
		}
		Integer save = contactService.save(contactVo);
		if(null != save && save > 0){
			result.success("提交 成功");
		}else{
			result.failure();
		}
		return result;
	}

	
}
