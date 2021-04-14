package com.sailun.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sailun.dao.PageCreateDao;
import com.sailun.domain.entity.PageCreate;
import com.sailun.service.PageCreateService;
import com.sailun.common.service.impl.BaseServiceImpl;
import com.sailun.domain.vo.PageCreateVo;
import com.sailun.domain.dto.PageCreateDto;
import com.sailun.common.entity.AdminResultByPage;
import com.sailun.annotation.AdminServiceLog;

/**
 * @ClassName: PageCreateServiceImpl
 * @Description: 页面创建
 * @author zhuzq
 * @date 2021年04月14日 14:56:55
 */
@Service
public class PageCreateServiceImpl extends BaseServiceImpl<PageCreate,Integer>  implements PageCreateService {
	
	@Autowired
	private PageCreateDao pageCreateDao;


	/**
	 * @Title: savePageCreate
	 * @Description: 保存
	 * @author zhuzq
	 * @date 2021年04月14日 14:56:55
	 * @param pageCreateVo
	 * @return
	 */
	@AdminServiceLog(description="页面创建保存")
	@Override
	public boolean savePageCreate(PageCreateVo pageCreateVo) {
		// PageCreateVo转PageCreate
		PageCreate pageCreate = convertPageCreate(pageCreateVo);
		Integer result = pageCreateDao.save(pageCreate);
		if (null != result && result > 0) {
			return true;
		}
		return false;
	}

	/**
	 * @Title: deletePageCreate
	 * @Description: 删除
	 * @author zhuzq
	 * @date 2021年04月14日 14:56:55
	 * @param pageCreateId
	 * @return
	 */
	@AdminServiceLog(description="页面创建 删除")
	@Override
	public boolean deletePageCreate(Integer pageCreateId) {
		Integer result = pageCreateDao.delete(pageCreateId);
		if (null != result && result > 0) {
			return true;
		}
		return false;
	}

	/**
	 * @Title: deleteByBatch
	 * @Description: 批量删除
	 * @author zhuzq
	 * @date 2021年04月14日 14:56:55
	 * @param pageCreateIdArr
	 * @return
	 */
	@AdminServiceLog(description="页面创建 批量删除")
	@Override
	public int deleteByBatch(Integer[] pageCreateIdArr) {
		List<Integer> pageCreateIdList = Arrays.asList(pageCreateIdArr);
		return pageCreateDao.deleteByBatch(pageCreateIdList);
	}

	/**
	 * @Title: updatePageCreate
	 * @Description: 修改
	 * @author zhuzq
	 * @date 2021年04月14日 14:56:55
	 * @param pageCreateVo
	 * @return
	 */
	@AdminServiceLog(description="页面创建 批量修改")
	@Override
	public boolean updatePageCreate(PageCreateVo pageCreateVo) {
		// PageCreateVo转PageCreate
		PageCreate pageCreate = convertPageCreate(pageCreateVo);
		Integer result = pageCreateDao.update(pageCreate);
		if (null != result && result > 0) {
			return true;
		}
		return false;
	}

	/**
	 * @Title: getPageCreate
	 * @Description: 根据pageCreateId获取页面创建
	 * @author zhuzq
	 * @date 2021年04月14日 14:56:55
	 * @param pageCreateId
	 * @return
	 */
	 @AdminServiceLog(description="页面创建根据pageCreateId获取页面创建")
	@Override
	public PageCreateDto getPageCreate(Integer pageCreateId) {
		 PageCreateDto pageCreateDTO = pageCreateDao.getPageCreate(pageCreateId);
		return pageCreateDTO;
	}

	/**
	 * @Title: findByPage
	 * @Description: 分页查找
	 * @author zhuzq
	 * * @date 2021年04月14日 14:56:55
	 * @param pageCreateVo
	 * @param jsonResult
	 * @return
	 */
	@AdminServiceLog(description="页面创建分页查找")
	@Override
	public AdminResultByPage findByPage(PageCreateVo pageCreateVo, AdminResultByPage jsonResult) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("pageCreateVo", pageCreateVo);
		paramMap.put("page", jsonResult);

		int count = pageCreateDao.findListByPageCount(paramMap);

