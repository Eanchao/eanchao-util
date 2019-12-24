package org.eanchao.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池工具类
 * @author Eanchao
 *
 */
public class ThreadPoolUtil {
	// 创建一个线程池
	private static ExecutorService threadPool = Executors.newCachedThreadPool();

	// 执行线程
	public static void execute(Runnable command) {
		//判断线程池是否处于关闭状态，没关闭直接运行
		if (!threadPool.isShutdown()) {
			threadPool.execute(command);
		}else {//关闭后，再重新创建
			threadPool = Executors.newCachedThreadPool();
			threadPool.execute(command);
		}
	}

	/**
	 * 关闭线程
	 */
	public static void shutDown() {
		threadPool.shutdown();
	}
}