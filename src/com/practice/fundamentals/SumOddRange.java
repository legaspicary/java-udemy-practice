package com.practice.fundamentals;

public class SumOddRange {
	public static boolean isOdd(int n) {
		return n > 0 && n % 2 == 1;
	}

	public static int sumOdd(int start, int end) {
		int sum = 0;
		if (end < start || start <= 0 || end <= 0)
			return -1;
		for (int i = start; i <= end; i++) {
			if (isOdd(i))
				sum += i;
		}
		return sum;
	}
}
