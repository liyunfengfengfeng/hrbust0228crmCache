package cn.itcast.crm.service;

import java.util.List;

/**
 * 操作功能表的业务层
 * 每一个权限组具有的什么功能
 * @author LIYUNFENG
 *
 */
public interface ISysPopedomPrivilegeService {
	public static final String SERVICE_NAME = 
			"cn.itcast.crm.service.impl.SysPopedomPrivilegeServiceImpl";
	/**
	 *调用操作功能表的业务层保存模块名称 操作名称 roleId 
	 *到sys_popedom_privilege表中
	 * @param roleId  权限组id
	 * @param popedomModules 模块名称   操作名称
	 */
	public void savePopedom(String roleId, String[] popedomModules);
	/**
	 * 进行回显 首先进行查出该roleId对应的功能
	 * 调用操作功能表的业务层
	 */
	public List<cn.itcast.crm.domain.SysPopedomPrivilege> findSysPopedomPrivilegesByRoleId(
			String id);
	/**
	 * 获取操作权限表中所有的数据
	 * @return
	 */
	public List<cn.itcast.crm.domain.SysPopedomPrivilege> findAllSysPopedomPrivileges(String roleId);
}
