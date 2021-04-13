package com.sailun.admin.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sailun.admin.dao.AboutusDao;
import com.sailun.admin.domain.entity.Aboutus;
import com.sailun.admin.service.AboutusService;
import com.sailun.common.service.impl.BaseServiceImpl;
import com.sailun.admin.domain.vo.AboutusVo;
import com.sailun.admin.domain.dto.AboutusDto;
import com.sailun.common.entity.AdminResultByPage;
import com.sailun.admin.annotation.AdminServiceLog;

/**
 * @ClassName: AboutusServiceImpl
 * @Description: 关于我们
 * @author zhuzq
 * @date 2021年04月09日 23:08:56
 */
@Service
public class AboutusServiceImpl extends BaseServiceImpl<Aboutus,Integer>  implements AboutusService {
	
	@Autowired
	private AboutusDao aboutusDao;


	/**
	 * @Title: saveAboutus
	 * @Description: 保存
	 * @author zhuzq
	 * @date 2021年04月09日 23:08:56
	 * @param aboutusVo
	 * @return
	 */
	@AdminServiceLog(description="关于我们保存")
	@Override
	public boolean saveAboutus(AboutusVo aboutusVo) {
		// AboutusVo转Aboutus
		Aboutus aboutus = convertAboutus(aboutusVo);
		Integer result = aboutusDao.save(aboutus);
		if (null != result && result > 0) {
			return true;
		}
		return false;
	}

	/**
	 * @Title: deleteAboutus
	 * @Description: 删除
	 * @author zhuzq
	 * @date 2021年04月09日 23:08:56
	 * @param aboutusId
	 * @return
	 */
	@AdminServiceLog(description="关于我们 删除")
	@Override
	public boolean deleteAboutus(Integer aboutusId) {
		Integer result = aboutusDao.delete(aboutusId);
		if (null != result && result > 0) {
			return true;
		}
		return false;
	}

	/**
	 * @Title: deleteByBatch
	 * @Description: 批量删除
	 * @author zhuzq
	 * @date 2021年04月09日 23:08:56
	 * @param aboutusIdArr
	 * @return
	 */
	@AdminServiceLog(description="关于我们 批量删除")
	@Override
	public int deleteByBatch(Integer[] aboutusIdArr) {
		List<Integer> aboutusIdList = Arrays.asList(aboutusIdArr);
		return aboutusDao.deleteByBatch(aboutusIdList);
	}

	/**
	 * @Title: updateAboutus
	 * @Description: 修改
	 * @author zhuzq
	 * @date 2021年04月09日 23:08:56
	 * @param aboutusVo
	 * @return
	 */
	@AdminServiceLog(description="关于我们 批量修改")
	@Override
	public boolean updateAboutus(AboutusVo aboutusVo) {
		// AboutusVo转Aboutus
		Aboutus aboutus = convertAboutus(aboutusVo);
		Integer result = aboutusDao.update(aboutus);
		if (null != result && result > 0) {
			return true;
		}
		return false;
	}

	/**
	 * @Title: getAboutus
	 * @Description: 根据aboutusId获取关于我们
	 * @author zhuzq
	 * @date 2021年04月09日 23:08:56
	 * @param aboutusId
	 * @return
	 */
	 @AdminServiceLog(description="关于我们根据aboutusId获取关于我们")
	@Override
	public AboutusDto getAboutus(Integer aboutusId) {
		AboutusDto aboutusDTO = null;
		Aboutus aboutus = aboutusDao.get(aboutusId);
		if (null != aboutus) {
			aboutusDTO = convertAboutusDto(aboutus);
		}
		return aboutusDTO;
	}

	/**
	 * @Title: findByPage
	 * @Description: 分页查找
	 * @author zhuzq
	 * * @date 2021年04月09日 23:08:56
	 * @param aboutusVo
	 * @param jsonResult
	 * @return
	 */
	@AdminServiceLog(description="关于我们分页查找")
	@Override
	public AdminResultByPage findByPage(AboutusVo aboutusVo, AdminResultByPage jsonResult) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("aboutusVo", aboutusVo);
		paramMap.put("page", jsonResult);

		int count = aboutusDao.findByPageCount(paramMap);

		if (count > 0) {
			List<AboutusDto> dataList = null;
			List<Aboutus> aboutusList = findByPage(paramMap);
			if (null != aboutusList && aboutusList.size() > 0) {
				dataList = new ArrayList<AboutusDto>();
				for (Aboutus aboutus : aboutusList) {
					// Aboutus转AboutusDTO
					AboutusDto aboutusDTO = convertAboutusDto(aboutus);
					dataList.add(aboutusDTO);
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
	 * @date 2021年04月09日 23:08:56
	 * @param aboutusVo
	 * @return
	 */
	@Override
	public String checkParam(AboutusVo aboutusVo) {
	    String content = aboutusVo.getContent();
		if (StringUtils.isBlank(content)) {
			return "内容不能为空";
		}
		return null;
	}


	/**
	 * @Title: checkUnique
	 * @Description: 唯一性验证
	 * @author zhuzq
	 * @date 2021年04月09日 23:08:56
	 * @param aboutusVo
	 * @return
	 */
	@Override
	public String checkUnique(AboutusVo AboutusVo) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("content", AboutusVo.getContent());
		List<Aboutus> aboutusList = aboutusDao.select(paramMap);
		if (null == aboutusList || aboutusList.size() < 1) {
			return null;
		}

		Integer aboutusId = AboutusVo.getAboutusId();
		if (null != aboutusId) {
			for (Aboutus entity : aboutusList) {
				if (!entity.getAboutusId().equals(aboutusId) && entity.getContent().equals(AboutusVo.getContent())) {
					return "内容已经存在";
				}
			}
		} else {
			return "内容已经存在";
		}
		return null;

	}

	/**
	 * @Title: convertAboutus
	 * @Description: AboutusVo转Aboutus
	 * @author zhuzq
	 * @date 2021年04月09日 23:08:56
	 * @param aboutusVo
	 * @return
	 */
	private Aboutus convertAboutus(AboutusVo aboutusVo) {
		Aboutus aboutus = new Aboutus();
		aboutus.setAboutusId(aboutusVo.getAboutusId());
		aboutus.setContent(aboutusVo.getContent());
		aboutus.setCreateDate(aboutusVo.getCreateDate());
		aboutus.setUpdateDate(aboutusVo.getUpdateDate());
		aboutus.setStatus(aboutusVo.getStatus());
		return aboutus;
	}

	/**
	 * @Title: convertAboutusDto
	 * @Description: Aboutus转AboutusDto
	 * @author zhuzq
	 * @date 2021年04月09日 23:08:56
	 * @param aboutus
	 * @return
	 */
	private AboutusDto convertAboutusDto(Aboutus aboutus) {
		AboutusDto dto = new AboutusDto();
		dto.setAboutusId(aboutus.getAboutusId());
		dto.setContent(aboutus.getContent());
		dto.setCreateDate(aboutus.getCreateDate());
		dto.setUpdateDate(aboutus.getUpdateDate());
		dto.setStatus(aboutus.getStatus());
		return dto;
	}
	
}
