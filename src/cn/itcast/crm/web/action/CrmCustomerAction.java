package cn.itcast.crm.web.action;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.xwork.StringUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ModelDriven;
import com.sun.org.apache.commons.beanutils.ConvertUtils;


import cn.itcast.bean.CompanySearch;
import cn.itcast.crm.container.ServiceProvinder;
import cn.itcast.crm.domain.City;
import cn.itcast.crm.domain.Company;
import cn.itcast.crm.domain.Province;
import cn.itcast.crm.domain.SysDictionaryType;
import cn.itcast.crm.domain.SysUser;
import cn.itcast.crm.domain.SysUserGroup;
import cn.itcast.crm.service.ICityService;
import cn.itcast.crm.service.ICompanyService;
import cn.itcast.crm.service.IProvinceService;
import cn.itcast.crm.service.ISysCodeRuleService;
import cn.itcast.crm.service.ISysDictionaryTypeService;
import cn.itcast.crm.service.ISysUserGroupService;
import cn.itcast.crm.service.ISysUserService;
import cn.itcast.crm.util.PinYinUtil;
import cn.itcast.crm.util.SQLDateConvertor;
import cn.itcast.crm.util.SessionUtils;
import cn.itcast.crm.web.form.CompanyForm;

/**
 * 处理客户拜访的action
 * @author LIYUNFENG
 *
 */
