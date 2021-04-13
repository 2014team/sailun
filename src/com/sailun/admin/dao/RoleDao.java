package com.sailun.admin.dao;

import org.springframework.stereotype.Repository;

import com.sailun.admin.domain.entity.Role;
import com.sailun.common.dao.BaseDao;

/**
 * @ClassName: RoleDao
 * @Description: 角色
 * @author zhuzq
 * @date 2020年04月30日 14:04:25
 */
@Repository
public interface RoleDao extends BaseDao<Role,Integer>{
	
	

}
