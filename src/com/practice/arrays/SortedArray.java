package com.practice.arrays;

import java.util.Scanner;

public class SortedArray {
	private static Scanner scanner;

	public static int[] getIntegers(int size) {
		SortedArray.scanner = new Scanner(System.in);
		int[] array = new int[size];
		for (int i = 0; i < size; i++) {
			array[i] = SortedArray.scanner.nextInt();
		}
		SortedArray.scanner.close();
		return array;
	}

	public static void printArray(int[] array) {
		String msg = "Element %d contents %d";
		for (int i = 0; i < array.length; i++) {
			System.out.println(String.format(msg, i, array[i]));
		}
	}

	public static int[] sortIntegers(int[] unsortedArray) {
		int[] sortedArray = new int[unsortedArray.length];
		for (int i = 0; i < sortedArray.length; i++) {
			sortedArray[i] = Integer.MIN_VALUE;
		}
		for (int i = 0; i < unsortedArray.length; i++) {
			int value = unsortedArray[i];
			for (int j = 0; j < sortedArray.length; j++) {
				if (value > sortedArray[j]) {
					// shift contents
					for (int k = sortedArray.length - 1; k > j; k--) {
						sortedArray[k] = sortedArray[k - 1];
					}
					sortedArray[j] = value;
					break;
				}
			}
		}
		return sortedArray;
	}

	public static void main(String[] args) {
		int[] arr = { 58, 85, -56, 0, 4 };
		printArray(sortIntegers(arr));
	}
}
