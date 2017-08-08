package cn.itcast.crm.dao.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import cn.itcast.crm.dao.ISysRoleDao;
import cn.itcast.crm.domain.SysRole;
/**
 * 权限组的dao层
 * 项目中还是有权限组页面的
 * 通过左部菜单操作权限组来到达权限组的list.jsp
 * @author LIYUNFENG
 *
 */
@Repository(ISysRoleDao.SERVICE_NAME)
public class SysRoleDaoImpl extends CommonDaoImpl<SysRole> implements ISysRoleDao {

	
}
