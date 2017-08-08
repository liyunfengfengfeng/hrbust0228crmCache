package cn.itcast.crm.interceptor;

import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

import cn.itcast.crm.annotation.Limit;
import cn.itcast.crm.container.ServiceProvinder;
import cn.itcast.crm.domain.SysPopedomPrivilege;
import cn.itcast.crm.domain.SysUser;
import cn.itcast.crm.service.ISysPopedomPrivilegeService;
import cn.itcast.crm.util.SessionUtils;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

@SuppressWarnings("serial")
public class LimitInterceptor extends MethodFilterInterceptor {
	/**
	 * 进行细粒度的权限控制 将标签上的内容与roleId与权限控制表中的内容进行比对 若匹配那就是有权限
	 */
	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		// 获取请求的action
		Object action = invocation.getAction();
		// 获取请求的方法的名称
		String methodName = invocation.getProxy().getMethod();
		// 获取action的请求的方法的封装类 传入方法的名称以及参数这里action中的方法没有参数
		Method method = action.getClass().getMethod(methodName, null);
		// 获取请求的request ServletActionContext是struts2里提供的获取request的类
		//获取request对象
		HttpServletRequest request=ServletActionContext.getRequest();
		// 检查注解 存在注解返回true 已经检查了用户是否具有权限
		Boolean flag = isCheckLimit(method, request);
		if (!flag) {
			System.out.println("用户没有权限");
			return "nonePopedom";
		}
		String returnValue = invocation.invoke();
		return returnValue;
	}

	private Boolean isCheckLimit(Method method, HttpServletRequest request) {
		// 处理方法的封装类
		if (method == null) {
			System.out.println("方法的封装类为空");
			return false;
		}
		// 处理当前的登录用户
		SysUser sysUser = SessionUtils.getSysUserFromSession(request);
		if (sysUser == null) {
			System.out.println("当前的登录用户为空");
			return false;
		}
		// 处理权限组
		if (sysUser.getSysRole() == null) {
			System.out.println("权限组为空");
			return false;
		}
		// 获取roleId
		String roleId = sysUser.getSysRole().getId();
		// 判断该方法是否存在注解
		Boolean annotationPresent = method.isAnnotationPresent(Limit.class);
		if (!annotationPresent) {
			return false;
		}
		Limit limit = method.getAnnotation(Limit.class);
		// 获取Limit注解上的属性 模块名称 module()
		String module = limit.module();
		// 获取Limit注解上的属性 操作名称 privilege()
		String privilege = limit.privilege();
		// 获取操作权限表的业务层
		ISysPopedomPrivilegeService sysPopedomPrivilegeService = (ISysPopedomPrivilegeService) ServiceProvinder
				.getService(ISysPopedomPrivilegeService.SERVICE_NAME);
		// 获取操作权限表中所有的数据
		List<SysPopedomPrivilege> sysPopedomPrivileges = sysPopedomPrivilegeService
				.findAllSysPopedomPrivileges(roleId);
		// 测试能否查询到sysPopedomPrivileges表中的数据
		for (SysPopedomPrivilege sysPopedomPrivilege : sysPopedomPrivileges) {
			System.out.println(sysPopedomPrivilege.getId().getPopedom_Module());
			System.out.println(sysPopedomPrivilege.getId()
					.getPopedom_Privilege());
			System.out.println(sysPopedomPrivilege.getId().getRoleId());
		}
		if (sysPopedomPrivileges == null) {
			System.out.println("您所查询到的数据不正确==null");
		}
		if (sysPopedomPrivileges.size() <= 0) {
			System.out.println("您所查询到的数据不正确sysPopedomPrivileges.size()<=0");
		}
		if(sysPopedomPrivileges.size()>0){
			System.out.println("sysPopedomPrivileges.size()>0");
		}
		Boolean flag = false;
		if (sysPopedomPrivileges != null && sysPopedomPrivileges.size() > 0) {
			for (int i = 0; i < sysPopedomPrivileges.size(); i++) {
				SysPopedomPrivilege sysPopedomPrivilege = sysPopedomPrivileges
						.get(i);
				if (roleId.equals(sysPopedomPrivilege.getId().getRoleId())
						&& module.equals(sysPopedomPrivilege.getId()
								.getPopedom_Module())
						&& privilege.equals(sysPopedomPrivilege.getId()
								.getPopedom_Privilege())) {
					flag = true;
					System.out.println("匹配到相应的权限flag值为true");
					break;
				}
			}

		}
		return flag;
	}

}
