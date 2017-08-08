package cn.itcast.crm.dao.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import cn.itcast.crm.dao.ISysUserDao;
import cn.itcast.crm.domain.SysUser;
@Repository(ISysUserDao.SERVICE_NAME)
public class SysUserDaoImpl extends CommonDaoImpl<SysUser> implements ISysUserDao {


}
