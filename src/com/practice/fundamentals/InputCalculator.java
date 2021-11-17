package com.practice.fundamentals;

import java.util.Scanner;

public class InputCalculator {
	public static void inputThenPrintSumAndAverage() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int sum = 0;
		int counter = 0;
		while (scanner.hasNextInt()) {
			sum += scanner.nextInt();
			scanner.nextLine();
			counter++;
		}
		long average = 0;
		if (counter > 0)
			average = Math.round((double) sum / (double) counter);
		String resultMsg = "SUM = %d AVG = %d";
		System.out.println(String.format(resultMsg, sum, average));
		scanner.close();
	}
}