@SuppressWarnings("serial")
public class CrmCustomerAction extends BaseAction implements ModelDriven<CompanyForm>{
	ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
	//创建客户表CompanyForm类的对象
	CompanyForm companyForm = new CompanyForm();
	//获取客户表的业务层
	ICompanyService companyService = 
			(ICompanyService)ctx.getBean(ICompanyService.SERVICE_NAME);
	
	
	//获取省份表的业务层
	IProvinceService provinceService =
			(IProvinceService)ctx.getBean(IProvinceService.SERVICE_NAME);
	
	
	//获取城市的业务层
	ICityService cityService = 
			(ICityService)ctx.getBean(ICityService.SERVICE_NAME);
	//获取编码规则表的业务层
	ISysCodeRuleService sysCodeRuleService = 
			(ISysCodeRuleService)ctx.getBean(ISysCodeRuleService.SERVICE_NAME);
	//获取用户表的业务层
	ISysUserService sysUserService = 
			(ISysUserService)ctx.getBean(ISysUserService.SERVICE_NAME);
	//获取部门表的业务层
	ISysUserGroupService sysUserGroupService = 
			(ISysUserGroupService)ctx.getBean(ISysUserGroupService.SERVICE_NAME);
	/**
	 * 获取下拉表的业务层
	 * 对客户下的页面下拉选提供数据
	 */
	ISysDictionaryTypeService sysDictionaryTypeService = 
			(ISysDictionaryTypeService)ServiceProvinder.getService(ISysDictionaryTypeService.SERVICE_NAME);
	/**
	 * 点击客户拜访
	 * 到达list.jsp
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	public String list() throws IllegalAccessException, InvocationTargetException{
		//调用下拉表的业务层获取客户的等级
		List<SysDictionaryType> gradeSelects = sysDictionaryTypeService.findCompanyGrade();
		//System.out.println("客户的等级有" + grades.size() +"种");
		//将查询到的客户等级集合放置到request作用域中
		request.setAttribute("gradeSelects", gradeSelects);
		
		
		//调用下拉表的业务层获取客户的来源
		List<SysDictionaryType> sourceSelects = sysDictionaryTypeService.findCompanySource();
		//将查询到的客户来源集合放置到request作用域中
		//System.out.println("客户的来源有" + sourceSelects.size() + "种");
		request.setAttribute("sourceSelects", sourceSelects);
		
		
		//调用下拉表的业务层获取客户的性质
		List<SysDictionaryType> qualitySelects = sysDictionaryTypeService.findCompanyQuality();
		//将查询到的客户性质集合放置到request作用域中
		//System.out.println("客户的性质有" + qualitySelects.size() + "种");
		request.setAttribute("qualitySelects", qualitySelects);
		
		
		//用于搜索条件的javabean   CompanySearch
		CompanySearch companySearch = new CompanySearch();
		//从vo对象拷贝到po对象
		BeanUtils.copyProperties(companySearch, companyForm);
		//测试是否接收到了数据
		//System.out.println("companySearch.getQuality()" + companySearch.getQuality());
		//System.out.println("companySearch.getCode()" + companySearch.getCode());
		//System.out.println("companySearch.getGrade()" + companySearch.getGrade());
		//System.out.println("companySearch.getName()" + companySearch.getName());
		//System.out.println("companySearch.getPycode()" + companySearch.getPycode());
		//System.out.println("companySearch.getSource()" + companySearch.getSource());
		//System.out.println("companySearch.getTel1()" + companySearch.getTel1());
		SysUser sysUser = SessionUtils.getSysUserFromSession(request);
		//调用业务层按照输入的条件查询所有的客户信息
		List<Company> companys  = companyService.findAllCompanyInformation(companySearch,sysUser);
		System.out.println("companys.size() :" + companys.size());
		//将查询到的客户信息放置到request作用域中
		request.setAttribute("companys", companys);
		return "list";
	}
	/**
	 * 跳转到add.jsp
	 * 新建客户信息
	 */
	public String add(){
		
		/*处理客户等级*/
		//调用下拉表的业务层查询所有的客户等级
		List<SysDictionaryType>  gradeSelects = sysDictionaryTypeService.findCompanyGrade();
		//System.out.println("sysDictionaryTypes.size()  :" + sysDictionaryTypes.size());
		//将客户等级集合放置到request作用域中
		request.setAttribute("gradeSelects", gradeSelects);
		
		/*处理区域名称*/
		List<SysDictionaryType>  regionNameSelects = sysDictionaryTypeService.findCompanyRegionNames();
		//System.out.println("regionNameSelects.size()  :" + regionNameSelects.size());
		//将区域名称集合放置到request作用域中
		request.setAttribute("regionNameSelects", regionNameSelects);
		
		/*处理客户来源*/
		//调用下拉表的业务层查询所有的客户来源
		List<SysDictionaryType> sourceSelects = sysDictionaryTypeService.findCompanySource();
		//System.out.println("sourceSelects.size()   :" + sourceSelects.size());
		//将客户来源集合放置到request作用域中
		request.setAttribute("sourceSelects", sourceSelects);
		
		/*处理所属行业*/
		//调用下拉表的业务层查询所有的所属行业
		List<SysDictionaryType> tradeSelects = sysDictionaryTypeService.findCompanyTrade();
		System.out.println("tradeSelects.size()  :" + tradeSelects.size());
		//将所属行业集合放置到request作用域中
		request.setAttribute("tradeSelects", tradeSelects);
		
		/*处理公司规模*/
		//调用下拉表的业务层查询所有的公司规模
		List<SysDictionaryType> scaleSelects = sysDictionaryTypeService.findCompanyScale();
		//System.out.println("scaleSelects.size()   :" + scaleSelects.size());
		//将公司规模集合放置到request作用域中
		request.setAttribute("scaleSelects", scaleSelects);
		
		/*处理省份*/
		//调用下拉表的业务层查询所有的省份
		List<Province> provinces = provinceService.findAllProvinces();
		System.out.println("provinces.size()  :" + provinces.size());
		//将省份集合放置到request作用域中
		request.setAttribute("provinces", provinces);
		
		
		/*处理客户性质*/
		//调用下拉表的业务层查询所有的客户性质
		List<SysDictionaryType>  qualitySelects = sysDictionaryTypeService.findCompanyQuality();
		//System.out.println("qualitySelects   :" + qualitySelects.size());
		//将客户性质集合放置到request作用域中
		request.setAttribute("qualitySelects", qualitySelects);
		
		/*处理经营范围*/
		//调用下拉表的业务层查询所有的经营范围
		List<SysDictionaryType> dealinSelects = sysDictionaryTypeService.findAllCompanyDealins();
		System.out.println("dealinSelects.size()" + dealinSelects.size());
		//将经营范围集合放置到request作用域中
		request.setAttribute("dealinSelects", dealinSelects);
		
		/*处理企业性质kind*/
		//调用下拉表的业务层查询所有的企业性质
		List<SysDictionaryType> kindSelects = 
				sysDictionaryTypeService.findAllCompanyKinds();
		System.out.println("kindSelects.size()   :" + kindSelects.size());
		//将企业性质集合放置到request作用域中
		request.setAttribute("kindSelects", kindSelects);
		//创建客户的po类
		Company company = new Company();
		//获取当前登录用户
		SysUser sysUser = SessionUtils.getSysUserFromSession(request);
		if(sysUser!=null){
			//处理创建人     创建日期      第一次创建客户时,创建人为当前登录用户  创建时间为当前时间
			companyForm.setCreater(sysUser.getCnName());
			companyForm.setCreateTime(DateFormatUtils.format(new java.util.Date(), "yyyy-MM-dd"));
			//处理修改人    修改日期       第一次创建客户时,修改人为当前登录用户  修改时间为当前时间
			companyForm.setUpdater(sysUser.getCnName());
			companyForm.setUpdateTime(DateFormatUtils.format(new java.util.Date(), "yyyy-MM-dd"));
			//处理所属人
			companyForm.setDispensePerson(sysUser.getCnName());
			
		}
		//生成流水号
		String glideNumber = sysCodeRuleService.createGlideNumber();
		System.out.println("生成的第一单流水号是     :" + glideNumber);
		request.setAttribute("glideNumber", glideNumber);
		return "add";
	}
	/**
	 * AJAX处理省下的城市
	 * 处理省下的城市
	 * @throws IOException 
	 */
	public String showCity() throws IOException{
		//页面listkey是省得id  所以这里获取到的是省得id
		String provinceId = (String)request.getParameter("name");
		System.out.println("您选择的省的id是  :" + provinceId);
		//通过城市的业务层获取该省下所有的城市的集合
		List<City> cities = cityService.findAllCityInThisProvince(provinceId);
		if(cities!=null&&cities.size()>0){
			//System.out.println("cities.size()  :" + cities.size());
			/**
			 * 因为查询到的集合中有不需要的字段
			 * 就可以通过jsonConfig类进行剔除
			 */
			JsonConfig config = new JsonConfig();
			config.setExcludes(new String[]{"id","pycode","pid","postcode","areacode"});
			JSONArray JsonArray = JSONArray.fromObject(cities, config);
			//System.out.println(JsonArray.toString());
			response.setCharacterEncoding("utf-8");
			//将查询到的城市信息返回到前台页面
			response.getWriter().append(JsonArray.toString());
		}
		return null;
	}
	/**
	 * @throws BadHanyuPinyinOutputFormatCombination 
	 * @throws IOException 
	 * 
	 */
	public String pinyin() throws BadHanyuPinyinOutputFormatCombination, IOException{
		//获取用户输入的客户名称
		String name = (String)request.getParameter("name");
		//若用户名不为空
		if(StringUtils.isNotBlank(name)){
			String firstPinYin = PinYinUtil.convertString2FirstPinYin(name);
			response.setCharacterEncoding("utf-8");
			response.getWriter().print(firstPinYin);
		}
		return null;
	}
	/**
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 * 
	 */
	public String save() throws IllegalAccessException, InvocationTargetException{
		//创建客户表的po对象
		Company company = new Company();
		//有字符串转换为date类型    需要注册转换器
		ConvertUtils.register(new SQLDateConvertor(), java.sql.Date.class);
		//从vo对象拷贝到po对象
		BeanUtils.copyProperties(company, companyForm);
		//处理ownerUser   所属人   待处理
		//所属人姓名  用户
		String dispensePerson = companyForm.getDispensePerson();
		List<SysUser> sysUsers = sysUserService.findSysUserByCNName(dispensePerson);
		System.out.println("sysUsers.size()    :" + sysUsers.size());
		if(sysUsers != null && sysUsers.size() == 1){
			SysUser sysUser = sysUsers.get(0);
			company.setOwnerUser(sysUser.getId());
		}
		//调用service层进行保存客户信息
		companyService.save(company);
		return "listAction";
	}
	/**
	 * 批量删除客户信息
	 * @return
	 */
	public String delete(){
		//获取要删除的用户id
		String[]ids = (String[])request.getParameterValues("ids");
		if(ids != null && ids.length > 0){
		//调用业务层进行删除
			companyService.deleteCompanys(ids);
			for(int i = 0;i<ids.length;i++){
				System.out.println("要删除的客户资料ids[i]是       :" + ids[i]);
			}
		}
		return "listAction";
	}
	/**
	 * 跳转到客户的编辑页面
	 * @return
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	@SuppressWarnings("unused")
	public String edit() throws IllegalAccessException, InvocationTargetException{
		//处理下拉列表
		/*处理客户等级*/
		//调用下拉表的业务层查询所有的客户等级
		List<SysDictionaryType>  gradeSelects = sysDictionaryTypeService.findCompanyGrade();
		//System.out.println("sysDictionaryTypes.size()  :" + sysDictionaryTypes.size());
		//将客户等级集合放置到request作用域中
		request.setAttribute("gradeSelects", gradeSelects);
		
