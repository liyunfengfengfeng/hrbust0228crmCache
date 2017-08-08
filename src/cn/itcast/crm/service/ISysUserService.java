package cn.itcast.crm.service;

import java.util.List;

import cn.itcast.bean.SysUserSearch;
import cn.itcast.crm.domain.SysUser;

public interface ISysUserService {
	public static final String SERVICE_NAME = "cn.itcast.crm.service.impl.SysUserServiceImpl";
	/**
	 * 依据条件查询所有的用户返回集合
	 * @param sysUserSearch
	 * @return
	 */
	List<SysUser> findSysUserByConditionWithNoPage(SysUserSearch sysUserSearch);
	/**
	 * 检查用户在login.jsp页面输入的用户名密码是否正确
	 * @param sysUserSearch
	 * @return
	 */
	public List<SysUser> checkNameAndPassword(SysUserSearch sysUserSearch);
	/**
	 * 保存系统用户信息到sys_user表中
	 * @param sysUser
	 */
	public void save(SysUser sysUser);
	/**
	 * 通过id数组批量
	 * 删除系统用户数据
	 * @param ids
	 */
	public void deleteByIds(String[] ids);
	/**
	 * 更改用户的状态
	 * 将用户状态设置为可用状态
	 * @param idArray
	 */
	public void setSysUserEnable(Integer[] idArray);
	/**
	 * 更改用户的状态
	 * 将用户状态设置为可用状态
	 * @param idArray
	 */
	public void setSysUserDisable(Integer[] idArray);
	/**
	 * 通过id查找到要进行编辑的用户
	 * 
	 * @param id
	 * @return
	 */
	public SysUser findSysUserById(Integer id);
	/**
	 * 更新系统用户的信息
	 * @param sysUser
	 */
	public void update(SysUser sysUser);
	/**
	 * 通过所属人姓名查询所属人 id
	 * @param dispensePerson
	 * @return
	 */
	public List<SysUser> findSysUserByCNName(String dispensePerson);
	/**
	 * 无条件查找
	 * 查询出所有的用户信息
	 * @return
	 */
	public List<SysUser> findSysUserByConditionWithNoPage();
}
