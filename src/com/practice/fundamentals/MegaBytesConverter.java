package com.practice.fundamentals;

public class MegaBytesConverter {
	private static final int DIVISOR = 1024;

	public static void printMegaBytesAndKiloBytes(int kiloBytes) {

		if (kiloBytes < 0) {
			System.out.println("Invalid Value");
			return;
		}

		int megaBytes = kiloBytes / DIVISOR;
		int remainingKiloBytes = kiloBytes % DIVISOR;
		String resultMsg = "%d KB = %d MB and %d KB";

		System.out.println(String.format(resultMsg, kiloBytes, megaBytes, remainingKiloBytes));
	}
}
