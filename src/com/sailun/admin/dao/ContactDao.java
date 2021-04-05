package com.sailun.admin.dao;

import com.sailun.common.dao.BaseDao;
import org.springframework.stereotype.Repository;
import com.sailun.admin.domain.entity.Contact;

/**
 * @ClassName: ContactDao
 * @Description: 联系信息
 * @author zhuzq
 * @date 2021年04月05日 17:02:24
 */
@Repository
public interface ContactDao extends BaseDao<Contact,Integer>{

}
