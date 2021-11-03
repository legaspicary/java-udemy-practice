package com.practice.concurrency;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadMain {
	public static void main(String[] args) {
//		threadAndRunnableDemo();
//		joinThreadDemo();
//		multiThreadDangerDemo();
//		multiThreadSyncDemo();
//		producerConsumerDemo();
//		concurrentPackageDemo();
		blockingQueueDemo();
	}

	public static void blockingQueueDemo() {
		ArrayBlockingQueue<String> buffer = new ArrayBlockingQueue<String>(6);

		ExecutorService exec = Executors.newFixedThreadPool(5);

		MyProducer producer = new MyProducer(buffer);
		MyConsumer consumer1 = new MyConsumer(buffer);
		MyConsumer consumer2 = new MyConsumer(buffer);

		exec.execute(producer);
		exec.execute(consumer1);
		exec.execute(consumer2);

		Future<String> future = exec.submit(new Callable<String>() {
			@Override
			public String call() throws Exception {
				return "Hello!";
			}
		});

		try {
			System.out.println(future.get());
		} catch (Exception e) {
			System.out.println("something went wrong");
		}

		exec.shutdown();
	}

//	public static void concurrentPackageDemo() {
//		List<String> buffer = new ArrayList<>();
//
//		ReentrantLock bufferLock = new ReentrantLock();
//
//		ExecutorService exec = Executors.newFixedThreadPool(5);
//
//		MyProducer producer = new MyProducer(buffer, bufferLock);
//		MyConsumer consumer1 = new MyConsumer(buffer, bufferLock);
//		MyConsumer consumer2 = new MyConsumer(buffer, bufferLock);
//
//		exec.execute(producer);
//		exec.execute(consumer1);
//		exec.execute(consumer2);
//
//		Future<String> future = exec.submit(new Callable<String>() {
//			@Override
//			public String call() throws Exception {
//				return "Hello!";
//			}
//		});
//
//		try {
//			System.out.println(future.get());
//		} catch (Exception e) {
//			System.out.println("something went wrong");
//		}
//
//		exec.shutdown();
//	}

	public static void producerConsumerDemo() {
		Message message = new Message();
		(new Thread(new Writer(message))).start();
		(new Thread(new Reader(message))).start();
	}

	// NOTE: keep synchronized code to a minimum
	public static void multiThreadSyncDemo() {
		SynchronizedCounter counter = new SynchronizedCounter(20);
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				counter.countToZero();
			}
		});
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				counter.countToZero();
			}
		});
		Thread t3 = new Thread(new Runnable() {
			@Override
			public void run() {
				counter.countToZero();
			}
		});
		t1.setName("Thread 1");
		t2.setName("Thread 2");
		t3.setName("Thread 3");
		t1.start();
		t2.start();
		t3.start();
//		t2.setName("hello!");
//		System.out.println(t2.getName());
	}

	public static void multiThreadDangerDemo() {
		Counter counter = new Counter(20);
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				counter.countToZero();
			}
		});
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				counter.countToZero();
			}
		});
		Thread t3 = new Thread(new Runnable() {
			@Override
			public void run() {
				counter.countToZero();
			}
		});
		t1.setName("Thread 1");
		t2.setName("Thread 2");
		t3.setName("Thread 3");
		t1.start();
		t2.start();
		t3.start();
//		t2.setName("hello!");
		System.out.println(t2.getName());
	}

	public static void joinThreadDemo() {
		Thread t1 = new ThreadChild();
		t1.start();
		Thread t2 = new ThreadChild();
		t2.start();

		new Thread(new RunnableChild() {
			@Override
			public void run() {
				System.out.println("I am before the two threads!");
				try {
					t1.join(1000);
					t2.join(1000);
				} catch (InterruptedException e) {
					System.out.println("Cannot wait! got interrupted.");
				}
				System.out.println("I executed after waiting for the two threads ahead... or timed out!");
			}
		}).start();

		System.out.println("I am from main thread");
	}

	public static void threadAndRunnableDemo() {
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

class Counter {
	private int n;

	public Counter(int n) {
		this.n = n;
	}

	public void countToZero() {
		while (n > 0) {
			System.out.println("Counter n is " + this.n + " by " + Thread.currentThread().getName());

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			n--;
		}
	}
}