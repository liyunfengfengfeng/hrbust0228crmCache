package cn.itcast.crm.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.crm.domain.SysUser;
import cn.itcast.crm.util.SessionUtils;
/**
 * 用过滤器检查用户是否登陆
 * @author a1996_000
 *
 */
public class CheckUserLoginFilter implements Filter {
	//用来存储无需过滤的路径
	List list = new ArrayList();
	//初始化方法
	public void init(FilterConfig arg0) throws ServletException {
		//存储无需过滤的路径
		list.add("/index.jsp");
		list.add("/image.jsp");
		list.add("/WEB-INF/page/login.jsp");
		list.add("/sys/sysUserAction_isLogin.do");
	}
	
	/**
	 * doFilter方法进行拦截
	 */
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		/**
		 * 将request与response转换为http形式
		 */
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		
		//获取浏览器地址栏上走过的路径
		String path = request.getServletPath();
		//判断是否存在于集合中
		if(list != null && list.size()>0 && list.contains(path)){
			//在集合中就不进行拦截
			chain.doFilter(request, response);
			return ;
		}
		//获取当前的登录用户
		SysUser sysUser = 
				SessionUtils.getSysUserFromSession(request);
		if(sysUser != null){
			//用户已经登陆
			//传递给下一个filter 若没有则到你正在请求的requestResource
			chain.doFilter(request, response);
		}else{
			//用户没有登录
			//转发到项目的根目录
			response.sendRedirect(request.getContextPath());
		}
	}
	//进行关闭的处理
	public void destroy() {

	}
	

}