		if (count > 0) {
			List<PageCreateDto> dataList = pageCreateDao.findListByPage(paramMap);
			jsonResult.setData(dataList);
			jsonResult.setCount(count);
		}
		return jsonResult;
	}

	/**
	 * @Title: checkParam
	 * @Description: 参数验证
	 * @author zhuzq
	 * @date 2021年04月14日 14:56:55
	 * @param pageCreateVo
	 * @return
	 */
	@Override
	public String checkParam(PageCreateVo pageCreateVo) {
	    String templateName = pageCreateVo.getTemplateName();
		if (StringUtils.isBlank(templateName)) {
			return "模本名称不能为空";
		}
	    String templatePath = pageCreateVo.getTemplatePath();
		if (StringUtils.isBlank(templatePath)) {
			return "模本路径不能为空";
		}
	    String templateContent = pageCreateVo.getTemplateContent();
		if (StringUtils.isBlank(templateContent)) {
			return "模本内容不能为空";
		}
	    String generatorFile = pageCreateVo.getGeneratorFile();
		if (StringUtils.isBlank(generatorFile)) {
			return "生成文件路径不能为空";
		}
		Integer sort = pageCreateVo.getSort();
		if (null == sort) {
			return "排序不能为空";
		}
		Integer pageConfigId = pageCreateVo.getPageConfigId();
		if (null == pageConfigId) {
			return "页面配置ID不能为空";
		}
		return null;
	}


	/**
	 * @Title: checkUnique
	 * @Description: 唯一性验证
	 * @author zhuzq
	 * @date 2021年04月14日 14:56:55
	 * @param pageCreateVo
	 * @return
	 */
	@Override
	public String checkUnique(PageCreateVo PageCreateVo) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("templateName", PageCreateVo.getTemplateName());
		List<PageCreate> pageCreateList = pageCreateDao.select(paramMap);
		if (null == pageCreateList || pageCreateList.size() < 1) {
			return null;
		}

		Integer pageCreateId = PageCreateVo.getPageCreateId();
		if (null != pageCreateId) {
			for (PageCreate entity : pageCreateList) {
				if (!entity.getPageCreateId().equals(pageCreateId) && entity.getTemplateName().equals(PageCreateVo.getTemplateName())) {
					return "模本名称已经存在";
				}
			}
		} else {
			return "模本名称已经存在";
		}
		return null;

	}

	/**
	 * @Title: convertPageCreate
	 * @Description: PageCreateVo转PageCreate
	 * @author zhuzq
	 * @date 2021年04月14日 14:56:55
	 * @param pageCreateVo
	 * @return
	 */
	private PageCreate convertPageCreate(PageCreateVo pageCreateVo) {
		PageCreate pageCreate = new PageCreate();
		pageCreate.setPageCreateId(pageCreateVo.getPageCreateId());
		pageCreate.setTemplateName(pageCreateVo.getTemplateName());
		pageCreate.setTemplatePath(pageCreateVo.getTemplatePath());
		pageCreate.setTemplateContent(pageCreateVo.getTemplateContent());
		pageCreate.setGeneratorFile(pageCreateVo.getGeneratorFile());
		pageCreate.setSort(pageCreateVo.getSort());
		pageCreate.setPageConfigId(pageCreateVo.getPageConfigId());
		pageCreate.setCreateDate(pageCreateVo.getCreateDate());
		pageCreate.setUpdateDate(pageCreateVo.getUpdateDate());
		return pageCreate;
	}

	/**
	 * @Title: convertPageCreateDto
	 * @Description: PageCreate转PageCreateDto
	 * @author zhuzq
	 * @date 2021年04月14日 14:56:55
	 * @param pageCreate
	 * @return
	 */
	private PageCreateDto convertPageCreateDto(PageCreate pageCreate) {
		PageCreateDto dto = new PageCreateDto();
		dto.setPageCreateId(pageCreate.getPageCreateId());
		dto.setTemplateName(pageCreate.getTemplateName());
		dto.setTemplatePath(pageCreate.getTemplatePath());
		dto.setTemplateContent(pageCreate.getTemplateContent());
		dto.setGeneratorFile(pageCreate.getGeneratorFile());
		dto.setSort(pageCreate.getSort());
		dto.setPageConfigId(pageCreate.getPageConfigId());
		dto.setCreateDate(pageCreate.getCreateDate());
		dto.setUpdateDate(pageCreate.getUpdateDate());
		return dto;
	}
	
}
