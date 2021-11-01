package com.practice.concurrency;

class SynchronizedCounter {
	private int n;

	public SynchronizedCounter(int n) {
		this.n = n;
	}

//	public synchronized void countToZero() {
	public void countToZero() {
		synchronized (this) {
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
//		while (n > 0) {
//			System.out.println("Counter n is " + this.n + " by " + Thread.currentThread().getName());
//
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			n--;
//		}
	}
}
