package com.sailun.admin.service.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sailun.admin.annotation.AdminServiceLog;
import com.sailun.admin.dao.NewsDao;
import com.sailun.admin.domain.dto.NewsDto;
import com.sailun.admin.domain.entity.News;
import com.sailun.admin.domain.vo.NewsVo;
import com.sailun.admin.service.NewsService;
import com.sailun.common.entity.AdminResultByPage;
import com.sailun.common.service.impl.BaseServiceImpl;

/**
 * @ClassName: NewsServiceImpl
 * @Description: 资讯发布
 * @author zhuzq
 * @date 2021年04月10日 15:36:31
 */
@Service
public class NewsServiceImpl extends BaseServiceImpl<News,Integer>  implements NewsService {
	
	@Autowired
	private NewsDao newsDao;


	/**
	 * @Title: saveNews
	 * @Description: 保存
	 * @author zhuzq
	 * @date 2021年04月10日 15:36:31
	 * @param newsVo
	 * @return
	 */
	@AdminServiceLog(description="资讯发布保存")
	@Override
	public boolean saveNews(NewsVo newsVo) {
		// NewsVo转News
		News news = convertNews(newsVo);
		Integer result = newsDao.save(news);
		if (null != result && result > 0) {
			return true;
		}
		return false;
	}

	/**
	 * @Title: deleteNews
	 * @Description: 删除
	 * @author zhuzq
	 * @date 2021年04月10日 15:36:31
	 * @param newsId
	 * @return
	 */
	@AdminServiceLog(description="资讯发布 删除")
	@Override
	public boolean deleteNews(Integer newsId) {
		Integer result = newsDao.delete(newsId);
		if (null != result && result > 0) {
			return true;
		}
		return false;
	}

	/**
	 * @Title: deleteByBatch
	 * @Description: 批量删除
	 * @author zhuzq
	 * @date 2021年04月10日 15:36:31
	 * @param newsIdArr
	 * @return
	 */
	@AdminServiceLog(description="资讯发布 批量删除")
	@Override
	public int deleteByBatch(Integer[] newsIdArr) {
		List<Integer> newsIdList = Arrays.asList(newsIdArr);
		return newsDao.deleteByBatch(newsIdList);
	}

	/**
	 * @Title: updateNews
	 * @Description: 修改
	 * @author zhuzq
	 * @date 2021年04月10日 15:36:31
	 * @param newsVo
	 * @return
	 */
	@AdminServiceLog(description="资讯发布 批量修改")
	@Override
	public boolean updateNews(NewsVo newsVo) {
		// NewsVo转News
		News news = convertNews(newsVo);
		Integer result = newsDao.update(news);
		if (null != result && result > 0) {
			return true;
		}
		return false;
	}

	/**
	 * @Title: getNews
	 * @Description: 根据newsId获取资讯发布
	 * @author zhuzq
	 * @date 2021年04月10日 15:36:31
	 * @param newsId
	 * @return
	 */
	 @AdminServiceLog(description="资讯发布根据newsId获取资讯发布")
	@Override
	public NewsDto getNews(Integer newsId) {
		NewsDto newsDTO =  newsDao.getNews(newsId);
		return newsDTO;
	}

	/**
	 * @Title: findByPage
	 * @Description: 分页查找
	 * @author zhuzq
	 * * @date 2021年04月10日 15:36:31
	 * @param newsVo
	 * @param jsonResult
	 * @return
	 */
	@AdminServiceLog(description="资讯发布分页查找")
	@Override
	public AdminResultByPage findByPage(NewsVo newsVo, AdminResultByPage jsonResult) {
		
		//创建日期处理
		String createDateStr = newsVo.getCreateDateStr();
		if(StringUtils.isNotBlank(createDateStr)){
			String[] createDateArr = createDateStr.split("~");
			if(null != createDateArr && createDateArr.length ==2){
				newsVo.setBeginDate(createDateArr[0]);
				newsVo.setEndDate(createDateArr[1]);
			}
		}
				
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("newsVo", newsVo);
		paramMap.put("page", jsonResult);

		int count = newsDao.findListByPageCount(paramMap);

		if (count > 0) {
			List<NewsDto> newsList = newsDao.findListByPage(paramMap);
			jsonResult.setData(newsList);
			jsonResult.setCount(count);
		}
		return jsonResult;
	}

	/**
	 * @Title: checkParam
	 * @Description: 参数验证
	 * @author zhuzq
	 * @date 2021年04月10日 15:36:31
	 * @param newsVo
	 * @return
	 */
	@Override
	public String checkParam(NewsVo newsVo,MultipartFile file) {
	    String title = newsVo.getTitle();
		if (StringUtils.isBlank(title)) {
			return "标题不能为空";
		}
	    String coverImage = newsVo.getCoverImage();
		if (StringUtils.isBlank(coverImage) &&(null == file || file.isEmpty())) {
			return "封面图片不能为空";
		}
	    String describe = newsVo.getDescribe();
		if (StringUtils.isBlank(describe)) {
			return "简介描述不能为空";
		}
		Integer status = newsVo.getStatus();
		if (null == status) {
			return "0:上架1：下架不能为空";
		}
		Integer newsTypeId = newsVo.getNewsTypeId();
		if (null == newsTypeId) {
			return "新闻类别Id不能为空";
		}
		return null;
	}


	/**
	 * @Title: checkUnique
	 * @Description: 唯一性验证
	 * @author zhuzq
	 * @date 2021年04月10日 15:36:31
	 * @param newsVo
	 * @return
	 */
	@Override
	public String checkUnique(NewsVo NewsVo) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("title", NewsVo.getTitle());
		List<News> newsList = newsDao.select(paramMap);
		if (null == newsList || newsList.size() < 1) {
			return null;
		}

		Integer newsId = NewsVo.getNewsId();
		if (null != newsId) {
			for (News entity : newsList) {
				if (!entity.getNewsId().equals(newsId) && entity.getTitle().equals(NewsVo.getTitle())) {
					return "标题已经存在";
				}
			}
		} else {
			return "标题已经存在";
		}
		return null;

	}

	/**
	 * @Title: convertNews
	 * @Description: NewsVo转News
	 * @author zhuzq
	 * @date 2021年04月10日 15:36:31
	 * @param newsVo
	 * @return
	 */
	private News convertNews(NewsVo newsVo) {
		News news = new News();
		news.setNewsId(newsVo.getNewsId());
		news.setTitle(newsVo.getTitle());
		news.setCoverImage(newsVo.getCoverImage());
		news.setDescribe(newsVo.getDescribe());
		news.setStatus(newsVo.getStatus());
		news.setCreateDate(newsVo.getCreateDate());
		news.setUpdateDate(newsVo.getUpdateDate());
		news.setNewsTypeId(newsVo.getNewsTypeId());
		news.setContent(newsVo.getContent());
		return news;
	}

	/**
	 * @Title: convertNewsDto
	 * @Description: News转NewsDto
	 * @author zhuzq
	 * @date 2021年04月10日 15:36:31
	 * @param news
	 * @return
	 */
	private NewsDto convertNewsDto(News news) {
		NewsDto dto = new NewsDto();
		dto.setNewsId(news.getNewsId());
		dto.setTitle(news.getTitle());
		dto.setCoverImage(news.getCoverImage());
		dto.setDescribe(news.getDescribe());
		dto.setStatus(news.getStatus());
		dto.setCreateDate(news.getCreateDate());
		dto.setUpdateDate(news.getUpdateDate());
		dto.setNewsTypeId(news.getNewsTypeId());
		dto.setContent(news.getContent());
		return dto;
	}
	
}