		//区域名称
		/*处理区域名称*/
		List<SysDictionaryType>  regionNameSelects = sysDictionaryTypeService.findCompanyRegionNames();
		//System.out.println("regionNameSelects.size()  :" + regionNameSelects.size());
		//将区域名称集合放置到request作用域中
		request.setAttribute("regionNameSelects", regionNameSelects);
		
		//客户来源
		/*处理客户来源*/
		//调用下拉表的业务层查询所有的客户来源
		List<SysDictionaryType> sourceSelects = sysDictionaryTypeService.findCompanySource();
		//System.out.println("sourceSelects.size()   :" + sourceSelects.size());
		//将客户来源集合放置到request作用域中
		request.setAttribute("sourceSelects", sourceSelects);
		
		//所属行业
		/*处理所属行业*/
		//调用下拉表的业务层查询所有的所属行业
		List<SysDictionaryType> tradeSelects = sysDictionaryTypeService.findCompanyTrade();
		System.out.println("tradeSelects.size()  :" + tradeSelects.size());
		//将所属行业集合放置到request作用域中
		request.setAttribute("tradeSelects", tradeSelects);
		
		//公司规模
		
		/*处理公司规模*/
		//调用下拉表的业务层查询所有的公司规模
		List<SysDictionaryType> scaleSelects = sysDictionaryTypeService.findCompanyScale();
		//System.out.println("scaleSelects.size()   :" + scaleSelects.size());
		//将公司规模集合放置到request作用域中
		request.setAttribute("scaleSelects", scaleSelects);
		
