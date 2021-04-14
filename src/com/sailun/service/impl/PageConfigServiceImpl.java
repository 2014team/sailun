package com.sailun.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sailun.dao.PageConfigDao;
import com.sailun.domain.entity.PageConfig;
import com.sailun.service.PageConfigService;
import com.sailun.common.service.impl.BaseServiceImpl;
import com.sailun.domain.vo.PageConfigVo;
import com.sailun.domain.dto.PageConfigDto;
import com.sailun.common.entity.AdminResultByPage;
import com.sailun.annotation.AdminServiceLog;

/**
 * @ClassName: PageConfigServiceImpl
 * @Description: 页面配置
 * @author zhuzq
 * @date 2021年04月14日 14:37:32
 */
@Service
public class PageConfigServiceImpl extends BaseServiceImpl<PageConfig,Integer>  implements PageConfigService {
	
	@Autowired
	private PageConfigDao pageConfigDao;


	/**
	 * @Title: savePageConfig
	 * @Description: 保存
	 * @author zhuzq
	 * @date 2021年04月14日 14:37:32
	 * @param pageConfigVo
	 * @return
	 */
	@AdminServiceLog(description="页面配置保存")
	@Override
	public boolean savePageConfig(PageConfigVo pageConfigVo) {
		// PageConfigVo转PageConfig
		PageConfig pageConfig = convertPageConfig(pageConfigVo);
		Integer result = pageConfigDao.save(pageConfig);
		if (null != result && result > 0) {
			return true;
		}
		return false;
	}

	/**
	 * @Title: deletePageConfig
	 * @Description: 删除
	 * @author zhuzq
	 * @date 2021年04月14日 14:37:32
	 * @param pageConfigId
	 * @return
	 */
	@AdminServiceLog(description="页面配置 删除")
	@Override
	public boolean deletePageConfig(Integer pageConfigId) {
		Integer result = pageConfigDao.delete(pageConfigId);
		if (null != result && result > 0) {
			return true;
		}
		return false;
	}

	/**
	 * @Title: deleteByBatch
	 * @Description: 批量删除
	 * @author zhuzq
	 * @date 2021年04月14日 14:37:32
	 * @param pageConfigIdArr
	 * @return
	 */
	@AdminServiceLog(description="页面配置 批量删除")
	@Override
	public int deleteByBatch(Integer[] pageConfigIdArr) {
		List<Integer> pageConfigIdList = Arrays.asList(pageConfigIdArr);
		return pageConfigDao.deleteByBatch(pageConfigIdList);
	}

	/**
	 * @Title: updatePageConfig
	 * @Description: 修改
	 * @author zhuzq
	 * @date 2021年04月14日 14:37:32
	 * @param pageConfigVo
	 * @return
	 */
	@AdminServiceLog(description="页面配置 批量修改")
	@Override
	public boolean updatePageConfig(PageConfigVo pageConfigVo) {
		// PageConfigVo转PageConfig
		PageConfig pageConfig = convertPageConfig(pageConfigVo);
		Integer result = pageConfigDao.update(pageConfig);
		if (null != result && result > 0) {
			return true;
		}
		return false;
	}

	/**
	 * @Title: getPageConfig
	 * @Description: 根据pageConfigId获取页面配置
	 * @author zhuzq
	 * @date 2021年04月14日 14:37:32
	 * @param pageConfigId
	 * @return
	 */
	 @AdminServiceLog(description="页面配置根据pageConfigId获取页面配置")
	@Override
	public PageConfigDto getPageConfig(Integer pageConfigId) {
		PageConfigDto pageConfigDTO = null;
		PageConfig pageConfig = pageConfigDao.get(pageConfigId);
		if (null != pageConfig) {
			pageConfigDTO = convertPageConfigDto(pageConfig);
		}
		return pageConfigDTO;
	}

