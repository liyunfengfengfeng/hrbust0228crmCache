package cn.itcast.crm.web.action;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.bean.ProvinceBean;
import cn.itcast.crm.annotation.Limit;
import cn.itcast.crm.container.ServiceProvinder;
import cn.itcast.crm.domain.Province;
import cn.itcast.crm.service.IProvinceService;
import cn.itcast.crm.web.form.ProvinceForm;

/**
 * 处理省份的action
 * @author LIYUNFENG
 *
 */
@SuppressWarnings("serial")
public class SysProvinceAction extends BaseAction implements ModelDriven<ProvinceForm>{
	ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
	//获取省份的form类
	ProvinceForm provinceForm = new ProvinceForm();
	//获取省份的业务层
	IProvinceService provinceService = 
			(IProvinceService)ctx.getBean(IProvinceService.SERVICE_NAME);
	
	/**
	 * 跳转到省份的list.jsp
	 * 页面
	 * @return
	 */
	@SuppressWarnings("unused")
	@Limit(module="province",privilege="list")
	public String list(){
		//获取省份的javaBean
		ProvinceBean provinceBean = new ProvinceBean();
		provinceBean.setName(request.getParameter("name"));
		System.out.println("provinceBean.getName()   " + provinceBean.getName());
		//调用省份业务层查询所有的省份
		List<Province> provinces = provinceService.findAllProvinces(provinceBean);
		System.out.println("provinces.size()    :" + provinces.size());
		//放置省份信息到request作用域中
		request.setAttribute("provinces", provinces);
		return "list";
	}
	/**
	 * 
	 * @return
	 */
	public String add(){
		return "add";
	}
	/**
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 * 
	 */
	public String save() throws IllegalAccessException, InvocationTargetException{
		System.out.println("保存所有的省份");
		//创建省份的po对象
		Province province = new Province();
		//从vo拷贝到po
		BeanUtils.copyProperties(province, provinceForm);
		//System.out.println("province.getName()    :" + province.getName());
		//System.out.println("province.getPycode()   :" + province.getPycode());
		//String operation = request.getParameter("window");
		//System.out.println("operation   is   :" + operation);
		//调用省份的业务层进行保存
		provinceService.saveProvince(province);
		return "add";
	}
	/**
	 * 跳转到省份的编辑页面
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	public String edit() throws IllegalAccessException, InvocationTargetException{
		//获取要编辑的省份id
		String id = request.getParameter("id");
		
		//System.out.println("要编辑的省份id   " + id);
		//通过id查找到当前的省份
		Province province = provinceService.findProvinceById(id);
		request.setAttribute("province", province);
		//从po对象拷贝到vo对象
		BeanUtils.copyProperties(provinceForm, province);
		return "edit";
	}
	/**
	 * 更新城市信息
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	public String update() throws IllegalAccessException, InvocationTargetException{
		//创建省份的po对象
		ProvinceBean provinceBean = new ProvinceBean();
		//或取要编辑的省份的id
		String id = request.getParameter("id");
		//System.out.println("或取要编辑的省份的id" + id);
		BeanUtils.copyProperties(provinceBean, provinceForm);
//		System.out.println("provinceBean.getName()    :" + provinceBean.getName());
//		System.out.println("provinceBean.getPycode()   :" + provinceBean.getPycode());
		//调用业务层进行更新
		provinceService.updateProvince(provinceBean,id);
		return "edit";
	}
	/**
	 * 省份页面的信息刷新
	 */
	public String refresh(){
		return "listAction";
	}
//	/**
//	 * 按照省份名称进行查找
//	 */
//	public String search(){
//		System.out.println("按照省份名称进行查找");
//		//获取查询的条件 省份名称
//		String provinceName = (String)request.getParameter("name");
//		//System.out.println("获取查询的条件 省份名称"  + provinceName);
//		//调用业务层进行查询
//		List<Province> provinces = provinceService.findProvinceByName(provinceName);
//		return "search";
//	}
	/**
	 * 删除省份的信息
	 */
	public String delete(){
		System.out.println("进行删除省份的操作");
		//获取要删除省份的id
		String []ids = (String[])request.getParameterValues("ids");
//		for(String id : ids){
//			System.out.println("输出要删除的省份id   :" + id);
//		}
		//调用省份的业务层进行删除
		provinceService.deleteProvinces(ids);
		return "listAction";
	}
	/**
	 * 模型驱动需要实现的方法
	 */
	public ProvinceForm getModel() {
		return provinceForm;
	}
}
