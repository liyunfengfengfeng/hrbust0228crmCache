package cn.itcast.crm.dao;

import java.util.List;

import cn.itcast.crm.domain.SysPopedomPrivilege;
/**
 * 该表存储每一个权限组拥有的什么权限
 * 而每一个用户对应一个权限组
 * @author LIYUNFENG
 *
 */
public interface ISysPopedomPrivilegeDao extends ICommonDao<SysPopedomPrivilege> {
	public static final String SERVICE_NAME =
			"cn.itcast.crm.dao.impl.SysPopedomPrivilegeDaoImpl";
	
	
}
