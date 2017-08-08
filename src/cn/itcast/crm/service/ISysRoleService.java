package cn.itcast.crm.service;

import java.util.List;

import cn.itcast.bean.SysRoleSearch;
import cn.itcast.crm.domain.SysRole;

/**
 * 权限组表的业务层
 * @author LIYUNFENG
 *
 */
public interface ISysRoleService {
	public static final String SERVICE_NAME = "cn.itcast.crm.service.impl.SysRoleServiceImpl";
	/**
	 * 权限组表的查询
	 * @param sysRoleSearch 通过该javaBean传递过来的对象
	 * @return
	 */
	public List<SysRole> findSysRoleByConditionWithNoPage(SysRoleSearch sysRoleSearch);
	/**
	 * 权限组表的信息的保存
	 * @param sysRole
	 */
	public void save(SysRole sysRole);
	/**
	 * 调用业务层的方法删除权限组的数据
	 * @param ids
	 */
	public void deleteSysRoleByIds(String[] ids);
	/**
	 * 通过id查找到要编辑的权限组页面
	 * 用于进行回显
	 * @param id
	 * @return
	 */
	public SysRole findSysRoleById(String id);
	/**
	 * 更新编辑页面里面的信息
	 * @param sysRole
	 */
	public void update(SysRole sysRole);
	/**
	 * 用于查询所有的权限组信息在系统用户表的页面下的add.jsp进行迭代
	 * @return
	 */
	public List<SysRole> findSysRoleByConditionWithNoPage();
}
