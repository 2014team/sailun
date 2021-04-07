package com.sailun.admin.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sailun.admin.dao.ContactDao;
import com.sailun.admin.domain.entity.Contact;
import com.sailun.admin.service.ContactService;
import com.sailun.common.service.impl.BaseServiceImpl;
import com.sailun.admin.domain.vo.ContactVo;
import com.sailun.admin.domain.dto.ContactDto;
import com.sailun.common.entity.AdminResultByPage;
import com.sailun.admin.annotation.AdminServiceLog;

/**
 * @ClassName: ContactServiceImpl
 * @Description: 联系我们
 * @author zhuzq
 * @date 2021年04月07日 23:01:45
 */
@Service
public class ContactServiceImpl extends BaseServiceImpl<Contact,Integer>  implements ContactService {
	
	@Autowired
	private ContactDao contactDao;


	/**
	 * @Title: saveContact
	 * @Description: 保存
	 * @author zhuzq
	 * @date 2021年04月07日 23:01:45
	 * @param contactVo
	 * @return
	 */
	@AdminServiceLog(description="联系我们保存")
	@Override
	public boolean saveContact(ContactVo contactVo) {
		// ContactVo转Contact
		Contact contact = convertContact(contactVo);
		Integer result = contactDao.save(contact);
		if (null != result && result > 0) {
			return true;
		}
		return false;
	}

	/**
	 * @Title: deleteContact
	 * @Description: 删除
	 * @author zhuzq
	 * @date 2021年04月07日 23:01:45
	 * @param contactId
	 * @return
	 */
	@AdminServiceLog(description="联系我们 删除")
	@Override
	public boolean deleteContact(Integer contactId) {
		Integer result = contactDao.delete(contactId);
		if (null != result && result > 0) {
			return true;
		}
		return false;
	}

	/**
	 * @Title: deleteByBatch
	 * @Description: 批量删除
	 * @author zhuzq
	 * @date 2021年04月07日 23:01:45
	 * @param contactIdArr
	 * @return
	 */
	@AdminServiceLog(description="联系我们 批量删除")
	@Override
	public int deleteByBatch(Integer[] contactIdArr) {
		List<Integer> contactIdList = Arrays.asList(contactIdArr);
		return contactDao.deleteByBatch(contactIdList);
	}

	/**
	 * @Title: updateContact
	 * @Description: 修改
	 * @author zhuzq
	 * @date 2021年04月07日 23:01:45
	 * @param contactVo
	 * @return
	 */
	@AdminServiceLog(description="联系我们 批量修改")
	@Override
	public boolean updateContact(ContactVo contactVo) {
		// ContactVo转Contact
		Contact contact = convertContact(contactVo);
		Integer result = contactDao.update(contact);
		if (null != result && result > 0) {
			return true;
		}
		return false;
	}

	/**
	 * @Title: getContact
	 * @Description: 根据contactId获取联系我们
	 * @author zhuzq
	 * @date 2021年04月07日 23:01:45
	 * @param contactId
	 * @return
	 */
	 @AdminServiceLog(description="联系我们根据contactId获取联系我们")
	@Override
	public ContactDto getContact(Integer contactId) {
		ContactDto contactDTO = null;
		Contact contact = contactDao.get(contactId);
		if (null != contact) {
			contactDTO = convertContactDto(contact);
		}
		return contactDTO;
	}

	/**
	 * @Title: findByPage
	 * @Description: 分页查找
	 * @author zhuzq
	 * * @date 2021年04月07日 23:01:45
	 * @param contactVo
	 * @param jsonResult
	 * @return
	 */
	@AdminServiceLog(description="联系我们分页查找")
	@Override
	public AdminResultByPage findByPage(ContactVo contactVo, AdminResultByPage jsonResult) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("contactVo", contactVo);
		paramMap.put("page", jsonResult);

		int count = contactDao.findByPageCount(paramMap);

		if (count > 0) {
			List<ContactDto> dataList = null;
			List<Contact> contactList = findByPage(paramMap);
			if (null != contactList && contactList.size() > 0) {
				dataList = new ArrayList<ContactDto>();
				for (Contact contact : contactList) {
					// Contact转ContactDTO
					ContactDto contactDTO = convertContactDto(contact);
					dataList.add(contactDTO);
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
	 * @date 2021年04月07日 23:01:45
	 * @param contactVo
	 * @return
	 */
	@Override
	public String checkParam(ContactVo contactVo) {
	    String username = contactVo.getUsername();
		if (StringUtils.isBlank(username)) {
			return "姓名不能为空";
		}
	    String mobileNum = contactVo.getMobileNum();
		if (StringUtils.isBlank(mobileNum)) {
			return "电话不能为空";
		}
	    String email = contactVo.getEmail();
		if (StringUtils.isBlank(email)) {
			return "邮箱不能为空";
		}
	    String vehicleBrand = contactVo.getVehicleBrand();
		if (StringUtils.isBlank(vehicleBrand)) {
			return "车辆品牌不能为空";
		}
	    String type = contactVo.getType();
		if (StringUtils.isBlank(type)) {
			return "型号不能为空";
		}
	    String contents = contactVo.getContents();
		if (StringUtils.isBlank(contents)) {
			return "内容不能为空";
		}
		return null;
	}


	/**
	 * @Title: checkUnique
	 * @Description: 唯一性验证
	 * @author zhuzq
	 * @date 2021年04月07日 23:01:45
	 * @param contactVo
	 * @return
	 */
	@Override
	public String checkUnique(ContactVo ContactVo) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("username", ContactVo.getUsername());
		List<Contact> contactList = contactDao.select(paramMap);
		if (null == contactList || contactList.size() < 1) {
			return null;
		}

		Integer contactId = ContactVo.getContactId();
		if (null != contactId) {
			for (Contact entity : contactList) {
				if (!entity.getContactId().equals(contactId) && entity.getUsername().equals(ContactVo.getUsername())) {
					return "姓名已经存在";
				}
			}
		} else {
			return "姓名已经存在";
		}
		return null;

	}

	/**
	 * @Title: convertContact
	 * @Description: ContactVo转Contact
	 * @author zhuzq
	 * @date 2021年04月07日 23:01:45
	 * @param contactVo
	 * @return
	 */
	private Contact convertContact(ContactVo contactVo) {
		Contact contact = new Contact();
		contact.setContactId(contactVo.getContactId());
		contact.setUsername(contactVo.getUsername());
		contact.setMobileNum(contactVo.getMobileNum());
		contact.setEmail(contactVo.getEmail());
		contact.setVehicleBrand(contactVo.getVehicleBrand());
		contact.setType(contactVo.getType());
		contact.setContents(contactVo.getContents());
		contact.setCreateDate(contactVo.getCreateDate());
		contact.setUpdateDate(contactVo.getUpdateDate());
		return contact;
	}

	/**
	 * @Title: convertContactDto
	 * @Description: Contact转ContactDto
	 * @author zhuzq
	 * @date 2021年04月07日 23:01:45
	 * @param contact
	 * @return
	 */
	private ContactDto convertContactDto(Contact contact) {
		ContactDto dto = new ContactDto();
		dto.setContactId(contact.getContactId());
		dto.setUsername(contact.getUsername());
		dto.setMobileNum(contact.getMobileNum());
		dto.setEmail(contact.getEmail());
		dto.setVehicleBrand(contact.getVehicleBrand());
		dto.setType(contact.getType());
		dto.setContents(contact.getContents());
		dto.setCreateDate(contact.getCreateDate());
		dto.setUpdateDate(contact.getUpdateDate());
		return dto;
	}
	
}
