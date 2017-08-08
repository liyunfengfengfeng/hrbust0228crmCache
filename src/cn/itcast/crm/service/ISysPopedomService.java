package cn.itcast.crm.service;

import java.util.List;

import cn.itcast.crm.domain.SysPopedom;

/**
 * 操作表的业务层
 * 包含对该系统所有的操作
 * 可以进行细粒度的权限控制
 * @author LIYUNFENG
 *
 */
public interface ISysPopedomService {
	public static final String SERVICE_NAME = 
			"cn.itcast.crm.service.impl.SysPopedomServiceImpl";
	/**
	 * 查询系统所具有的所有功能
	 * @return
	 */
	public List<SysPopedom> findAllPopedom();
}
