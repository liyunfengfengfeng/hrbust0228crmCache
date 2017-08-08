package cn.itcast.crm.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.xwork.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.crm.container.ServiceProvinder;
import cn.itcast.crm.dao.ISysMenuPrivilegeDao;
import cn.itcast.crm.domain.SysMenu;
import cn.itcast.crm.domain.SysMenuId;
import cn.itcast.crm.domain.SysMenuPrivilege;
import cn.itcast.crm.domain.SysMenuPrivilegeId;
import cn.itcast.crm.service.ISysMenuPrivilegeService;
/**
 * 建立菜单权限表的业务层
 * 将用户选择好的菜单放置到菜单权限表中
 * 每一个权限组roleId对应着许多的菜单权限
 * 每一个用户对应一个权限组roleId
 * @author LIYUNFENG
 *
 */
@Service(ISysMenuPrivilegeService.SERVICE_NAME)
@Transactional(readOnly=true)
public class SysMenuPrivilegeServiceImpl implements ISysMenuPrivilegeService {
	//获取菜单权限组的dao层
	@Resource(name=ISysMenuPrivilegeDao.SERVICE_NAME)
	ISysMenuPrivilegeDao sysMenuPrivilegeDao;
	/**
	 * 调用业务层将菜单保存在菜单权限表中
	 * @param roleId
	 * @param menuModule
	 */
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
	public void saveMenu2SysMenuPrivilege(String roleId, String[] menuModule) {
		//封装查询的条件
		String whereHql = "";
		//封装查询条件的数据
		List paramList = new ArrayList();
		//再进行保存时先通过roleId进行删除因为重复保存联合主键会报错
		if(StringUtils.isNotBlank(roleId)){
			
			whereHql = whereHql + " and o.id.roleId = ? ";
			paramList.add(roleId.trim());
			
			List<SysMenuPrivilege> sysMenuPrivileges = 
					sysMenuPrivilegeDao.findObjectsByConditionWithNoPage(whereHql, paramList);
			//调用业务层进行删除
			sysMenuPrivilegeDao.deleteCollection(sysMenuPrivileges);
		}
		
		
		
		
		
		if(StringUtils.isNotBlank(roleId) && menuModule!=null && menuModule.length>0){
			for(int i= 0;i<menuModule.length;i++){
				String []menuModuleArray = menuModule[i].split(",");
				//创建菜单权限组联合主键的po对象
				SysMenuPrivilegeId sysMenuPrivilegeId = new SysMenuPrivilegeId();
				//创建菜单权限表的po对象
				SysMenuPrivilege sysMenuPrivilege = new SysMenuPrivilege();
				sysMenuPrivilegeId.setRoleId(roleId);
				sysMenuPrivilegeId.setMenuModule(menuModuleArray[0]);
				sysMenuPrivilegeId.setMenuPrivilege(menuModuleArray[1]);
				sysMenuPrivilege.setId(sysMenuPrivilegeId);
				//调用菜单权限组表的业务层进行保存
				sysMenuPrivilegeDao.save(sysMenuPrivilege);
			}
			
		}
	}
	/**
	 * 通过roleId查询该roleId权限组具有的权限
	 * 在菜单权限表中具有的权限
	 * 与查询到的所有菜单进行校对
	 * 进行回显设置
	 * @param roleId
	 * @return
	 */
	public List<SysMenuPrivilege> findAllSysMenuPrivileges(String roleId) {
		//封装查询的条件
		String whereHql = "";
		//封装查询条件的数据
		List paramList = new ArrayList();
		if(StringUtils.isNotBlank(roleId)){
			whereHql = whereHql + " and o.id.roleId = ? ";
			paramList.add(roleId.trim());
		}
		//调用菜单权限表查询所有的roleId对应的数据
		return sysMenuPrivilegeDao.findObjectsByConditionWithNoPage(whereHql, paramList);
	}
	/**
	 * 在业务层中查询出所有的菜单权限表中的数据
	 * @return
	 */
	public List<SysMenuPrivilege> findAllSysMenuPrivileges() {
		
		return sysMenuPrivilegeDao.findObjectsByConditionWithNoPage();
	}

}
