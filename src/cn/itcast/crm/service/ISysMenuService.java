package cn.itcast.crm.service;

import java.util.List;

import cn.itcast.crm.domain.SysMenu;

/**
 * sys_menu的业务层
 * 该表存储系统的所有菜单
 * @author LIYUNFENG
 *
 */
public interface ISysMenuService {
	public static final String SERVICE_NAME =
			"cn.itcast.crm.service.impl.SysMenuServiceImpl";
	/**
	 * 调用系统的业务层查询所有的菜单
	 * 在前台页面进行迭代输出
	 * @return
	 */
	public List<SysMenu> findAllSysMenus();
}
