package cn.itcast.crm.service.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.crm.dao.ISysDictionaryTypeDao;
import cn.itcast.crm.domain.SysDictionaryType;
import cn.itcast.crm.service.ISysDictionaryTypeService;
import cn.itcast.crm.util.Global;
/**
 * 数据字典表的service层
 * 该表存储下拉列表需要的数据
 * @author LIYUNFENG
 *
 */
@Transactional(readOnly=true)
@Service(ISysDictionaryTypeService.SERVICE_NAME)
public class SysDictionaryTypeServiceImpl implements ISysDictionaryTypeService{
	
	//获取下拉表的dao层
	@Resource(name=ISysDictionaryTypeDao.SERVICE_NAME)
	ISysDictionaryTypeDao sysDictionaryTypeDao;
	/**
	 * 查询所有的客户等级
	 * @return
	 */
	public List<SysDictionaryType> findCompanyGrade() {
		//封装查询的条件
		String whereHql = "";
		//封装查询条件的数据
		List paramList = new ArrayList();
		whereHql = whereHql + " and o.code = ? ";
		paramList.add(Global.companyGrade.toString());
		//排序
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put(" order by o.sort ", " asc ");
		//调用下拉表的dao层进行查询
		return sysDictionaryTypeDao.findObjectsByConditionWithNoPage(whereHql, paramList, orderby);
	}
	/**
	 * 查询所有的客户来源
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SysDictionaryType> findCompanySource() {
		//封装查询的条件
		String whereHql = "";
		//封装查询条件的数据
		List paramList = new ArrayList();
		whereHql = whereHql + " and o.code = ? ";
		//在下拉表中客户来源code值为source
		paramList.add(Global.companySource.toString());
		//排序
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put(" order by o.sort ", " asc ");
		//调用下拉表的dao层进行查询
		return sysDictionaryTypeDao.findObjectsByConditionWithNoPage(whereHql, paramList, orderby);
	}
	/**
	 * 在下拉表中查询客户的性质
	 * @return
	 */
	public List<SysDictionaryType> findCompanyQuality() {
		//封装查询的条件
		String whereHql = "";
		//封装查询条件的数据
		List paramList = new ArrayList();
		whereHql = whereHql + " and o.code = ? ";
		//在下拉表中客户来源code值为source
		paramList.add(Global.companyQuality.toString());
		//排序
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put(" order by o.sort ", " asc ");
		//调用下拉表的dao层进行查询
		return sysDictionaryTypeDao.findObjectsByConditionWithNoPage(whereHql, paramList, orderby);
	}
	/**
	 * 在下拉表中查询区域名称
	 * @return
	 */
	public List<SysDictionaryType> findCompanyRegionNames() {
		//封装查询的条件
		String whereHql = "";
		//封装查询条件的数据
		List paramList = new ArrayList();
		whereHql = whereHql + " and o.code = ? ";
		//在下拉表中客户来源code值为source
		paramList.add(Global.companyRegionName.toString().trim());
		//排序
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put(" order by o.sort ", " asc ");
		//调用下拉表的dao层进行查询
		return sysDictionaryTypeDao.findObjectsByConditionWithNoPage(whereHql, paramList, orderby);
	}
	/**
	 * 在下拉列表中查询所属行业
	 * @return
	 */
	public List<SysDictionaryType> findCompanyTrade() {
		//封装查询的条件
		String whereHql = "";
		//封装查询条件的数据
		List paramList = new ArrayList();
		whereHql = whereHql + " and o.code = ? ";
		//在下拉表中客户来源code值为source
		paramList.add(Global.companyTrade.toString().trim());
		//排序
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put(" order by o.sort ", " asc ");
		//调用下拉表的dao层进行查询
		return sysDictionaryTypeDao.findObjectsByConditionWithNoPage(whereHql, paramList, orderby);
	}
	/**
	 * 在下拉列表中查询经营范围
	 * @return
	 */
	public List<SysDictionaryType> findCompanyScale() {
		//封装查询的条件
		String whereHql = "";
		//封装查询条件的数据
		List paramList = new ArrayList();
		whereHql = whereHql + " and o.code = ? ";
		//在下拉表中客户来源code值为source
		paramList.add(Global.companyScale.toString().trim());
		//排序
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put(" order by o.sort ", " asc ");
		//调用下拉表的dao层进行查询
		return sysDictionaryTypeDao.findObjectsByConditionWithNoPage(whereHql, paramList, orderby);
	}
	/**
	 * 在下拉表中查询所有的经营范围
	 * @return
	 */
	public List<SysDictionaryType> findAllCompanyDealins() {
		//封装查询的条件
		String whereHql = "";
		//封装查询条件的数据
		List paramList = new ArrayList();
		whereHql = whereHql + " and o.code = ? ";
		//在下拉表中客户来源code值为source
		paramList.add(Global.companyDealin.toString().trim());
		//排序
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put(" order by o.sort ", " asc ");
		//调用下拉表的dao层进行查询
		return sysDictionaryTypeDao.findObjectsByConditionWithNoPage(whereHql, paramList, orderby);
	}
	/**
	 * 在下拉表中查询所有的企业性质
	 * @return
	 */
	public List<SysDictionaryType> findAllCompanyKinds() {
		//封装查询的条件
		String whereHql = "";
		//封装查询条件的数据
		List paramList = new ArrayList();
		whereHql = whereHql + " and o.code = ? ";
		//在下拉表中客户来源code值为source
		paramList.add(Global.companyKind.toString().trim());
		//排序
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put(" order by o.sort ", " asc ");
		//调用下拉表的dao层进行查询
		return sysDictionaryTypeDao.findObjectsByConditionWithNoPage(whereHql, paramList, orderby);
	}
	/**
	 * 查询所有的流水号中缀
	 * @return
	 */
	public List<SysDictionaryType> findAllGlideBits() {
		
		//封装查询的条件
		String whereHql = "";
		//封装查询条件的数据
		List paramList = new ArrayList();
		whereHql = whereHql + " and o.code = ? ";
		//在下拉表中客户来源code值为source
		paramList.add(Global.GLIDE_BIT.toString().trim());
		//排序
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put(" order by o.sort ", " asc ");
		//调用下拉表的dao层进行查询
		return sysDictionaryTypeDao.findObjectsByConditionWithNoPage(whereHql, paramList, orderby);
	}
	/**
	 * 查询所有的日期号
	 * @return
	 */
	public List<SysDictionaryType> findAllAreaTimes() {
		//封装查询的条件
		String whereHql = "";
		//封装查询条件的数据
		List paramList = new ArrayList();
		whereHql = whereHql + " and o.code = ? ";
		//在下拉表中客户来源code值为source
		paramList.add(Global.AREA_TIME.toString().trim());
		//排序
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put(" order by o.sort ", " asc ");
		//调用下拉表的dao层进行查询
		return sysDictionaryTypeDao.findObjectsByConditionWithNoPage(whereHql, paramList, orderby);
	}
	
}
