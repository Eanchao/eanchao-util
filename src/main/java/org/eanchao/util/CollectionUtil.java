/**
 * 
 */
package org.eanchao.util;

import java.util.Collection;
import java.util.Map;

/**
 * 说明: 集合工具类
 * 
 * @author Eanchao
 */
public class CollectionUtil {

	/**
	 * 功能说明：判断List或Set对象是否空或不包含元素<br>
	 * @param coll
	 * @return
	 * boolean
	 */
	public static boolean isEmpty(Collection<?> coll){
		return coll == null || coll.isEmpty();
	}
	
	/**
	 * 功能说明：判断List或Set对象是否不为空或包含元素<br>
	 * @param coll
	 * @return
	 * boolean
	 */
	public static boolean notEmpty(Collection<?> coll){
		return coll != null && !coll.isEmpty();
	}
	
	
	/**
	 * 功能说明：判断Map对象是否空或不包含元素<br>
	 * @param map
	 * @return
	 * boolean
	 */
	public static boolean isEmpty(Map<?, ?> map){
		return map == null || map.isEmpty();
	}
	
	
	/**
	 * 功能说明：判断Map对象是否不为空或包含元素<br>
	 * @param map
	 * @return
	 * boolean
	 */
	public static boolean notEmpty(Map<?, ?> map){
		return map != null && !map.isEmpty();
	}
}
