package com.practice.concurrency;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

public class MyProducer implements Runnable {
	private ArrayBlockingQueue<String> buffer;

	public MyProducer(ArrayBlockingQueue<String> buffer) {
		this.buffer = buffer;
	}

	public void run() {
		Random random = new Random();
		String[] nums = { "1", "2", "3", "4", "5" };

		for (String num : nums) {
			try {
				System.out.println("Producer is adding " + num);
				buffer.put(num);
				Thread.sleep(random.nextInt(1000));
			} catch (InterruptedException e) {
				System.out.println("Producer interrupted");
			}
		}
		System.out.println("Producer is exiting");
		try {
			buffer.put("EOF");
		} catch (InterruptedException e) {
			System.out.println("Producer interrupted");
		}
	}

}

class MyConsumer implements Runnable {
	private ArrayBlockingQueue<String> buffer;

	public MyConsumer(ArrayBlockingQueue<String> buffer) {
		this.buffer = buffer;
	}

	public void run() {
		while (true) {
			synchronized (buffer) {
				try {
					if (buffer.isEmpty()) {
						continue;
					}
					if (buffer.peek().equals("EOF")) {
						System.out.println("Consumer is exiting");
						break;
					} else {
						System.out.println("Consumer has removed " + buffer.take());
					}
				} catch (InterruptedException e) {
					System.out.println("Consumer interrupted");
				}
			}
		}

	}

}