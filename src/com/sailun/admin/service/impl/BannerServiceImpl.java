package com.sailun.admin.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sailun.admin.dao.BannerDao;
import com.sailun.admin.domain.entity.Banner;
import com.sailun.admin.service.BannerService;
import com.sailun.common.service.impl.BaseServiceImpl;
import com.sailun.admin.domain.vo.BannerVo;
import com.sailun.admin.domain.dto.BannerDto;
import com.sailun.common.entity.AdminResultByPage;
import com.sailun.admin.annotation.AdminServiceLog;

/**
 * @ClassName: BannerServiceImpl
 * @Description: 首页广告
 * @author zhuzq
 * @date 2021年04月09日 14:50:15
 */
@Service
public class BannerServiceImpl extends BaseServiceImpl<Banner,Integer>  implements BannerService {
	
	@Autowired
	private BannerDao bannerDao;


	/**
	 * @Title: saveBanner
	 * @Description: 保存
	 * @author zhuzq
	 * @date 2021年04月09日 14:50:15
	 * @param bannerVo
	 * @return
	 */
	@AdminServiceLog(description="首页广告保存")
	@Override
	public boolean saveBanner(BannerVo bannerVo) {
		// BannerVo转Banner
		Banner banner = convertBanner(bannerVo);
		Integer result = bannerDao.save(banner);
		if (null != result && result > 0) {
			return true;
		}
		return false;
	}

	/**
	 * @Title: deleteBanner
	 * @Description: 删除
	 * @author zhuzq
	 * @date 2021年04月09日 14:50:15
	 * @param bannerId
	 * @return
	 */
	@AdminServiceLog(description="首页广告 删除")
	@Override
	public boolean deleteBanner(Integer bannerId) {
		Integer result = bannerDao.delete(bannerId);
		if (null != result && result > 0) {
			return true;
		}
		return false;
	}

	/**
	 * @Title: deleteByBatch
	 * @Description: 批量删除
	 * @author zhuzq
	 * @date 2021年04月09日 14:50:15
	 * @param bannerIdArr
	 * @return
	 */
	@AdminServiceLog(description="首页广告 批量删除")
	@Override
	public int deleteByBatch(Integer[] bannerIdArr) {
		List<Integer> bannerIdList = Arrays.asList(bannerIdArr);
		return bannerDao.deleteByBatch(bannerIdList);
	}

	/**
	 * @Title: updateBanner
	 * @Description: 修改
	 * @author zhuzq
	 * @date 2021年04月09日 14:50:15
	 * @param bannerVo
	 * @return
	 */
	@AdminServiceLog(description="首页广告 批量修改")
	@Override
	public boolean updateBanner(BannerVo bannerVo) {
		// BannerVo转Banner
		Banner banner = convertBanner(bannerVo);
		Integer result = bannerDao.update(banner);
		if (null != result && result > 0) {
			return true;
		}
		return false;
	}

	/**
	 * @Title: getBanner
	 * @Description: 根据bannerId获取首页广告
	 * @author zhuzq
	 * @date 2021年04月09日 14:50:15
	 * @param bannerId
	 * @return
	 */
	 @AdminServiceLog(description="首页广告根据bannerId获取首页广告")
	@Override
	public BannerDto getBanner(Integer bannerId) {
		BannerDto bannerDTO = null;
		Banner banner = bannerDao.get(bannerId);
		if (null != banner) {
			bannerDTO = convertBannerDto(banner);
		}
		return bannerDTO;
	}

	/**
	 * @Title: findByPage
	 * @Description: 分页查找
	 * @author zhuzq
	 * * @date 2021年04月09日 14:50:15
	 * @param bannerVo
	 * @param jsonResult
	 * @return
	 */
	@AdminServiceLog(description="首页广告分页查找")
	@Override
	public AdminResultByPage findByPage(BannerVo bannerVo, AdminResultByPage jsonResult) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("bannerVo", bannerVo);
		paramMap.put("page", jsonResult);

		int count = bannerDao.findByPageCount(paramMap);

		if (count > 0) {
			List<BannerDto> dataList = null;
			List<Banner> bannerList = findByPage(paramMap);
			if (null != bannerList && bannerList.size() > 0) {
				dataList = new ArrayList<BannerDto>();
				for (Banner banner : bannerList) {
					// Banner转BannerDTO
					BannerDto bannerDTO = convertBannerDto(banner);
					dataList.add(bannerDTO);
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
	 * @date 2021年04月09日 14:50:15
	 * @param bannerVo
	 * @return
	 */
	@Override
	public String checkParam(BannerVo bannerVo) {
	    String imageUrl = bannerVo.getImageUrl();
		if (StringUtils.isBlank(imageUrl)) {
			return "图片地址不能为空";
		}
	    String jumpUrl = bannerVo.getJumpUrl();
		if (StringUtils.isBlank(jumpUrl)) {
			return "跳转地址不能为空";
		}
		Integer status = bannerVo.getStatus();
		if (null == status) {
			return "1:停用不能为空";
		}
		return null;
	}


	/**
	 * @Title: checkUnique
	 * @Description: 唯一性验证
	 * @author zhuzq
	 * @date 2021年04月09日 14:50:15
	 * @param bannerVo
	 * @return
	 */
	@Override
	public String checkUnique(BannerVo BannerVo) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("imageUrl", BannerVo.getImageUrl());
		List<Banner> bannerList = bannerDao.select(paramMap);
		if (null == bannerList || bannerList.size() < 1) {
			return null;
		}

		Integer bannerId = BannerVo.getBannerId();
		if (null != bannerId) {
			for (Banner entity : bannerList) {
				if (!entity.getBannerId().equals(bannerId) && entity.getImageUrl().equals(BannerVo.getImageUrl())) {
					return "图片地址已经存在";
				}
			}
		} else {
			return "图片地址已经存在";
		}
		return null;

	}

	/**
	 * @Title: convertBanner
	 * @Description: BannerVo转Banner
	 * @author zhuzq
	 * @date 2021年04月09日 14:50:15
	 * @param bannerVo
	 * @return
	 */
	private Banner convertBanner(BannerVo bannerVo) {
		Banner banner = new Banner();
		banner.setBannerId(bannerVo.getBannerId());
		banner.setImageUrl(bannerVo.getImageUrl());
		banner.setJumpUrl(bannerVo.getJumpUrl());
		banner.setStatus(bannerVo.getStatus());
		banner.setCreateDate(bannerVo.getCreateDate());
		banner.setUpdateDate(bannerVo.getUpdateDate());
		return banner;
	}

	/**
	 * @Title: convertBannerDto
	 * @Description: Banner转BannerDto
	 * @author zhuzq
	 * @date 2021年04月09日 14:50:15
	 * @param banner
	 * @return
	 */
	private BannerDto convertBannerDto(Banner banner) {
		BannerDto dto = new BannerDto();
		dto.setBannerId(banner.getBannerId());
		dto.setImageUrl(banner.getImageUrl());
		dto.setJumpUrl(banner.getJumpUrl());
		dto.setStatus(banner.getStatus());
		dto.setCreateDate(banner.getCreateDate());
		dto.setUpdateDate(banner.getUpdateDate());
		return dto;
	}
	
}
