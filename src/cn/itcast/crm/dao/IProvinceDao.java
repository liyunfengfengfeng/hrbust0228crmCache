package cn.itcast.crm.dao;

import cn.itcast.crm.domain.Province;
/**
 * 省份表的dao层
 * @author LIYUNFENG
 *
 */
public interface IProvinceDao extends ICommonDao<Province> {
	public static final String SERVICE_NAME = "cn.itcast.crm.dao.impl.ProvinceDaoImpl";
}
