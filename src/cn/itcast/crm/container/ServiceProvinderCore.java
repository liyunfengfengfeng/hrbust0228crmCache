package cn.itcast.crm.container;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * 这里封装了spring容器获取bean的方法
 * @author LIYUNFENG
 *
 */
public class ServiceProvinderCore {
	public static ApplicationContext ctx;
	public static void load(String fileName){
		ctx = new ClassPathXmlApplicationContext(fileName);
	}
}
