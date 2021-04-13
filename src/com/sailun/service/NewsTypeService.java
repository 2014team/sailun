package com.sailun.service;

import com.sailun.common.service.BaseService;
import com.sailun.domain.dto.NewsTypeDto;
import com.sailun.domain.entity.NewsType;
import com.sailun.domain.vo.NewsTypeVo;
import com.sailun.common.entity.AdminResultByPage;

/**
 * @ClassName: NewsTypeDao
 * @Description: 新闻类别
 * @author zhuzq
 * @date 2021年04月10日 15:23:28
 */
public interface NewsTypeService extends BaseService<NewsType,Integer>{

	/**
	 * @Title: saveNewsType
	 * @Description: 保存
	 * @author zhuzq
	 * @date 2021年04月10日 15:23:28
	 * @param newsTypeVo
	 * @return
	 */
	public boolean saveNewsType(NewsTypeVo newsTypeVo);

	/**
	 * @Title: deleteNewsType
	 * @Description: 删除
	 * @author zhuzq
	 * @date 2021年04月10日 15:23:28
	 * @param newsTypeId
	 * @return
	 */
	public boolean deleteNewsType(Integer newsTypeId);

	/**
	 * @Title: deleteByBatch
	 * @Description: 批量删除
	 * @author zhuzq
	 * @date 2021年04月10日 15:23:28
	 * @param newsTypeIdArr
	 * @return
	 */
	public int deleteByBatch(Integer[] newsTypeIdArr);

	/**
	 * @Title: updateNewsType
	 * @Description: 修改
	 * @author zhuzq
	 * @date 2021年04月10日 15:23:28
	 * @param newsTypeVo
	 * @return
	 */
	public boolean updateNewsType(NewsTypeVo newsTypeVo);

	/**
	 * @Title: getNewsType
	 * @Description: 根据newsTypeId获取对象
	 * @author zhuzq
	 * @date 2021年04月10日 15:23:28
	 * @param newsTypeId
	 * @return
	 */
	public NewsTypeDto getNewsType(Integer newsTypeId);

	/**
	 * @Title: findByPage
	 * @Description: 分页查找
	 * @author zhuzq
	 * @date 2021年04月10日 15:23:28
	 * @param newsTypeVo
	 * @param jsonResult
	 * @return
	 */
	public AdminResultByPage findByPage(NewsTypeVo newsTypeVo, AdminResultByPage jsonResult);

	/**
	 * @Title: checkParam
	 * @Description: 参数验证
	 * @author zhuzq
	 * @date 2021年04月10日 15:23:28
	 * @param newsTypeVo
	 * @return
	 */
	public String checkParam(NewsTypeVo newsTypeVo);

	/**
	 * @Title: checkUnique
	 * @Description: 唯一性验证
	 * @author zhuzq
	 * @date 2021年04月10日 15:23:28
	 * @param newsTypeVo
	 * @return
	 */
	public String checkUnique(NewsTypeVo newsTypeVo);

}
