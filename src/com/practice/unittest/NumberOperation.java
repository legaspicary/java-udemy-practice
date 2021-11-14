package com.practice.unittest;

public class NumberOperation {
	private int value;

	public NumberOperation(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void increment(int val) {
		this.value += val;
	}

	public void decrement(int val) {
		this.value -= val;
	}
}
