package com.sailun.service;

import com.sailun.common.service.BaseService;
import com.sailun.domain.dto.ContactDto;
import com.sailun.domain.entity.Contact;
import com.sailun.domain.vo.ContactVo;

import java.util.List;
import java.util.Map;

import com.sailun.common.entity.AdminResultByPage;

/**
 * @ClassName: ContactDao
 * @Description: 联系我们
 * @author zhuzq
 * @date 2021年04月07日 23:01:45
 */
public interface ContactService extends BaseService<Contact,Integer>{

	/**
	 * @Title: saveContact
	 * @Description: 保存
	 * @author zhuzq
	 * @date 2021年04月07日 23:01:45
	 * @param contactVo
	 * @return
	 */
	public boolean saveContact(ContactVo contactVo);

	/**
	 * @Title: deleteContact
	 * @Description: 删除
	 * @author zhuzq
	 * @date 2021年04月07日 23:01:45
	 * @param contactId
	 * @return
	 */
	public boolean deleteContact(Integer contactId);

	/**
	 * @Title: deleteByBatch
	 * @Description: 批量删除
	 * @author zhuzq
	 * @date 2021年04月07日 23:01:45
	 * @param contactIdArr
	 * @return
	 */
	public int deleteByBatch(Integer[] contactIdArr);

	/**
	 * @Title: updateContact
	 * @Description: 修改
	 * @author zhuzq
	 * @date 2021年04月07日 23:01:45
	 * @param contactVo
	 * @return
	 */
	public boolean updateContact(ContactVo contactVo);

	/**
	 * @Title: getContact
	 * @Description: 根据contactId获取对象
	 * @author zhuzq
	 * @date 2021年04月07日 23:01:45
	 * @param contactId
	 * @return
	 */
	public ContactDto getContact(Integer contactId);

	/**
	 * @Title: findByPage
	 * @Description: 分页查找
	 * @author zhuzq
	 * @date 2021年04月07日 23:01:45
	 * @param contactVo
	 * @param jsonResult
	 * @return
	 */
	public AdminResultByPage findByPage(ContactVo contactVo, AdminResultByPage jsonResult);

	/**
	 * @Title: checkParam
	 * @Description: 参数验证
	 * @author zhuzq
	 * @date 2021年04月07日 23:01:45
	 * @param contactVo
	 * @return
	 */
	public String checkParam(ContactVo contactVo);

	/**
	 * @Title: checkUnique
	 * @Description: 唯一性验证
	 * @author zhuzq
	 * @date 2021年04月07日 23:01:45
	 * @param contactVo
	 * @return
	 */
	public String checkUnique(ContactVo contactVo);
	
	
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
