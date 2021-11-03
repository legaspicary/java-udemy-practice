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
//		blockingQueueDemo();
//		deadlockDemo();
//		starvationDemo();
		fairLockDemo();
	}

	public static void fairLockDemo() {
		String str1 = "Hello!";

		Thread t1 = new Thread(new Worker(str1), "Prio 10");
		Thread t2 = new Thread(new Worker(str1), "Prio 8");
		Thread t3 = new Thread(new Worker(str1), "Prio 6");
		Thread t4 = new Thread(new Worker(str1), "Prio 4");
		Thread t5 = new Thread(new Worker(str1), "Prio 2");

		t1.setPriority(10);
		t2.setPriority(8);
		t3.setPriority(6);
		t4.setPriority(4);
		t5.setPriority(2);

		t4.start();
		t5.start();
		t2.start();
		t3.start();
		t1.start();

	}

	public static void starvationDemo() {
		// Occurs when thread has no chance to run (e.g. lowest priority)
		String str1 = "Hello!";

		Thread t1 = new Thread(new Worker(str1), "Prio 10");
		Thread t2 = new Thread(new Worker(str1), "Prio 8");
		Thread t3 = new Thread(new Worker(str1), "Prio 6");
		Thread t4 = new Thread(new Worker(str1), "Prio 4");
		Thread t5 = new Thread(new Worker(str1), "Prio 2");

		t1.setPriority(10);
		t2.setPriority(8);
		t3.setPriority(6);
		t4.setPriority(4);
		t5.setPriority(2);

		t4.start();
		t5.start();
		t2.start();
		t3.start();
		t1.start();

	}

	public static void deadlockDemo() {
		// Solution: take lock in the same order
		// Caution: take care of getting locks in different orders
		String str1 = "Hi";
		String str2 = "Hello";
		Thread t1 = new Thread(() -> {
			synchronized (str1) {
				System.out.println("Thread 1 has lock for str1");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					System.out.println("Thread 1 interrupted");
				}
				System.out.println("Thread 1 waiting for str2 lock");
				synchronized (str2) {
					System.out.println("Thread 1 has str2 lock");
				}
				System.out.println("Thread 1 has released lock for str1");
			}
		});

		Thread t2 = new Thread(() -> {
			synchronized (str1) {
				System.out.println("Thread 2 has lock for str1");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					System.out.println("Thread 2 interrupted");
				}
				System.out.println("Thread 1 waiting for str2lock");
				synchronized (str2) {
					System.out.println("Thread 2 has str2 lock");
				}
				System.out.println("Thread 2 has released lock for str1");
			}
		});

		t1.start();
		t2.start();
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