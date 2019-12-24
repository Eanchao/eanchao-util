package org.eanchao.util;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * 字符串验证工具类
 * <pre>
 *  1、判断集合是否为空
 *  2、判断Map是否为空
 *  3、判断数组是否为空
 *  4、判断List是否为空
 *  5、邮箱格式验证
 *  6、手机号验证
 *  7、电话号码验证
 *  8、检查字符串是否是空白：<code>null</code>、空字符串<code>""</code>或只有空白字符。
 *  9、判断字符串是否只包含unicode数字。
 * 10、判断字符串是否只包含unicode数字，包括小数。
 * 11、判断字符串是否只包含unicode数字和空格<code>' '</code>。
 * 12、判断是否包含标点
 * </pre>
 * @author Eanchao
 *
 */
public class ValidationUtils {
	private static char punct[] = { ',', '.', '!', '?', ';', ':', '，', '。', '！', '？', '；', '：', '、' };

	/**
	 * 判断集合是否为空
	 * 
	 * @param collection
	 * @return
	 */
	public static boolean isEmpty(Collection<?> collection) {
		return collection == null || collection.isEmpty();
	}

	/**
	 * 判断Map是否为空
	 * 
	 * @param map
	 * @return
	 */
	public static boolean isEmpty(Map<?, ?> map) {
		return map == null || map.isEmpty();
	}

	/**
	 * 判断数组是否为空
	 * 
	 * @param array
	 * @return
	 */
	public static boolean isEmpty(Object[] array) {
		return array == null || array.length == 0;
	}

	/**
	 * 判断List是否为空
	 * 
	 * @param list
	 * @return
	 */
	public static boolean isEmpty(List<Object> list) {
		return list == null || list.size() == 0;
	}

	/**
	 * 邮箱格式验证
	 * 
	 * <pre>
	 * emailRegex是整体邮箱正则表达式
	 * emailName是@前面的名称部分
	 * emailDomain是后面的域名部分
	 * </pre>
	 * 
	 * @param str
	 * @return b
	 */
	public static boolean isEmail(String str) {
		boolean b = false;
		// 如果输入参数为""或null返回false
		if (str != null || str != "") {
			Pattern pattern;
			Matcher matcher;
			String emailRegex, emailName, emailDomain;
			emailName = "^[0-9A-Za-z]+\\w*";
			emailDomain = "([0-9a-z]+\\.)+[0-9a-z]+$";
			emailRegex = emailName + "@" + emailDomain;
			pattern = Pattern.compile(emailRegex);
			matcher = pattern.matcher(str);
			b = matcher.matches();
		}
		return b;
	}

	/**
	 * 手机号验证
	 * 
	 * @param str
	 * @return 验证通过返回true
	 */
	public static boolean isMobile(String str) {
		Pattern p = null;
		Matcher m = null;
		boolean b = false;
		p = Pattern.compile("^[1][3,4,5,6,7,8,9][0-9]{9}$"); // 验证手机号 1[3,4,5,6,7,8]9876545435
		m = p.matcher(str);
		b = m.matches();
		return b;
	}

	/**
	 * 电话号码验证
	 * 
	 * @param str
	 * @return 验证通过返回true
	 */
	public static boolean isPhone(String str) {
		Pattern p1 = null, p2 = null;
		Matcher m = null;
		boolean b = false;
		p1 = Pattern.compile("^[0][1-9]{2,3}-[0-9]{5,10}$"); // 验证带区号的
		p2 = Pattern.compile("^[1-9]{1}[0-9]{5,8}$"); // 验证没有区号的
		if (str.length() > 9) {
			m = p1.matcher(str);
			b = m.matches();
		} else {
			m = p2.matcher(str);
			b = m.matches();
		}
		return b;
	}

