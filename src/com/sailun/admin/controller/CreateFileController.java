package com.sailun.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sailun.service.CreateFileSerivce;


@Controller
public class CreateFileController {

	@Qualifier("bannerCreateFileServiceImpl")
	CreateFileSerivce bannerCreateFileService;
	
	@RequestMapping("/admin/center/create/banner")
	public void createBannerFile(){
		bannerCreateFileService.createFile();
	}
}
