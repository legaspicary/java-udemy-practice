package com.practice.concurrency;

public class ThreadMain {
	public static void main(String[] args) {
		Thread t1 = new ThreadChild();
		t1.start();
		t1.interrupt();

		new Thread() {
			public void run() {
				System.out.println("I am an anonymous thread class!");
			}
		}.start();

		new Thread(new RunnableChild()).start();
		new Thread(new RunnableChild() {
			@Override
			public void run() {
				System.out.println("I am overriding runnable child!");
			}
		}).start();

		System.out.println("I am from main thread");

		new ThreadChild().start();
		new ThreadChild().start();
		new ThreadChild().start();
	}
}
