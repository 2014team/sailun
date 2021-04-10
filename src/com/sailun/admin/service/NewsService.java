package com.sailun.admin.service;

import com.sailun.common.service.BaseService;
import com.sailun.admin.domain.entity.News;
import com.sailun.admin.domain.vo.NewsVo;

import org.springframework.web.multipart.MultipartFile;

import com.sailun.admin.domain.dto.NewsDto;
import com.sailun.common.entity.AdminResultByPage;

/**
 * @ClassName: NewsDao
 * @Description: 资讯发布
 * @author zhuzq
 * @date 2021年04月10日 15:36:31
 */
public interface NewsService extends BaseService<News,Integer>{

	/**
	 * @Title: saveNews
	 * @Description: 保存
	 * @author zhuzq
	 * @date 2021年04月10日 15:36:31
	 * @param newsVo
	 * @return
	 */
	public boolean saveNews(NewsVo newsVo);

	/**
	 * @Title: deleteNews
	 * @Description: 删除
	 * @author zhuzq
	 * @date 2021年04月10日 15:36:31
	 * @param newsId
	 * @return
	 */
	public boolean deleteNews(Integer newsId);

	/**
	 * @Title: deleteByBatch
	 * @Description: 批量删除
	 * @author zhuzq
	 * @date 2021年04月10日 15:36:31
	 * @param newsIdArr
	 * @return
	 */
	public int deleteByBatch(Integer[] newsIdArr);

	/**
	 * @Title: updateNews
	 * @Description: 修改
	 * @author zhuzq
	 * @date 2021年04月10日 15:36:31
	 * @param newsVo
	 * @return
	 */
	public boolean updateNews(NewsVo newsVo);

	/**
	 * @Title: getNews
	 * @Description: 根据newsId获取对象
	 * @author zhuzq
	 * @date 2021年04月10日 15:36:31
	 * @param newsId
	 * @return
	 */
	public NewsDto getNews(Integer newsId);

	/**
	 * @Title: findByPage
	 * @Description: 分页查找
	 * @author zhuzq
	 * @date 2021年04月10日 15:36:31
	 * @param newsVo
	 * @param jsonResult
	 * @return
	 */
	public AdminResultByPage findByPage(NewsVo newsVo, AdminResultByPage jsonResult);

	/**
	 * @Title: checkParam
	 * @Description: 参数验证
	 * @author zhuzq
	 * @date 2021年04月10日 15:36:31
	 * @param newsVo
	 * @return
	 */
	public String checkParam(NewsVo newsVo,MultipartFile file);

	/**
	 * @Title: checkUnique
	 * @Description: 唯一性验证
	 * @author zhuzq
	 * @date 2021年04月10日 15:36:31
	 * @param newsVo
	 * @return
	 */
	public String checkUnique(NewsVo newsVo);

}
