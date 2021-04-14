package com.sailun.service;

import com.sailun.common.service.BaseService;
import com.sailun.domain.entity.PageConfig;
import com.sailun.domain.vo.PageConfigVo;
import com.sailun.domain.dto.PageConfigDto;
import com.sailun.common.entity.AdminResultByPage;

/**
 * @ClassName: PageConfigDao
 * @Description: 页面配置
 * @author zhuzq
 * @date 2021年04月14日 14:37:31
 */
public interface PageConfigService extends BaseService<PageConfig,Integer>{

	/**
	 * @Title: savePageConfig
	 * @Description: 保存
	 * @author zhuzq
	 * @date 2021年04月14日 14:37:31
	 * @param pageConfigVo
	 * @return
	 */
	public boolean savePageConfig(PageConfigVo pageConfigVo);

	/**
	 * @Title: deletePageConfig
	 * @Description: 删除
	 * @author zhuzq
	 * @date 2021年04月14日 14:37:31
	 * @param pageConfigId
	 * @return
	 */
	public boolean deletePageConfig(Integer pageConfigId);

	/**
	 * @Title: deleteByBatch
	 * @Description: 批量删除
	 * @author zhuzq
	 * @date 2021年04月14日 14:37:31
	 * @param pageConfigIdArr
	 * @return
	 */
	public int deleteByBatch(Integer[] pageConfigIdArr);

	/**
	 * @Title: updatePageConfig
	 * @Description: 修改
	 * @author zhuzq
	 * @date 2021年04月14日 14:37:31
	 * @param pageConfigVo
	 * @return
	 */
	public boolean updatePageConfig(PageConfigVo pageConfigVo);

	/**
	 * @Title: getPageConfig
	 * @Description: 根据pageConfigId获取对象
	 * @author zhuzq
	 * @date 2021年04月14日 14:37:31
	 * @param pageConfigId
	 * @return
	 */
	public PageConfigDto getPageConfig(Integer pageConfigId);

	/**
	 * @Title: findByPage
	 * @Description: 分页查找
	 * @author zhuzq
	 * @date 2021年04月14日 14:37:31
	 * @param pageConfigVo
	 * @param jsonResult
	 * @return
	 */
	public AdminResultByPage findByPage(PageConfigVo pageConfigVo, AdminResultByPage jsonResult);

	/**
	 * @Title: checkParam
	 * @Description: 参数验证
	 * @author zhuzq
	 * @date 2021年04月14日 14:37:31
	 * @param pageConfigVo
	 * @return
	 */
	public String checkParam(PageConfigVo pageConfigVo);

	/**
	 * @Title: checkUnique
	 * @Description: 唯一性验证
	 * @author zhuzq
	 * @date 2021年04月14日 14:37:31
	 * @param pageConfigVo
	 * @return
	 */
	public String checkUnique(PageConfigVo pageConfigVo);

}
