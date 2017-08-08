package cn.itcast.crm.util;

import org.apache.commons.lang.xwork.StringUtils;

/**
 * 类型转化类
 * 
 * @author LIYUNFENG
 * 
 */
public class DataType {
	/**
	 * 通过该方法将字符串数组转化为整形数组
	 * 
	 * @param ids
	 * @return
	 */
	public static Integer[] converterStringArray2IntegerArray(String[] ids) {
		// 转化的整形数组长度要保持一致
		Integer[] id = new Integer[ids.length];
		if (ids != null && ids.length > 0) {
			for (int i = 0; i < ids.length; i++) {
				id[i] = Integer.parseInt(ids[i]);
			}
			return id;
		}
		return null;
	}

	/**
	 * 处理客户编码产生当前流水号 3位 001 4位 0001
	 */
	public static String createCurrentGlideNumber(int glideNumber) {
		String glideNum = "";
		if (glideNumber <= 3) {
			glideNum = "00";
		} else {
			for (int i = 0; i < glideNumber - 1; i++) {
				glideNum = glideNum + "0";
			}
		}
		glideNum = glideNum + "1";
		return glideNum;
	}

	/**
	 * 生成当前流水号的下一条流水号 "0001"------>"10001" "10001"----->10001 10001 + 1
	 * ---->10002 10002---->"10002" 截取为0002
	 * 
	 * @param args
	 */
	public static String createNextGlideNumber(String glideNumber) {
		if (StringUtils.isNotBlank(glideNumber)) {
			glideNumber += "1" + glideNumber;
		}
		Integer num = Integer.parseInt(glideNumber);
		++num;
		glideNumber = num.toString().substring(2);
		return glideNumber;
	}

	public static void main(String[] args) {
		// 产生4位的当前流水号
		System.out.println("产生4位的当前流水号     :"
				+ DataType.createCurrentGlideNumber(4));
		// 获取0001的下一位流水号
		System.out.println("获取0001的下一位流水号     :"
				+ DataType.createNextGlideNumber("0001"));
	}
}
