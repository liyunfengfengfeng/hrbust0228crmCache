package cn.itcast.crm.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import cn.itcast.bean.SysUserGroupSearch;
import cn.itcast.crm.dao.ISysUserGroupDao;
import cn.itcast.crm.domain.SysUserGroup;
import cn.itcast.crm.service.ISysUserGroupService;
@Transactional(readOnly=true)
@Service(ISysUserGroupService.SERVICE_NAME)
public class SysUserGroupServiceImpl implements ISysUserGroupService {
	//注入部门的dao层
	@Resource(name=ISysUserGroupDao.SERVICE_NAME)
	private ISysUserGroupDao sysUserGroupDao;
	/**
	 * 调用dao层的方法批量删除数据
	 */
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
	public void deleteObjectsByIds(Serializable[] ids) {
		sysUserGroupDao.deleteObjectsByIds(ids);
		
	}
	/**
	 * 通过条件查询部门里面的数据
	 * @return
	 */
	public List<SysUserGroup> findSysUserGroupByConditionWithNoPage(
			SysUserGroupSearch sysUserGroupSearch) {
		//封装要查询的条件
		String whereHql = "";
		//封装查询条件的数据
		List paramList = new ArrayList();
		if(sysUserGroupSearch!=null){
			if(StringUtils.isNotBlank(sysUserGroupSearch.getName())){
				whereHql = whereHql + " and o.name like ?";
				paramList.add("%"+sysUserGroupSearch.getName().trim()+"%");
			}
		}
		//排序
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put(" order by o.id ", " asc ");
		return sysUserGroupDao.findObjectsByConditionWithNoPage(whereHql,paramList,orderby);
	}
	/**
	 * 保存部门信息
	 * @param sysUserGroup
	 */
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
	public void save(SysUserGroup sysUserGroup) {
		//调用部门的dao层进行保存
		sysUserGroupDao.save(sysUserGroup);
		
	}
	/**
	 * 删除部门信息
	 * @param id
	 */
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
	public void delete(Integer[] id) {
		//调用部门的dao层进行删除
		sysUserGroupDao.deleteObjectsByIds(id);
		
	}
	/**
	 * 通过id查找部门信息
	 * @param id
	 * @return
	 */
	public SysUserGroup findSysUserGroupById(Serializable id) {
		//封装查询的条件
		String whereHql = "";
		//封装查询条件的数据
		List paramList = new ArrayList();
		if(id != null){
			whereHql = whereHql+" o.id = ? ";
			paramList.add(id);
		}
		//调用dao层进行通过id进行查询
		return sysUserGroupDao.find(id);
	}
	/**
	 * 更新部门信息
	 * @param sysUserGroup
	 */
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
	public void updateSysUserGroup(SysUserGroup sysUserGroup) {
		if(sysUserGroup != null){
			sysUserGroupDao.update(sysUserGroup);
		}
	}
	/**
	 * 查找所有的部门
	 * 以用于在人事管理页面下的list.jsp的部门
	 * 下拉列表里进行迭代
	 * @return
	 */
	public List<SysUserGroup> findAllSysUserGroups() {
		
		return sysUserGroupDao.findObjectsByConditionWithNoPage();
	}
	

}
