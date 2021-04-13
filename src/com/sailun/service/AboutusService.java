package com.sailun.service;

import com.sailun.common.service.BaseService;
import com.sailun.domain.dto.AboutusDto;
import com.sailun.domain.entity.Aboutus;
import com.sailun.domain.vo.AboutusVo;
import com.sailun.common.entity.AdminResultByPage;

/**
 * @ClassName: AboutusDao
 * @Description: 关于我们
 * @author zhuzq
 * @date 2021年04月09日 23:08:56
 */
public interface AboutusService extends BaseService<Aboutus,Integer>{

	/**
	 * @Title: saveAboutus
	 * @Description: 保存
	 * @author zhuzq
	 * @date 2021年04月09日 23:08:56
	 * @param aboutusVo
	 * @return
	 */
	public boolean saveAboutus(AboutusVo aboutusVo);

	/**
	 * @Title: deleteAboutus
	 * @Description: 删除
	 * @author zhuzq
	 * @date 2021年04月09日 23:08:56
	 * @param aboutusId
	 * @return
	 */
	public boolean deleteAboutus(Integer aboutusId);

	/**
	 * @Title: deleteByBatch
	 * @Description: 批量删除
	 * @author zhuzq
	 * @date 2021年04月09日 23:08:56
	 * @param aboutusIdArr
	 * @return
	 */
	public int deleteByBatch(Integer[] aboutusIdArr);

	/**
	 * @Title: updateAboutus
	 * @Description: 修改
	 * @author zhuzq
	 * @date 2021年04月09日 23:08:56
	 * @param aboutusVo
	 * @return
	 */
	public boolean updateAboutus(AboutusVo aboutusVo);

	/**
	 * @Title: getAboutus
	 * @Description: 根据aboutusId获取对象
	 * @author zhuzq
	 * @date 2021年04月09日 23:08:56
	 * @param aboutusId
	 * @return
	 */
	public AboutusDto getAboutus(Integer aboutusId);

	/**
	 * @Title: findByPage
	 * @Description: 分页查找
	 * @author zhuzq
	 * @date 2021年04月09日 23:08:56
	 * @param aboutusVo
	 * @param jsonResult
	 * @return
	 */
	public AdminResultByPage findByPage(AboutusVo aboutusVo, AdminResultByPage jsonResult);

	/**
	 * @Title: checkParam
	 * @Description: 参数验证
	 * @author zhuzq
	 * @date 2021年04月09日 23:08:56
	 * @param aboutusVo
	 * @return
	 */
	public String checkParam(AboutusVo aboutusVo);

	/**
	 * @Title: checkUnique
	 * @Description: 唯一性验证
	 * @author zhuzq
	 * @date 2021年04月09日 23:08:56
	 * @param aboutusVo
	 * @return
	 */
	public String checkUnique(AboutusVo aboutusVo);

}
