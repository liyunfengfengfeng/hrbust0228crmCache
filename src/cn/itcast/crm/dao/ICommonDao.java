package cn.itcast.crm.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;

import cn.itcast.crm.domain.SysMenu;
import cn.itcast.crm.domain.SysPopedom;
import cn.itcast.crm.domain.SysPopedomPrivilege;
import cn.itcast.crm.domain.SysUser;
import cn.itcast.crm.domain.SysUserGroup;

public interface ICommonDao<T> {
	/**
	 * 保存实体
	 * @param sysUserGroup
	 */
	public void save(T entity);
	/**
	 * 通过id查找实体
	 * @param id
	 * @return
	 */
	public T find(Serializable id);
	/**
	 * 通过id批量删除数据
	 * @param ids
	 */
	public void deleteObjectsByIds(Serializable[] ids);
	/**
	 * 更新实体
	 * @param sysUserGroup
	 */
	public void update(T entity);
	/**
	 * 删除集合包括删除了集合中的所有实体
	 * @param list
	 */
	public void deleteCollection(Collection<T> entities);
	/**
	 * 依据条件查询所有的数据
	 * @param whereHql 封装查询的条件
	 * @param paramList封装查询条件的数据
	 * @param orderby  排序
	 * @return
	 */
	List<T> findObjectsByConditionWithNoPage(String whereHql,
			List paramList, LinkedHashMap<String, String> orderby);
	/**
	 * 查找所有的部门
	 * 没有限制条件
	 * 以用于在人事管理页面下的list.jsp的部门
	 * 下拉列表里进行迭代
	 * @return
	 */
	List<T> findObjectsByConditionWithNoPage();
	 /**
     * 用于检查登录名及密码
     * @param whereHql
     * @param paramList
     * @return
     */
	List<T> findObjectsByConditionWithNoPage(String whereHql, List paramList);
	/**
	 * 查询系统具备的所有功能
	 * @return
	 */
	public List<T> findAllPopedom();
	/**
	 * 查询当前roleId所对应的数据
	 * 删除之
	 * @param whereHql
	 * @param paramList
	 * @return
	 */
	public List<T> findSysPopedomsByRoleId(String whereHql,
			List paramList);
	/**
	 * 在操作权限组功能表中找到所有的roleId对应的数据
	 * 用于进行回显
	 * @param whereHql
	 * @param paramList
	 * @return
	 */
	List<T> findSysPopedomPrivilegesByRoleId(String whereHql,
			List paramList);
	
		public List<T> findObjectsByConditionWithNoPage(
				LinkedHashMap<String, String> orderby);
}
