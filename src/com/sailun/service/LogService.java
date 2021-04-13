package com.sailun.service;

import com.sailun.common.service.BaseService;
import com.sailun.domain.dto.LogDto;
import com.sailun.domain.entity.Log;
import com.sailun.domain.vo.LogVo;
import com.sailun.common.entity.AdminResultByPage;

/**
 * @ClassName: LogDao
 * @Description: 菜单
 * @author zhuzq
 * @date 2020年05月14日 22:04:07
 */
public interface LogService extends BaseService<Log, Integer> {

	/**
	 * @Title: deleteByBatch
	 * @Description: 批量删除
	 * @author zhuzq
	 * @date 2020年05月14日 22:04:07
	 * @param logIdArr
	 * @return
	 */
	public int deleteByBatch(Integer[] logIdArr);

	/**
	 * @Title: getLog
	 * @Description: 根据logId获取对象
	 * @author zhuzq
	 * @date 2020年05月14日 22:04:07
	 * @param logId
	 * @return
	 */
	public LogDto getLog(Integer logId);

	/**
	 * @Title: findByPage
	 * @Description: 分页查找
	 * @author zhuzq
	 * @date 2020年05月14日 22:04:07
	 * @param logVo
	 * @param jsonResult
	 * @return
	 */
	public AdminResultByPage findByPage(LogVo logVo, AdminResultByPage jsonResult);

}
