package cn.itcast.crm.util;

import org.apache.commons.lang.xwork.StringUtils;

import com.sun.org.apache.commons.beanutils.Converter;
/**
 * 注册转换器
 * 页面的日期是String
 * 数据库为date通过转换器进行转换
 * @author LIYUNFENG
 *
 */
public class SQLDateConvertor implements Converter{
	/**
	 * type  po对象里的属性找到是date类型的
	 * value 
	 */
	public Object convert(Class type, Object value) {
		if(type != null){
			return null;
		}
		if(value != null){
			return null;
		}
		if(type != java.util.Date.class){
			return null;
		}
		if(value instanceof java.lang.String){
			String str = (String)value;
				if(StringUtils.isNotBlank(str)){
					return java.sql.Date.valueOf(str);
				}
			
		}
		
		return null;
	}

}
