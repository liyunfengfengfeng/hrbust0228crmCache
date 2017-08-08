package cn.itcast.crm.util;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/**
 * 此类用于处理拼音码的产生
 * @author LIYUNFENG
 *
 */
public class PinYinUtil {
/**
 * 此方法将汉字转换为其拼音第一个首字母
 * 英文不变
 * @throws BadHanyuPinyinOutputFormatCombination 
 */
	public static  String convertString2FirstPinYin(String str) throws BadHanyuPinyinOutputFormatCombination{
		//转换之后的拼音字符串
		String pinyin = "";
		//将字符串转换为char类型数组
		char[]strArray = str.toCharArray();
		//输出字符型数组
//		for(char i:strArray){
//			System.out.println(i);
//		}
		/**
		 * pinyin4J里的类将汉字
		 * 转化为拼音
		 */
		HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
		//设置转化为小写拼音首字母
		defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
		//设置不显示音标即是几声的
		defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
		//判断是否是汉字
		for(int i = 0; i < strArray.length; i++){
			
			//处理中文
			if(strArray[i]>128){
				pinyin = pinyin + PinyinHelper.toHanyuPinyinStringArray(strArray[i], defaultFormat)[0].charAt(0);
			}else{
				pinyin = pinyin + strArray[i];
			}
		}
		return pinyin;
	}
	/**
	 * 该类将汉字转换为完整的拼音
	 * @param args
	 * @throws BadHanyuPinyinOutputFormatCombination
	 */
	public static String convertString2AllPinYin(String str) throws BadHanyuPinyinOutputFormatCombination{
		//转换后的拼音是
		String pinyin = "";
		//将字符串转换为char类型的数组
		char []strArray = str.toCharArray();
		//设置汉字转换为拼音的格式
		HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
		//设置转换后的拼音为小写
		format.setCaseType(HanyuPinyinCaseType.LOWERCASE);
		//设置转换后的拼音没有音标
		format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
		for(int i = 0; i < strArray.length; i++){
			//如果是中文
			if(strArray[i]>128){
				pinyin = pinyin + PinyinHelper.toHanyuPinyinStringArray(strArray[i], format)[0];
			}else{
				pinyin += strArray[i];
			}
			
		}
		return pinyin;
	}
	public static void main(String[] args) throws BadHanyuPinyinOutputFormatCombination {
		System.out.println(convertString2FirstPinYin("HELLO WORLD"));
		System.out.println(convertString2FirstPinYin("你好世界"));
		System.out.println(convertString2AllPinYin("HELLO WORLD"));
		System.out.println(convertString2AllPinYin("你好世界"));
	}
}
