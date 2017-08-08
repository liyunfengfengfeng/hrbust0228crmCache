package cn.itcast.crm.service.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.xwork.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.bean.CompanySearch;
import cn.itcast.crm.dao.ICompanyDao;
import cn.itcast.crm.domain.Company;
import cn.itcast.crm.domain.SysUser;
import cn.itcast.crm.service.ICompanyService;
import cn.itcast.crm.util.DataType;
/**
 * 客户类的业务层
 * @author LIYUNFENG
 *
 */
@Service(ICompanyService.SERVICE_NAME)
@Transactional(readOnly=true)
public class CompanyServiceImpl implements ICompanyService {
	
	//获取客户的dao层
	@Resource(name=ICompanyDao.SERVICE_NAME)
	ICompanyDao companyDao;
	
	
	/**
	 * 按照条件查找
	 * 所有的客户信息
	 * @param companySearch
	 * @return
	 */
	public List<Company> findAllCompanyInformation(CompanySearch companySearch,SysUser sysUser) {
		//封装查询的条件
		String whereHql = "";
		//封装查询的条件的数据
		List paramList = new ArrayList();
		if(companySearch!=null){
			//客户编码code
			if(StringUtils.isNotBlank(companySearch.getCode())){
				whereHql = whereHql + " and o.code like ? ";
				paramList.add("%"+companySearch.getCode().trim()+"%");
			}
			//客户名称name
			if(StringUtils.isNotBlank(companySearch.getName())){
				whereHql = whereHql + " and o.name like ? ";
				paramList.add("%"+companySearch.getName().trim()+"%");
			}
			//客户拼音码pycode
			if(StringUtils.isNotBlank(companySearch.getPycode())){
				whereHql = whereHql + " and o.pycode like ? ";
				paramList.add("%"+companySearch.getPycode().trim()+"%");
			}
			//电话一tel1
			if(StringUtils.isNotBlank(companySearch.getTel1())){
				whereHql = whereHql + " and o.tel1 like ? ";
				paramList.add("%"+companySearch.getTel1().trim()+"%");
			}
			//客户等级grade   通过id查询  保存时也是保存该客户等级的id
			if(StringUtils.isNotBlank(companySearch.getGrade())){
				whereHql = whereHql + " and o.grade = ? ";
				paramList.add(companySearch.getGrade().trim());
			}
			//客户来源source   通过id查询  保存时也是保存该客户来源的id
			if(StringUtils.isNotBlank(companySearch.getSource())){
				whereHql = whereHql + " and o.source = ? ";
				paramList.add(companySearch.getSource().trim());
			}
			//客户性质quality   通过id查询  保存时也是保存该客户性质的id
			if(StringUtils.isNotBlank(companySearch.getQuality())){
				whereHql = whereHql + " and o.quality = ? ";
				paramList.add(companySearch.getQuality().trim());
			}
		}
		whereHql = whereHql + " or o.shareFlag = ? and o.shareIds like ? ";
		paramList.add("Y");
		paramList.add("%#"+ sysUser.getId() +"#%");
		//排序
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put(" order by o.id ", " asc ");
		//调用客户dao层进行排序
		
		return companyDao.findObjectsByConditionWithNoPage(whereHql, paramList, orderby);
	}

	/**
	 * 保存客户的信息
	 * @param company
	 */
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
	public void save(Company company) {
		
		companyDao.save(company);
	}
	/**
	 * 批量删除用户信息
	 * @param ids
	 */
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
	public void deleteCompanys(String[] ids) {
		Integer[]id = DataType.converterStringArray2IntegerArray(ids);
		companyDao.deleteObjectsByIds(id);
	}
	/**
	 * 通过id查找到当前要编辑的客户
	 * @param id
	 * @return
	 */
	public List<Company> findCompanyById(Integer id) {
		//封装查询的条件
		String whereHql = "";
		//封装查询条件的数据
		List paramList = new ArrayList();
		if(StringUtils.isNotBlank(id.toString())){
			whereHql = whereHql + " and o.id = ? ";
			paramList.add(id);
		}
		//调用dao层进行查找
		return companyDao.findObjectsByConditionWithNoPage(whereHql, paramList);
	}
	/**
	 * 调用业务层保存客户信息
	 * @param company
	 */
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
	public void updateCompany(Company company) {
		
		companyDao.update(company);
	}
	
	/**
	 * 更新下次联系时间
	 */
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
	public void updateCompany(String[] id, Date nextTouchData) {
		
		for(int i=0;i<id.length;i++){
			Company company = companyDao.find(Integer.parseInt(id[i]));
			company.setNextTouchDate(nextTouchData);
			companyDao.update(company);
		}
		
		
	}
	/**
	 * 设置客户的共享信息
	 * @param id   要共享的客户id
	 * @param uid  接受共享的用户
	 */
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
	public void setShareInfor(String id, String[] uid) {
		//通过id查找到当前用户
		Company company = companyDao.find(Integer.parseInt(id));
		StringBuffer bf = new StringBuffer("#");
		if(uid!=null && uid.length > 0){
			company.setShareFlag("Y");
			for(int i=0;i<uid.length;i++){
				bf.append(uid[i]+"#");
			}
		}
		company.setShareIds(bf.toString());
		//调用到层进行更新
		companyDao.update(company);
	}

}
