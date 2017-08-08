package cn.itcast.crm.web.action;

import java.util.List;

import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.crm.container.ServiceProvinder;
import cn.itcast.crm.domain.SysMenu;
import cn.itcast.crm.domain.SysUser;
import cn.itcast.crm.service.ISysMenuService;
import cn.itcast.crm.util.SessionUtils;

import com.opensymphony.xwork2.ActionSupport;

public class MenuAction extends BaseAction {
	ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
	//获取菜单的业务层
	ISysMenuService sysMenuService = 
			(ISysMenuService)ctx.getBean(ISysMenuService.SERVICE_NAME);
	/**
	 * 获取首页面的top.jsp进行显示
	 * @return
	 */
	public String top(){
		//获取当前时间
		String date = DateFormatUtils.format(new java.util.Date(), "yyyy-MM-dd");
		//将当前时间存储到request作用域中
		request.setAttribute("date",date);
		//获取当前的登录用户
		SysUser sysUser = SessionUtils.getSysUserFromSession(request);
		request.setAttribute("sysUser", sysUser);
		return "top";
	}
	/**
	 * 获取首页面的left.jsp进行显示
	 * @return
	 */
	public String left(){
		//调用业务层在菜单表中查询到所有的菜单    left.jsp中动态生成菜单
		List<SysMenu> sysMenus = sysMenuService.findAllSysMenus();
		//测试能否接收到菜单的名称
		//for(SysMenu sysMenu : sysMenus){
		//	System.out.println("获取到的菜单名称是   :" + sysMenu.getMenuName());
		//}
		//存储菜单到request作用域中
		request.setAttribute("sysMenus", sysMenus);
		return "left";
	}
	
	
}
