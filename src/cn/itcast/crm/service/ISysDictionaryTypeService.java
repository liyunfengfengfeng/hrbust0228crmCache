package cn.itcast.crm.service;

import java.util.List;

import cn.itcast.crm.domain.SysDictionaryType;

/**
 * 数据字典表的service层
 * 该表存储下拉列表需要的数据
 * @author LIYUNFENG
 *
 */

public interface ISysDictionaryTypeService {
	public static final String SERVICE_NAME = "cn.itcast.crm.service.impl.SysDictionaryTypeServiceImpl";
	/**
	 * 查询所有的客户等级
	 * @return
	 */
	public List<SysDictionaryType> findCompanyGrade();
	/**
	 * 查询所有的客户来源
	 * @return
	 */
	public List<SysDictionaryType> findCompanySource();
	/**
	 * 在下拉表中查询客户的性质
	 * @return
	 */
	public List<SysDictionaryType> findCompanyQuality();
	/**
	 * 在下拉表中查询区域名称
	 * @return
	 */
	public List<SysDictionaryType> findCompanyRegionNames();
	/**
	 * 在下拉列表中查询所属行业
	 * @return
	 */
	public List<SysDictionaryType> findCompanyTrade();
	/**
	 * 在下拉列表中查询经营范围
	 * @return
	 */
	public List<SysDictionaryType> findCompanyScale();
	/**
	 * 在下拉表中查询所有的经营范围
	 * @return
	 */
	public List<SysDictionaryType> findAllCompanyDealins();
	/**
	 * 在下拉表中查询所有的企业性质
	 * @return
	 */
	public List<SysDictionaryType> findAllCompanyKinds();
	/**
	 * 查询所有的流水号中缀
	 * @return
	 */
	public List<SysDictionaryType> findAllGlideBits();
	/**
	 * 查询所有的日期号
	 * @return
	 */
	public List<SysDictionaryType> findAllAreaTimes();
}
