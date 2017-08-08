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

import cn.itcast.bean.ProvinceBean;
import cn.itcast.crm.dao.IProvinceDao;
import cn.itcast.crm.domain.Province;
import cn.itcast.crm.service.IProvinceService;
import cn.itcast.crm.util.DataType;


/**
 * 创建省份表的业务层
 * @author LIYUNFENG
 *
 */
@Service(IProvinceService.SERVICE_NAME)
@Transactional(readOnly=true)
public class ProvinceServiceImpl implements IProvinceService {
	
	//获取省份的dao层
	@Resource(name=IProvinceDao.SERVICE_NAME)
	IProvinceDao provinceDao;
	/**
	 * 查找所有的省份
	 * @return
	 */
	public List<Province> findAllProvinces() {
		
		return provinceDao.findObjectsByConditionWithNoPage();
	}
	/**
	 * 保存省份信息
	 * @param province
	 */
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
	public void saveProvince(Province province) {
		provinceDao.save(province);
		
	}
	/**
	 * 通过id查找到当前省份
	 * @param id
	 * @return
	 */
	public Province findProvinceById(String id) {
		//封装查询的条件
		String whereHql = "";
		//封装查询条件的数据
		List paramList = new ArrayList();
		if(StringUtils.isNotBlank(id)){
			whereHql = whereHql + " and o.id = ? ";
			paramList.add(Integer.parseInt(id));
		}
		List<Province> provinces = provinceDao.findObjectsByConditionWithNoPage(whereHql, paramList);
		if(provinces != null && provinces.size() > 0){
			return provinces.get(0);
		}
		return null;
	}
	/**
	 * 修改省份信息
	 * @param provinceBean
	 * @param id
	 */
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
	public void updateProvince(ProvinceBean provinceBean, String id) {
		//通过 id查找到当前的省份
		Province province = provinceDao.find(Integer.parseInt(id));
		//设置省的名称
		province.setName(provinceBean.getName());
		//设置省得拼音码
		province.setPycode(provinceBean.getPycode());
		//更新省份
		provinceDao.update(province);
	}
	/**
	 * 通过省份名称查找所有的省份
	 * @param provinceBean
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Province> findAllProvinces(ProvinceBean provinceBean) {
		//封装查询的条件
		String whereHql = "";
		//封装查询条件的数据
		List paramList = new ArrayList();
		if(provinceBean != null){
			if(StringUtils.isNotBlank(provinceBean.getName())){
				System.out.println("provinceBean.getName()        :" + provinceBean.getName());
				whereHql = whereHql + " and o.name like ? ";
				paramList.add("%" + provinceBean.getName() + "%");
			}else{
				System.out.println("provinceBean.getName() == null");
				return provinceDao.findObjectsByConditionWithNoPage();
			}
			
		}else{
			System.out.println("provinceBean == null");
		}
		//排序
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put(" order by o.id ", " asc ");
		return provinceDao.findObjectsByConditionWithNoPage(whereHql, paramList, orderby);
	}
	/**
	 * 通过id数组批量删除省份信息
	 * @param ids
	 */
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
	public void deleteProvinces(String[] ids) {
		Integer []id = DataType.converterStringArray2IntegerArray(ids);
		provinceDao.deleteObjectsByIds(id);
	}
	/**
	 * 通过省份名称查询省份
	 * @param provinceName
	 * @return
	 */
	public List<Province> findProvinceByName(String provinceName) {
		//封装查询的条件
		String whereHql = "";
		//封装查询条件的数据
		List paramList = new ArrayList();
		if(StringUtils.isNotBlank(provinceName)){
			whereHql = whereHql + " and o.name like ? ";
			paramList.add("%" + provinceName.trim() + "%");
		}
		//排序
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put(" order by o.id ", " asc ");
		return provinceDao.findObjectsByConditionWithNoPage(whereHql, paramList, orderby);
	}

	

}
