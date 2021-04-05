package com.sailun.admin.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.sailun.admin.domain.entity.Menu;
import com.sailun.common.dao.BaseDao;

/**
 * @ClassName: MenuDao
 * @Description: 菜单
 * @author zhuzq
 * @date 2020年05月04日 13:39:50
 */
@Repository
public interface MenuDao extends BaseDao<Menu,Integer>{

	/**
	* @Title: selectByBatch
	* @Description: 批量查找
	* @author zhuzq
	* @date  2020年5月10日 下午10:56:26
	* @param paramMap
	* @return
	*/
	public List<Menu> selectByBatch(Map<String,Object> paramMap);
}
