package com.practice.concurrency;

public class RunnableChild implements Runnable {
	private static int count = 0;

	@Override
	public void run() {
		System.out.println(String.format("Hello I am a runnable! #%d!", ++RunnableChild.count));
	}

}
