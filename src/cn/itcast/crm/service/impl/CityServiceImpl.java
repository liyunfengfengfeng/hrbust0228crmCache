package cn.itcast.crm.service.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.xwork.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.crm.dao.ICityDao;
import cn.itcast.crm.domain.City;
import cn.itcast.crm.service.ICityService;
import cn.itcast.crm.util.DataType;
/**
 * 创建城市表的业务层
 * @author LIYUNFENG
 *
 */
@Service(ICityService.SERVICE_NAME)
@Transactional(readOnly=true)
public class CityServiceImpl implements ICityService {
	
	//获取城市的dao层
	@Resource(name=ICityDao.SERVICE_NAME)
	ICityDao cityDao;
	/**
	 * 通过省得id获取旗下所有的城市
	 * @param provinceId
	 * @return
	 */
	public List<City> findAllCityInThisProvince(String provinceId) {
		//封装查询的条件
		String whereHql = "";
		//封装查询条件的数据
		List paramList = new ArrayList();
		if(StringUtils.isNotBlank(provinceId)){
			whereHql = whereHql + " and o.pid = ? ";
			paramList.add(Integer.parseInt(provinceId));
		}
		//排序
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put(" order by o.id ", " asc ");
		return cityDao.findObjectsByConditionWithNoPage(whereHql, paramList, orderby);
	}
	/**
	 * 查询所有的城市
	 * @return
	 */
	public List<City> findAllCityWithCondition() {
		
		return cityDao.findObjectsByConditionWithNoPage();
	}
	/**
	 * 通过查询该省份id 下的所有城市
	 * @param pid
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<City> findAllCityWithCondition(String pid) {
		//封装查询的条件
		String whereHql  = "";
		//封装查询条件的数据
		List paramList = new ArrayList();
		if(StringUtils.isNotBlank(pid)){
			Integer province_id = Integer.parseInt(pid);
			whereHql  = whereHql + " and o.pid = ? ";
			paramList.add(province_id);
			
		}
		//排序
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put(" order by o.id ", " asc ");
		return cityDao.findObjectsByConditionWithNoPage(whereHql, paramList, orderby);
	}
	/**
	 * 添加城市信息
	 * @param city
	 */
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
	public void saveCity(City city) {
		// 添加城市信息
		cityDao.save(city);
	}
	/**
	 * 批量删除城市信息
	 * @param ids
	 */
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
	public void deleteCity(String[] ids) {
		// 删除城市信息
		Integer []id = DataType.converterStringArray2IntegerArray(ids);
		cityDao.deleteObjectsByIds(id);
	}
	/**
	 * 通过id查找到当前的城市
	 * @param parseInt
	 * @return
	 */
	public City findCityById(int id) {
		
		return cityDao.find(id);
	}
	/**
	 * 更新城市信息
	 * @param city
	 */
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
	public void updateCity(City city) {
		cityDao.update(city);
		
	}

}
