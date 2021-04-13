package com.sailun.service;

import com.sailun.common.service.BaseService;
import com.sailun.domain.dto.DriverDto;
import com.sailun.domain.entity.Driver;
import com.sailun.domain.vo.DriverVo;

import org.springframework.web.multipart.MultipartFile;

import com.sailun.common.entity.AdminResultByPage;

/**
 * @ClassName: DriverDao
 * @Description: 车手介绍
 * @author zhuzq
 * @date 2021年04月10日 18:08:25
 */
public interface DriverService extends BaseService<Driver,Integer>{

	/**
	 * @Title: saveDriver
	 * @Description: 保存
	 * @author zhuzq
	 * @date 2021年04月10日 18:08:25
	 * @param driverVo
	 * @return
	 */
	public boolean saveDriver(DriverVo driverVo);

	/**
	 * @Title: deleteDriver
	 * @Description: 删除
	 * @author zhuzq
	 * @date 2021年04月10日 18:08:25
	 * @param driverId
	 * @return
	 */
	public boolean deleteDriver(Integer driverId);

	/**
	 * @Title: deleteByBatch
	 * @Description: 批量删除
	 * @author zhuzq
	 * @date 2021年04月10日 18:08:25
	 * @param driverIdArr
	 * @return
	 */
	public int deleteByBatch(Integer[] driverIdArr);

	/**
	 * @Title: updateDriver
	 * @Description: 修改
	 * @author zhuzq
	 * @date 2021年04月10日 18:08:25
	 * @param driverVo
	 * @return
	 */
	public boolean updateDriver(DriverVo driverVo);

	/**
	 * @Title: getDriver
	 * @Description: 根据driverId获取对象
	 * @author zhuzq
	 * @date 2021年04月10日 18:08:25
	 * @param driverId
	 * @return
	 */
	public DriverDto getDriver(Integer driverId);

	/**
	 * @Title: findByPage
	 * @Description: 分页查找
	 * @author zhuzq
	 * @date 2021年04月10日 18:08:25
	 * @param driverVo
	 * @param jsonResult
	 * @return
	 */
	public AdminResultByPage findByPage(DriverVo driverVo, AdminResultByPage jsonResult);

	/**
	 * @Title: checkParam
	 * @Description: 参数验证
	 * @author zhuzq
	 * @date 2021年04月10日 18:08:25
	 * @param driverVo
	 * @return
	 */
	public String checkParam(DriverVo driverVo,MultipartFile file);

	/**
	 * @Title: checkUnique
	 * @Description: 唯一性验证
	 * @author zhuzq
	 * @date 2021年04月10日 18:08:25
	 * @param driverVo
	 * @return
	 */
	public String checkUnique(DriverVo driverVo);

}
