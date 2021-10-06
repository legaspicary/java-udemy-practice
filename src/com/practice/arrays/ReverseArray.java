package com.practice.arrays;

public class ReverseArray {
	private static void reverse(int[] array) {
		int size = array.length;
		System.out.print("Array = [");
		for (int i = 0; i < size; i++) {
			System.out.print(array[i]);
			if (i < size - 1)
				System.out.print(", ");
		}
		System.out.println("]");
		for (int i = 0, j = size - 1; i < size / 2; i++, j--) {
			int temp = array[i];
			array[i] = array[j];
			array[j] = temp;
		}
		System.out.print("Reversed array = [");
		for (int i = 0; i < size; i++) {
			System.out.print(array[i]);
			if (i < size - 1)
				System.out.print(", ");
		}
		System.out.println("]");
	}

	public static void main(String args[]) {
		int[] arr = { 1, 2, 3, 4, 5 };
		reverse(arr);
	}
}
