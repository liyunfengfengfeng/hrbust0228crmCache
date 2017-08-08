package cn.itcast.crm.service.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.xwork.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.bean.SysUserSearch;
import cn.itcast.crm.dao.ISysUserDao;
import cn.itcast.crm.domain.SysUser;
import cn.itcast.crm.service.ISysUserService;
import cn.itcast.crm.util.DataType;
@Service(ISysUserService.SERVICE_NAME)
@Transactional(readOnly=true)
public class SysUserServiceImpl implements ISysUserService {
	//获取用户的dao层
	@Resource(name = ISysUserDao.SERVICE_NAME)
	ISysUserDao sysUserDao;
	/**
	 * 依据条件查询所有的用户返回集合
	 * @param sysUserSearch
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes", "unchecked" })
	public List<SysUser> findSysUserByConditionWithNoPage(
			SysUserSearch sysUserSearch) {
		//封装查询的条件
		String whereHql = "";
		//封装查询条件的数据
		List paramList = new ArrayList();
		if(sysUserSearch != null){
			//处理用户名
			if(StringUtils.isNotBlank(sysUserSearch.getName())){
				whereHql = whereHql + " and o.name like ? ";
				paramList.add("%" + sysUserSearch.getName().trim()+ "%");
			}
			//处理中文名
			if(StringUtils.isNotBlank(sysUserSearch.getCnName())){
				whereHql = whereHql + " and o.cnName like ? ";
				paramList.add("%" + sysUserSearch.getCnName().trim()+ "%");
			}
			//处理部门
			if(sysUserSearch.getGroupId() != null && sysUserSearch.getGroupId() != 0){
				whereHql = whereHql + " and o.sysUserGroup.id = ? ";
				paramList.add(sysUserSearch.getGroupId());
			}
			//处理状态
			if(StringUtils.isNotBlank(sysUserSearch.getStatus())){
				whereHql = whereHql + " and o.status like ? ";
				paramList.add("%" + sysUserSearch.getStatus().trim() + "%");
			}
		}
		//排序
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put(" order by o.id ", " asc ");
		return sysUserDao.findObjectsByConditionWithNoPage(whereHql, paramList, orderby);
	}
	/**
	 * 检查用户在login.jsp页面输入的用户名密码是否正确
	 * @param sysUserSearch
	 * @return
	 */
	public List<SysUser> checkNameAndPassword(SysUserSearch sysUserSearch) {
		//封装查询的条件
		String whereHql = "";
		//封装查询条件的数据
		List paramList = new ArrayList();
		if(sysUserSearch != null){
			//处理用户名
			if(StringUtils.isNotBlank(sysUserSearch.getName())){
				whereHql = whereHql + " and o.name = ? ";
				paramList.add(sysUserSearch.getName().trim());
			}
			//处理密码
			if(StringUtils.isNotBlank(sysUserSearch.getPassword())){
				whereHql = whereHql + " and o.password = ? ";
				paramList.add(sysUserSearch.getPassword().trim());
			}
		}
		List<SysUser> sysUsers = sysUserDao.findObjectsByConditionWithNoPage(whereHql,paramList);
		//System.out.println("用户登录匹配数据" + sysUsers.size());
		
		return sysUsers;
	}
	/**
	 * 保存系统用户信息到sys_user表中
	 * @param sysUser
	 */
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
	public void save(SysUser sysUser) {
		//调用dao层进行保存
		sysUserDao.save(sysUser);
	}
	/**
	 * 
	 * 通过id数组批量
	 * 删除系统用户数据
	 * @param ids
	 *
	 */
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
	public void deleteByIds(String[] ids) {
		Integer []id = DataType.converterStringArray2IntegerArray(ids);
		sysUserDao.deleteObjectsByIds(id);
		
	}
	/**
	 * 更改用户的状态
	 * 将用户状态设置为可用状态
	 * @param idArray
	 */
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
	public void setSysUserEnable(Integer[] idArray) {
		//创建用户po对象
		SysUser sysUser = new SysUser();
		if(idArray != null && idArray.length > 0){
			for(Integer id : idArray){
				sysUser = sysUserDao.find(id);
				sysUser.setStatus("Y");
				//调用dao层进行更新
				sysUserDao.update(sysUser);
			}
		}
		
	}
	/**
	 * 更改用户的状态
	 * 将用户状态设置为可用状态
	 * @param idArray
	 */
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
	public void setSysUserDisable(Integer[] idArray) {
		//创建po对象
		SysUser sysUser = new SysUser();
		if(idArray != null && idArray.length > 0){
			for(Integer id : idArray){
				sysUser = sysUserDao.find(id);
				sysUser.setStatus("N");
				sysUserDao.update(sysUser);
			}
		}
	}
	/**
	 * 通过id查找到要进行编辑的用户
	 * 
	 * @param id
	 * @return
	 */
	public SysUser findSysUserById(Integer id) {
		
		return sysUserDao.find(id);
	}
	/**
	 * 更新系统用户的信息
	 * @param sysUser
	 */
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
	public void update(SysUser sysUser) {
		//调用dao层进行更新
		sysUserDao.update(sysUser);
	}
	/**
	 * 通过所属人姓名查询所属人 id
	 * @param dispensePerson
	 * @return
	 */
	public List<SysUser> findSysUserByCNName(String dispensePerson) {
		//封装查询的条件
		String whereHql = "";
		//封装查询条件的数据
		List paramList = new ArrayList();
		if(StringUtils.isNotBlank(dispensePerson)){
			whereHql = whereHql + " and o.cnName = ? ";
			paramList.add(dispensePerson.trim());
		}
		//排序
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put(" order by o.id ", " asc ");
		return sysUserDao.findObjectsByConditionWithNoPage(whereHql, paramList, orderby);
	}
	/**
	 * 无条件查找
	 * 查询出所有的用户信息
	 * @return
	 */
	public List<SysUser> findSysUserByConditionWithNoPage() {
		
		return sysUserDao.findObjectsByConditionWithNoPage();
	}
}
