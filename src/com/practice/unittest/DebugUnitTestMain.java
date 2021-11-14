package com.practice.unittest;

public class DebugUnitTestMain {

	public static void main(String[] args) {
		System.out.println("Hello");
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 10; i++) {
			sb.append("Hello");
			System.out.println(sb);
		}
		System.out.println(sb);
	}

}
