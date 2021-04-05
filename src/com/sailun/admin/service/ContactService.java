package com.sailun.admin.service;

import com.sailun.common.service.BaseService;
import com.sailun.admin.domain.entity.Contact;
import com.sailun.admin.domain.vo.ContactVo;
import com.sailun.admin.domain.dto.ContactDto;
import com.sailun.common.entity.AdminResultByPage;

/**
 * @ClassName: ContactDao
 * @Description: 联系信息
 * @author zhuzq
 * @date 2021年04月05日 17:02:26
 */
public interface ContactService extends BaseService<Contact,Integer>{

	/**
	 * @Title: saveContact
	 * @Description: 保存
	 * @author zhuzq
	 * @date 2021年04月05日 17:02:26
	 * @param contactVo
	 * @return
	 */
	public boolean saveContact(ContactVo contactVo);

	/**
	 * @Title: deleteContact
	 * @Description: 删除
	 * @author zhuzq
	 * @date 2021年04月05日 17:02:26
	 * @param contactId
	 * @return
	 */
	public boolean deleteContact(Integer contactId);

	/**
	 * @Title: deleteByBatch
	 * @Description: 批量删除
	 * @author zhuzq
	 * @date 2021年04月05日 17:02:26
	 * @param contactIdArr
	 * @return
	 */
	public int deleteByBatch(Integer[] contactIdArr);

	/**
	 * @Title: updateContact
	 * @Description: 修改
	 * @author zhuzq
	 * @date 2021年04月05日 17:02:26
	 * @param contactVo
	 * @return
	 */
	public boolean updateContact(ContactVo contactVo);

	/**
	 * @Title: getContact
	 * @Description: 根据contactId获取对象
	 * @author zhuzq
	 * @date 2021年04月05日 17:02:26
	 * @param contactId
	 * @return
	 */
	public ContactDto getContact(Integer contactId);

	/**
	 * @Title: findByPage
	 * @Description: 分页查找
	 * @author zhuzq
	 * @date 2021年04月05日 17:02:26
	 * @param contactVo
	 * @param jsonResult
	 * @return
	 */
	public AdminResultByPage findByPage(ContactVo contactVo, AdminResultByPage jsonResult);

	/**
	 * @Title: checkParam
	 * @Description: 参数验证
	 * @author zhuzq
	 * @date 2021年04月05日 17:02:26
	 * @param contactVo
	 * @return
	 */
	public String checkParam(ContactVo contactVo);

	/**
	 * @Title: checkUnique
	 * @Description: 唯一性验证
	 * @author zhuzq
	 * @date 2021年04月05日 17:02:26
	 * @param contactVo
	 * @return
	 */
	public String checkUnique(ContactVo contactVo);

}
