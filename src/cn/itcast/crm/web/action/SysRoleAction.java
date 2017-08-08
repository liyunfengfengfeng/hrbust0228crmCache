package cn.itcast.crm.web.action;





import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ModelDriven;
import com.sun.org.apache.commons.beanutils.BeanUtils;

import cn.itcast.bean.SysRoleSearch;

import cn.itcast.crm.annotation.Limit;
import cn.itcast.crm.container.ServiceProvinder;
import cn.itcast.crm.domain.SysMenu;
import cn.itcast.crm.domain.SysMenuPrivilege;
import cn.itcast.crm.domain.SysPopedom;
import cn.itcast.crm.domain.SysPopedomPrivilege;
import cn.itcast.crm.domain.SysRole;
import cn.itcast.crm.service.ISysMenuPrivilegeService;
import cn.itcast.crm.service.ISysMenuService;
import cn.itcast.crm.service.ISysPopedomPrivilegeService;
import cn.itcast.crm.service.ISysPopedomService;
import cn.itcast.crm.service.ISysRoleService;
import cn.itcast.crm.service.ISysUserGroupService;
import cn.itcast.crm.service.ISysUserService;
import cn.itcast.crm.util.DataType;
import cn.itcast.crm.web.form.SysRoleForm;

/**
 * 处理权限组的action
 * @author LIYUNFENG
 *
 */
@SuppressWarnings("serial")
public class SysRoleAction extends BaseAction implements ModelDriven<SysRoleForm>{
	//获取权限组表的业务层
//	ISysRoleService sysRoleService = 
//			(ISysRoleService)ServiceProvinder.getService(ISysRoleService.SERVICE_NAME);
	//建立权限组表的模型驱动的对象
	private SysRoleForm sysRoleForm = new SysRoleForm();
//	//获取系统功能表的业务层
//	ISysPopedomService sysPopedomService = 
//			(ISysPopedomService)ServiceProvinder.getService(ISysPopedomService.SERVICE_NAME);
//	//获取操作功能表的业务层
//	ISysPopedomPrivilegeService sysPopedomPrivilegeService = 
//			(ISysPopedomPrivilegeService)ServiceProvinder.getService(ISysPopedomPrivilegeService.SERVICE_NAME);
//	//获取菜单的业务层
//	ISysMenuService sysMenuService = 
//			(ISysMenuService) ServiceProvinder.getService(ISysMenuService.SERVICE_NAME);
//	//获取菜单权限表的业务层
//	ISysMenuPrivilegeService sysMenuPrivilegeService = 
//			(ISysMenuPrivilegeService)ServiceProvinder.getService(ISysMenuPrivilegeService.SERVICE_NAME);
	static {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		//获取权限组表的业务层
		ISysRoleService sysRoleService = 
				(ISysRoleService)ctx.getBean(ISysRoleService.SERVICE_NAME);
		
		//获取系统功能表的业务层
		ISysPopedomService sysPopedomService = 
				(ISysPopedomService)ctx.getBean(ISysPopedomService.SERVICE_NAME);
		//获取操作功能表的业务层
		ISysPopedomPrivilegeService sysPopedomPrivilegeService = 
				(ISysPopedomPrivilegeService)ctx.getBean(ISysPopedomPrivilegeService.SERVICE_NAME);
		//获取菜单的业务层
		ISysMenuService sysMenuService = 
				(ISysMenuService) ctx.getBean(ISysMenuService.SERVICE_NAME);
		//获取菜单权限表的业务层
		ISysMenuPrivilegeService sysMenuPrivilegeService = 
				(ISysMenuPrivilegeService)ctx.getBean(ISysMenuPrivilegeService.SERVICE_NAME);
				
	}
	ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
	//获取权限组表的业务层
	ISysRoleService sysRoleService = 
			(ISysRoleService)ctx.getBean(ISysRoleService.SERVICE_NAME);
	
