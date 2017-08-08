package cn.itcast.crm.dao;

import cn.itcast.crm.domain.Company;
/**
 * 顾客类的dao层
 * 因为这里的顾客是一个公司或一个企业
 * @author LIYUNFENG
 *
 */
public interface ICompanyDao extends ICommonDao<Company> {
	public static final String SERVICE_NAME = "cn.itcast.crm.dao.impl.CompanyDaoImpl";
}
