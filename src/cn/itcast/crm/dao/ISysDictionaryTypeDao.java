package cn.itcast.crm.dao;

import cn.itcast.crm.domain.SysDictionaryType;
/**
 * 数据字典表的dao层
 * 该表存储下拉列表需要的数据
 * @author LIYUNFENG
 *
 */

public interface ISysDictionaryTypeDao extends ICommonDao<SysDictionaryType> {
	public static final String SERVICE_NAME = "cn.itcast.crm.dao.impl.SysDictionaryTypeDaoImpl";
}
