package com.sailun.admin.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sailun.admin.dao.DriverDao;
import com.sailun.admin.domain.entity.Driver;
import com.sailun.admin.service.DriverService;
import com.sailun.common.service.impl.BaseServiceImpl;
import com.sailun.admin.domain.vo.DriverVo;
import com.sailun.admin.domain.dto.DriverDto;
import com.sailun.common.entity.AdminResultByPage;
import com.sailun.admin.annotation.AdminServiceLog;

/**
 * @ClassName: DriverServiceImpl
 * @Description: 车手介绍
 * @author zhuzq
 * @date 2021年04月10日 18:08:25
 */
@Service
public class DriverServiceImpl extends BaseServiceImpl<Driver,Integer>  implements DriverService {
	
	@Autowired
	private DriverDao driverDao;


	/**
	 * @Title: saveDriver
	 * @Description: 保存
	 * @author zhuzq
	 * @date 2021年04月10日 18:08:25
	 * @param driverVo
	 * @return
	 */
	@AdminServiceLog(description="车手介绍保存")
	@Override
	public boolean saveDriver(DriverVo driverVo) {
		// DriverVo转Driver
		Driver driver = convertDriver(driverVo);
		Integer result = driverDao.save(driver);
		if (null != result && result > 0) {
			return true;
		}
		return false;
	}

	/**
	 * @Title: deleteDriver
	 * @Description: 删除
	 * @author zhuzq
	 * @date 2021年04月10日 18:08:25
	 * @param driverId
	 * @return
	 */
	@AdminServiceLog(description="车手介绍 删除")
	@Override
	public boolean deleteDriver(Integer driverId) {
		Integer result = driverDao.delete(driverId);
		if (null != result && result > 0) {
			return true;
		}
		return false;
	}

	/**
	 * @Title: deleteByBatch
	 * @Description: 批量删除
	 * @author zhuzq
	 * @date 2021年04月10日 18:08:25
	 * @param driverIdArr
	 * @return
	 */
	@AdminServiceLog(description="车手介绍 批量删除")
	@Override
	public int deleteByBatch(Integer[] driverIdArr) {
		List<Integer> driverIdList = Arrays.asList(driverIdArr);
		return driverDao.deleteByBatch(driverIdList);
	}

	/**
	 * @Title: updateDriver
	 * @Description: 修改
	 * @author zhuzq
	 * @date 2021年04月10日 18:08:25
	 * @param driverVo
	 * @return
	 */
	@AdminServiceLog(description="车手介绍 批量修改")
	@Override
	public boolean updateDriver(DriverVo driverVo) {
		// DriverVo转Driver
		Driver driver = convertDriver(driverVo);
		Integer result = driverDao.update(driver);
		if (null != result && result > 0) {
			return true;
		}
		return false;
	}

	/**
	 * @Title: getDriver
	 * @Description: 根据driverId获取车手介绍
	 * @author zhuzq
	 * @date 2021年04月10日 18:08:25
	 * @param driverId
	 * @return
	 */
	 @AdminServiceLog(description="车手介绍根据driverId获取车手介绍")
	@Override
	public DriverDto getDriver(Integer driverId) {
		DriverDto driverDTO = null;
		Driver driver = driverDao.get(driverId);
		if (null != driver) {
			driverDTO = convertDriverDto(driver);
		}
		return driverDTO;
	}

	/**
	 * @Title: findByPage
	 * @Description: 分页查找
	 * @author zhuzq
	 * * @date 2021年04月10日 18:08:25
	 * @param driverVo
	 * @param jsonResult
	 * @return
	 */
	@AdminServiceLog(description="车手介绍分页查找")
	@Override
	public AdminResultByPage findByPage(DriverVo driverVo, AdminResultByPage jsonResult) {
		//创建日期处理
		String createDateStr = driverVo.getCreateDateStr();
		if(StringUtils.isNotBlank(createDateStr)){
			String[] createDateArr = createDateStr.split("~");
			if(null != createDateArr && createDateArr.length ==2){
				driverVo.setBeginDate(createDateArr[0]);
				driverVo.setEndDate(createDateArr[1]);
			}
		}
				
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("driverVo", driverVo);
		paramMap.put("page", jsonResult);

		int count = driverDao.findByPageCount(paramMap);

		if (count > 0) {
			List<DriverDto> dataList = null;
			List<Driver> driverList = findByPage(paramMap);
			if (null != driverList && driverList.size() > 0) {
				dataList = new ArrayList<DriverDto>();
				for (Driver driver : driverList) {
					// Driver转DriverDTO
					DriverDto driverDTO = convertDriverDto(driver);
					dataList.add(driverDTO);
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
	 * @date 2021年04月10日 18:08:25
	 * @param driverVo
	 * @return
	 */
	@Override
	public String checkParam(DriverVo driverVo,MultipartFile file) {
	    String driverName = driverVo.getDriverName();
		if (StringUtils.isBlank(driverName)) {
			return "车手名称不能为空";
		}
	    String coverImage = driverVo.getCoverImage();
		if (StringUtils.isBlank(coverImage) && (null == file  || file.isEmpty() )) {
			return "封面图片不能为空";
		}
	    String content = driverVo.getContent();
		if (StringUtils.isBlank(content)) {
			return "内容介绍不能为空";
		}
		Integer status = driverVo.getStatus();
		if (null == status) {
			return "0:上架1：下架不能为空";
		}
		return null;
	}


	/**
	 * @Title: checkUnique
	 * @Description: 唯一性验证
	 * @author zhuzq
	 * @date 2021年04月10日 18:08:25
	 * @param driverVo
	 * @return
	 */
	@Override
	public String checkUnique(DriverVo DriverVo) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("driverName", DriverVo.getDriverName());
		List<Driver> driverList = driverDao.select(paramMap);
		if (null == driverList || driverList.size() < 1) {
			return null;
		}

		Integer driverId = DriverVo.getDriverId();
		if (null != driverId) {
			for (Driver entity : driverList) {
				if (!entity.getDriverId().equals(driverId) && entity.getDriverName().equals(DriverVo.getDriverName())) {
					return "车手名称已经存在";
				}
			}
		} else {
			return "车手名称已经存在";
		}
		return null;

	}

	/**
	 * @Title: convertDriver
	 * @Description: DriverVo转Driver
	 * @author zhuzq
	 * @date 2021年04月10日 18:08:25
	 * @param driverVo
	 * @return
	 */
	private Driver convertDriver(DriverVo driverVo) {
		Driver driver = new Driver();
		driver.setDriverId(driverVo.getDriverId());
		driver.setDriverName(driverVo.getDriverName());
		driver.setCoverImage(driverVo.getCoverImage());
		driver.setContent(driverVo.getContent());
		driver.setStatus(driverVo.getStatus());
		driver.setCreateDate(driverVo.getCreateDate());
		driver.setUpdateDate(driverVo.getUpdateDate());
		return driver;
	}

	/**
	 * @Title: convertDriverDto
	 * @Description: Driver转DriverDto
	 * @author zhuzq
	 * @date 2021年04月10日 18:08:25
	 * @param driver
	 * @return
	 */
	private DriverDto convertDriverDto(Driver driver) {
		DriverDto dto = new DriverDto();
		dto.setDriverId(driver.getDriverId());
		dto.setDriverName(driver.getDriverName());
		dto.setCoverImage(driver.getCoverImage());
		dto.setContent(driver.getContent());
		dto.setStatus(driver.getStatus());
		dto.setCreateDate(driver.getCreateDate());
		dto.setUpdateDate(driver.getUpdateDate());
		return dto;
	}
	
}
