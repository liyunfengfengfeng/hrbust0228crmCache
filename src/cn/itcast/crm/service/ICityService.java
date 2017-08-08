package cn.itcast.crm.service;

import java.util.List;

import cn.itcast.crm.domain.City;

/**
 * 创建城市表的业务层
 * @author LIYUNFENG
 *
 */
public interface ICityService {
	public static final String SERVICE_NAME="cn.itcast.crm.service.impl.CityServiceImpl";
	/**
	 * 通过省得id获取旗下所有的城市
	 * @param provinceId
	 * @return
	 */
	public List<City> findAllCityInThisProvince(String provinceId);
	/**
	 * 查询所有的城市
	 * @return
	 */
	public List<City> findAllCityWithCondition();
	/**
	 * 通过查询该省份id 下的所有城市
	 * @param pid
	 * @return
	 */
	public List<City> findAllCityWithCondition(String pid);
	/**
	 * 添加城市信息
	 * @param city
	 */
	public void saveCity(City city);
	/**
	 * 批量删除城市信息
	 * @param ids
	 */
	public void deleteCity(String[] ids);
	/**
	 * 通过id查找到当前的城市
	 * @param parseInt
	 * @return
	 */
	public City findCityById(int id);
	/**
	 * 更新城市信息
	 * @param city
	 */
	public void updateCity(City city);
}
