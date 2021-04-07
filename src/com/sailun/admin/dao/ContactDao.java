package com.sailun.admin.dao;

import com.sailun.common.dao.BaseDao;
import org.springframework.stereotype.Repository;
import com.sailun.admin.domain.entity.Contact;

/**
 * @ClassName: ContactDao
 * @Description: 联系我们
 * @author zhuzq
 * @date 2021年04月07日 23:01:41
 */
@Repository
public interface ContactDao extends BaseDao<Contact,Integer>{

}
