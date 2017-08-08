package cn.itcast.crm.dao.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import cn.itcast.crm.dao.ISysDictionaryTypeDao;
import cn.itcast.crm.domain.SysDictionaryType;
/**
 * 数据字典表的dao层
 * 该表存储下拉列表需要的数据
 * @author LIYUNFENG
 *
 */
@Repository(ISysDictionaryTypeDao.SERVICE_NAME)
public class SysDictionaryTypeDaoImpl extends CommonDaoImpl<SysDictionaryType> implements
		ISysDictionaryTypeDao {

	

}
