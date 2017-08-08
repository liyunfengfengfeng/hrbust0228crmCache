package cn.itcast.crm.web.action;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.crm.container.ServiceProvinder;
import cn.itcast.crm.domain.City;
import cn.itcast.crm.domain.Province;
import cn.itcast.crm.service.ICityService;
import cn.itcast.crm.service.IProvinceService;
import cn.itcast.crm.web.form.CityForm;

/**
 * city表的action类
 * @author LIYUNFENG
 *
 */
@SuppressWarnings("serial")
public class CityAction extends BaseAction implements ModelDriven<CityForm>{
	ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
	//获取城市form
	CityForm cityForm = new CityForm();
	//获取省份的业务层
	IProvinceService provinceService = 
			(IProvinceService)ctx.getBean(IProvinceService.SERVICE_NAME);
	//获取城市的业务层
	ICityService cityService = 
			(ICityService)ctx.getBean(ICityService.SERVICE_NAME);
	/**
	 * 跳转到城市下的list.jsp
	 * @return
	 */
	public String list(){
		//查询所有的省份
		List<Province> provinces = provinceService.findAllProvinces();
		//测试查询到的省份
//		for(Province province : provinces){
//			System.out.println("province.getName()    :" + province.getName());
//		}
		request.setAttribute("provinces", provinces);
		
		//查询用户输入的省份条件 即省份的id
		String pid = request.getParameter("pid");
		System.out.println("您要查询的省份id 是 :" + pid);
		//第一次进来时是查询所有的城市
		List<City> citys = cityService.findAllCityWithCondition(pid);
		//测试查询到的城市
//		for(City city : citys){
//			System.out.println("city.getName()    :" + city.getName());
//		}
		request.setAttribute("citys", citys);
		return "list";
	}
	/**
	 * 新建城市页面
	 */
	public String add(){
		String pid = request.getParameter("pid");
		System.out.println("要添加的城市所属的省份id" + pid);
		//创建城市的po对象
		City city = new City();
		city.setPid(Integer.parseInt(pid));
		//将城市信息存储到request作用域中
		request.setAttribute("city", city);
		return "add";
	}
	/**
	 * 添加城市信息
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	public String update() throws IllegalAccessException, InvocationTargetException{
		//创建城市的po类
		City city = new City();
		//从vo拷贝到po
		BeanUtils.copyProperties(city, cityForm);
		//处理省份id
		city.setPid(Integer.parseInt(cityForm.getPid()));
//		System.out.println("city.getPid()   :" + city.getPid());
//		System.out.println("city.getAreacode()   :" + city.getAreacode());
//		System.out.println("city.getName()   :" + city.getName());
//		System.out.println("city.getPostcode()   :" + city.getPostcode());
//		System.out.println("city.getPycode()   :" + city.getPycode());
		//调用业务层进行保存
		cityService.saveCity(city);
		return "listAction";
	}
	/**
	 * 删除城市信息
	 */
	public String delete(){
		System.out.println("正在删除城市信息");
		String []ids = (String[])request.getParameterValues("ids"); 
//		for(String id : ids){
//			System.out.println("要删除的id集合是         :" + id);
//		}
		//调用城市业务层进行删除
		cityService.deleteCity(ids);
		return "listAction";
	}
	/**
	 * 处理刷新
	 */
	public String refresh(){
		return "listAction";
	}
	/**
	 * 处理城市的编辑页面
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	public String edit() throws IllegalAccessException, InvocationTargetException{
		//获取要编辑的城市id
		String id = (String)request.getParameter("id");
		System.out.println("获取要编辑的城市id " + id);
		//通过id查找到当前的城市
		City city = cityService.findCityById(Integer.parseInt(id));
		//从po拷贝到vo进行回显
		BeanUtils.copyProperties(cityForm, city);
		return "edit";
	}
	/**
	 * 更新城市信息
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	public String updateCity() throws IllegalAccessException, InvocationTargetException{
		//获取要更新的城市id
		String id = request.getParameter("id");
		//System.out.println("id    :" + id);
		//通过城市id查找到当前要更新的城市
		City city = cityService.findCityById(Integer.parseInt(id));
		//从vo拷贝到po
		BeanUtils.copyProperties(city, cityForm);
		//处理id
		city.setId(Integer.parseInt(cityForm.getId()));
		//处理pid
		city.setPid(Integer.parseInt(cityForm.getPid()));
		//调用业务层进行更新
		cityService.updateCity(city);
		return "edit";
	}
	/**
	 * 实现模型驱动
	 */
	public CityForm getModel() {
		// TODO Auto-generated method stub
		return cityForm;
	}
}
