package cn.itcast.crm.service;

import java.io.Serializable;
import java.util.List;

import cn.itcast.bean.SysUserGroupSearch;
import cn.itcast.crm.domain.SysUserGroup;

/**
 * 创建部门的业务层
 * @author LIYUNFENG
 *
 */
public interface ISysUserGroupService {
	public static final String SERVICE_NAME 
	= "cn.itcast.crm.service.impl.SysUserGroupServiceImpl";
	/**
	 * 通过id批量删除数据
	 * @param ids
	 */
	public void deleteObjectsByIds(Serializable[] ids);
	/**
	 * 通过条件查询部门里面的数据
	 * @return
	 */
	public List<SysUserGroup> findSysUserGroupByConditionWithNoPage(
			SysUserGroupSearch sysUserGroupSearch);
	/**
	 * 保存部门信息
	 * @param sysUserGroup
	 */
	public void save(SysUserGroup sysUserGroup);
	/**
	 * 删除部门信息
	 * @param id
	 */
	public void delete(Integer[] id);
	/**
	 * 通过id查找部门信息
	 * @param id
	 * @return
	 */
	public SysUserGroup findSysUserGroupById(Serializable id);

	/**
	 * 更新部门信息
	 * @param sysUserGroup
	 */
	public void updateSysUserGroup(SysUserGroup sysUserGroup);
	/**
	 * 查找所有的部门
	 * 以用于在人事管理页面下的list.jsp的部门
	 * 下拉列表里进行迭代
	 * @return
	 */
	public List<SysUserGroup> findAllSysUserGroups();
}
