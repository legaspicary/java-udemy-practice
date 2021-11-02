package com.practice.concurrency;

public class ThreadMain {
	public static void main(String[] args) {
//		threadAndRunnableDemo();
//		joinThreadDemo();
//		multiThreadDangerDemo();
//		multiThreadSyncDemo();
		producerConsumerDemo();
	}

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