	//获取系统功能表的业务层
	ISysPopedomService sysPopedomService = 
			(ISysPopedomService)ctx.getBean(ISysPopedomService.SERVICE_NAME);
	//获取操作功能表的业务层
	ISysPopedomPrivilegeService sysPopedomPrivilegeService = 
			(ISysPopedomPrivilegeService)ctx.getBean(ISysPopedomPrivilegeService.SERVICE_NAME);
	//获取菜单的业务层
	ISysMenuService sysMenuService = 
			(ISysMenuService) ctx.getBean(ISysMenuService.SERVICE_NAME);
	//获取菜单权限表的业务层
	ISysMenuPrivilegeService sysMenuPrivilegeService = 
			(ISysMenuPrivilegeService)ctx.getBean(ISysMenuPrivilegeService.SERVICE_NAME);
	/**
	 * 通过list返回到权限组下的list.jsp
	 * @return
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	@Limit(module="role",privilege="list")
	
	public String list() throws IllegalAccessException, InvocationTargetException{
		//用于传递搜索条件
		SysRoleSearch sysRoleSearch = new SysRoleSearch();
		//从vo拷贝到po
		BeanUtils.copyProperties(sysRoleSearch, sysRoleForm);
		//测试能否接收到表单数据
//		System.out.println(sysRoleForm.getName());
//		System.out.println(sysRoleSearch.getName());
		//调用业务层进行查找
		@SuppressWarnings("unused")
		List<SysRole> sysRoles = sysRoleService.findSysRoleByConditionWithNoPage(sysRoleSearch);
		//检查是否查询到数据
		//System.out.println(sysRoles.size());
		request.setAttribute("sysRoles", sysRoles);
		return "list";
	}
	/**
	 * 在权限组表中新建页面的跳转
	 * 返回走list.jsp但要走list.do的路径
	 */
	@Limit(module="role",privilege="add")
	public String add(){
		
		return "add";
	}
	/**
	 * 在权限组表中add.jsp页面的保存权限组的名称以及备注
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	@Limit(module="role",privilege="save")
	public String save() throws IllegalAccessException, InvocationTargetException{
		//测试获取表单用户输入的数据
//		System.out.println(sysRoleForm.getName());
//		System.out.println(sysRoleForm.getRemark());
		//创建po对象
		SysRole sysRole = new SysRole();
		//从vo拷贝到po
		BeanUtils.copyProperties(sysRole, sysRoleForm);
		//调用权限组表的业务层进行保存
		sysRoleService.save(sysRole);
		return "listAction";
	}
	/**
	 * 权限组表中add.jsp页面里的返回按钮
	 */
	public String back(){
		return "listAction";
	}
	/**
	 * 在list.jsp中删除权限组表中的数据
	 * 返回listAction重新再进行一次查询
	 */
	@Limit(module="role",privilege="delete")
	public String delete(){
		//获取要删除的id批量进行删除
		/**
		 * 因为权限组的id设置为uuid
		 * 没有办法通过id批量删除
		 */
		String []ids = (String[])request.getParameterValues("ids");
		//测试是否接受要删除数据的id
//		for(String id:ids){
//			System.out.println(id);
//		}
		//调用权限组业务层的方法进行删除
		sysRoleService.deleteSysRoleByIds(ids);
		return "listAction";
	}
	/**
	 * 到达权限组下面的编辑页面
	 * edit.jsp
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	@Limit(module="role",privilege="edit")
	public String edit() throws IllegalAccessException, InvocationTargetException{
		//首先要进行的是回显
		String id = (String)request.getParameter("id");
		//检测能否接受到数据
		//System.out.println(id);
		//调用业务层的方法进行查找
		SysRole sysRole = sysRoleService.findSysRoleById(id);
		//检测能否查询到数据
		//System.out.println(sysRole.getName());
		
		//回显
		BeanUtils.copyProperties(sysRoleForm, sysRole);
		
		return "edit";
	}
	/**
	 * 在编辑页面进行的更新
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 * 
	 */
	@Limit(module="role",privilege="update")
	public String update() throws IllegalAccessException, InvocationTargetException{
//		System.out.println(sysRoleForm.getId());
//		System.out.println(sysRoleForm.getName());
//		System.out.println(sysRoleForm.getRemark());
		SysRole sysRole = new SysRole();
		//从vo复制到po
		BeanUtils.copyProperties(sysRole, sysRoleForm);
		//调用业务层进行保存
		sysRoleService.update(sysRole);
		return "listAction";
	}
	/**
	 * 操作表中的menu下的view.jsp
	 * 展示所有的系统的菜单的设置
	 * @return
	 */
	@Limit(module="role",privilege="listMenu")
	public String listMenu(){
		//获取页面传过来的权限组id roleId
		String roleId = (String)request.getParameter("roleId");
		//测试是否接收到roleId
		//System.out.println("是否接收到roleId  :" + roleId);
		//通过id查询到权限组对象
		SysRole sysRole = sysRoleService.findSysRoleById(roleId);
		//将权限组对象放置在request作用域中   传到菜单展示页view.jsp中   保存的
		//时候会用到
		request.setAttribute("sysRole", sysRole);
		//调用菜单的业务层获取所有的菜单
		List<SysMenu> sysMenus = sysMenuService.findAllSysMenus();
		//测试查询到的菜单数据
//		for(SysMenu sysMenu:sysMenus){
//			System.out.println(sysMenu.getMenuName());
//		}
		request.setAttribute("sysMenus", sysMenus);
		//获取用户已经勾选了的 要进行回显的菜单列表集合
		List<SysMenuPrivilege> sysMenuPrivileges = sysMenuPrivilegeService.findAllSysMenuPrivileges(roleId);
		request.setAttribute("sysMenuPrivileges", sysMenuPrivileges);
		return "listMenu"; 
	}
	/**
	 * 操作表中的popedom下的view.jsp
	 * 展示所有的系统的操作
	 * @return
	 */
	@Limit(module="role",privilege="listPopedom")
	public String listPopedom(){
		//获取要修改功能的权限组
		String id = (String)request.getParameter("roleId");
		//测试能否收到id
		//System.out.println("权限组id is " + id);
		//通过id找到该权限组对象
		SysRole sysRole = sysRoleService.findSysRoleById(id);
		//将权限组对象存储到request对象中
		request.setAttribute("sysRole", sysRole);
		/**
		 * 将系统具有的所有功能查询出来
		 */
		List<SysPopedom> sysPopedoms = 
				sysPopedomService.findAllPopedom();
		//将存储系统所有功能的集合放到request作用域中
		request.setAttribute("sysPopedoms", sysPopedoms);
		/**
		 * 进行回显 首先进行查出该roleId对应的功能
		 * 调用操作功能表的业务层
		 */
		List<SysPopedomPrivilege> sysPopedomPrivileges = 
				sysPopedomPrivilegeService.findSysPopedomPrivilegesByRoleId(id);
		//将要回显集合的数据放置在request作用域中
		request.setAttribute("sysPopedomPrivileges", sysPopedomPrivileges);
		return "listPopedom";
	}
	/**
	 * 将在功能表中勾选的权限保存到
	 * sys_popedom_privilege表中
	 */
	@Limit(module="role",privilege="updatePopedom")
	public String updatePopedom(){
		//获取要保存的权限组id  roleId
		String roleId = (String)request.getParameter("roleId");
		//测试能否接收到roleId
		//System.out.println("获取要保存的权限组id  roleId  :" + roleId);
		//获取模块名称与操作名称     他们是有,分割的value属性值
		String []popedomModules = (String[]) request.getParameterValues("popedomModule");
		//测试能否接收到模块名称   操作名称
		//for(int i =0;i<popedomModules.length;i++){
		//System.out.println(popedomModules[i]);
		//}
		//调用操作功能表的业务层保存模块名称 操作名称 roleId 
		//到sys_popedom_privilege表中
		sysPopedomPrivilegeService.savePopedom(roleId,popedomModules);
		return "updatePopedom";
	}
	/**
	 * 更新menu菜单到菜单权限表sys_menu_privilege中
	 */
	@Limit(module="role",privilege="updateMenu")
	public String updateMenu(){
		//获取roleId
		String roleId = (String)request.getParameter("roleId");
		//测试能否接收到roleId
		System.out.println("菜单权限表中要保存的roleId 是  :" + roleId);
		//获取要保存的菜单及菜单名称
		String[]menuModules = (String[])request.getParameterValues("menuModule");
		//测试能否接收到要保存的菜单模块名称 操作名称
//		for(int i = 0;i<menuModules.length;i++){
//		System.out.println(menuModules[i]);
//		}
		//调用菜单权限表的业务层进行保存
		sysMenuPrivilegeService.saveMenu2SysMenuPrivilege(roleId,menuModules);
		return "updateMenu";
	}
	/**
	 * 实现模型驱动的方法获取表单数据
	 */
	public SysRoleForm getModel() {
		
		return sysRoleForm;
	}

}
