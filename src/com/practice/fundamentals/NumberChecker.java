package com.practice.fundamentals;

public class NumberChecker {
	public static boolean hasEqualSum(int a, int b, int c) {
		return a + b == c;
	}

	private static boolean isTeen(int n) {
		return n >= 13 && n <= 19;
	}

	public static boolean hasTeen(int a, int b, int c) {
		return isTeen(a) || isTeen(b) || isTeen(c);
	}

	public static void printEqual(int a, int b, int c) {
		if (a < 0 || b < 0 || c < 0) {
			System.out.println("Invalid Value");
			return;
		}
		if (a == b && b == c) {
			System.out.println("All numbers are equal");
		} else if ((a == b && a != c) || (b == c && a != c) || (a == c && b != c)) {
			System.out.println("Neither all are equal or different");
		} else {
			System.out.println("All numbers are different");
		}

	}

	public static boolean isPalindrome(int number) {
		number = Math.abs(number);
		int numberCopy = number;
		int reverse = 0;
		while (numberCopy > 0) {
			reverse = (reverse * 10) + (numberCopy % 10);
			numberCopy /= 10;
		}
		return number == reverse;
	}
}
