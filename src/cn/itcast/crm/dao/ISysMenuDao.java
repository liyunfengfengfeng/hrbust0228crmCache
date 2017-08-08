package cn.itcast.crm.dao;

import java.util.LinkedHashMap;
import java.util.List;

import cn.itcast.crm.domain.SysMenu;
/**
 * 菜单表的dao层
 * @author LIYUNFENG
 *
 */
public interface ISysMenuDao extends ICommonDao<SysMenu> {
	public static final String SERVICE_NAME = 
			"cn.itcast.crm.dao.impl.SysMenuDaoImpl";
	
}
