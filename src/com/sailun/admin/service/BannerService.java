package com.sailun.admin.service;

import com.sailun.common.service.BaseService;
import com.sailun.admin.domain.entity.Banner;
import com.sailun.admin.domain.vo.BannerVo;
import com.sailun.admin.domain.dto.BannerDto;
import com.sailun.common.entity.AdminResultByPage;

/**
 * @ClassName: BannerDao
 * @Description: 广告 banner
 * @author zhuzq
 * @date 2021年04月09日 00:05:21
 */
public interface BannerService extends BaseService<Banner,Integer>{

	/**
	 * @Title: saveBanner
	 * @Description: 保存
	 * @author zhuzq
	 * @date 2021年04月09日 00:05:21
	 * @param bannerVo
	 * @return
	 */
	public boolean saveBanner(BannerVo bannerVo);

	/**
	 * @Title: deleteBanner
	 * @Description: 删除
	 * @author zhuzq
	 * @date 2021年04月09日 00:05:21
	 * @param bannerId
	 * @return
	 */
	public boolean deleteBanner(Integer bannerId);

	/**
	 * @Title: deleteByBatch
	 * @Description: 批量删除
	 * @author zhuzq
	 * @date 2021年04月09日 00:05:21
	 * @param bannerIdArr
	 * @return
	 */
	public int deleteByBatch(Integer[] bannerIdArr);

	/**
	 * @Title: updateBanner
	 * @Description: 修改
	 * @author zhuzq
	 * @date 2021年04月09日 00:05:21
	 * @param bannerVo
	 * @return
	 */
	public boolean updateBanner(BannerVo bannerVo);

	/**
	 * @Title: getBanner
	 * @Description: 根据bannerId获取对象
	 * @author zhuzq
	 * @date 2021年04月09日 00:05:21
	 * @param bannerId
	 * @return
	 */
	public BannerDto getBanner(Integer bannerId);

	/**
	 * @Title: findByPage
	 * @Description: 分页查找
	 * @author zhuzq
	 * @date 2021年04月09日 00:05:21
	 * @param bannerVo
	 * @param jsonResult
	 * @return
	 */
	public AdminResultByPage findByPage(BannerVo bannerVo, AdminResultByPage jsonResult);

	/**
	 * @Title: checkParam
	 * @Description: 参数验证
	 * @author zhuzq
	 * @date 2021年04月09日 00:05:21
	 * @param bannerVo
	 * @return
	 */
	public String checkParam(BannerVo bannerVo);

	/**
	 * @Title: checkUnique
	 * @Description: 唯一性验证
	 * @author zhuzq
	 * @date 2021年04月09日 00:05:21
	 * @param bannerVo
	 * @return
	 */
	public String checkUnique(BannerVo bannerVo);

}
