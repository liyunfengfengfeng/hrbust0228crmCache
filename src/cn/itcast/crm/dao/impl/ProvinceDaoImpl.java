package cn.itcast.crm.dao.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import cn.itcast.crm.dao.IProvinceDao;
import cn.itcast.crm.domain.Province;
/**
 * 省份表的dao层
 * @author LIYUNFENG
 *
 */
@Repository(IProvinceDao.SERVICE_NAME)
public class ProvinceDaoImpl extends CommonDaoImpl<Province> implements IProvinceDao {

	

}
