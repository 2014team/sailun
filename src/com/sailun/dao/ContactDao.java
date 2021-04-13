package com.sailun.dao;

import com.sailun.common.dao.BaseDao;
import com.sailun.domain.entity.Contact;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

/**
 * @ClassName: ContactDao
 * @Description: 联系我们
 * @author zhuzq
 * @date 2021年04月07日 23:01:41
 */
@Repository
public interface ContactDao extends BaseDao<Contact,Integer>{
	
	/**
	* @Title: getByBatch
	* @Description: 批量查询
	* @author zhuzq
	* @date  2021年4月8日 下午10:46:51
	* @param paramMap
	* @return
	*/
	public List<Contact> getByBatch(Map<String,Object> paramMap);

}
