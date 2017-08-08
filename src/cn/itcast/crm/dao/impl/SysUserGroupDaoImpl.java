package cn.itcast.crm.dao.impl;

import org.springframework.stereotype.Repository;

import cn.itcast.crm.dao.ISysUserGroupDao;
import cn.itcast.crm.domain.SysUserGroup;
@Repository(ISysUserGroupDao.SERVICE_NAME)
public class SysUserGroupDaoImpl extends CommonDaoImpl<SysUserGroup> implements ISysUserGroupDao {

}
