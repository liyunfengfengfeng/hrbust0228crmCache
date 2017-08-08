package cn.itcast.crm.dao.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import cn.itcast.crm.dao.ISysMenuPrivilegeDao;
import cn.itcast.crm.domain.SysMenuPrivilege;
/**
 * 建立菜单权限表的dao层
 * sys_menu_privilege
 * @author LIYUNFENG
 *
 */
@Repository(ISysMenuPrivilegeDao.SERVICE_NAME)
public class SysMenuPrivilegeDaoImpl extends CommonDaoImpl<SysMenuPrivilege> implements
		ISysMenuPrivilegeDao {

	
}
