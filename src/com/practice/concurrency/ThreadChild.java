package com.practice.concurrency;

public class ThreadChild extends Thread {
	private static int count = 0;
	private int id = 0;

	@Override
	public void run() {
		id = ++ThreadChild.count;
		System.out.println(String.format("Hello from thread #%d!", this.id));
		System.out.println(String.format("Thread #%d going to sleep for 3 seconds", this.id));
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			System.out.println(String.format("Thread #%d interrupted!", this.id));
		}
		System.out.println(String.format("Thread #%d done sleeping!", this.id));
	}
}
