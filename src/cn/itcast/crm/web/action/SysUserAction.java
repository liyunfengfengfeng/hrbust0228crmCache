package cn.itcast.crm.web.action;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.xwork.StringUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ModelDriven;
import com.sun.org.apache.commons.beanutils.ConvertUtils;

import cn.itcast.bean.SysUserSearch;
import cn.itcast.crm.annotation.Limit;
import cn.itcast.crm.container.ServiceProvinder;
import cn.itcast.crm.domain.SysRole;
import cn.itcast.crm.domain.SysUser;
import cn.itcast.crm.domain.SysUserGroup;
import cn.itcast.crm.service.ISysRoleService;
import cn.itcast.crm.service.ISysUserGroupService;
import cn.itcast.crm.service.ISysUserService;
import cn.itcast.crm.util.DataType;
import cn.itcast.crm.util.MD5keyBean;
import cn.itcast.crm.util.SQLDateConvertor;
import cn.itcast.crm.util.SessionUtils;

import cn.itcast.crm.web.form.SysUserForm;

@SuppressWarnings("serial")
/**
 * 系统用户表的action
 * @author LIYUNFENG
 *
 */
public class SysUserAction extends BaseAction implements
		ModelDriven<SysUserForm> {
	static {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		// 获取部门的业务层
		ISysUserGroupService sysUserGroupService = (ISysUserGroupService) ctx.getBean(ISysUserGroupService.SERVICE_NAME);
		// 获取用户的service
		ISysUserService sysUserService = (ISysUserService) ctx.getBean(ISysUserService.SERVICE_NAME);
				
		// 获取权限组的业务层
		ISysRoleService sysRoleService = (ISysRoleService) ctx.getBean(ISysRoleService.SERVICE_NAME);
				
	}
	// 初始化模型驱动对象
	SysUserForm sysUserForm = new SysUserForm();
//	// 获取部门的业务层
//	ISysUserGroupService sysUserGroupService = (ISysUserGroupService) ServiceProvinder
//			.getService(ISysUserGroupService.SERVICE_NAME);
//	// 获取用户的service
//	ISysUserService sysUserService = (ISysUserService) ServiceProvinder
//			.getService(ISysUserService.SERVICE_NAME);
//	// 获取权限组的业务层
//	ISysRoleService sysRoleService = (ISysRoleService) ServiceProvinder
//			.getService(ISysRoleService.SERVICE_NAME);

	/**
	 * 人事管理的list.jsp页面
	 * 
	 * @return
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	@Limit(module = "user", privilege = "list")
	public String list() throws IllegalAccessException,
			InvocationTargetException {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		// 获取部门的业务层
		ISysUserGroupService sysUserGroupService = (ISysUserGroupService) ctx.getBean(ISysUserGroupService.SERVICE_NAME);
		// 获取用户的service
		ISysUserService sysUserService = (ISysUserService) ctx.getBean(ISysUserService.SERVICE_NAME);
				
		// 获取权限组的业务层
		ISysRoleService sysRoleService = (ISysRoleService) ctx.getBean(ISysRoleService.SERVICE_NAME);
		// 查找所有的部门
		List<SysUserGroup> sysUserGroups = sysUserGroupService
				.findAllSysUserGroups();
		// 测试是否取得数据
		// for(SysUserGroup sysUserGroup:sysUserGroups){
		// System.out.println("sysUserGroup.getName() : " +
		// sysUserGroup.getName());
		// }
		// 保存集合到request中
		request.setAttribute("sysUserGroups", sysUserGroups);
		// 测试能否接受到表单数据
		// System.out.println("" + sysUserForm.getName());
		// System.out.println("" + sysUserForm.getStatus());
		// System.out.println("" + sysUserForm.getGroupId());
		// System.out.println("" + sysUserForm.getCnName());
		// 创建用户的javabean即search对象
		SysUserSearch sysUserSearch = new SysUserSearch();
		// 从vo复制到po
		BeanUtils.copyProperties(sysUserSearch, sysUserForm);
		// System.out.println("" + sysUserSearch.getName());
		// System.out.println("" + sysUserSearch.getStatus());
		// System.out.println("" + sysUserSearch.getGroupId());
		// System.out.println("" + sysUserSearch.getCnName());
		List<SysUser> sysUsers = sysUserService
				.findSysUserByConditionWithNoPage(sysUserSearch);
		// 测试能否查到数据
		// System.out.println("sysUsers.size() :" + sysUsers.size());
		// 保存查询到的系统用户集合到request中
		request.setAttribute("sysUsers", sysUsers);
		// 返回list.jsp
		return "list";
	}

	/**
	 * 从人事管理的list.jsp页面 转发到add.jsp
	 * 
	 * @return
	 */
	@Limit(module = "user", privilege = "add")
	public String add() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		// 获取部门的业务层
		ISysUserGroupService sysUserGroupService = (ISysUserGroupService) ctx.getBean(ISysUserGroupService.SERVICE_NAME);
		// 获取用户的service
		ISysUserService sysUserService = (ISysUserService) ctx.getBean(ISysUserService.SERVICE_NAME);
				
		// 获取权限组的业务层
		ISysRoleService sysRoleService = (ISysRoleService) ctx.getBean(ISysRoleService.SERVICE_NAME);
		// 查询所有的操作权限组以用于在add.jsp中进行下拉列表迭代
		List<SysRole> sysRoles = sysRoleService
				.findSysRoleByConditionWithNoPage();
		// for(SysRole sysRole : sysRoles){
		// System.out.println(sysRole.getName());
		// }
		// 将查询到的权限组集合放置到request中
		request.setAttribute("sysRoles", sysRoles);
		// 查询所有的所属部门以用于在add.jsp中进行下拉列表迭代
		// 查询所有的部门
		List<SysUserGroup> sysUserGroups = sysUserGroupService
				.findAllSysUserGroups();
		// for(SysUserGroup sysUserGroup : sysUserGroups){
		// System.out.println(sysUserGroup.getName());
		// }
		// 将查询到的部门集合放置到request中
		request.setAttribute("sysUserGroups", sysUserGroups);
		/**
		 * 第一次添加用户时创建人修改人相同 添加时间与修改时间相同
		 */
		// 从session中获取当前登录用户
		SysUser sysUser = SessionUtils.getSysUserFromSession(request);
		if (sysUser != null) {
			// System.out.println("当前的登录用户是" + sysUser.getCnName());
			// 处理创建人
			sysUserForm.setCreator(sysUser.getCnName());
			// 处理修改人
			sysUserForm.setUpdater(sysUser.getCnName());
			// 处理创建时间
			/**
			 * 这里需要将date的时间格式转化为字符串格式 字符串格式转化为日期类型就需要注册转换器了
			 */
			String curTime = DateFormatUtils.format(new java.util.Date(),
					"yyyy-MM-dd HH:mm:ss");
			// 处理创建时间
			sysUserForm.setCreateTime(curTime);
			// 处理修改时间
			sysUserForm.setUpdateTime(curTime);
		} else {
			return "login";
		}
		// 返回add.jsp
		return "add";
	}

	/**
	 * 判断用户登录的方法
	 * 
	 * @throws UnsupportedEncodingException
	 */
	@Limit(module = "user", privilege = "isLogin")
	public String isLogin() throws UnsupportedEncodingException {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		// 获取部门的业务层
		ISysUserGroupService sysUserGroupService = (ISysUserGroupService) ctx.getBean(ISysUserGroupService.SERVICE_NAME);
		// 获取用户的service
		ISysUserService sysUserService = (ISysUserService) ctx.getBean(ISysUserService.SERVICE_NAME);
				
		// 获取权限组的业务层
		ISysRoleService sysRoleService = (ISysRoleService) ctx.getBean(ISysRoleService.SERVICE_NAME);
		// 处理验证码
		boolean flag = SessionUtils.isCheckNum(request);
		// 测试验证码检验是否生效
		// System.out.println("checkNum is :" + flag);
		// 处理验证码不匹配
		if (!flag) {
			this.addFieldError("checkNum", "验证码错误");
			return "login";
		}
		// 获取用户输入的用户名
		String name = request.getParameter("name");
		// 获取用户输入的密码
		String password = request.getParameter("password");
		// 测试能否接受到登录信息
		// System.out.println("name :" + name);
		// System.out.println("password :" + password);
		// 对密码进行加密 md5加密
		MD5keyBean mD5keyBean = new MD5keyBean();
		password = mD5keyBean.getkeyBeanofStr(password);
		// System.out.println("password :" + password);
		// 创建用户search对象
		SysUserSearch sysUserSearch = new SysUserSearch();
		sysUserSearch.setName(name);
		sysUserSearch.setPassword(password);
		List sysUsers = sysUserService.checkNameAndPassword(sysUserSearch);
		// 获取登录用户
				SysUser sysUser = null;
				if (sysUsers != null && sysUsers.size() == 1) {
					for (Object obj : sysUsers) {
						sysUser = (SysUser) obj;
					}
				}
				
					
		Boolean loginFlag = false;
		if (sysUsers != null && sysUsers.size() == 1) {
			loginFlag = true;
			// System.out.println("sysUser.getMoveTelephone() :" +
			// sysUser.getMoveTelephone());
			// 将当前登录用户保存在session中
			SessionUtils.saveSysUser2Session(sysUser, request);
		
		}
		// 用户名或密码不匹配
		if (!loginFlag) {
			this.addFieldError("name", "用户名或密码错误");
			return "login";
		}
		String rememberMe = (String) request.getParameter("rememberMe");
		// 是否勾选记住我
		// System.out.println("rememberMe  :" + rememberMe);
		if (StringUtils.isNotBlank(rememberMe) && rememberMe != null) {
			if (rememberMe.equals("yes")) {
				// 保存用户名密码到cookie中
				// 密码要再一次获取
				addCookie(name, request.getParameter("password"), request,
						response);
			}
		}
		
		return "main";
	}

	// 保存用户名密码到cookie中
	private void addCookie(String name, String password,
			HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException {
		if (StringUtils.isNotBlank(name) && StringUtils.isNotBlank(password)) {
			// 在后台进行编码在前台name输入框中进行解码 cookie中的汉字会乱码
			Cookie cookie1 = new Cookie("name", java.net.URLEncoder.encode(
					name, "utf-8"));
			Cookie cookie2 = new Cookie("psw", password);
			// 设置cookie的父路径
			cookie1.setPath(request.getContextPath() + "/");
			cookie2.setPath(request.getContextPath() + "/");
			// 设置cookie的生命周期
			cookie1.setMaxAge(7 * 24 * 60 * 60);
			cookie2.setMaxAge(7 * 24 * 60 * 60);
			// 添加cookie到响应头
			response.addCookie(cookie1);
			response.addCookie(cookie2);
		}

	}

	/**
	 * 新建用户add.jsp中保存所有的信息
	 * 
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	@Limit(module = "user", privilege = "save")
	public String save() throws IllegalAccessException,
			InvocationTargetException {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		// 获取部门的业务层
		ISysUserGroupService sysUserGroupService = (ISysUserGroupService) ctx.getBean(ISysUserGroupService.SERVICE_NAME);
		// 获取用户的service
		ISysUserService sysUserService = (ISysUserService) ctx.getBean(ISysUserService.SERVICE_NAME);
				
		// 获取权限组的业务层
		ISysRoleService sysRoleService = (ISysRoleService) ctx.getBean(ISysRoleService.SERVICE_NAME);
		// 建立po对象
		SysUser sysUser = new SysUser();
		// 将vo对象付给po对象再此之前需要进行注册转换器String转换为date类型
		ConvertUtils.register(new SQLDateConvertor(), java.sql.Date.class);
		BeanUtils.copyProperties(sysUser, sysUserForm);
		// 处理部门 实例化po
		SysUserGroup sysUserGroup = new SysUserGroup();
		// 设置id
		sysUserGroup.setId(Integer.parseInt(sysUserForm.getGroupId()));
		// 设置部门
		sysUser.setSysUserGroup(sysUserGroup);
		// 处理权限组实例化po
		SysRole sysRole = new SysRole();
		// 设置id
		sysRole.setId(sysUserForm.getRoleId());
		// 设置权限组
		sysUser.setSysRole(sysRole);
		// 处理密码
		String password = sysUserForm.getPassword();
		MD5keyBean mD5keyBean = new MD5keyBean();
		password = mD5keyBean.getkeyBeanofStr(password);
		sysUser.setPassword(password);
		// 通过系统用户表的业务层进行保存
		sysUserService.save(sysUser);
		return "listAction";
	}

	/**
	 * 系统用户界面下点击删除 执行的删除操作
	 */
	@Limit(module = "user", privilege = "delete")
	public String delete() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		// 获取部门的业务层
		ISysUserGroupService sysUserGroupService = (ISysUserGroupService) ctx.getBean(ISysUserGroupService.SERVICE_NAME);
		// 获取用户的service
		ISysUserService sysUserService = (ISysUserService) ctx.getBean(ISysUserService.SERVICE_NAME);
				
		// 获取权限组的业务层
		ISysRoleService sysRoleService = (ISysRoleService) ctx.getBean(ISysRoleService.SERVICE_NAME);
		// 获取要删除数据的id(数组形式)
		String[] ids = (String[]) request.getParameterValues("ids");
		// System.out.println("删除了" + ids.length + "条数据");
		// 调用业务层进行删除
		sysUserService.deleteByIds(ids);
		return "listAction";
	}

	/**
	 * 设置用户的状态为#{'Y':'启用','N':'停用'}" 设置为可用状态
	 * 
	 * @return
	 */
	@Limit(module = "user", privilege = "enable")
	public String enable() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		// 获取部门的业务层
		ISysUserGroupService sysUserGroupService = (ISysUserGroupService) ctx.getBean(ISysUserGroupService.SERVICE_NAME);
		// 获取用户的service
		ISysUserService sysUserService = (ISysUserService) ctx.getBean(ISysUserService.SERVICE_NAME);
				
		// 获取权限组的业务层
		ISysRoleService sysRoleService = (ISysRoleService) ctx.getBean(ISysRoleService.SERVICE_NAME);
		// 定义整形数组
		Integer[] idArray = null;
		// 获取要修改状态的数据的id
		String[] ids = (String[]) request.getParameterValues("ids");
		// 将字符串id转换为整形id
		if (ids != null && ids.length > 0) {
			idArray = DataType.converterStringArray2IntegerArray(ids);
		}
		// 调用业务层方法通过id进行修改
		if (idArray != null) {

			sysUserService.setSysUserEnable(idArray);
		}
		return "listAction";
	}

	/**
	 * 设置用户的状态为#{'Y':'启用','N':'停用'}" 设置为不可用状态
	 * 
	 * @return
	 */
	@Limit(module = "user", privilege = "disable")
	public String disable() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		// 获取部门的业务层
		ISysUserGroupService sysUserGroupService = (ISysUserGroupService) ctx.getBean(ISysUserGroupService.SERVICE_NAME);
		// 获取用户的service
		ISysUserService sysUserService = (ISysUserService) ctx.getBean(ISysUserService.SERVICE_NAME);
				
		// 获取权限组的业务层
		ISysRoleService sysRoleService = (ISysRoleService) ctx.getBean(ISysRoleService.SERVICE_NAME);
		// 声明整形数组
		Integer[] idArray = null;
		// 获取要设置为不可用状态的数据
		String[] ids = (String[]) request.getParameterValues("ids");
		if (ids != null && ids.length > 0) {
			// 将字符串数组转换为整形数组
			idArray = DataType.converterStringArray2IntegerArray(ids);
		}
		// 调用业务层进行状态设置为不可用状态
		if (idArray != null && idArray.length > 0) {
			sysUserService.setSysUserDisable(idArray);
		}
		return "listAction";
	}

	/**
	 * 系统用户表下面的list.jsp 跳转到edit.jsp
	 * 
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	@Limit(module = "user", privilege = "edit")
	public String edit() throws IllegalAccessException,
			InvocationTargetException {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		// 获取部门的业务层
		ISysUserGroupService sysUserGroupService = (ISysUserGroupService) ctx.getBean(ISysUserGroupService.SERVICE_NAME);
		// 获取用户的service
		ISysUserService sysUserService = (ISysUserService) ctx.getBean(ISysUserService.SERVICE_NAME);
				
		// 获取权限组的业务层
		ISysRoleService sysRoleService = (ISysRoleService) ctx.getBean(ISysRoleService.SERVICE_NAME);
		// 获取要编辑的用户id
		Integer id = null;
		String iD = (String) request.getParameter("id");
		if (iD != null && StringUtils.isNotBlank(iD)) {
			id = Integer.parseInt(iD);
		}
		SysUser sysUser = null;
		// 调用业务层通过id查找到要编辑的用户
		if (id != null && id > 0) {
			sysUser = sysUserService.findSysUserById(id);
		}
		if (sysUser != null) {
			// 从po复制到vo
			BeanUtils.copyProperties(sysUserForm, sysUser);

			// 处理系统用户信息的回显在edit.jsp
			/**
			 * 修改时创建人与创建时间保持不变 修改人修改时间为当前登录用户与当前时间
			 */
			// 处理创建人
			sysUserForm.setCreator(sysUser.getCnName());
			// 处理创建时间
			sysUserForm.setCreateTime(sysUser.getCreateTime());
		}
		// 获取当前登录用户
		SysUser curSysUser = SessionUtils.getSysUserFromSession(request);
		// 处理修改人
		sysUserForm.setUpdater(curSysUser.getCnName());
		// 处理修改时间
		sysUserForm.setUpdateTime(DateFormatUtils.format(new java.util.Date(),
				"yyyy-MM-dd HH:mm:ss"));
		// 处理操作权限组的下拉列表框
		List<SysRole> sysRoles = sysRoleService
				.findSysRoleByConditionWithNoPage();
		// 将权限组集合保存到request中
		request.setAttribute("sysRoles", sysRoles);
		// 处理部门的下拉列表框
		List<SysUserGroup> sysUserGroups = sysUserGroupService
				.findAllSysUserGroups();
		// 将部门集合保存到request中
		request.setAttribute("sysUserGroups", sysUserGroups);
		if (sysUser != null) {
			// 处理部门的回显
			sysUserForm.setGroupId(sysUser.getSysUserGroup().getId().toString()
					.trim());

			// 处理权限组的回显
			sysUserForm.setRoleId(sysUser.getSysRole().getId());
		}
		return "edit";
	}

	/**
	 * 系统用户表下面的edit.jsp里的保存 即要进行更新
	 * 
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	@Limit(module = "user", privilege = "update")
	public String update() throws IllegalAccessException,
			InvocationTargetException {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		// 获取部门的业务层
		ISysUserGroupService sysUserGroupService = (ISysUserGroupService) ctx.getBean(ISysUserGroupService.SERVICE_NAME);
		// 获取用户的service
		ISysUserService sysUserService = (ISysUserService) ctx.getBean(ISysUserService.SERVICE_NAME);
				
		// 获取权限组的业务层
		ISysRoleService sysRoleService = (ISysRoleService) ctx.getBean(ISysRoleService.SERVICE_NAME);
		// 创建系统用户的po对象
		SysUser sysUser = new SysUser();
		/**
		 * 从vo拷贝到po有字符串转换为date类型的情况 此时需要进行注册转换器
		 */
		ConvertUtils.register(new SQLDateConvertor(), java.sql.Date.class);
		// 从vo拷贝到po
		BeanUtils.copyProperties(sysUser, sysUserForm);
		// 处理权限组
		String roleId = (String) request.getParameter("roleId");
		if (StringUtils.isNotBlank(roleId)) {
			// 创建权限组po对象
			SysRole sysRole = new SysRole();
			// 设置id
			sysRole.setId(roleId);
			// 设置权限组
			sysUser.setSysRole(sysRole);
		}
		// 处理部门
		String groupId = (String) request.getParameter("groupId");
		Integer id = Integer.parseInt(groupId);
		// 创建部门po对象
		SysUserGroup sysUserGroup = new SysUserGroup();
		// 设置id
		sysUserGroup.setId(id);
		// 设置部门
		sysUser.setSysUserGroup(sysUserGroup);
		// 调用业务层进行更新
		sysUserService.update(sysUser);
		return "listAction";
	}

	/**
	 * edit.jsp跳转到修改密码页面 loadPassword.jsp
	 */
	@Limit(module = "user", privilege = "load")
	public String load() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		// 获取部门的业务层
		ISysUserGroupService sysUserGroupService = (ISysUserGroupService) ctx.getBean(ISysUserGroupService.SERVICE_NAME);
		// 获取用户的service
		ISysUserService sysUserService = (ISysUserService) ctx.getBean(ISysUserService.SERVICE_NAME);
				
		// 获取权限组的业务层
		ISysRoleService sysRoleService = (ISysRoleService) ctx.getBean(ISysRoleService.SERVICE_NAME);
		// 获取要编辑修改密码的用户的id
		String iD = (String) request.getParameter("id");
		Integer id = Integer.parseInt(iD);
		// 获取要编辑修改密码的用户
		SysUser sysUser = sysUserService.findSysUserById(id);
		// 获取到没有乱码的中文名
		String cnName = sysUser.getCnName();
		// 将其放置到request中
		request.setAttribute("sysUser", sysUser);
		// 将要修改密码的用户的id传过去
		sysUserForm.setId(id.toString());
		return "load";
	}

	/**
	 * 对密码进行修改 修改完成之后回到编辑页面
	 */
	@Limit(module = "user", privilege = "updatePassword")
	public String updatePassword() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		// 获取部门的业务层
		ISysUserGroupService sysUserGroupService = (ISysUserGroupService) ctx.getBean(ISysUserGroupService.SERVICE_NAME);
		// 获取用户的service
		ISysUserService sysUserService = (ISysUserService) ctx.getBean(ISysUserService.SERVICE_NAME);
				
		// 获取权限组的业务层
		ISysRoleService sysRoleService = (ISysRoleService) ctx.getBean(ISysRoleService.SERVICE_NAME);
		// 获取要修改密码的用户id
		Integer id = null;
		String iD = (String) request.getParameter("id");
		if (iD != null && StringUtils.isNotBlank(iD)) {
			id = Integer.parseInt(iD);
		}
		// System.out.println("获取要修改密码的用户id" + id);
		// 获取新的密码
		String password = (String) request.getParameter("password");
		// System.out.println("password is" + password);
		// 对要存储的密码进行加密
		MD5keyBean mD5keyBean = new MD5keyBean();
		password = mD5keyBean.getkeyBeanofStr(password);
		SysUser sysUser = null;
		// 查找密码被修改的用户
		if (id != null) {
			sysUser = sysUserService.findSysUserById(id);
		}
		if (sysUser != null) {
			// 修改密码
			sysUser.setPassword(password);
			// 调用dao层进行更新
			sysUserService.update(sysUser);
		}
		return "editAction";
	}

	/**
	 * 处理返回 返回上一界面
	 */
	public String back() {
		return "listAction";
	}

	/**
	 * 实现模型驱动的方法
	 */
	public SysUserForm getModel() {

		return sysUserForm;
	}
}
