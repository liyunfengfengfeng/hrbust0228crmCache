package cn.itcast.crm.service;

import java.sql.Date;
import java.util.List;

import cn.itcast.bean.CompanySearch;
import cn.itcast.crm.domain.Company;
import cn.itcast.crm.domain.SysUser;

/**
 * 客户类的业务层
 * @author LIYUNFENG
 *
 */
public interface ICompanyService {
	public static final String SERVICE_NAME = "cn.itcast.crm.service.impl.CompanyServiceImpl";
	/**
	 * 按照条件查找
	 * 所有的客户信息
	 * @param companySearch
	 * @return
	 */
	public List<Company> findAllCompanyInformation(CompanySearch companySearch,SysUser sysUser);
	/**
	 * 保存客户的信息
	 * @param company
	 */
	public void save(Company company);
	/**
	 * 批量删除用户信息
	 * @param ids
	 */
	public void deleteCompanys(String[] ids);
	/**
	 * 通过id查找到当前要编辑的客户
	 * @param id
	 * @return
	 */
	public List<Company> findCompanyById(Integer id);
	/**
	 * 调用业务层保存客户信息
	 * @param company
	 */
	public void updateCompany(Company company);
	//更新下次练习时间
	public void updateCompany(String[] id, Date nextTouchData);
	/**
	 * 设置客户的共享信息
	 * @param id   要共享的客户id
	 * @param uid  接受共享的用户
	 */
	public void setShareInfor(String id, String[] uid);
}
