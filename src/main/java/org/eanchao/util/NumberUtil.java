package org.eanchao.util;

public class NumberUtil {
	/**
	 * 判断输入的数据是否是奇数
	 * 奇数返回true
	 * @param num
	 * @return
	 */
	public static Boolean isOddNumber(int num) {
		Boolean flag = null;
		if (num % 2 == 0) {
			flag = false;
		}else {
		flag = true;
		}
		return flag;
	}

	public static void main(String[] args) {
		System.out.println(isOddNumber(22));
	}
}
