package com.sailun.admin.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sailun.admin.dao.NewsTypeDao;
import com.sailun.admin.domain.entity.NewsType;
import com.sailun.admin.service.NewsTypeService;
import com.sailun.common.service.impl.BaseServiceImpl;
import com.sailun.admin.domain.vo.NewsTypeVo;
import com.sailun.admin.domain.dto.NewsTypeDto;
import com.sailun.common.entity.AdminResultByPage;
import com.sailun.admin.annotation.AdminServiceLog;

/**
 * @ClassName: NewsTypeServiceImpl
 * @Description: 新闻类别
 * @author zhuzq
 * @date 2021年04月10日 15:23:28
 */
@Service
public class NewsTypeServiceImpl extends BaseServiceImpl<NewsType,Integer>  implements NewsTypeService {
	
	@Autowired
	private NewsTypeDao newsTypeDao;


	/**
	 * @Title: saveNewsType
	 * @Description: 保存
	 * @author zhuzq
	 * @date 2021年04月10日 15:23:28
	 * @param newsTypeVo
	 * @return
	 */
	@AdminServiceLog(description="新闻类别保存")
	@Override
	public boolean saveNewsType(NewsTypeVo newsTypeVo) {
		// NewsTypeVo转NewsType
		NewsType newsType = convertNewsType(newsTypeVo);
		Integer result = newsTypeDao.save(newsType);
		if (null != result && result > 0) {
			return true;
		}
		return false;
	}

	/**
	 * @Title: deleteNewsType
	 * @Description: 删除
	 * @author zhuzq
	 * @date 2021年04月10日 15:23:28
	 * @param newsTypeId
	 * @return
	 */
	@AdminServiceLog(description="新闻类别 删除")
	@Override
	public boolean deleteNewsType(Integer newsTypeId) {
		Integer result = newsTypeDao.delete(newsTypeId);
		if (null != result && result > 0) {
			return true;
		}
		return false;
	}

	/**
	 * @Title: deleteByBatch
	 * @Description: 批量删除
	 * @author zhuzq
	 * @date 2021年04月10日 15:23:28
	 * @param newsTypeIdArr
	 * @return
	 */
	@AdminServiceLog(description="新闻类别 批量删除")
	@Override
	public int deleteByBatch(Integer[] newsTypeIdArr) {
		List<Integer> newsTypeIdList = Arrays.asList(newsTypeIdArr);
		return newsTypeDao.deleteByBatch(newsTypeIdList);
	}

	/**
	 * @Title: updateNewsType
	 * @Description: 修改
	 * @author zhuzq
	 * @date 2021年04月10日 15:23:28
	 * @param newsTypeVo
	 * @return
	 */
	@AdminServiceLog(description="新闻类别 批量修改")
	@Override
	public boolean updateNewsType(NewsTypeVo newsTypeVo) {
		// NewsTypeVo转NewsType
		NewsType newsType = convertNewsType(newsTypeVo);
		Integer result = newsTypeDao.update(newsType);
		if (null != result && result > 0) {
			return true;
		}
		return false;
	}

	/**
	 * @Title: getNewsType
	 * @Description: 根据newsTypeId获取新闻类别
	 * @author zhuzq
	 * @date 2021年04月10日 15:23:28
	 * @param newsTypeId
	 * @return
	 */
	 @AdminServiceLog(description="新闻类别根据newsTypeId获取新闻类别")
	@Override
	public NewsTypeDto getNewsType(Integer newsTypeId) {
		NewsTypeDto newsTypeDTO = null;
		NewsType newsType = newsTypeDao.get(newsTypeId);
		if (null != newsType) {
			newsTypeDTO = convertNewsTypeDto(newsType);
		}
		return newsTypeDTO;
	}

	/**
	 * @Title: findByPage
	 * @Description: 分页查找
	 * @author zhuzq
	 * * @date 2021年04月10日 15:23:28
	 * @param newsTypeVo
	 * @param jsonResult
	 * @return
	 */
	@AdminServiceLog(description="新闻类别分页查找")
	@Override
	public AdminResultByPage findByPage(NewsTypeVo newsTypeVo, AdminResultByPage jsonResult) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("newsTypeVo", newsTypeVo);
		paramMap.put("page", jsonResult);

		int count = newsTypeDao.findByPageCount(paramMap);

		if (count > 0) {
			List<NewsTypeDto> dataList = null;
			List<NewsType> newsTypeList = findByPage(paramMap);
			if (null != newsTypeList && newsTypeList.size() > 0) {
				dataList = new ArrayList<NewsTypeDto>();
				for (NewsType newsType : newsTypeList) {
					// NewsType转NewsTypeDTO
					NewsTypeDto newsTypeDTO = convertNewsTypeDto(newsType);
					dataList.add(newsTypeDTO);
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
	 * @date 2021年04月10日 15:23:28
	 * @param newsTypeVo
	 * @return
	 */
	@Override
	public String checkParam(NewsTypeVo newsTypeVo) {
	    String typeName = newsTypeVo.getTypeName();
		if (StringUtils.isBlank(typeName)) {
			return "分类名称不能为空";
		}
		return null;
	}


	/**
	 * @Title: checkUnique
	 * @Description: 唯一性验证
	 * @author zhuzq
	 * @date 2021年04月10日 15:23:28
	 * @param newsTypeVo
	 * @return
	 */
	@Override
	public String checkUnique(NewsTypeVo NewsTypeVo) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("typeName", NewsTypeVo.getTypeName());
		List<NewsType> newsTypeList = newsTypeDao.select(paramMap);
		if (null == newsTypeList || newsTypeList.size() < 1) {
			return null;
		}

		Integer newsTypeId = NewsTypeVo.getNewsTypeId();
		if (null != newsTypeId) {
			for (NewsType entity : newsTypeList) {
				if (!entity.getNewsTypeId().equals(newsTypeId) && entity.getTypeName().equals(NewsTypeVo.getTypeName())) {
					return "分类名称已经存在";
				}
			}
		} else {
			return "分类名称已经存在";
		}
		return null;

	}

	/**
	 * @Title: convertNewsType
	 * @Description: NewsTypeVo转NewsType
	 * @author zhuzq
	 * @date 2021年04月10日 15:23:28
	 * @param newsTypeVo
	 * @return
	 */
	private NewsType convertNewsType(NewsTypeVo newsTypeVo) {
		NewsType newsType = new NewsType();
		newsType.setNewsTypeId(newsTypeVo.getNewsTypeId());
		newsType.setTypeName(newsTypeVo.getTypeName());
		newsType.setCreateDate(newsTypeVo.getCreateDate());
		newsType.setUpdateDate(newsTypeVo.getUpdateDate());
		return newsType;
	}

	/**
	 * @Title: convertNewsTypeDto
	 * @Description: NewsType转NewsTypeDto
	 * @author zhuzq
	 * @date 2021年04月10日 15:23:28
	 * @param newsType
	 * @return
	 */
	private NewsTypeDto convertNewsTypeDto(NewsType newsType) {
		NewsTypeDto dto = new NewsTypeDto();
		dto.setNewsTypeId(newsType.getNewsTypeId());
		dto.setTypeName(newsType.getTypeName());
		dto.setCreateDate(newsType.getCreateDate());
		dto.setUpdateDate(newsType.getUpdateDate());
		return dto;
	}
	
}
