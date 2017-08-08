package cn.itcast.crm.util;

import java.lang.reflect.ParameterizedType;

/**
 * 该类是为了获取.class在通过id查找对象以及在通过条件查询数据时 会用到类的简单名称 from entityclass.getsimpleName()
 */
public class GenericClass {
	public static  Class getGenericClass(Class clazz) {
		// 获取父类的泛型类型
		ParameterizedType type = (ParameterizedType) clazz
				.getGenericSuperclass();
		// 泛型获取到的是一个数组,有的可能会有多个参数
		Class entityClass = (Class) type.getActualTypeArguments()[0];
		return entityClass;
	}
}
