package org.eanchao.util;

import java.util.UUID;

/**
 * 加密计算工具类
 * <pre>
 * 1、MD5加密计算
 * </pre>
 * @author Eanchao
 *
 */
public class CalculationUtils {
	/**
	 * 创建UUID字符串
	 * @return
	 */
	public static String getUUIDString() {
		String uuid=UUID.randomUUID().toString().replace("-", "");
		return uuid;
	}

}
