package com.practice.concurrency;

import java.util.Random;

public class Message {
	private String message;
	private boolean empty = true;

	public synchronized String read() {
		while (empty) {
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println("Got interrupted while trying to sleep!");
			}
		}
		empty = true;
		notifyAll();
		return message;
	}

	public synchronized void write(String message) {
		while (!empty) {
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println("Got interrupted while trying to sleep!");
			}
		}
		empty = false;
		this.message = message;
		notifyAll();
	}
}

// Note: the producer class
class Writer implements Runnable {
	private Message message;

	public Writer(Message message) {
		this.message = message;
	}

	@Override
	public void run() {
		String[] messages = { "Hello hello", "Hi hi", "Hey hey", "Hehe boi" };

		Random random = new Random();

		for (String str : messages) {
			message.write(str);
			try {
				Thread.sleep(random.nextInt(2000));
			} catch (InterruptedException e) {
				System.out.println("Got interrupted while trying to sleep!");
			}
		}

		message.write("Finished");
	}

}

// Note: the consumer class

class Reader implements Runnable {
	private Message message;

	public Reader(Message message) {
		this.message = message;
	}

	@Override
	public void run() {
		Random random = new Random();
		String latestMessage = "Finished";
		while (!(latestMessage = message.read()).equals("Finished")) {
			System.out.println(latestMessage);
			try {
				Thread.sleep(random.nextInt(2000));
			} catch (InterruptedException e) {
				System.out.println("Got interrupted while trying to sleep!");
			}
		}
	}

}
