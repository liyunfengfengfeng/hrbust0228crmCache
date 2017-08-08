package cn.itcast.crm.dao;

import java.util.List;

import cn.itcast.crm.domain.SysPopedom;
/**
 * 操作表
 * 包含对该系统所有的操作
 * 可以进行细粒度的权限控制
 * @author LIYUNFENG
 *
 */
public interface ISysPopedomDao extends ICommonDao<SysPopedom> {
	public static final String SERVICE_NAME = 
				"cn.itcast.crm.dao.impl.SysPopedomDaoImpl";
	
}
