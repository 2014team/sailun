package com.sailun.service;

import com.sailun.common.service.BaseService;
import com.sailun.domain.entity.PageCreate;
import com.sailun.domain.vo.PageCreateVo;
import com.sailun.domain.dto.PageCreateDto;
import com.sailun.common.entity.AdminResultByPage;

/**
 * @ClassName: PageCreateDao
 * @Description: 页面创建
 * @author zhuzq
 * @date 2021年04月14日 14:56:55
 */
public interface PageCreateService extends BaseService<PageCreate,Integer>{

	/**
	 * @Title: savePageCreate
	 * @Description: 保存
	 * @author zhuzq
	 * @date 2021年04月14日 14:56:55
	 * @param pageCreateVo
	 * @return
	 */
	public boolean savePageCreate(PageCreateVo pageCreateVo);

	/**
	 * @Title: deletePageCreate
	 * @Description: 删除
	 * @author zhuzq
	 * @date 2021年04月14日 14:56:55
	 * @param pageCreateId
	 * @return
	 */
	public boolean deletePageCreate(Integer pageCreateId);

	/**
	 * @Title: deleteByBatch
	 * @Description: 批量删除
	 * @author zhuzq
	 * @date 2021年04月14日 14:56:55
	 * @param pageCreateIdArr
	 * @return
	 */
	public int deleteByBatch(Integer[] pageCreateIdArr);

	/**
	 * @Title: updatePageCreate
	 * @Description: 修改
	 * @author zhuzq
	 * @date 2021年04月14日 14:56:55
	 * @param pageCreateVo
	 * @return
	 */
	public boolean updatePageCreate(PageCreateVo pageCreateVo);

	/**
	 * @Title: getPageCreate
	 * @Description: 根据pageCreateId获取对象
	 * @author zhuzq
	 * @date 2021年04月14日 14:56:55
	 * @param pageCreateId
	 * @return
	 */
	public PageCreateDto getPageCreate(Integer pageCreateId);

	/**
	 * @Title: findByPage
	 * @Description: 分页查找
	 * @author zhuzq
	 * @date 2021年04月14日 14:56:55
	 * @param pageCreateVo
	 * @param jsonResult
	 * @return
	 */
	public AdminResultByPage findByPage(PageCreateVo pageCreateVo, AdminResultByPage jsonResult);

	/**
	 * @Title: checkParam
	 * @Description: 参数验证
	 * @author zhuzq
	 * @date 2021年04月14日 14:56:55
	 * @param pageCreateVo
	 * @return
	 */
	public String checkParam(PageCreateVo pageCreateVo);

	/**
	 * @Title: checkUnique
	 * @Description: 唯一性验证
	 * @author zhuzq
	 * @date 2021年04月14日 14:56:55
	 * @param pageCreateVo
	 * @return
	 */
	public String checkUnique(PageCreateVo pageCreateVo);

}
