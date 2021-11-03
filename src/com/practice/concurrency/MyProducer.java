package com.practice.concurrency;

import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class MyProducer implements Runnable {
	private List<String> buffer;
	private ReentrantLock bufferLock;

	public MyProducer(List<String> buffer, ReentrantLock bufferLock) {
		this.buffer = buffer;
		this.bufferLock = bufferLock;
	}

	public void run() {
		Random random = new Random();
		String[] nums = { "1", "2", "3", "4", "5" };

		for (String num : nums) {
			try {
				System.out.println("Producer is adding " + num);
				bufferLock.lock();
				buffer.add(num);
				bufferLock.unlock();
				Thread.sleep(random.nextInt(1000));
			} catch (InterruptedException e) {
				System.out.println("Producer interrupted");
			}
		}
		System.out.println("Producer is exiting");
		bufferLock.lock();
		buffer.add("EOF");
		bufferLock.unlock();
	}

}

class MyConsumer implements Runnable {
	private List<String> buffer;
	private ReentrantLock bufferLock;

	public MyConsumer(List<String> buffer, ReentrantLock bufferLock) {
		this.buffer = buffer;
		this.bufferLock = bufferLock;
	}

	public void run() {
		int counter = 0;
		while (true) {
			if (bufferLock.tryLock()) {
				try {

					if (buffer.isEmpty()) {
						continue;
					}
					System.out.println("Counter is = " + counter);
					if (buffer.get(0).equals("EOF")) {
						System.out.println("Consumer is exiting");
						break;
					} else {
						System.out.println("Consumer has removed " + buffer.remove(0));
					}
				} finally {
					bufferLock.unlock();
				}
			} else {
				counter++;
			}

		}

	}

}