package cn.itcast.crm.dao;

import cn.itcast.crm.domain.SysMenuPrivilege;
/**
 * 建立菜单权限表的dao层
 * sys_menu_privilege
 * @author LIYUNFENG
 *
 */
public interface ISysMenuPrivilegeDao extends ICommonDao<SysMenuPrivilege> {
	public static final String SERVICE_NAME = "cn.itcast.crm.dao.impl.SysMenuPrivilegeDaoImpl";
}