	/**
	 * 检查字符串是否是空白：<code>null</code>、空字符串<code>""</code>或只有空白字符。
	 * 
	 * <pre>
	 * StringUtil.isBlank(null)      = true
	 * StringUtil.isBlank("")        = true
	 * StringUtil.isBlank(" ")       = true
	 * StringUtil.isBlank("bob")     = false
	 * StringUtil.isBlank("  bob  ") = false
	 * </pre>
	 *
	 * @param str 要检查的字符串
	 *
	 * @return 如果为空白, 则返回<code>true</code>
	 */
	public static boolean isBlank(String str) {
		int length;

		if ((str == null) || ((length = str.length()) == 0)) {
			return true;
		}

		for (int i = 0; i < length; i++) {
			if (!Character.isWhitespace(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 判断字符串是否只包含unicode数字。
	 *
	 * <p>
	 * <code>null</code>将返回<code>false</code>，空字符串<code>""</code>将返回<code>true</code>。
	 * </p>
	 * 
	 * <pre>
	 * StringUtil.isNumeric(null)   = false
	 * StringUtil.isNumeric("")     = true
	 * StringUtil.isNumeric("  ")   = false
	 * StringUtil.isNumeric("123")  = true
	 * StringUtil.isNumeric("12 3") = false
	 * StringUtil.isNumeric("ab2c") = false
	 * StringUtil.isNumeric("12-3") = false
	 * StringUtil.isNumeric("12.3") = false
	 * </pre>
	 *
	 * @param str 要检查的字符串
	 *
	 * @return 如果字符串非<code>null</code>并且全由unicode数字组成，则返回<code>true</code>
	 */
	public static boolean isNumeric(String str) {
		if (str == null) {
			return false;
		}

		int length = str.length();

		for (int i = 0; i < length; i++) {
			if (!Character.isDigit(str.charAt(i))) {
				return false;
			}
		}

		return true;
	}

	/**
	 * 判断字符串是否只包含unicode数字，包括小数。
	 *
	 * <p>
	 * <code>null</code>将返回<code>false</code>，空字符串<code>""</code>将返回<code>true</code>。
	 * </p>
	 * 
	 * <pre>
	 * StringUtil.isNumeric(null)   = false
	 * StringUtil.isNumeric("")     = false
	 * StringUtil.isNumeric("  ")   = false
	 * StringUtil.isNumeric("123")  = true
	 * StringUtil.isNumeric("12 3") = false
	 * StringUtil.isNumeric("ab2c") = false
	 * StringUtil.isNumeric("12-3") = false
	 * StringUtil.isNumeric("12.3") = true
	 * </pre>
	 *
	 * @param str 要检查的字符串
	 *
	 * @return 如果字符串非<code>null</code>并且全由unicode数字组成，则返回<code>true</code>
	 */
	public static boolean isNumber(String str) {
		if (isBlank(str)) {
			return false;
		}
		int index = str.indexOf(".");
		if (index < 0) {
			return isNumeric(str);
		} else {
			String num1 = str.substring(0, index);
			String num2 = str.substring(index + 1);
			return isNumeric(num1) && isNumeric(num2);
		}
	}

	/**
	 * 判断字符串是否只包含unicode数字和空格<code>' '</code>。
	 *
	 * <p>
	 * <code>null</code>将返回<code>false</code>，空字符串<code>""</code>将返回<code>true</code>。
	 * </p>
	 * 
	 * <pre>
	 * StringUtil.isNumericSpace(null)   = false
	 * StringUtil.isNumericSpace("")     = true
	 * StringUtil.isNumericSpace("  ")   = true
	 * StringUtil.isNumericSpace("123")  = true
	 * StringUtil.isNumericSpace("12 3") = true
	 * StringUtil.isNumericSpace("ab2c") = false
	 * StringUtil.isNumericSpace("12-3") = false
	 * StringUtil.isNumericSpace("12.3") = false
	 * </pre>
	 *
	 * @param str 要检查的字符串
	 *
	 * @return 如果字符串非<code>null</code>并且全由unicode数字和空格组成，则返回<code>true</code>
	 */
	public static boolean isNumericSpace(String str) {
		if (str == null) {
			return false;
		}
		int length = str.length();
		for (int i = 0; i < length; i++) {
			if (!Character.isDigit(str.charAt(i)) && (str.charAt(i) != ' ')) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 判断是否包含标点
	 */
	public static boolean ContainsPunctuation(String str) {
		for (int i = 0; i < str.length(); ++i) {
			for (int j = 0; j < punct.length; ++j) {
				if (punct[j] == str.charAt(i)) {
					return true;
				}
			}
		}

		return false;
	}

}
