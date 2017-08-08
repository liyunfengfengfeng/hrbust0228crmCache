package cn.itcast.crm.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 实现自定义的注解
 * 对action中的方法实现细粒度的权限控制
 * @author LIYUNFENG
 *
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Limit {
	/**
	 * 注解中的属性不能定义为私有
	 * @return
	 */
	 String module();
	 String privilege();
}
