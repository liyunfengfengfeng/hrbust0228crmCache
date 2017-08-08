package cn.itcast.crm.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 最基础的action继承actionSupport实现servletRequestAware
 * 和servletaResponseAware 其他的action只需要继承他BaseAction就好了
 * 如果搜索条件包括用户输入的选项时,那么就在实现模型驱动
 * @author LIYUNFENG
 *
 */
public class BaseAction extends ActionSupport 
			implements ServletRequestAware,ServletResponseAware{
	/**
	 * 如果要想让继承他的子类直接使用父类的方法，设置protected就好了
	 */
	protected HttpServletResponse response;
	protected HttpServletRequest request;
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
		
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
		
	}

}
