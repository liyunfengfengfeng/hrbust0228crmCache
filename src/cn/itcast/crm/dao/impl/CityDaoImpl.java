package cn.itcast.crm.dao.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import cn.itcast.crm.dao.ICityDao;
import cn.itcast.crm.domain.City;
/**
 * 城市city表的dao层
 * @author LIYUNFENG
 *
 */
@Repository(ICityDao.SERVICE_NAME)
public class CityDaoImpl extends CommonDaoImpl<City> implements ICityDao {

	
}
