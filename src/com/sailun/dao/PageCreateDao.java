package com.sailun.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.sailun.common.dao.BaseDao;
import com.sailun.domain.dto.PageCreateDto;
import com.sailun.domain.entity.PageCreate;

/**
 * @ClassName: PageCreateDao
 * @Description: 页面创建
 * @author zhuzq
 * @date 2021年04月14日 14:56:52
 */
@Repository
public interface PageCreateDao extends BaseDao<PageCreate,Integer>{
	
	public PageCreateDto getPageCreate(Integer pageCreateId);
	
	public List<PageCreateDto> findListByPage(Map<String,Object> paramMap);
	
	public Integer findListByPageCount(Map<String,Object> paramMap);
	

}
