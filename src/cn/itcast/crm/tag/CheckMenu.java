package cn.itcast.crm.tag;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTag;

import cn.itcast.crm.container.ServiceProvinder;
import cn.itcast.crm.domain.SysMenuPrivilege;
import cn.itcast.crm.domain.SysUser;
import cn.itcast.crm.service.ISysMenuPrivilegeService;
import cn.itcast.crm.util.SessionUtils;
/**
 * 该类用于实现自定义的标签   实现的功能是
 * 当前登录用户的roleId在菜单权限组表中所拥有的
 * 模块名称与操作名称与整个系统菜单中的匹配
 * 若匹配则显示
 * 否则不显示
 * 用户登录后系统菜单只显示该用户能够进行点击的部分
 * @author LIYUNFENG
 *
 */
public class CheckMenu implements SimpleTag{
	
	//pageContext对象这个对象代表页面上下文,该对象主要用于访问JSP之间的共享数据
	private PageContext pageContext;
	// 自定义标签JspFragment类
	private JspFragment jspFragment;
	//<hrbust:checkMenu module="" privilege=""/>
	//设置标签中的属性
	private String module;		//模块名称
	private String privilege;	//操作名称
	
	//封装的逻辑标签实现的功能写在这里
	public void doTag() throws JspException, IOException {
		//获取页面上下文的request
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		//获取当前的登录用户
		SysUser sysUser = SessionUtils.getSysUserFromSession(request);
		if(sysUser == null){
			return ;
		}
		if(sysUser.getSysRole()==null){
			return ;
		}
		//获取当前用户的权限组id
		String roleId = sysUser.getSysRole().getId();
		//获取菜单权限表的业务层
		ISysMenuPrivilegeService sysMenuPrivilegeService = 
				(ISysMenuPrivilegeService)ServiceProvinder.getService(ISysMenuPrivilegeService.SERVICE_NAME);
		//调用业务层查询出所有的菜单权限表中的数据 
		List<SysMenuPrivilege> sysMenuPrivileges = 
				sysMenuPrivilegeService.findAllSysMenuPrivileges();
		/**
		 * 如果用户的模块名称操作名称在菜单权
		 * 限表中可以查询得到在设置为true
		 */
		Boolean flag = false;
		if(sysMenuPrivileges != null && sysMenuPrivileges.size() > 0){
			for(int i = 0 ; i < sysMenuPrivileges.size(); i++){
				SysMenuPrivilege sysMenuPrivilege = sysMenuPrivileges.get(i);
				if(roleId.equals(sysMenuPrivilege.getId().getRoleId())
						&&module.equals(sysMenuPrivilege.getId().getMenuModule())
							&&privilege.equals(sysMenuPrivilege.getId().getMenuPrivilege())){
					//集合中存在是输出标签体中的内容
					this.jspFragment.invoke(null);
					/**
					 * 页面中的模块名称操作名称会循环 一次比较一条数据
					 * 找到了就break;
					 */
					break;
				}
			}
		}
	}
	
	

	public JspTag getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setJspBody(JspFragment jspFragment) {
		this.jspFragment = jspFragment;
	}
	//要对pageContext进行初始化 否则空指针
	public void setJspContext(JspContext jc) {
		this.pageContext = (PageContext) jc;
		
	}

	public void setParent(JspTag arg0) {
		// TODO Auto-generated method stub
		
	}

	

	

	public JspFragment getJspFragment() {
		return jspFragment;
	}

	public void setJspFragment(JspFragment jspFragment) {
		this.jspFragment = jspFragment;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public String getPrivilege() {
		return privilege;
	}

	public void setPrivilege(String privilege) {
		this.privilege = privilege;
	}



	public PageContext getPageContext() {
		return pageContext;
	}



	public void setPageContext(PageContext pageContext) {
		this.pageContext = pageContext;
	}

}
