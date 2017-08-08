package cn.itcast.crm.dao;

import cn.itcast.crm.domain.City;

public interface ICityDao extends ICommonDao<City> {
	public static final String SERVICE_NAME = "cn.itcast.crm.dao.impl.CityDaoImpl";
}
