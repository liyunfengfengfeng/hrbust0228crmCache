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

import cn.itcast.crm.dao.ISysPopedomPrivilegeDao;
import cn.itcast.crm.domain.SysPopedomPrivilege;
import cn.itcast.crm.domain.SysPopedomPrivilegeId;
import cn.itcast.crm.service.ISysPopedomPrivilegeService;
/**
 * 操作功能表的业务层
 * 每一个权限组具有的什么功能
 * @author LIYUNFENG
 *
 */
@Service(ISysPopedomPrivilegeService.SERVICE_NAME)
@Transactional(readOnly=true)
public class SysPopedomPrivilegeServiceImpl implements
		ISysPopedomPrivilegeService {
	//获取操作功能表的dao层
	@Resource(name = ISysPopedomPrivilegeDao.SERVICE_NAME)
	ISysPopedomPrivilegeDao sysPopedomPrivilegeDao;
	/**
	 *调用操作功能表的业务层保存模块名称 操作名称 roleId 
	 *到sys_popedom_privilege表中
	 * @param roleId  权限组id
	 * @param popedomModules 模块名称   操作名称
	 */
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
	public void savePopedom(String roleId, String[] popedomModules) {
		/**
		 * 因为联合主键重复保存肯定会报错 故无法保存
		 * 所以再进行下一次保存时需要删除该roleId
		 * 所对应的数据
		 */
		//封装查询条件
		String whereHql = "";
		//封装查询条件对应的数据
		List ParamList = new ArrayList();
		if(StringUtils.isNotBlank(roleId)){
			whereHql = whereHql + " and o.id.roleId = ? ";
			ParamList.add(roleId.trim());
		}
		//调用操作权限表的dao层查询roleId对应的数据
		List<SysPopedomPrivilege> sysPopedomPrivileges = 
				sysPopedomPrivilegeDao.findSysPopedomsByRoleId(whereHql,ParamList);
		//调用dao层将查询到的数据删除这样就可以重复添加
		sysPopedomPrivilegeDao.deleteCollection(sysPopedomPrivileges);
		//保存roleId 模块名称  操作名称到数据库中
		if(StringUtils.isNotBlank(roleId) && popedomModules != null && popedomModules.length > 0){
			for(int i=0;i<popedomModules.length;i++){
				String []popedomModulesArray = popedomModules[i].split(",");
				//创建权限组表的po对象
				SysPopedomPrivilege sysPopedomPrivilege = new SysPopedomPrivilege();
				//创建联合主键的po对象
				SysPopedomPrivilegeId sysPopedomPrivilegeId = new SysPopedomPrivilegeId();
				//联合主键的po对象保存数据
				sysPopedomPrivilegeId.setRoleId(roleId);
				sysPopedomPrivilegeId.setPopedom_Module(popedomModulesArray[0]);
				sysPopedomPrivilegeId.setPopedom_Privilege(popedomModulesArray[1]);
				//设置联合主键id
				sysPopedomPrivilege.setId(sysPopedomPrivilegeId);
				//调用dao层保存对象
				sysPopedomPrivilegeDao.save(sysPopedomPrivilege);
			}
			
		}
	}
	/**
	 * 进行回显 首先进行查出该roleId对应的功能
	 * 调用操作功能表的业务层
	 */
	public List<SysPopedomPrivilege> findSysPopedomPrivilegesByRoleId(String id) {
		//封装查询的语句
		String whereHql = "";
		//封装查询语句的条件的数据
		List paramList = new ArrayList();
		if(StringUtils.isNotBlank(id)){
			//System.out.println("回显需要的id" + id);
			whereHql = whereHql + " and o.id.roleId = ? ";
			paramList.add(id);
		}
		//排序
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put(" order by o.sort ", " asc ");
		return sysPopedomPrivilegeDao.findSysPopedomPrivilegesByRoleId(whereHql,paramList);
	}
	/**
	 * 获取操作权限表中所有的数据
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SysPopedomPrivilege> findAllSysPopedomPrivileges(String roleId) {
		//封装查询的条件
		String whereHql = "";
		//封装查询条件的数据
		List paramList = new ArrayList();
		if(StringUtils.isNotBlank(roleId)){
			whereHql = whereHql + " and o.id.roleId = ? ";
			paramList.add(roleId.trim());
		}
		//排序
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put(" order by o.id.roleId ", " asc ");
		return sysPopedomPrivilegeDao.findObjectsByConditionWithNoPage(whereHql, paramList, orderby);
	}

}
