package com.thread;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ThreadGroupTest implements Runnable {

	public void run() {
		String name = Thread.currentThread().getName();
		System.out.println("Start " + name);
		try {
			doTask();
		} catch (InterruptedException e) {
			System.out.printf("Thread %s: Interrupted\n", name);
			return;
		}
		System.out.println("end " + name);
	}

	private void doTask() throws InterruptedException {
		Random random = new Random((new Date()).getTime());
		int value = (int) (random.nextDouble() * 100);
		System.out.printf("%s sleep %d 秒\n", Thread.currentThread().getName(),
				value);
		TimeUnit.SECONDS.sleep(value);
	}

	private static void waitFinish(ThreadGroup threadGroup) {
		while (threadGroup.activeCount() > 9) {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		// 创建5个线程，并入group里面进行管理
		ThreadGroup threadGroup = new ThreadGroup("Searcher");
		ThreadGroupTest test = new ThreadGroupTest();
		for (int i = 0; i < 5; i++) {
			Thread thred = new Thread(threadGroup, test);
			thred.start();
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		// 通过这种方法可以看group里面的所有信息
		System.out.printf("Number of Threads: %d\n", threadGroup.activeCount());
		System.out.println("***********************Information about the Thread Group");
		threadGroup.list();

		// 这样可以复制group里面的thread信息
		Thread[] threads = new Thread[threadGroup.activeCount()];
		threadGroup.enumerate(threads);
		System.out.println("============================================");
		for (int i = 0; i < threadGroup.activeCount(); i++) {
			System.out.printf("%s: %s\n", threads[i].getName(),
					threads[i].getState());
		}

		waitFinish(threadGroup);
		// 将group里面的所有线程都给interpet
		threadGroup.interrupt();
	}

}
