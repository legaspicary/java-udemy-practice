package com.practice.concurrency;

import java.util.concurrent.locks.ReentrantLock;

public class Worker implements Runnable {
	public static ReentrantLock lock = new ReentrantLock();
	String str;
	private int runCount = 1;

	Worker(String str) {
		this.str = str;
	}

	@Override
	public void run() {
		for (int i = 0; i < 25; i++) {
			lock.lock();
			try {
				System.out.format("Thread %s count run = %d\n", Thread.currentThread().getName(), runCount++);
			} finally {
				lock.unlock();
			}
		}
	}
}
