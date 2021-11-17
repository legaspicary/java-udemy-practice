package com.practice.fundamentals;

public class MinutesToYearsDaysCalculator {
	private static final long MINUTES_IN_YEAR = 525_600L;
	private static final long MINUTES_IN_DAY = 1_440L;

	public static void printYearsAndDays(long minutes) {
		if (minutes < 0) {
			System.out.println("Invalid Value");
			return;
		}

		long minutesCopy = minutes;

		String resultMsg = "%d min = %d y and %d d";
		long years = minutes / MINUTES_IN_YEAR;
		minutes %= MINUTES_IN_YEAR;
		long days = minutes / MINUTES_IN_DAY;

		System.out.println(String.format(resultMsg, minutesCopy, years, days));
	}
}