		//省份
		
		/*处理省份*/
		//调用下拉表的业务层查询所有的省份
		List<Province> provinces = provinceService.findAllProvinces();
		System.out.println("provinces.size()  :" + provinces.size());
		//将省份集合放置到request作用域中
		request.setAttribute("provinces", provinces);
		
		
		
		//客户性质
		/*处理客户性质*/
		//调用下拉表的业务层查询所有的客户性质
		List<SysDictionaryType>  qualitySelects = sysDictionaryTypeService.findCompanyQuality();
		//System.out.println("qualitySelects   :" + qualitySelects.size());
		//将客户性质集合放置到request作用域中
		request.setAttribute("qualitySelects", qualitySelects);
		
		//经营范围
		/*处理经营范围*/
		//调用下拉表的业务层查询所有的经营范围
		List<SysDictionaryType> dealinSelects = sysDictionaryTypeService.findAllCompanyDealins();
		System.out.println("dealinSelects.size()" + dealinSelects.size());
		//将经营范围集合放置到request作用域中
		request.setAttribute("dealinSelects", dealinSelects);
		
		//企业性质
		/*处理企业性质kind*/
		//调用下拉表的业务层查询所有的企业性质
		List<SysDictionaryType> kindSelects = 
				sysDictionaryTypeService.findAllCompanyKinds();
		System.out.println("kindSelects.size()   :" + kindSelects.size());
		//将企业性质集合放置到request作用域中
		request.setAttribute("kindSelects", kindSelects);
		
		
		
		
		
		
		//获取要编辑的客户的信息的id
		String iD = (String)request.getParameter("id");
		//System.out.println("要编辑的客户的信息的id   :"  + id);
		Integer id = Integer.parseInt(iD);
		//调用业务层通过id查找到当前用户
		List<Company> companys = companyService.findCompanyById(id);
		//创建客户po对象
		Company company = null;
		//System.out.println("companys.size()    :" + companys.size());
		if(companys!=null && companys.size()==1){
			company = companys.get(0);
		}
		if(company != null){
			//从po拷贝到vo   已进行回显
			BeanUtils.copyProperties(companyForm, company);
			//处理下次联系时间
			String nextTouchTime = DateFormatUtils.format(company.getNextTouchDate(), "yyyy-MM-dd");
			//设置下次联系时间的回显
			companyForm.setNextTouchDate(nextTouchTime);
		}
		//处理城市
		if(StringUtils.isNotBlank(company.getProvince())){
			//company.getProvince()  :7
			System.out.println("company.getProvince()  :" + company.getProvince());
			//调用城市的业务层查询该省的所有城市
			List<City> citys = cityService.findAllCityInThisProvince(company.getProvince());
			//放置到request作用域中
			request.setAttribute("citys", citys);
		}
		//处理修改人    修改日期
		//获取当前登录用户
		SysUser sysUser = SessionUtils.getSysUserFromSession(request);
		companyForm.setUpdater(sysUser.getCnName());
		//修改日期即为当前日期
		companyForm.setUpdateTime(DateFormatUtils.format(new java.util.Date(), "yyyy-MM-dd"));
		return "edit";
	}
	/**
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 * 
	 */
	public String update() throws IllegalAccessException, InvocationTargetException{
		//创建客户的po对象
		Company company = new Company();
		//字符串类型转换为日期 类型   注册转换器
		ConvertUtils.register(new SQLDateConvertor(), java.sql.Date.class);
		//从vo拷贝到po
		BeanUtils.copyProperties(company, companyForm);
		//调用业务层进行保存客户信息
		companyService.updateCompany(company);
		return "listAction";
	}
	/**
	 * 跳转到nextTouchTime.jsp
	 * 设置下次联系时间
	 */
	public String nextTouchTime(){
//		//获取要设置下次联系时间的客户id
//		String []ids = (String[])request.getParameterValues("ids");
//		//将客户id放置到request作用域中
//		request.setAttribute("ids", ids);
		return "nextTouchTime";
	}
	/**
	 * 修改下次联系时间
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	public String updateNextTouchTime() throws IllegalAccessException, InvocationTargetException{
		//获取修改联系时间的客户id
		String[]ids = request.getParameterValues("ids");
//		for(int i = 0;i < ids.length; i++){
//			System.out.println("ids[i]         :" + ids[i]);
//		}
		String []id = null;
		for(int i=0;i<ids.length;i++){
			id=ids[0].split(",");
		}
		String nextTouchDate = request.getParameter("nextTouchDate");
		java.sql.Date nextTouchData = java.sql.Date.valueOf(nextTouchDate);
		//调用业务层进行更新
		companyService.updateCompany(id,nextTouchData);
		return "updateNextTouchTime";
		
		
	}
	/**
	 * 设置客户共享
	 * @return
	 */
	public String showShareSetOne() {
		// 获取带共享的客户id
		String id = request.getParameter("id");
//		if (ids != null && ids.length > 0) {
//			for (int i = 0; i < ids.length; i++) {
//				System.out.println("您想要共享的客户id     :" + ids[i]);
//			}
//		}
		//调用业务层通过id查询到要共享的id
		List<Company> companys = companyService.findCompanyById(Integer.parseInt(id));
		System.out.println("companys.size()  :" + companys.size());
		Company company = null;
		if(companys != null && companys.size() == 1){
			company = companys.get(0);
		}else{
			return null;
		}
		//将要共享的客户放置到request作用域中
		request.setAttribute("company", company);
		//查询所有的部门
		List<SysUserGroup> sysUserGroups = sysUserGroupService.findAllSysUserGroups();
		//System.out.println("sysUserGroups.size()       :" + sysUserGroups.size());
		request.setAttribute("sysUserGroups", sysUserGroups);
		//查询所有的用户
		List<SysUser> sysUsers = sysUserService.findSysUserByConditionWithNoPage();
		//System.out.println("sysUsers.size()       :" + sysUsers.size());
		request.setAttribute("sysUsers", sysUsers);
		
		//获取已经接受共享的用户id
		String[]uid = (String[])request.getParameterValues("uid");
//		if(uid != null && uid.length > 0){
//			for(int i=0;i<uid.length;i++){
//				System.out.println("已经接受共享的用户id 是" + uid[i]);
//			}
//		}
		List<SysUser> sysUserList = new ArrayList<SysUser>();
		//通过id查找到用户
		if(uid!=null && uid.length>0){
			for(int i=0;i<uid.length;i++){
				SysUser sysUser = sysUserService.findSysUserById(Integer.parseInt(uid[i]));
				sysUserList.add(sysUser);
				
			}
		
		}
		request.setAttribute("sysUserList", sysUserList);
		return "showShareSetOne";
	}
	/**
	 * 更新共享信息
	 * 由于一些特殊原因将自己的客户
	 * 共享给其他的客户
	 */
	public String updateShareSetOne(){
		//获取要共享的客户id
		String id = (String)request.getParameter("id");
		//System.out.println("id is  :" + id);
		//request.setAttribute("id", id);
		//获取要接受共享的用户id
		String[]uid = (String[])request.getParameterValues("uid");
		//for(int i=0;i<uid.length;i++){
		//	System.out.println("uid[i] is  :" + uid[i]);
		//}
		//request.setAttribute("uid", uid);
		//调用客户的业务层进行处理
		companyService.setShareInfor(id,uid);
		return "updateShareSetOne";
	}
	/**
	 * 处理经手人变更
	 */
	public String showChangePerson(){
		//获取要变更归属人的用户
		String []ids = (String[])request.getParameterValues("ids");
		
		return "showChangePerson";
	}
	/**
	 * 显示模型驱动的方法
	 * 获取页面表单数据
	 */
	public CompanyForm getModel() {
		
		return companyForm;
	}
}