	/**
	 * @Title: findByPage
	 * @Description: 分页查找
	 * @author zhuzq
	 * * @date 2021年04月14日 14:37:32
	 * @param pageConfigVo
	 * @param jsonResult
	 * @return
	 */
	@AdminServiceLog(description="页面配置分页查找")
	@Override
	public AdminResultByPage findByPage(PageConfigVo pageConfigVo, AdminResultByPage jsonResult) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("pageConfigVo", pageConfigVo);
		paramMap.put("page", jsonResult);

		int count = pageConfigDao.findByPageCount(paramMap);

		if (count > 0) {
			List<PageConfigDto> dataList = null;
			List<PageConfig> pageConfigList = findByPage(paramMap);
			if (null != pageConfigList && pageConfigList.size() > 0) {
				dataList = new ArrayList<PageConfigDto>();
				for (PageConfig pageConfig : pageConfigList) {
					// PageConfig转PageConfigDTO
					PageConfigDto pageConfigDTO = convertPageConfigDto(pageConfig);
					dataList.add(pageConfigDTO);
				}
			}
			jsonResult.setData(dataList);
			jsonResult.setCount(count);
		}
		return jsonResult;
	}

	/**
	 * @Title: checkParam
	 * @Description: 参数验证
	 * @author zhuzq
	 * @date 2021年04月14日 14:37:32
	 * @param pageConfigVo
	 * @return
	 */
	@Override
	public String checkParam(PageConfigVo pageConfigVo) {
	    String configPageName = pageConfigVo.getConfigPageName();
		if (StringUtils.isBlank(configPageName)) {
			return "配置页面不能为空";
		}
	    String code = pageConfigVo.getCode();
		if (StringUtils.isBlank(code)) {
			return "编号不能为空";
		}
		return null;
	}


	/**
	 * @Title: checkUnique
	 * @Description: 唯一性验证
	 * @author zhuzq
	 * @date 2021年04月14日 14:37:32
	 * @param pageConfigVo
	 * @return
	 */
	@Override
	public String checkUnique(PageConfigVo pageConfigVo) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("code", pageConfigVo.getCode());
		List<PageConfig> pageConfigList = pageConfigDao.select(paramMap);
		if (null == pageConfigList || pageConfigList.size() < 1) {
			return null;
		}

		Integer pageConfigId = pageConfigVo.getPageConfigId();
		if (null != pageConfigId && pageConfigId > 0) {
			for (PageConfig entity : pageConfigList) {
				if (!entity.getPageConfigId().equals(pageConfigId) && entity.getCode().equals(pageConfigVo.getCode())) {
					return "编码已经存在";
				}
			}
		} else {
			return "编码已经存在";
		}
		return null;

	}

	/**
	 * @Title: convertPageConfig
	 * @Description: PageConfigVo转PageConfig
	 * @author zhuzq
	 * @date 2021年04月14日 14:37:32
	 * @param pageConfigVo
	 * @return
	 */
	private PageConfig convertPageConfig(PageConfigVo pageConfigVo) {
		PageConfig pageConfig = new PageConfig();
		pageConfig.setPageConfigId(pageConfigVo.getPageConfigId());
		pageConfig.setConfigPageName(pageConfigVo.getConfigPageName());
		pageConfig.setCode(pageConfigVo.getCode());
		pageConfig.setCreateDate(pageConfigVo.getCreateDate());
		pageConfig.setUpdateDate(pageConfigVo.getUpdateDate());
		return pageConfig;
	}

	/**
	 * @Title: convertPageConfigDto
	 * @Description: PageConfig转PageConfigDto
	 * @author zhuzq
	 * @date 2021年04月14日 14:37:32
	 * @param pageConfig
	 * @return
	 */
	private PageConfigDto convertPageConfigDto(PageConfig pageConfig) {
		PageConfigDto dto = new PageConfigDto();
		dto.setPageConfigId(pageConfig.getPageConfigId());
		dto.setConfigPageName(pageConfig.getConfigPageName());
		dto.setCode(pageConfig.getCode());
		dto.setCreateDate(pageConfig.getCreateDate());
		dto.setUpdateDate(pageConfig.getUpdateDate());
		return dto;
	}
	
}
