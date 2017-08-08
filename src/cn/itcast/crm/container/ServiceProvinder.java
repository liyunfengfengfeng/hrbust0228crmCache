package cn.itcast.crm.container;

import javax.management.RuntimeErrorException;

import org.apache.commons.lang.StringUtils;
import org.springframework.context.ApplicationContext;

/**
 * 这里封装了spring容器
 * 
 * @author LIYUNFENG
 * 
 */
public class ServiceProvinder {
	// private ServiceProvinderCore serviceProvinderCore = new
	// ServiceProvinderCore();
	/**
	 * 静态内部快在该类方法执行之前先执行 在这里对ApplicationContext ctx对象进行初始化
	 */
	static {
		ServiceProvinderCore.load("beans.xml");
	}

	/**
	 * 获取bean
	 * 
	 * @return
	 */
	public static Object getService(String beanName) {
		/**
		 * StringUtils该类为Apache自带的他只能判断字符串是否为空 不能判断对象是否为空
		 */
		if (StringUtils.isBlank(beanName)) {
			throw new RuntimeException("您访问的服务器名称为空");
		}
		Object bean = null;
		if (ServiceProvinderCore.ctx.containsBean(beanName)) {
			bean = ServiceProvinderCore.ctx.getBean(beanName);
		}
		if (bean == null) {
			throw new RuntimeException("您访问的服务器名称" + beanName + "不存在");
		}
		return bean;
	}
}
