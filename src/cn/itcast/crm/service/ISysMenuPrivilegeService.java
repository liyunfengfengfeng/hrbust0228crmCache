package cn.itcast.crm.service;

import java.util.List;

import cn.itcast.crm.domain.SysMenuPrivilege;

/**
 * 建立菜单权限表的业务层
 * 将用户选择好的菜单放置到菜单权限表中
 * 每一个权限组roleId对应着许多的菜单权限
 * 每一个用户对应一个权限组roleId
 * @author LIYUNFENG
 *
 */
public interface ISysMenuPrivilegeService {
	public static final String SERVICE_NAME = 
			"cn.itcast.crm.service.impl.SysMenuPrivilegeServiceImpl";
	/**
	 * 调用业务层将菜单保存在菜单权限表中
	 * @param roleId
	 * @param menuModule
	 */
	public void saveMenu2SysMenuPrivilege(String roleId, String[] menuModule);
	/**
	 * 通过roleId查询该roleId权限组具有的权限
	 * 在菜单权限表中具有的权限
	 * 与查询到的所有菜单进行校对
	 * 进行回显设置
	 * @param roleId
	 * @return
	 */
	public List<SysMenuPrivilege> findAllSysMenuPrivileges(String roleId);
	/**
	 * 在业务层中查询出所有的菜单权限表中的数据
	 * @return
	 */
	public List<SysMenuPrivilege> findAllSysMenuPrivileges();
}
