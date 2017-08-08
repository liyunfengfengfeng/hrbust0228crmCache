package cn.itcast.crm.dao;

import cn.itcast.crm.domain.SysRole;
/**
 * 权限组的dao层
 * @author LIYUNFENG
 *
 */
public interface ISysRoleDao extends ICommonDao<SysRole> {
	public static final String SERVICE_NAME = "cn.itcast.crm.dao.impl.SysRoleDaoImpl";
}
