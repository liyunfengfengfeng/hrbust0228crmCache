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

import cn.itcast.bean.SysRoleSearch;
import cn.itcast.crm.dao.ISysRoleDao;
import cn.itcast.crm.domain.SysRole;
import cn.itcast.crm.service.ISysRoleService;
/**
 * 权限组表的业务层
 * @author LIYUNFENG
 *
 */
@Service(ISysRoleService.SERVICE_NAME)
@Transactional(readOnly=true)
public class SysRoleServiceImpl implements ISysRoleService {
	//获取权限组表的dao层
	@Resource(name = ISysRoleDao.SERVICE_NAME)
	ISysRoleDao sysRoleDao;
	/**
	 * 权限组表的查询
	 * @param sysRoleSearch 通过该javaBean传递过来的对象
	 * @return
	 */
	public List<SysRole> findSysRoleByConditionWithNoPage(
			SysRoleSearch sysRoleSearch) {
		//封装查询的条件
		String wherHql = "";
		//封装查询条件的数据
		List paramList = new ArrayList();
		if(sysRoleSearch!=null){
			if(StringUtils.isNotBlank(sysRoleSearch.getName())){
				wherHql = wherHql + " and o.name like ? ";
				paramList.add("%" + sysRoleSearch.getName() + "%");
			}
		}
		//对权限组表中查询出来的数据进行排序
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put(" order by o.id ", " desc ");
		return sysRoleDao.findObjectsByConditionWithNoPage(wherHql, paramList, orderby);
	}
	/**
	 * 权限组表的信息的保存
	 * @param sysRole
	 */
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
	public void save(SysRole sysRole) {
		sysRoleDao.save(sysRole);
		
	}
	/**
	 * 调用业务层的方法删除权限组的数据
	 * @param ids
	 */
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
	public void deleteSysRoleByIds(String[] ids) {
		//这里的string数组可以向上转型为Serilable[]的
		sysRoleDao.deleteObjectsByIds(ids);
		
	}
	/**
	 * 通过id查找到要编辑的权限组页面
	 * 用于进行回显
	 * @param id
	 * @return
	 */
	public SysRole findSysRoleById(String id) {
		
		return sysRoleDao.find(id);
	}
	/**
	 * 更新编辑页面里面的信息
	 * @param sysRole
	 */
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
	public void update(SysRole sysRole) {
		sysRoleDao.update(sysRole);
		
	}
	/**
	 * 用于查询所有的权限组信息在系统用户表的页面下的add.jsp进行迭代
	 * @return
	 */
	public List<SysRole> findSysRoleByConditionWithNoPage() {
		//无条件查询
		//排序
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put(" order by o.id ", "  desc ");
		return sysRoleDao.findObjectsByConditionWithNoPage(null, null,orderby);
	}

}
