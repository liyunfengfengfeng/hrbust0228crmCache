package cn.itcast.crm.dao.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import cn.itcast.crm.dao.ICompanyDao;
import cn.itcast.crm.domain.Company;
/**
 * 顾客类的dao层
 * 因为这里的顾客是一个公司或一个企业
 * @author LIYUNFENG
 *
 */
@Repository(ICompanyDao.SERVICE_NAME)
public class CompanyDaoImpl extends CommonDaoImpl<Company> implements ICompanyDao {

	
}
