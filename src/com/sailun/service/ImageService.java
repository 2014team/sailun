package com.sailun.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.sailun.constant.ImagePrefixNameEnum;
import com.sailun.constant.ImageSuffixNameEnum;


public interface ImageService {

	/**
	 * @Title: checkImage
	 * @Description: 图片验证
	 * @param file
	 * @return
	 */
	public String checkImage(MultipartFile file);

	/**
	 * @Title: uploadImage
	 * @Description: 上传图片
	 * @param request
	 * @param file
	 * @param uploadPath
	 * @return
	 */
	public String uploadImage(HttpServletRequest request, MultipartFile file, String uploadPath,boolean dirCreteFlag);
	
	
	public String uploadMinImage(HttpServletRequest request, MultipartFile file, String uploadPath);
	
	public String uploadImage(HttpServletRequest request, MultipartFile file, String uploadPath,Integer width,Integer height,ImagePrefixNameEnum prefix,ImageSuffixNameEnum suffix);

}
