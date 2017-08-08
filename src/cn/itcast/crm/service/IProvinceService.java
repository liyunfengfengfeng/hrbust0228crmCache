package cn.itcast.crm.service;

import java.util.List;

import cn.itcast.bean.ProvinceBean;
import cn.itcast.crm.domain.Province;

/**
 * 创建省份表的业务层
 * @author LIYUNFENG
 *
 */
public interface IProvinceService {
	public static final String SERVICE_NAME = "cn.itcast.crm.service.impl.ProvinceServiceImpl";
	/**
	 * 查找所有的省份
	 * @return
	 */
	public List<Province> findAllProvinces();
	/**
	 * 保存省份信息
	 * @param province
	 */
	public void saveProvince(Province province);
	/**
	 * 通过id查找到当前省份
	 * @param id
	 * @return
	 */
	public Province findProvinceById(String id);
	/**
	 * 修改省份信息
	 * @param provinceBean
	 * @param id
	 */
	public void updateProvince(ProvinceBean provinceBean, String id);
	/**
	 * 通过省份名称查找所有的省份
	 * @param provinceBean
	 * @return
	 */
	public List<Province> findAllProvinces(ProvinceBean provinceBean);
	/**
	 * 通过id数组批量删除省份信息
	 * @param ids
	 */
	public void deleteProvinces(String[] ids);
	/**
	 * 通过省份名称查询省份
	 * @param provinceName
	 * @return
	 */
	public List<Province> findProvinceByName(String provinceName);
}
