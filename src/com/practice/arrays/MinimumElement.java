package com.practice.arrays;

import java.util.Scanner;

public class MinimumElement {
	private static Scanner scanner;

	private static int readInteger() {
		MinimumElement.scanner = new Scanner(System.in);
		int n = MinimumElement.scanner.nextInt();
		MinimumElement.scanner.close();
		return n;
	}

	private static int[] readElements(int size) {
		MinimumElement.scanner = new Scanner(System.in);
		int[] array = new int[size];
		for (int i = 0; i < size; i++) {
			array[i] = MinimumElement.scanner.nextInt();
		}
		MinimumElement.scanner.close();
		return array;
	}

	private static int findMin(int[] array) {
		int min = array[0];
		for (int i = 1; i < array.length; i++) {
			if (min > array[i])
				min = array[i];
		}
		return min;
	}
}
