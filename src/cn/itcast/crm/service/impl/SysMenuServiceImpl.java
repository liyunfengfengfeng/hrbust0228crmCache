package cn.itcast.crm.service.impl;

import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.crm.dao.ISysMenuDao;
import cn.itcast.crm.domain.SysMenu;
import cn.itcast.crm.service.ISysMenuService;
/**
 * sys_menu的业务层
 * 该表存储系统的所有菜单
 * @author LIYUNFENG
 *
 */
@Service(ISysMenuService.SERVICE_NAME)
@Transactional(readOnly = true)
public class SysMenuServiceImpl implements ISysMenuService {
	//获取菜单的dao层
	@Resource(name=ISysMenuDao.SERVICE_NAME)
	ISysMenuDao sysMenuDao;
	/**
	 * 调用系统的业务层查询所有的菜单
	 * 在前台页面进行迭代输出
	 * @return
	 */
	public List<SysMenu> findAllSysMenus() {
		//增加排序
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put(" order by o.sort ", " asc ");
		return sysMenuDao.findObjectsByConditionWithNoPage(orderby);
	}
	
}
